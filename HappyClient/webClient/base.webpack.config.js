var webpack = require('webpack');
var merge = require("webpack-merge");

//var HtmlWebpackPlugin = require('html-webpack-plugin');
var generatedConfig = require('./scalajs.webpack.config');
var commonConfig = require('./common.webpack.config.js');

module.exports = merge(generatedConfig, commonConfig);

/*
module.exports = {
  entry: "./entry.js",
  output: {
    path: __dirname,
    filename: "bundle.js"
  },
  module: {
    loaders: [
      { test: /\.css$/, loader: "style-loader!css-loader" }
    ]
  }
};
*/
