const http = require('http');
const fs = require('fs');
const path = require('path');
const { execSync } = require('child_process');

const PORT = 18080;
const LOCAL_MAVEN = path.join(__dirname, 'localMaven');

// Maven repository URLs to proxy
const REPOS = [
  'https://dl.google.com/dl/android/maven2',
  'https://repo1.maven.org/maven2',
];

function downloadWithCurl(url, dest) {
  try {
    const dir = path.dirname(dest);
    if (!fs.existsSync(dir)) fs.mkdirSync(dir, { recursive: true });
    execSync(`curl -sf --max-time 30 -o "${dest}" "${url}"`, { stdio: 'pipe' });
    return fs.existsSync(dest) && fs.statSync(dest).size > 0;
  } catch (e) {
    return false;
  }
}

const server = http.createServer((req, res) => {
  const reqPath = req.url.replace(/^\/+/, '');
  const localFile = path.join(LOCAL_MAVEN, reqPath);

  // Check local first
  if (fs.existsSync(localFile) && fs.statSync(localFile).isFile()) {
    const data = fs.readFileSync(localFile);
    res.writeHead(200, { 'Content-Length': data.length });
    res.end(data);
    console.log(`[LOCAL] ${reqPath}`);
    return;
  }

  // Proxy from remote repos
  for (const repo of REPOS) {
    const url = `${repo}/${reqPath}`;
    const tmpFile = `${localFile}.tmp`;
    if (downloadWithCurl(url, tmpFile)) {
      // Move to final location
      const dir = path.dirname(localFile);
      if (!fs.existsSync(dir)) fs.mkdirSync(dir, { recursive: true });
      fs.renameSync(tmpFile, localFile);
      const data = fs.readFileSync(localFile);
      res.writeHead(200, { 'Content-Length': data.length });
      res.end(data);
      console.log(`[PROXY] ${reqPath} <- ${repo}`);
      return;
    }
    // Clean up failed tmp
    try { fs.unlinkSync(tmpFile); } catch(e) {}
  }

  console.log(`[404] ${reqPath}`);
  res.writeHead(404);
  res.end('Not found');
});

server.listen(PORT, '127.0.0.1', () => {
  console.log(`Maven proxy running on http://127.0.0.1:${PORT}`);
  console.log('Serving from: ' + LOCAL_MAVEN);
});

// Keep alive
process.on('SIGTERM', () => { server.close(); process.exit(0); });
