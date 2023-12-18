const express = require('express');
const { createProxyMiddleware } = require('http-proxy-middleware');

const app = express();
const port = 8081; // Choose a different port than your main app

// Define the proxy route
app.use('/sms-proxy', createProxyMiddleware({
  target: 'https://www.intouchsms.co.rw',
  changeOrigin: true,
  pathRewrite: {
    '^/sms-proxy': '', // remove the '/sms-proxy' path prefix when forwarding the request
  },
}));

// Start the server
app.listen(port, () => {
  console.log(`Proxy server listening on port ${port}`);
});
