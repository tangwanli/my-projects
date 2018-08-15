const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
	mode: 'development',
    entry: './src/app.js',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'main.js'
    },
    plugins: [
        new HtmlWebpackPlugin({
        	filename: 'index.html',
        	template: path.resolve(__dirname, 'src/index.html')
        })
    ],
    module: {
    	rules: [{
    	    test: /\.css$/,
    	    use: ['style-loader',
            {
                loader: 'css-loader',
                module: false
            }]/*,
            exclude: [
                path.resolve(__dirname,'src/common')
            ],
            include: [
                path.resolve(__dirname,'src/common')
            ]*/
    	},
        {
            test: /\.s(a|c)ss$/,
            use: ['style-loader','css-loader','sass-loader',]
        },
    	{
    	    test: /\.(jpg|ttf|eot|woff|woff2|svg)$/,
    	    use: ['file-loader']
    	},
    	{
    	    test: /\.(jpg|jpeg|png|gif)$/,
    	    use: [{
    	    	loader: 'url-loader',
    	    	options: {
    	    		limit: 100000
    	    	}
    	    }]
    	}]
    },
    devServer: {
    	open: true,
    	port: 8990
    }
};