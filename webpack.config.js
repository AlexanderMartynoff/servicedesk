'use strict';

let ExtractTextPlugin = require('extract-text-webpack-plugin');
let path = require('path');

module.exports = {
  entry: {
    // agent entries
    'agent.application': './agent/src/main/war/WEB-INF/public/application/module/agent/application/module.js',
    'agent.auth': './agent/src/main/war/WEB-INF/public/application/module/agent/authentication/module.js',
    // customer entries
    'customer.application': './customer/src/main/web/WEB-INF/public/application/module/customer/application/module.js',
    'customer.auth': './customer/src/main/web/WEB-INF/public/application/module/customer/authentication/module.js'
  },
  output: {
    filename: '[name].js',
    path: './common/src/main/resources/META-INF/resources/public/build',
    publicPath: '/public/build/'
  },
  resolve: {
    root: [
      path.resolve('./common/src/main/resources/META-INF/resources/public/application/style/css'),
      path.resolve('./common/src/main/resources/META-INF/resources/public/application/module/common')
    ],
    modulesDirectories: ['node_modules']
  },
  module: {
    loaders: [
      {
        test: /\.js$/,
        loader: 'babel',
        query: {
          presets: ['es2015']
        }
      },
      {
        test: /\.less$/,
        loader: "style!css!less"
      },
      {
        test: /\.css$/,
        loader: ExtractTextPlugin.extract('style-loader', 'css-loader')
      },
      {
        test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
        loader: "file",
        query: {
          name: 'font/[name].[ext]'
        }
      },
      {
        test: /\.(woff|woff2)/,
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
  plugins: [
    new ExtractTextPlugin('[name].css')
  ]
};
