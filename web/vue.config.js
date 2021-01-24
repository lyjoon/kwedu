const path = require('path')

module.exports = {
    "publicPath": "/kwedu",
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