const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

const drawPic = {
  data: {
    rpx: 0
  },
  showCanvas: function () {
    var context = wx.createCanvasContext('smile'),
    // 创建渐变对象
    gradient = context.createLinearGradient(0, 0, this.setPx(615), this.setPx(578));
    gradient.addColorStop(0, "red");
    gradient.addColorStop(0.25, "#ec71df");
    gradient.addColorStop(0.5, "#2944b9");
    gradient.addColorStop(0.75, "#81dde2");
    gradient.addColorStop(1, "#f0ef85");
    // 创建阴影
    context.shadowColor = "rgba(0, 0, 0, 0.5)";
    context.shadowBlur = 3;
    context.shadowOffsetX = 7;
    context.shadowOffsetY = 7;
    // 绘制路径
    context.arc(this.setPx(157), this.setPx(160), this.setPx(157), -Math.PI / 18, -(Math.PI - Math.PI / 18), true);
    context.moveTo(this.setPx(655), this.setPx(155));
    context.arc(this.setPx(500), this.setPx(160), this.setPx(157), -Math.PI / 18, -(Math.PI - Math.PI / 18), true);
    context.moveTo(this.setPx(585), this.setPx(360));
    context.arc(this.setPx(330), this.setPx(270), this.setPx(280), Math.PI / 9, (Math.PI - Math.PI / 9), false);
    context.setStrokeStyle(gradient);
    context.setLineWidth(4);
    context.stroke();
    context.draw();
  },
  setPx: function (rpxSize) {
    return this.data.rpx * rpxSize;
  },
  initRpx: function () {
    var that = this;
    wx.createSelectorQuery().select('.container').boundingClientRect(function (rect) {
      that.data.rpx = rect.width / 750;
      that.showCanvas();
    }).exec();
  }
};

module.exports = {
  formatTime: formatTime,
  drawPic: drawPic
}
