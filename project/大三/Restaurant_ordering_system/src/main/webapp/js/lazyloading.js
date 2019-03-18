/*
延迟加载
 */


            var imgElements = document.getElementsByTagName("img");  
            var lazyImgArr = [];  
            var j = 0;
            var mainTemp = -1;
            //body（页面）可用工作区高度
            var bodyHeight = window.screen.availHeight;  
            for(var i=0; i<imgElements.length; i++) {  
             if(imgElements[i].className == "lazy"){  
               lazyImgArr[j] = imgElements[i];
               j++; 

             }  
            } 

        window.onscroll = function() {  
                displayPic();    
       };

  
   
    function displayPic() {
      var scrollHeight = document.body.scrollTop;//滚动的高度  

            if(mainTemp < scrollHeight) {//为true表示是向下滚动，否则是向上滚动，不需要执行动作。  
              for(var k=0; k<lazyImgArr.length; k++) {  
              var imgTop = lazyImgArr[k].offsetTop - scrollHeight;//1305（图片纵坐标）
              if(imgTop <= bodyHeight) {  
                lazyImgArr[k].src = lazyImgArr[k].alt;   
                }  
            }  
              
            temp = scrollHeight;  
         }
    }



