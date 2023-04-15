// global
// 
$(function() {
    var $img = $("#content").find("ul>li:eq(1)").find("img").css("border","1px solid red");
    const go = document.querySelector(".triangle");
    go.addEventListener("click", ()=>{
        Promise.resolve().then(()=>{
            console.log(1)
        });
        console.log("addEventListener 1");
    })
    go.addEventListener("click", ()=>{
        Promise.resolve().then(()=>{
            console.log(2)
        });
        console.log("addEventListener 2");
    })
    go.onclick = function() {
        Promise.resolve().then(()=>{
            console.log(3)
        });
        console.log("onclick show me 3");
    }
    go.onclick = function() {
        Promise.resolve().then(()=>{
            console.log(4)
        });
        console.log("onclick show 4");
    }
    console.log("show me", go);
})
