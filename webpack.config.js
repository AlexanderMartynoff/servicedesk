'use strict';


let ExtractTextPlugin = require('extract-text-webpack-plugin');
let resolve = require('path').resolve;


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
      },
      {
        test: /\.css$/,
        loader: ExtractTextPlugin.extract({
          fallbackLoader: 'style-loader',
          loader: 'css-loader'
        })
      },
      {
        test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
        loader: "file",
        query: {
          name: 'font/[name].[ext]'
        }
      },
      {
        test: /\.(woff|woff2)$/,
        loader:'file',
        query: {
          name: "font/[name].[ext]"
        }
      },
      {
        test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
        loader: 'file',
        query: {
          name: "font/[name].[ext]"
        }
      },
      {
        test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
        loader: 'file',
        query: {
          name: 'font/[name].[ext]'
        }
      }
    ]
  },
  output: {
    filename: '[name].build.js',
    path: './common/src/main/resources/META-INF/resources/public/build',
    publicPath: '/public/application/build/'
  },
  resolve: {
    modules: [
      resolve('./common/src/main/resources/META-INF/resources/public/application/module/common'),
      resolve('./common/src/main/resources/META-INF/resources/public/application/style/css'),
      'node_modules'
    ]
  },

  plugins: [
    new ExtractTextPlugin('style.css')
  ]
};
