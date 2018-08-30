<template>
  <div class='study' @click="leave">
  <input type="radio" name="time" id="sunrise" checked />
    <input type="radio" name="time" id="sunset" />
    <div>

    </div>
    <div class='szene'>
        <div class='image i1'>
            JavaScript
            <div class='nail'>
            </div>
        </div>
        <div class='image i2'>
             CSS
            <div class='nail'>
            </div>
        </div>
    <div class="box2" style="margin: 60px 0 0 403px;transform: scale(1.5);">
        <router-view></router-view>
    </div>
    <div class='body'>
        </div>
        <div class='table'>
        </div>
        <div class='laptop'>
        </div>
        <div class='mouse'>
        </div>
        <div class='notes'>
        </div>
        <div class='lamp'>
            <div class='top'>
            </div>
        </div>
        <div class='headphones'>
        </div>
        <div class='trash'>
            <div class='paper p1'>
            </div>
            <div class='paper p2'>
            </div>
            <div class='paper p3'>
            </div>
            <div class='paper p4'>
            </div>
        </div>
    </div>
    <input type="radio" name="time" id="sunrise" checked />
    <input type="radio" name="time" id="sunset" />
    <div class="heavens">
        <label class="sunrise"></label>
        <label class="sunset"></label>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  mounted() {
        setInterval(() => {
        //   debugger
        var sunrise = document.getElementById('sunrise');
        var sunset = document.getElementById('sunset');
        sunrise.removeAttribute("checked");
        sunset.setAttribute("checked", true);
        var body = document.body;
        body.style.background = '#ccc';
    }, 2000);
  },
  methods: {
    leave(ev) {
        this.$router.push('/');
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
* {
    margin: 0;
    padding: 0;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}

*:before,
*:after {
    content: '';
    display: block;
    position: absolute;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}

.study {
    hieght: 100%;
    background: #fff;
}

.szene {
    position: absolute;
    left: 50%;
    bottom: 200px;
    width: 800px;
    height: 400px;
    margin-left: -400px;
    overflow: hidden;
}

.szene div {
    position: absolute;
}

.image {
    width: 120px;
    height: 120px;
    line-height: 100px;
    text-align: center;
    font-family: 'Open Sans', sans-serif;
    font-size: 18px;
    font-weight: 700;
    color: #888;
    border: 8px solid #444;
    background: #eee;
}

.image.i1 {
    top: 100px;
    left: 100px;
}

.image.i2 {
    top: 50px;
    left: 300px;
}

.image .nail {
    top: -30px;
    left: 50%;
    width: 8px;
    height: 8px;
    margin-left: -4px;
    border-radius: 50%;
    background: #444;
}

.image .nail:before,
.image .nail:after {
    top: -5px;
    width: 1px;
    height: 35px;
    background: #444;
}

.image .nail:before {
    left: -11px;
    -webkit-transform: rotate(55deg);
    -ms-transform: rotate(55deg);
    transform: rotate(55deg);
}

.image .nail:after {
    left: 19px;
    -webkit-transform: rotate(-55deg);
    -ms-transform: rotate(-55deg);
    transform: rotate(-55deg);
}

.head {
    bottom: 90px;
    left: 575px;
    width: 85px;
    height: 85px;
    border-radius: 50%;
    background: #eee;
}

.head .eyes {
    top: 58px;
    left: 30px;
    width: 6px;
    height: 6px;
    border-radius: 50%;
    background: #444;
    box-shadow: 20px 0 0 #444;
    -webkit-animation: 8s eyes ease infinite;
    animation: 8s eyes ease infinite;
}

@-webkit-keyframes eyes {
    0% {
        -webkit-transform: translate3d(0, 0, 0);
        transform: translate3d(0, 0, 0);
    }
    5% {
        -webkit-transform: translate3d(0, -18px, 0);
        transform: translate3d(0, -18px, 0);
    }
    10% {
        -webkit-transform: translate3d(0, -19px, 0);
        transform: translate3d(0, -19px, 0);
    }
    15% {
        -webkit-transform: translate3d(-15px, -18px, 0);
        transform: translate3d(-15px, -18px, 0);
    }
    20% {
        -webkit-transform: translate3d(-15px, -18px, 0);
        transform: translate3d(-15px, -18px, 0);
    }
    25% {
        -webkit-transform: translate3d(15px, -18px, 0);
        transform: translate3d(15px, -18px, 0);
    }
    30% {
        -webkit-transform: translate3d(15px, -18px, 0);
        transform: translate3d(15px, -18px, 0);
    }
    35% {
        -webkit-transform: translate3d(0, -18px, 0);
        transform: translate3d(0, -18px, 0);
    }
    40% {
        -webkit-transform: translate3d(0, -18px, 0);
        transform: translate3d(0, -18px, 0);
    }
    45% {
        -webkit-transform: translate3d(0, 0, 0);
        transform: translate3d(0, 0, 0);
    }
    100% {
        -webkit-transform: translate3d(0, 0, 0);
        transform: translate3d(0, 0, 0);
    }
}

@keyframes eyes {
    0% {
        -webkit-transform: translate3d(0, 0, 0);
        transform: translate3d(0, 0, 0);
    }
    5% {
        -webkit-transform: translate3d(0, -18px, 0);
        transform: translate3d(0, -18px, 0);
    }
    10% {
        -webkit-transform: translate3d(0, -19px, 0);
        transform: translate3d(0, -19px, 0);
    }
    15% {
        -webkit-transform: translate3d(-15px, -18px, 0);
        transform: translate3d(-15px, -18px, 0);
    }
    20% {
        -webkit-transform: translate3d(-15px, -18px, 0);
        transform: translate3d(-15px, -18px, 0);
    }
    25% {
        -webkit-transform: translate3d(15px, -18px, 0);
        transform: translate3d(15px, -18px, 0);
    }
    30% {
        -webkit-transform: translate3d(15px, -18px, 0);
        transform: translate3d(15px, -18px, 0);
    }
    35% {
        -webkit-transform: translate3d(0, -18px, 0);
        transform: translate3d(0, -18px, 0);
    }
    40% {
        -webkit-transform: translate3d(0, -18px, 0);
        transform: translate3d(0, -18px, 0);
    }
    45% {
        -webkit-transform: translate3d(0, 0, 0);
        transform: translate3d(0, 0, 0);
    }
    100% {
        -webkit-transform: translate3d(0, 0, 0);
        transform: translate3d(0, 0, 0);
    }
}

.body {
    bottom: -20px;
    left: 578px;
    width: 82px;
    height: 110px;
    border-radius: 0 0 50% 50%;
    background: #eee;
}

.table {
    bottom: 15px;
    left: 280px;
    width: 500px;
    height: 15px;
    background: #444;
}

.table:before,
.table:after {
    top: 15px;
    width: 10px;
    height: 20px;
    border-top: 3px solid #aaa;
    background: #eee;
}

.table:before {
    left: 20px;
}

.table:after {
    right: 20px;
}

.laptop {
    bottom: 35px;
    left: 550px;
    width: 140px;
    height: 70px;
    border-radius: 2px 2px 0 0;
    background: #ddd;
}

.laptop:before {
    top: 50%;
    left: 50%;
    width: 18px;
    height: 18px;
    margin: -9px 0 0 -9px;
    border-radius: 50%;
    background: #fff;
}

.laptop:after {
    top: 70px;
    left: -5px;
    width: 150px;
    height: 5px;
    border-radius: 2px 2px 0 0;
    background: #888;
}

.mouse {
    bottom: 30px;
    left: 510px;
    width: 20px;
    height: 6px;
    border-bottom: 2px solid #888;
    border-radius: 25%;
    background: #ddd;
}

.notes {
    bottom: 30px;
    left: 705px;
    width: 60px;
    height: 12px;
    background: #fff;
    border: 4px solid #222;
    border-radius: 4px;
    border-left: 0;
}

.lamp {
    bottom: 30px;
    left: 410px;
    width: 40px;
    height: 20px;
    border-radius: 80px 80px 0 0;
    background: #eee;
}

.lamp:before,
.lamp:after {
    z-index: -1;
    width: 6px;
    height: 80px;
    background: #ccc;
}

.lamp:before {
    top: -70px;
    left: 8px;
    -webkit-transform: rotate(-15deg);
    -ms-transform: rotate(-15deg);
    transform: rotate(-15deg);
}

.lamp:after {
    top: -108px;
    left: 30px;
    -webkit-transform: rotate(75deg);
    -ms-transform: rotate(75deg);
    transform: rotate(75deg)
}

.lamp .top {
    top: -75px;
    left: 45px;
    width: 50px;
    height: 25px;
    border-radius: 100px 100px 0 0;
    background: #eee;
    -webkit-transform: rotate(-15deg);
    -ms-transform: rotate(-15deg);
    transform: rotate(-15deg);
}

.headphones {
    bottom: 85px;
    left: 547px;
    width: 137px;
    height: 110px;
    border-radius: 50%;
    border-top: 10px solid #444;
}

.headphones:before,
.headphones:after {
    width: 20px;
    height: 40px;
    top: 20px;
    background: #ddd;
}

.headphones:before {
    left: -8px;
    border-radius: 80px 0 0 80px;
    border-right: 3px solid #444;
}

.headphones:after {
    right: -7px;
    border-radius: 0 80px 80px 0;
    border-left: 3px solid #444;
}

.trash {
    bottom: 10px;
    left: 20px;
    width: 100px;
    height: 8px;
    background: #444;
}

.trash:after {
    top: 8px;
    left: 3px;
    width: 94px;
    height: 25px;
    border-radius: 0 0 50px 50px;
    background: #555;
}

.trash .paper {
    z-index: -1;
    width: 25px;
    height: 50px;
    border: 2px solid #555;
    background: #ddd;
}

.trash .paper.p1 {
    top: -15px;
    left: 10px;
    -webkit-transform: rotate(-20deg);
    -ms-transform: rotate(-20deg);
    transform: rotate(-20deg);
}

.trash .paper.p2 {
    top: -12px;
    left: 30px;
    -webkit-transform: rotate(-40deg);
    -ms-transform: rotate(-40deg);
    transform: rotate(-40deg);
}

.trash .paper.p3 {
    top: -15px;
    left: 60px;
    -webkit-transform: rotate(10deg);
    -ms-transform: rotate(10deg);
    transform: rotate(10deg);
}

.trash .paper.p4 {
    top: -12px;
    left: 30px;
    -webkit-transform: rotate(65deg);
    -ms-transform: rotate(65deg);
    transform: rotate(65deg);
}

/* 日出日落 */

#sunset:checked~* {
    --sunset: 1;
    --sunrise: 0;
    --color-building-dark: #00436F;
    --color-building: #0258C6;
    --color-building-light: #1771C5;
    --color-cloud: #9ED5F8;
}

#sunrise:checked~* {
    --sunrise: 1;
    --sunset: 0;
    --color-building-dark: #50A8E3;
    --color-building: #9BD9FE;
    --color-building-light: #E5F7FE;
    --color-cloud: white;
}

