const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');
const resolve = require('path');

module.exports = {
  devServer: {
    hot: true,

//    contentBase: resolve.join(__dirname, './'),
/*
    contentBase : [
      "assets"
    ],
    publicPath: '/',

    historyApiFallback: true
    */
  },
  plugins: [
    new HtmlWebpackPlugin({
      title: 'My App',
      template: 'index.ejs',
      inject: 'head'
    }),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NamedModulesPlugin()
  ],
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader' ]
      }
    ],
    loaders: [
      { test: /\.css$/, loader: "style-loader!css-loader" },
      { test: /\.hbs$/, loader: "handlebars" },
      { 
//        enforce :'pre', 
        test: /\.js$/, 
        loader: 'source-map-loader', 
  //      exclude: [/(.*scala.*)/, /(.*.map)/, /happy-web-components-fastopt.js/, /(.*.scala)/, /node_modules/, /scala/, /scala-js/, /happy-web-components-fastopt-bundle/, /\*.map/] , 
        options: {quite: true }},
      {
        test: /\.html$/,
        loader: '!html-loader'

/*        use: {
          loader: 'html-loader',
          options: {
            attrs: [':data-src']
          }
        }*/
      }
    ]
  }
};
