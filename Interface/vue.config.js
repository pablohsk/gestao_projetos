module.exports = {
    devServer: {
      proxy: {
        '/api': {
          target: 'http://localhost:8080', // URL do servidor backend
          changeOrigin: true
        }
      }
    }
  }  