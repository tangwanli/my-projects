<template>
  <div class="game">
    <p class='score'>score: {{score}}</p>
    <div class="all-pic"><img></div>
  </div>
</template>

<script>
export default {
  name: 'game',
  data () {
    return {
      msg: 'game page',
      score: 0
    }
  },
  // 还有bug，点击了之后不会立即消失，以后再改了
  mounted() {
    let doc = document,
        allPic = doc.getElementsByClassName('all-pic')[0],
        boxHeight = doc.getElementsByClassName('game')[0].clientHeight,
        multiple = allPic.clientWidth - allPic.firstElementChild.clientWidth; // 用总的div长度减去一个img的长度，保证img不会超出框框
        
        let timer = setInterval(function(){
                let allPic = doc.getElementsByClassName('all-pic')[0],
                    pics = allPic.getElementsByTagName('img'),
                    len = pics.length -1
                if (len < 5) {
                let src = "../../static/monster" + Math.round(Math.random()*3) + ".png", 
                    left = Math.random()*multiple,
                    newImg = doc.createElement('img');
                  newImg.setAttribute('src',src);
                  newImg.style.left = left + 'px';
                  allPic.appendChild(newImg);

                  for (let i=0;i<len;i++) {
                    pics[i].onclick = function() {
                      allPic.removeChild(pics[i]);
                      console.log('success',this,i);
                    }
                  }
                }
                else {
                  clearInterval(timer);
                }
           //   console.log('what happen2',len);
        }, 1000);
  console.log('what happen' ,boxHeight);
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
</style>