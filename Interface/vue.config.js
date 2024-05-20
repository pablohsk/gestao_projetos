const TerserPlugin = require('terser-webpack-plugin');

module.exports = {
    configureWebpack: {
        optimization: {
            minimize: true,
            minimizer: [new TerserPlugin({
                terserOptions: {
                    compress: {
                        drop_console: true,
                    },
                },
                parallel: true,
            })],
        },
    },
};
