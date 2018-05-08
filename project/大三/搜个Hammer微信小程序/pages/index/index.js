//index.js
//获取应用实例
const app = getApp();
const util = require("../../utils/util.js");

Page({
  data: {
    welcome: '开始旋转',
    rpx: 0,
    rotate: false
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onReady: function() {
    util.drawPic.initRpx();
  },
  eyesRotate: function(e) {
    this.setData({
      rotate: true
    });
    setTimeout(function(){
      wx.navigateTo({
        url: '../search/search'
      });
    },1100);
  }
})