:root {
    --color-window-dark: #3B98D8;
    --color-window-light: white;
}

.heavens {
    -webkit-box-flex: 0;
    -webkit-flex: 0 0 30%;
    -ms-flex: 0 0 30%;
    flex: 0 0 30%;
}

#app:before,
#app:after {
    content: '';
    position: absolute;
    display: block;
    width: 100vw;
    height: 100vh;
    left: calc(50% - 50vw);
    top: calc(50% - 50vh);
    z-index: -10;
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
}

#app:before {
    background: -webkit-linear-gradient(top, #73DAF9, #E5F7FE);
    background: linear-gradient(to bottom, #73DAF9, #E5F7FE);
    opacity: var(--sunrise);
}

#app:after {
    background: -webkit-linear-gradient(top, #0846B0, #23B2EE);
    background: linear-gradient(to bottom, #0846B0, #23B2EE);
    opacity: var(--sunset);
}

.sky {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    box-shadow: 0 0 2rem rgba(0, 0, 0, 0.1);
}

.sky:before,
.sky:after {
    content: '';
    display: block;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    z-index: -1;
}

.sky:before {
    background: -webkit-linear-gradient(top, #2CA4F4, #C2E6FB);
    background: linear-gradient(to bottom, #2CA4F4, #C2E6FB);
    opacity: var(--sunrise);
}

.sky:after {
    background: -webkit-linear-gradient(top, #043385, #1797D7);
    background: linear-gradient(to bottom, #043385, #1797D7);
    opacity: var(--sunset);
}

.times {
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: horizontal;
    -webkit-box-direction: normal;
    -webkit-flex-direction: row;
    -ms-flex-direction: row;
    flex-direction: row;
    -webkit-box-pack: justify;
    -webkit-justify-content: space-between;
    -ms-flex-pack: justify;
    justify-content: space-between;
    padding-top: 0.5rem;
    overflow: hidden;
}

.time {
    color: white;
}

.time:nth-child(1) {
    -webkit-animation-delay: 0s !important;
    animation-delay: 0s !important;
}

.time:nth-child(2) {
    -webkit-animation-delay: 0.05s !important;
    animation-delay: 0.05s !important;
}

.time:nth-child(3) {
    -webkit-animation-delay: 0.1s !important;
    animation-delay: 0.1s !important;
}

.time:nth-child(4) {
    -webkit-animation-delay: 0.15s !important;
    animation-delay: 0.15s !important;
}

.time:nth-child(5) {
    -webkit-animation-delay: 0.2s !important;
    animation-delay: 0.2s !important;
}

.time:first-child:after {
    font-size: 2.5rem;
}

.time:first-child~.time {
    opacity: 0.5;
}

.time:before {
    content: '';
    display: block;
    left: calc(50% - 0.8rem);
    margin-bottom: 0.5rem;
    width: 0;
    height: 0;
    border-width: 0.8rem;
    border-style: solid;
    border-color: transparent;
    border-bottom-color: white;
}

.time:after {
    font-size: 2rem;
}

.city {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
}

.windows {
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    background: -webkit-repeating-linear-gradient(bottom, #044DA8 0, #044DA8 6px, transparent 6px, transparent var(--window-space, 14px));
    background: repeating-linear-gradient(to top, #044DA8 0, #044DA8 6px, transparent 6px, transparent var(--window-space, 14px));
    overflow: hidden;
}

.windows,
.windows:before,
.windows:after {
    background-clip: content-box !important;
}

.windows:before,
.windows:after {
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    content: '';
    display: block;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
}

.windows:before {
    background: -webkit-repeating-linear-gradient(bottom, var(--window-color, var(--color-window-light)) 0, var(--window-color, var(--color-window-light)) 6px, transparent 6px, transparent var(--window-space, 14px));
    background: repeating-linear-gradient(to top, var(--window-color, var(--color-window-light)) 0, var(--window-color, var(--color-window-light)) 6px, transparent 6px, transparent var(--window-space, 14px));
    opacity: var(--sunrise);
}

.windows:after {
    background: -webkit-repeating-linear-gradient(bottom, gold 0, gold 6px, transparent 6px, transparent var(--window-space, 14px));
    background: repeating-linear-gradient(to top, gold 0, gold 6px, transparent 6px, transparent var(--window-space, 14px));
    opacity: var(--sunset);
    -webkit-transition-delay: calc(var(--sunset, 0) * 1.5s);
    transition-delay: calc(var(--sunset, 0) * 1.5s);
    -webkit-transition-duration: 0.75s;
    transition-duration: 0.75s;
}

.ledge {
    width: 100%;
    height: 0;
    padding: 50% 0;
    overflow: hidden;
}

.ledge:before {
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    content: '';
    display: block;
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    -webkit-transform-origin: right top;
    transform-origin: right top;
    background: -webkit-linear-gradient(top, rgba(0, 0, 0, 0.3), transparent);
    background: linear-gradient(to bottom, rgba(0, 0, 0, 0.3), transparent);
}

.ledge:after {
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    content: '';
    display: block;
    position: absolute;
    top: 0;
    height: 4px;
    width: 100%;
    background: var(--color-building);
    box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
}

.building {
    position: absolute;
    bottom: 0;
    height: 60%;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: horizontal;
    -webkit-box-direction: normal;
    -webkit-flex-direction: row;
    -ms-flex-direction: row;
    flex-direction: row;
    -webkit-box-pack: end;
    -webkit-justify-content: flex-end;
    -ms-flex-pack: end;
    justify-content: flex-end;
    -webkit-box-align: end;
    -webkit-align-items: flex-end;
    -ms-flex-align: end;
    align-items: flex-end;
    z-index: 1;
}

.building>.tower {
    bottom: 0;
    z-index: 1;
    background: currentColor;
}

.building>.tower,
.building>.tower:before,
.building>.tower:after {
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
}

.building:nth-child(1) {
    left: 64px;
    height: 145px;
}

.building:nth-child(1)>.tower:nth-child(1) {
    --color-pointy: var(--color-building-dark);
    width: 21px;
    height: 70%;
    background: white;
    color: var(--color-building-dark);
    background: currentColor;
    --window-color: var(--color-window-dark);
}

.building:nth-child(1)>.tower:nth-child(1):after {
    content: '';
    display: block;
    position: absolute;
    width: 3px;
    height: 30px;
    bottom: 100%;
    box-shadow: 15px -5px 0 var(--color-pointy);
    z-index: -1;
}

.building:nth-child(1)>.tower:nth-child(1):before {
    content: '';
    display: block;
    position: absolute;
    bottom: 100%;
    left: 0;
    height: 2rem;
    width: 100%;
    z-index: -1;
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    background: var(--color-pointy);
    -webkit-transform-origin: bottom right;
    transform-origin: bottom right;
    -webkit-transform: skewY(-45deg);
    transform: skewY(-45deg);
    z-index: -1;
}

.building:nth-child(1)>.tower:nth-child(1) .windows,
.building:nth-child(1)>.tower:nth-child(1) .windows:before,
.building:nth-child(1)>.tower:nth-child(1) .windows:after {
    padding-right: 8px;
}

.building:nth-child(1)>.tower:nth-child(2) {
    --color-pointy: var(--color-building);
    width: 50px;
    height: 100%;
    color: var(--color-building);
}

.building:nth-child(1)>.tower:nth-child(2):before {
    content: '';
    display: block;
    position: absolute;
    bottom: 100%;
    left: 0;
    height: 45%;
    width: 100%;
    z-index: -1;
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    background: var(--color-pointy);
    -webkit-transform-origin: bottom right;
    transform-origin: bottom right;
    -webkit-transform: skewY(-55deg);
    transform: skewY(-55deg);
    z-index: -1;
}

.building:nth-child(1)>.tower:nth-child(2) .windows,
.building:nth-child(1)>.tower:nth-child(2) .windows:before,
.building:nth-child(1)>.tower:nth-child(2) .windows:after {
    padding-left: 12px;
}

.building:nth-child(1)>.tower:nth-child(3) {
    --color-pointy: var(--color-building);
    width: 21px;
    height: 90%;
    color: var(--color-building);
    -webkit-transform-origin: bottom left;
    transform-origin: bottom left;
}

.building:nth-child(1)>.tower:nth-child(3):after {
    content: '';
    display: block;
    position: absolute;
    width: 3px;
    height: 30px;
    bottom: 100%;
    box-shadow: 5px -15px 0 var(--color-pointy), 10px -5px 0 var(--color-pointy);
    z-index: -1;
}

.building:nth-child(1)>.tower:nth-child(3):before {
    content: '';
    display: block;
    position: absolute;
    bottom: 100%;
    left: 0;
    height: 2rem;
    width: 100%;
    z-index: -1;
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    background: var(--color-pointy);
    -webkit-transform-origin: bottom left;
    transform-origin: bottom left;
    -webkit-transform: skewY(30deg);
    transform: skewY(30deg);
    z-index: -1;
}

.building:nth-child(1)>.tower:nth-child(3) .windows,
.building:nth-child(1)>.tower:nth-child(3) .windows:before,
.building:nth-child(1)>.tower:nth-child(3) .windows:after {
    padding-left: 12px;
}

.building:nth-child(2) {
    left: 284px;
    height: 250px;
}

.building:nth-child(2)>.tower:nth-child(1),
.building:nth-child(2)>.tower:nth-child(3) {
    width: 38px;
    height: 50%;
}

.building:nth-child(2)>.tower:nth-child(1) .windows,
.building:nth-child(2)>.tower:nth-child(1) .windows:before,
.building:nth-child(2)>.tower:nth-child(1) .windows:after,
.building:nth-child(2)>.tower:nth-child(3) .windows,
.building:nth-child(2)>.tower:nth-child(3) .windows:before,
.building:nth-child(2)>.tower:nth-child(3) .windows:after {
    padding: 0 6px;
}

.building:nth-child(2)>.tower:nth-child(1) {
    color: var(--color-building-dark);
    --color-pointy: var(--color-building-dark);
    --window-color: var(--color-window-dark);
    --window-space: 20px;
}

.building:nth-child(2)>.tower:nth-child(1):after {
    content: '';
    display: block;
    position: absolute;
    width: 3px;
    height: 30px;
    bottom: 100%;
    box-shadow: 10px 15px 0 var(--color-pointy), 20px 20px 0 var(--color-pointy);
    z-index: -1;
}

.building:nth-child(2)>.tower:nth-child(1):before {
    content: '';
    display: block;
    position: absolute;
    bottom: 100%;
    left: 0;
    height: 4px;
    width: 100%;
    background: var(--color-building);
}

.building:nth-child(2)>.tower:nth-child(2) {
    width: 62px;
    height: 100%;
    color: var(--color-building);
    --color-pointy: var(--color-building);
    --window-color: var(--color-window-light);
    --window-space: 20px;
}

.building:nth-child(2)>.tower:nth-child(2):after {
    content: '';
    display: block;
    position: absolute;
    width: 3px;
    height: 30px;
    bottom: 100%;
    box-shadow: 20px 5px 0 var(--color-pointy), 40px 15px 0 var(--color-pointy);
    z-index: -1;
}

.building:nth-child(2)>.tower:nth-child(2):before {
    content: '';
    height: 100%;
    position: absolute;
    top: 0;
    display: block;
    width: 20px;
    background: var(--color-building-dark);
}

.building:nth-child(2)>.tower:nth-child(2) .windows,
.building:nth-child(2)>.tower:nth-child(2) .windows:before,
.building:nth-child(2)>.tower:nth-child(2) .windows:after {
    padding-left: 30px;
}

.building:nth-child(2)>.tower:nth-child(3) {
    color: var(--color-building);
    --window-space: 20px;
}

.building:nth-child(3) {
    left: 554px;
    height: 180px;
}

.building:nth-child(3)>.tower:nth-child(1) {
    --color-pointy: var(--color-building-dark);
    width: 21px;
    height: 70%;
    background: white;
    color: var(--color-building-dark);
    background: var(--color-building-dark);
    --window-color: var(--color-window-dark);
}

.building:nth-child(3)>.tower:nth-child(1):before {
    content: '';
    display: block;
    position: absolute;
    bottom: 100%;
    left: 0;
    height: 2rem;
    width: 100%;
    z-index: -1;
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    background: var(--color-pointy);
    -webkit-transform-origin: bottom right;
    transform-origin: bottom right;
    -webkit-transform: skewY(-55deg);
    transform: skewY(-55deg);
    z-index: -1;
}

.building:nth-child(3)>.tower:nth-child(1) .windows,
.building:nth-child(3)>.tower:nth-child(1) .windows:before,
.building:nth-child(3)>.tower:nth-child(1) .windows:after {
    padding-right: 8px;
}

.building:nth-child(3)>.tower:nth-child(2) {
    --color-pointy: var(--color-building);
    width: 30px;
    height: 100%;
    color: var(--color-building);
}

.building:nth-child(3)>.tower:nth-child(2):after {
    content: '';
    display: block;
    position: absolute;
    width: 3px;
    height: 30px;
    bottom: 100%;
    box-shadow: 10px 20px 0 var(--color-pointy), 14px 23px 0 var(--color-pointy), 20px 15px 0 var(--color-pointy);
    z-index: -1;
}

.building:nth-child(3)>.tower:nth-child(2):before {
    content: '';
    display: block;
    position: absolute;
    bottom: 100%;
    left: 0;
    height: 4px;
    width: 100%;
    background: var(--color-building-light);
}

.building:nth-child(3)>.tower:nth-child(2) .windows,
.building:nth-child(3)>.tower:nth-child(2) .windows:before,
.building:nth-child(3)>.tower:nth-child(2) .windows:after {
    padding-left: 12px;
}

.building:nth-child(3)>.tower:nth-child(3) {
    --color-pointy: var(--color-building);
    width: 40px;
    height: 70%;
    color: var(--color-building);
    -webkit-transform-origin: bottom left;
    transform-origin: bottom left;
}

.building:nth-child(3)>.tower:nth-child(3):before {
    content: '';
    display: block;
    position: absolute;
    bottom: 100%;
    left: 0;
    height: 60px;
    width: 100%;
    z-index: -1;
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    background: var(--color-pointy);
    -webkit-transform-origin: bottom left;
    transform-origin: bottom left;
    -webkit-transform: skewY(50deg);
    transform: skewY(50deg);
    z-index: -1;
}

.building:nth-child(3)>.tower:nth-child(3) .windows,
.building:nth-child(3)>.tower:nth-child(3) .windows:before,
.building:nth-child(3)>.tower:nth-child(3) .windows:after {
    padding-left: 12px;
}

.heavens {
    position: absolute;
    width: 200px;
    right: 20px;
    top: 20px;
    z-index: 10;
    height: 100%;
    /* overflow: hidden; */
}

[class^="sun"] {
    position: absolute;
    text-align: center;
    width: 100%;
    cursor: pointer;
}

[class^="sun"]:before {
    content: attr(data-title);
    display: inline-block;
    width: 100%;
    margin: 2rem 0;
    color: white;
    font-size: 1.5rem;
}

[class^="sun"]:after {
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    margin-top: 1rem;
    content: '';
    display: inline-block;
    width: 100%;
    border-radius: 50%;
}

.glow {
    width: 200px;
    height: 200px;
    z-index: -1;
    position: absolute;
    right: 0;
    -webkit-filter: blur(50px);
    filter: blur(50px);
}

.glow:before,
.glow:after {
    content: '';
    display: block;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border-radius: 50%;
}

.glow:before {
    background: #FFFAAD;
}

.glow:after {
    background: white;
}

.sunrise:after {
    width: 78px;
    height: 78px;
    background: #FFFAAD;
    box-shadow: 0 0 0 1rem rgba(255, 250, 173, 0.3);
}

.sunset:before {
    margin-bottom: 3rem;
}

.sunset:after {
    width: 52px;
    height: 52px;
    background: white;
    box-shadow: 0 0 0 1rem rgba(255, 255, 255, 0.3), 0 0 0 2rem rgba(255, 255, 255, 0.15);
}

.clouds {
    overflow: hidden;
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 10rem;
    z-index: 1;
    -webkit-transition: box-shadow 3s cubic-bezier(0.25, 0, 0.1, 1);
    transition: box-shadow 3s cubic-bezier(0.25, 0, 0.1, 1);
}

.clouds:before,
.clouds:after {
    -webkit-animation-duration: 3s;
    animation-duration: 3s;
    -webkit-animation-timing-function: cubic-bezier(0.25, 0, 0.1, 1);
    animation-timing-function: cubic-bezier(0.25, 0, 0.1, 1);
    -webkit-animation-fill-mode: forwards;
    animation-fill-mode: forwards;
    -webkit-animation-direction: alternate;
    animation-direction: alternate;
    -webkit-animation-iteration-count: infinite;
    animation-iteration-count: infinite;
}

.clouds:before {
    background: white;
    box-shadow: 76px 48px 0 white, 163px 23px 0 white, 246px 24px 0 white, 311px 49px 0 white, 399px 56px 0 white, 479px 19px 0 white, 565px 33px 0 white, 645px 19px 0 white, 722px 21px 0 white, 798px 29px 0 white;
    -webkit-animation-name: clouds-sunrise;
    animation-name: clouds-sunrise;
}

.clouds:after {
    background: #9ED5F8;
    opacity: var(--sunset);
    box-shadow: 76px 48px 0 #9ED5F8, 163px 23px 0 #9ED5F8, 246px 24px 0 #9ED5F8, 311px 49px 0 #9ED5F8, 399px 56px 0 #9ED5F8, 479px 19px 0 #9ED5F8, 565px 33px 0 #9ED5F8, 645px 19px 0 #9ED5F8, 722px 21px 0 #9ED5F8, 798px 29px 0 #9ED5F8;
    -webkit-animation-name: clouds-sunset;
    animation-name: clouds-sunset;
}

@-webkit-keyframes clouds-sunrise {
    to {
        box-shadow: 76px 44px 0 white, 163px 13px 0 white, 246px 28px 0 white, 311px 57px 0 white, 399px 44px 0 white, 479px 21px 0 white, 565px 27px 0 white, 645px 20px 0 white, 722px 7px 0 white, 798px 34px 0 white;
    }
}

@keyframes clouds-sunrise {
    to {
        box-shadow: 76px 44px 0 white, 163px 13px 0 white, 246px 28px 0 white, 311px 57px 0 white, 399px 44px 0 white, 479px 21px 0 white, 565px 27px 0 white, 645px 20px 0 white, 722px 7px 0 white, 798px 34px 0 white;
    }
}

@-webkit-keyframes clouds-sunset {
    to {
        box-shadow: 76px 44px 0 #9ED5F8, 163px 13px 0 #9ED5F8, 246px 28px 0 #9ED5F8, 311px 57px 0 #9ED5F8, 399px 44px 0 #9ED5F8, 479px 21px 0 #9ED5F8, 565px 27px 0 #9ED5F8, 645px 20px 0 #9ED5F8, 722px 7px 0 #9ED5F8, 798px 34px 0 #9ED5F8;
    }
}

@keyframes clouds-sunset {
    to {
        box-shadow: 76px 44px 0 #9ED5F8, 163px 13px 0 #9ED5F8, 246px 28px 0 #9ED5F8, 311px 57px 0 #9ED5F8, 399px 44px 0 #9ED5F8, 479px 21px 0 #9ED5F8, 565px 27px 0 #9ED5F8, 645px 20px 0 #9ED5F8, 722px 7px 0 #9ED5F8, 798px 34px 0 #9ED5F8;
    }
}

.clouds:before,
.clouds:after {
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    -webkit-transition-timing-function: ease-in-out;
    transition-timing-function: ease-in-out;
    width: 10rem;
    height: 10rem;
    top: 5rem;
    left: -5rem;
    border-radius: 50%;
    content: '';
    display: block;
    position: absolute;
}

.stars {
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    overflow: hidden;
}

.stars:before,
.stars:after {
    -webkit-transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    transition: all 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1);
    opacity: var(--sunset);
    content: '';
    display: block;
    position: absolute;
    border-radius: 50%;
}

.stars:before {
    height: 3px;
    width: 3px;
    box-shadow: 576px 67px 3px white, 445px 343px 1px white, 53px 355px 4px white, 413px 236px 4px white, 115px 219px 3px white, 130px 288px 4px white, 251px 113px 4px white, 517px 85px 3px white, 143px 290px 1px white, 267px 364px 2px white, 743px 185px 1px white, 199px 14px 2px white, 79px 20px 2px white, 67px 277px 3px white, 731px 101px 3px white, 23px 214px 2px white, 668px 203px 3px white, 258px 280px 3px white, 729px 348px 4px white, 744px 288px 2px white, 299px 248px 2px white, 642px 283px 4px white, 558px 80px 1px white, 714px 23px 2px white, 254px 133px 3px white, 706px 302px 2px white, 326px 260px 3px white, 379px 289px 2px white, 378px 137px 3px white, 64px 9px 1px white;
}

.stars:after {
    height: 5px;
    width: 5px;
    box-shadow: 541px 201px 3px white, 791px 331px 3px white, 492px 186px 2px white, 286px 171px 3px white, 660px 307px 3px white, 586px 297px 4px white, 273px 278px 2px white, 468px 326px 2px white, 2px 41px 3px white, 378px 175px 3px white, 87px 186px 2px white, 405px 105px 2px white, 489px 282px 3px white, 39px 165px 3px white, 288px 110px 2px white, 141px 71px 3px white, 460px 175px 1px white, 435px 150px 3px white, 652px 202px 1px white, 367px 248px 2px white, 147px 252px 1px white, 690px 350px 3px white, 624px 118px 4px white, 263px 90px 1px white, 680px 221px 3px white, 265px 341px 1px white, 337px 300px 3px white, 704px 242px 3px white, 656px 202px 1px white, 346px 95px 4px white;
    -webkit-transition-delay: calc(var(--sunset) * 1.5s);
    transition-delay: calc(var(--sunset) * 1.5s);
}

input {
    position: absolute;
    visibility: hidden;
    pointer-events: none;
}

#sunrise:checked~#app .time {
    -webkit-animation: time-move-sunrise 1.5s none;
    animation: time-move-sunrise 1.5s none;
}

#sunrise:checked~#app .time:after {
    content: '';
    -webkit-animation: time-change-sunrise 2.5s both;
    animation: time-change-sunrise 2.5s both;
}

#sunrise:checked~#app .heavens>.sunset:before {
    -webkit-animation: fade-out 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: fade-out 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunrise:checked~#app .heavens>.sunset:after {
    -webkit-animation: circle-leave 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: circle-leave 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunrise:checked~#app .heavens>.sunrise {
    pointer-events: none;
}

#sunrise:checked~#app .heavens>.sunrise:before {
    -webkit-animation: fade-in 0.75s 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: fade-in 0.75s 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunrise:checked~#app .heavens>.sunrise:after {
    -webkit-animation: circle-enter 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: circle-enter 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunrise:checked~#app .glow:before {
    -webkit-animation: circle-enter 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: circle-enter 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunrise:checked~#app .glow:after {
    -webkit-animation: circle-leave 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: circle-leave 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunrise:checked~#app .ledge:before {
    -webkit-animation: ledge-shadow-sunrise 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: ledge-shadow-sunrise 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
}

@-webkit-keyframes ledge-shadow-sunrise {
    50% {
        -webkit-transform: skewX(-25deg);
        transform: skewX(-25deg);
    }
    60% {
        -webkit-transform: skewX(-80deg);
        transform: skewX(-80deg);
    }
    from,
    to {
        -webkit-animation-timing-function: ease;
        animation-timing-function: ease;
        -webkit-transform: skewX(-45deg);
        transform: skewX(-45deg);
    }
}

@keyframes ledge-shadow-sunrise {
    50% {
        -webkit-transform: skewX(-25deg);
        transform: skewX(-25deg);
    }
    60% {
        -webkit-transform: skewX(-80deg);
        transform: skewX(-80deg);
    }
    from,
    to {
        -webkit-animation-timing-function: ease;
        animation-timing-function: ease;
        -webkit-transform: skewX(-45deg);
        transform: skewX(-45deg);
    }
}

@-webkit-keyframes time-move-sunrise {
    50% {
        -webkit-transform: translateY(-25%);
        transform: translateY(-25%);
        opacity: 0;
    }
}

@keyframes time-move-sunrise {
    50% {
        -webkit-transform: translateY(-25%);
        transform: translateY(-25%);
        opacity: 0;
    }
}

#sunset:checked~.time {
    -webkit-animation: time-move-sunset 1.5s none;
    animation: time-move-sunset 1.5s none;
}

#sunset:checked~.time:after {
    content: '';
    -webkit-animation: time-change-sunset 2.5s both;
    animation: time-change-sunset 2.5s both;
}

#sunset:checked~.heavens>.sunrise:before {
    -webkit-animation: fade-out 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: fade-out 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunset:checked~.heavens>.sunrise:after {
    -webkit-animation: circle-leave 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: circle-leave 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunset:checked~.heavens>.sunset {
    pointer-events: none;
}

#sunset:checked~.heavens>.sunset:before {
    -webkit-animation: fade-in 0.75s 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: fade-in 0.75s 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunset:checked~.heavens>.sunset:after {
    -webkit-animation: circle-enter 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: circle-enter 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunset:checked~.glow:after {
    -webkit-animation: circle-enter 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: circle-enter 0.75s 0.75s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunset:checked~.glow:before {
    -webkit-animation: circle-leave 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: circle-leave 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
}

#sunset:checked~.ledge:before {
    -webkit-animation: ledge-shadow-sunset 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
    animation: ledge-shadow-sunset 1.5s cubic-bezier(0.25, 0, 0.1, 1) both;
}

@-webkit-keyframes ledge-shadow-sunset {
    50% {
        -webkit-transform: skewX(-25deg);
        transform: skewX(-25deg);
    }
    60% {
        -webkit-transform: skewX(-80deg);
        transform: skewX(-80deg);
    }
    from,
    to {
        -webkit-animation-timing-function: ease;
        animation-timing-function: ease;
        -webkit-transform: skewX(-45deg);
        transform: skewX(-45deg);
    }
}

@keyframes ledge-shadow-sunset {
    50% {
        -webkit-transform: skewX(-25deg);
        transform: skewX(-25deg);
    }
    60% {
        -webkit-transform: skewX(-80deg);
        transform: skewX(-80deg);
    }
    from,
    to {
        -webkit-animation-timing-function: ease;
        animation-timing-function: ease;
        -webkit-transform: skewX(-45deg);
        transform: skewX(-45deg);
    }
}

@-webkit-keyframes time-move-sunset {
    50% {
        -webkit-transform: translateY(-25%);
        transform: translateY(-25%);
        opacity: 0;
    }
}

@keyframes time-move-sunset {
    50% {
        -webkit-transform: translateY(-25%);
        transform: translateY(-25%);
        opacity: 0;
    }
}

@-webkit-keyframes circle-leave {
    50% {
        -webkit-transform: translateY(-50%);
        transform: translateY(-50%);
        opacity: 1;
    }
    to {
        -webkit-animation-timing-function: ease-out;
        animation-timing-function: ease-out;
        -webkit-transform: translateY(60vh);
        transform: translateY(60vh);
        opacity: 0;
    }
}

@keyframes circle-leave {
    50% {
        -webkit-transform: translateY(-50%);
        transform: translateY(-50%);
        opacity: 1;
    }
    to {
        -webkit-animation-timing-function: ease-out;
        animation-timing-function: ease-out;
        -webkit-transform: translateY(60vh);
        transform: translateY(60vh);
        opacity: 0;
    }
}

@-webkit-keyframes circle-enter {
    from {
        opacity: 0;
        -webkit-transform: translateY(-50vh);
        transform: translateY(-50vh);
    }
    to {
        opacity: 1;
        -webkit-transform: translateY(0);
        transform: translateY(0);
    }
}

@keyframes circle-enter {
    from {
        opacity: 0;
        -webkit-transform: translateY(-50vh);
        transform: translateY(-50vh);
    }
    to {
        opacity: 1;
        -webkit-transform: translateY(0);
        transform: translateY(0);
    }
}

@-webkit-keyframes time-change-sunrise {
    from {
        content: attr(data-sunset);
    }
    to {
        content: attr(data-sunrise);
    }
}

@keyframes time-change-sunrise {
    from {
        content: attr(data-sunset);
    }
    to {
        content: attr(data-sunrise);
    }
}

@-webkit-keyframes time-change-sunset {
    from {
        content: attr(data-sunrise);
    }
    to {
        content: attr(data-sunset);
    }
}

@keyframes time-change-sunset {
    from {
        content: attr(data-sunrise);
    }
    to {
        content: attr(data-sunset);
    }
}

@-webkit-keyframes fade-out {
    from {
        opacity: 1;
    }
    to {
        opacity: 0;
    }
}

@keyframes fade-out {
    from {
        opacity: 1;
    }
    to {
        opacity: 0;
    }
}

@-webkit-keyframes fade-in {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}

@keyframes fade-in {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}
</style>
