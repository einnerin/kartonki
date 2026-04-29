"""Generate a draft Play Store feature graphic (1024x500 PNG).

This is a placeholder/MVP version: dark gradient background, the app icon on
the left, brand text on the right. Replace with a proper design before
Production listing — Open testing it can stand-in.

Output: docs/release-assets/feature_graphic_1024x500.png

Run:
    python scripts/release/make_feature_graphic.py
"""
from __future__ import annotations

from pathlib import Path

from PIL import Image, ImageDraw, ImageFont

REPO = Path(__file__).resolve().parents[2]
ICON = REPO / "docs/release-assets/play_store_icon_512.png"
OUT = REPO / "docs/release-assets/feature_graphic_1024x500.png"

W, H = 1024, 500
BG_TOP = (13, 13, 26)         # #0D0D1A — same as launcher background
BG_BOTTOM = (40, 25, 70)      # purple tint to give a gradient
ACCENT = (210, 130, 255)      # pinkish-purple
TEXT = (240, 240, 255)


def vertical_gradient(size: tuple[int, int], top: tuple[int, int, int], bottom: tuple[int, int, int]) -> Image.Image:
    img = Image.new("RGB", size, top)
    px = img.load()
    w, h = size
    for y in range(h):
        t = y / max(h - 1, 1)
        r = int(top[0] * (1 - t) + bottom[0] * t)
        g = int(top[1] * (1 - t) + bottom[1] * t)
        b = int(top[2] * (1 - t) + bottom[2] * t)
        for x in range(w):
            px[x, y] = (r, g, b)
    return img


def load_font(size: int, *, bold: bool = False) -> ImageFont.FreeTypeFont | ImageFont.ImageFont:
    candidates_bold = [
        "C:/Windows/Fonts/segoeuib.ttf",
        "C:/Windows/Fonts/arialbd.ttf",
        "C:/Windows/Fonts/calibrib.ttf",
    ]
    candidates_regular = [
        "C:/Windows/Fonts/segoeui.ttf",
        "C:/Windows/Fonts/arial.ttf",
        "C:/Windows/Fonts/calibri.ttf",
    ]
    paths = candidates_bold if bold else candidates_regular
    for p in paths:
        if Path(p).exists():
            return ImageFont.truetype(p, size)
    return ImageFont.load_default()


def main() -> None:
    canvas = vertical_gradient((W, H), BG_TOP, BG_BOTTOM)

    # Soft accent glow on the right edge
    glow = Image.new("RGB", (W, H), (0, 0, 0))
    glow_draw = ImageDraw.Draw(glow)
    cx, cy = int(W * 0.78), H // 2
    for r, alpha in [(280, 30), (200, 50), (140, 70)]:
        glow_draw.ellipse([cx - r, cy - r, cx + r, cy + r], fill=(ACCENT[0] * alpha // 255, ACCENT[1] * alpha // 255, ACCENT[2] * alpha // 255))
    canvas = Image.blend(canvas, glow, 0.25)

    # Icon on the left
    icon_size = 360
    icon = Image.open(ICON).convert("RGB").resize((icon_size, icon_size), Image.Resampling.LANCZOS)
    icon_x = 80
    icon_y = (H - icon_size) // 2
    canvas.paste(icon, (icon_x, icon_y))

    # Text block on the right
    draw = ImageDraw.Draw(canvas)
    title_font = load_font(96, bold=True)
    subtitle_font = load_font(34)
    text_x = icon_x + icon_size + 60
    title = "Kartonki"
    subtitle = "учи слова через игру"

    # Title position
    title_bbox = draw.textbbox((0, 0), title, font=title_font)
    title_h = title_bbox[3] - title_bbox[1]
    sub_bbox = draw.textbbox((0, 0), subtitle, font=subtitle_font)
    sub_h = sub_bbox[3] - sub_bbox[1]
    gap = 16
    block_h = title_h + gap + sub_h
    title_y = (H - block_h) // 2 - 20  # slight visual lift
    sub_y = title_y + title_h + gap

    draw.text((text_x, title_y), title, font=title_font, fill=TEXT)
    draw.text((text_x, sub_y), subtitle, font=subtitle_font, fill=(200, 200, 220))

    OUT.parent.mkdir(parents=True, exist_ok=True)
    canvas.save(OUT, "PNG", optimize=True)
    print(f"wrote {OUT.relative_to(REPO)}  size={W}x{H}")


if __name__ == "__main__":
    main()
