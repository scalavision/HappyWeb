var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  plugins: [new HtmlWebpackPlugin({
    title: 'My App',
    template: 'index.ejs'
  })],
  module: {
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
        loader: '!html-loader',
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
