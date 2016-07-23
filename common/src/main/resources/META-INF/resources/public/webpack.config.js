module.exports = {
  entry: './agent/src/main/war/WEB-INF/public/application/module/agent/application/module.js',
  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        loader: 'babel',
        query: {
          presets: ['es2015']
        }
      }
    ]
  },
  output: {
    filename: 'build.js'
  }
};
