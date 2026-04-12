const { Jimp } = require('jimp');

async function removeBg(inputPath, outputPath, tolerance = 40) {
  const img = await Jimp.read(inputPath);
  const w = img.width;
  const h = img.height;

  // Sample the background color from the top-left corner
  const bgColor = img.getPixelColor(2, 2);
  const bgR = (bgColor >> 24) & 0xff;
  const bgG = (bgColor >> 16) & 0xff;
  const bgB = (bgColor >> 8)  & 0xff;
  console.log(`Background color sampled at (2,2): rgb(${bgR}, ${bgG}, ${bgB})`);

  // BFS flood-fill from all four corners
  const visited = new Uint8Array(w * h);
  const queue = [];

  function enqueue(x, y) {
    if (x < 0 || y < 0 || x >= w || y >= h) return;
    const idx = y * w + x;
    if (visited[idx]) return;
    const c = img.getPixelColor(x, y);
    const r = (c >> 24) & 0xff;
    const g = (c >> 16) & 0xff;
    const b = (c >> 8)  & 0xff;
    const dist = Math.sqrt((r - bgR) ** 2 + (g - bgG) ** 2 + (b - bgB) ** 2);
    if (dist > tolerance) return;
    visited[idx] = 1;
    queue.push([x, y]);
  }

  // Seed from all four corners + edges
  for (let x = 0; x < w; x++) { enqueue(x, 0); enqueue(x, h - 1); }
  for (let y = 0; y < h; y++) { enqueue(0, y); enqueue(w - 1, y); }

  let head = 0;
  while (head < queue.length) {
    const [cx, cy] = queue[head++];
    enqueue(cx + 1, cy);
    enqueue(cx - 1, cy);
    enqueue(cx, cy + 1);
    enqueue(cx, cy - 1);
  }

  let removed = 0;
  for (let y = 0; y < h; y++) {
    for (let x = 0; x < w; x++) {
      if (visited[y * w + x]) {
        img.setPixelColor(0x00000000, x, y);
        removed++;
      }
    }
  }

  console.log(`Removed ${removed} background pixels (${((removed / (w * h)) * 100).toFixed(1)}% of image)`);
  await img.write(outputPath);
  console.log(`Saved to ${outputPath}`);
}

removeBg(
  'app/src/main/res/drawable/logo.png',
  'app/src/main/res/drawable/logo.png',
  45,
).catch(console.error);
