<template>
<div>
    <!-- 美食信息上传模块 -->
    <div class="fod sec">
      <div class="fod-box">
          <!-- 美食上传模块 -->
        <div class="fod-upload">
              <span>
          <img class="food-pic" width="200px" height="200px" src="static/img/c2.jpg">
          </span>
          <input @change="changeFoodPic($event)" id="food" type="file">
          <label for="food" class="select-food">选择菜品图片</label>
          <span @click="subAddGood($event)" class="confirm-upload-all">确定上传</span>
        </div>
        <!-- //美食上传模块 -->
        <!-- 美食首页模块 -->
        <div class="fod-poster-upload">
        <ul class="list-group file-inf">
          <li class="list-group-item list-group-item-success file-name">文件名： <span></span></li>
          <li class="list-group-item list-group-item-info file-size">文件大小： <span></span></li>
          <li class="list-group-item list-group-item-warning file-type">文件类型： <span></span></li>
          <li class="list-group-item list-group-item-danger file-lastModified">文件上次修改时间： <span></span></li>
          <li class="list-group-item list-group-item-success file-path">Blob文件路径： <span></span></li>
          <li class="list-group-item list-group-item-info file-size"></li>
          <li class="list-group-item list-group-item-warning file-type"></li>
          <li class="list-group-item list-group-item-danger file-path"></li>
          <li class="list-group-item list-group-item-success file-name"></li>
          <li class="list-group-item list-group-item-info file-size"></li>
          <li class="list-group-item list-group-item-warning file-type"></li>
          <li class="list-group-item list-group-item-danger file-path"></li>
          <li class="list-group-item list-group-item-success file-name"></li>
          <li class="list-group-item list-group-item-success file-name"></li>
          <li class="list-group-item list-group-item-info file-size"></li>
          <li class="list-group-item list-group-item-warning file-type"></li>
          <li class="list-group-item list-group-item-danger file-path"></li>
          <li class="list-group-item list-group-item-success file-name"></li>
          <li class="list-group-item list-group-item-success file-name"></li>
          <li class="list-group-item list-group-item-info file-size"></li>
          <li class="list-group-item list-group-item-warning file-type"></li>
          <li class="list-group-item list-group-item-danger file-path"></li>
          <li class="list-group-item list-group-item-success file-name"></li>
        </ul>
        </div>
        <!-- //美食首页模块 -->

        <!-- 美食信息模块 -->
        <div class="fod-inf-change">
          <div class="fod-change">
              <h3>美食信息</h3>
            <div class="btn-group">
              <button type="button" class="fod-type btn btn-info">选择类型</button> <!-- 最后食物的类型就读取的这个 -->
              <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
              </button>
              <ul @click="selType($event)" class="dropdown-menu">
                <li><a href="#">单人套餐</a></li>
                <li><a href="#">套餐</a></li>
                <li><a href="#">热菜</a></li>
                <li><a href="#">凉菜</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">粥</a></li>
                <li><a href="#">小吃</a></li>
                <li><a href="#">饮品</a></li>
              </ul>
            </div>
            <input class="fod-name" type="text" placeholder="请输入美食的名字：">
            <input class="fod-price" type="text" placeholder="请输入美食的价格：">
            <input class="fod-des" type="text" placeholder="请输入美食的描述：">
          </div>
          <div class="progress my-pro">
          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
            0%
          </div>
        </div>
        </div>
        <!-- //美食信息模块 -->
      </div>
  </div>
    <!-- //美食信息上传模块 -->
</div>

</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
    }
  },
  created() {
  },
  computed: {
  },
  methods: {
    changeFoodPic(ev) {
      let posFiles = ev.target.files;
      let reader = new FileReader();
      reader.readAsDataURL(posFiles[0]);
      reader.onload = function(event) {
        $('.food-pic').attr('src', event.target.result);
      }
      $('.file-name span').text(posFiles[0].name);
      $('.file-size span').text(posFiles[0].size);
      $('.file-type span').text(posFiles[0].type);
      $('.file-lastModified span').text(new Date(parseInt(posFiles[0].lastModified)).toLocaleString());
      $('.file-path span').text(URL.createObjectURL(posFiles[0]));
    },
    selType(ev) {
      $('.fod-type').text($(ev.target).text());
    },
    subAddGood(ev) {
      let foodSrc = '';
      if ($('.food-pic').attr('src') !== 'static/img/c2.jpg') {
        foodSrc = $('.food-pic').attr('src');
      }
      $.post('AddGoodsServlet', {
        foodname: $('.fod-name').val(),
        price: $('.fod-price').val(),
        foodType: $('.fod-type').text(),
        description: $('.fod-des').val(),
        icon: foodSrc
      }, (res) => {
        this.$router.push('addGoods');
        alert('添加菜品成功');
        $('.fod-name').val('');
        $('.fod-price').val('');
        $('.fod-des').val('');
        $('.file-inf span').text('');
        $('.food-pic').attr('src', 'static/img/c2.jpg');
      });
    }
  }
}

</script>

<style scoped>
  @import '../../common/global2'
</style>