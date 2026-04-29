"""Generate Play Store icon (512x512 PNG, no alpha) from drawable/logo.png.

Approach: crop logo.png to its non-transparent bounding box (the rounded-square
artwork itself, without transparent padding) and scale to 512x512. Composite on
the launcher background color so the output has no alpha — Play Store rejects
PNGs with transparency.

logo.png is the source artwork (1024x1024) used as foreground for the
adaptive launcher icon. It already contains the rounded-square frame and
gradient, so for Play Store flat 512 we use it as-is rather than re-running the
adaptive composite (which produces an icon-in-icon appearance because the inset
double-frames the artwork).

Output: docs/release-assets/play_store_icon_512.png

Run:
    python scripts/release/make_play_icon.py
"""
from __future__ import annotations

import re
from pathlib import Path

from PIL import Image

REPO = Path(__file__).resolve().parents[2]
LOGO = REPO / "app/src/main/res/drawable/logo.png"
COLORS_XML = REPO / "app/src/main/res/values/colors.xml"
OUT = REPO / "docs/release-assets/play_store_icon_512.png"

SIZE = 512


def read_bg_color() -> tuple[int, int, int]:
    text = COLORS_XML.read_text(encoding="utf-8")
    m = re.search(r'name="ic_launcher_background"\s*>\s*#([0-9A-Fa-f]+)', text)
    if not m:
        raise SystemExit("ic_launcher_background not found in colors.xml")
    h = m.group(1)
    if len(h) == 8:  # #AARRGGBB
        h = h[2:]
    if len(h) != 6:
        raise SystemExit(f"unexpected color length: #{h}")
    return int(h[0:2], 16), int(h[2:4], 16), int(h[4:6], 16)


def main() -> None:
    bg_rgb = read_bg_color()

    src = Image.open(LOGO).convert("RGBA")
    bbox = src.split()[3].getbbox()
    if bbox is None:
        raise SystemExit("logo.png is fully transparent")
    cropped = src.crop(bbox)
    resized = cropped.resize((SIZE, SIZE), Image.Resampling.LANCZOS)

    canvas = Image.new("RGB", (SIZE, SIZE), bg_rgb)
    canvas.paste(resized, (0, 0), mask=resized.split()[3])

    OUT.parent.mkdir(parents=True, exist_ok=True)
    canvas.save(OUT, "PNG", optimize=True)
    print(f"wrote {OUT.relative_to(REPO)}  size={SIZE}x{SIZE}  bg=#{bg_rgb[0]:02X}{bg_rgb[1]:02X}{bg_rgb[2]:02X}  cropped_bbox={bbox}")


if __name__ == "__main__":
    main()
