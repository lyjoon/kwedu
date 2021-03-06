const path = require('path')
const process = require('process')

module.exports = {
    "publicPath": process.env.VUE_APP_PUBLIC_PATH || '/',
    "outputDir" : path.resolve(__dirname, "../api/src/main/resources/static"),
    "transpileDependencies": [
        "vuetify"
    ],
    chainWebpack: config => {
        config
          .plugin('html')
          .tap(args => {
          args[0].title = '교원에듀 빨간펜 강동센터';	// Replace your title here
          return args;
        });
      }
}