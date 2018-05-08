// global.js

(function() {

	// 搜索框切换效果
	(function() {
		var arrText = ["例如：重庆鸡公煲",
		                "例如：其他的什么东西",
		                "例如：什么哟",
		                "例如：其他的什么东西",
		                "例如：其他的什么东西"
		              ],
		    aLi = $(".search-tab li"),
		    aInput = $(".search-text"),
		    iNow = 0;

        aLi.each(function(index) {
        	var that = $(this);
        	that.click(function() { // this指每一个li
        		aLi.removeClass("search-active");
        		that.addClass("search-active");
        		iNow = index;
        		aInput.val(arrText[iNow]);
        		
        	});
        });
        
        aInput.focus(function() {
        	var that = $(this);
        	if (that.val() == arrText[iNow]) {
                that.val("");
        	}
        });

        aInput.blur(function() {
        	var that = $(this);
        	if (that.val() == "") {
        		that.val(arrText[iNow]);
        	}
        });

	})();

})();




/*  // 一点点js实现，写了一些不想写了，很麻烦
window.onload = function() {
    
   (function() {
   	var aLi = document.getElementsByClassName("search-tab")[0].getElementsByTagName("li");
   	// var aLi = document.querySelectorAll(".search-tab li");
   	
   	var len = aLi.length++;
   	for (;len--;) {
   		(function(num) {
   	  	    aLi[num].onclick = function() {
   	  	    	var len = aLi.length++;
   		    for(;len--;){
   		    	aLi[len].className = "";
   		    }
   		    this.className = "search-active";
   	        };
   	    })(len);
   	}
   	
   })();
};*/