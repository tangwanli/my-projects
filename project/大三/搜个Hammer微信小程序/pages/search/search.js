//index.js
//获取应用实例
const app = getApp();
const util = require("../../utils/util.js");

Page({
  data: {
    userInfo: {},
    hasUserInfo: false,
    rpx: 0,
    rotate: false,
    isfocus: false,
    inpVal: '',
    isUrl: false,
    url: ''
  },
  onReady: function () {
    util.drawPic.initRpx();
    wx.getUserInfo({
      success: res => {
        app.globalData.userInfo = res.userInfo;
        // 这里面的this依然指向page
        this.setData({
          userInfo: app.globalData.userInfo
        });
      }
    })
  },
  getUserInfo: function (e) {
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  tapInp: function(e) {
    this.setData({
      isfocus: true
    });
  },
  setInp: function(e) {
    this.setData({
      inpVal: e.detail.value
    });
  },
  submit: function(e) {
    if(this.data.inpVal !== '') {
      var that = this;
      wx.request({
        url: 'http://suggestion.baidu.com/su',
        data: {
          wd: that.data.inpVal,
          cb: "twl"
        },
        success: function (res) {
          /*twl({q:"undefined",p:false,s:["undefined是什么意思","undefined reference to","undefined symbol","undefined control sequence","js undefined判断","undefined reference to vtable for","undefined is not a function","undefined is not an object evaluating","undefined js","undefined is not an object"]}); */

          // 由于返回的jsonp数据，中的为一个对象字符串不为json字符串，所以就很难转换为对象，就只有通过下面方法慢慢来
          // 由于正则表达式的(?<=x)在这里用会出问题，所以这里还要用一个split
          // 先去掉最后的那个括号,然后再去掉前面的'twl({'，再去掉',s:[',去掉之后再加上'"s":['
          var twl = res.data,
            reg = /.+(?=\);$)/g,
            sDataStr = '{"s":[' + reg.exec(twl)[0].split('twl({')[1].split(',s:[')[1],
            sDataObj = JSON.parse(sDataStr);

          console.log(sDataObj);
          that.setData({
            isUrl: true,
            url: "http://www.baidu.com/s?wd='" +sDataObj.s[0]+ "'"
          });
          /*wx.navigateTo({
            url: "http://www.baidu.com/s?wd='+sDataObj.s[0]+'"
          });*/
        },
        fail: function (data) {
          console.log(data + '1234');
        }
      });
    }
  }
})
