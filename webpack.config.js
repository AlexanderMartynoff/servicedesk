var path = require('path');


module.exports = {
  entry: './agent/src/main/war/WEB-INF/public/application/module/agent/application/module.js',
  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        loader: 'babel',
        query: {presets: ['es2015']}
      }
    ]
  },
  output: {
    filename: '[name].build.js'
  },
  resolve: {
    root: [
      path.resolve('./common/src/main/resources/META-INF/resources/public/application/module/common')
    ]
  }
};
