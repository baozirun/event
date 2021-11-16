const path = require('path')
const webpack = require('webpack')

function resolve(dir) {
  return path.join(__dirname, dir)
}

const monent = require('moment')
const hash = monent().format('YYYYMMDDHHmmss')+'.'+new Date().getTime();

// 动态修改环境变量
// 执行命令： npm run build -- --VUE_APP_CONTEXT=/mbp/system
process.argv.forEach(item=>{
  if(item.startsWith('--VUE_APP')){
    let arr=item.substr(2,item.length).split('=');
    process.env[arr[0]]=arr[1]
    console.log('set process evn '+arr[0]+'='+arr[1])
  }
})

// vue.config.js
module.exports = {
  publicPath: process.env.NODE_ENV === 'production' ? process.env.VUE_APP_CONTEXT : '',
  outputDir: '../event-server/src/main/resources/static',
  /*
    Vue-cli3:
    Crashed when using Webpack `import()` #2463
    https://github.com/vuejs/vue-cli/issues/2463

   */
  /*
  pages: {
    index: {
      entry: 'src/main.js',
      chunks: ['chunk-vendors', 'chunk-common', 'index']
    }
  },
  */
  configureWebpack: {
    plugins: [
      // Ignore all locale files of moment.js
      new webpack.IgnorePlugin(/^\.\/locale$/, /moment$/)
    ],
    output: {
      filename: `[name].${hash}.js`,
      chunkFilename: `[name].${hash}.js`
    }
  },

  chainWebpack: (config) => {
    config.resolve.alias
      .set('@$', resolve('src'))
      .set('@api', resolve('src/api'))
      .set('@comp', resolve('src/components'))
      .set('@views', resolve('src/views'))
      .set('@layout', resolve('src/layout'))
      .set('@static', resolve('src/static'))

    const svgRule = config.module.rule('svg')
    svgRule.uses.clear()
    svgRule
      .oneOf('inline')
      .resourceQuery(/inline/)
      .use('vue-svg-icon-loader')
      .loader('vue-svg-icon-loader')
      .end()
      .end()
      .oneOf('external')
      .use('file-loader')
      .loader('file-loader')
      .options({
        name: 'assets/[name].[hash:8].[ext]'
      })
    /* svgRule.oneOf('inline')
      .resourceQuery(/inline/)
      .use('vue-svg-loader')
      .loader('vue-svg-loader')
      .end()
      .end()
      .oneOf('external')
      .use('file-loader')
      .loader('file-loader')
      .options({
        name: 'assets/[name].[hash:8].[ext]'
      })
    */
  },

  css: {
    loaderOptions: {
      less: {
        modifyVars: {
          /* less 变量覆盖，用于自定义 ant design 主题 */

          /*
          'primary-color': '#F5222D',
          'link-color': '#F5222D',
          'border-radius-base': '4px',
          */
        },
        javascriptEnabled: true
      }
    },
    extract:{
      filename: `css/[name].${hash}.css`,
      chunkFilename:`css/[name].${hash}.css`,
    }
  },

  devServer: {
    // development server port 8000
    port: 8000,
    proxy: {
      "/login": {
        // target: "http://127.0.0.1:8080",
        target: "http://130.120.3.253",
        ws: false,
        changeOrigin: true
      },
      "/": {
        target: "http://localhost:8080",
        // target: "http://130.120.2.146:8080",
        // target: "http://130.120.3.253/system",
        ws: false,
        changeOrigin: true
      }
    }
  },

  productionSourceMap: false,
  lintOnSave: undefined,
  // babel-loader no-ignore node_modules/*
  transpileDependencies: []
}