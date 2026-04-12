const { Jimp } = require('jimp');
const path = require('path');

// Mipmap density sizes for launcher icons (px)
const sizes = {
  'mipmap-mdpi':    48,
  'mipmap-hdpi':    72,
  'mipmap-xhdpi':   96,
  'mipmap-xxhdpi':  144,
  'mipmap-xxxhdpi': 192,
};

const src = 'app/src/main/res/drawable/logo.png';
const resDir = 'app/src/main/res';

async function main() {
  const img = await Jimp.read(src);
  console.log(`Source image: ${img.width}x${img.height}`);

  for (const [folder, size] of Object.entries(sizes)) {
    const outDir = path.join(resDir, folder);
    const outPath = path.join(outDir, 'ic_launcher.png');
    const outRound = path.join(outDir, 'ic_launcher_round.png');

    const resized = img.clone().resize({ w: size, h: size });
    await resized.write(outPath);
    await resized.write(outRound);
    console.log(`Written ${outPath} (${size}x${size})`);
  }
  console.log('Done!');
}

main().catch(console.error);
