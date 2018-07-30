class Loading{
    constructor(container,opt){
        this.container = container;
        this.option = opt || '';
    }
    init(){
        this.render();
    }
    render(){
        let html = '',
            type = this.option.type;
        if (type === 'bar-process'){
            html = `<div class='shape'><div class="bar">
                            <div class="completed"></div>
                        </div></div>`;
        }
        if (type === 'hourglass-process'){
            html = `<div class='shape'><div class="hourglass-top">
                            <div class="hourglass-top-sand"></div>
                        </div>
                        <div class="hourglass-bottom">
                            <div class="hourglass-bottom-sand"></div>
                       </div></div>`;
        }
        if (type === 'circle-process'){
            html = `<div class='shape'>
                        <svg xmlns="http://www.w3.org/200/svg" height="150" width="110">
                            <circle cx="55" cy="55" r="50" fill="none" stroke="grey" stroke-width="10" stroke-linecap="round"/>
                            <circle transform="rotate(-90,55 55)" class="demo2" id="J_demo2" cx="55" cy="55" r="50" fill="none" stroke="red" stroke-width="10" stroke-dasharray="10,1000"/>
                        </svg>
                    </div>`;
        }
        html += this.container.innerHTML = html;
    }
    getProcess(){
        let type = this.option.type,
            value = 0;
        if (type === 'bar-process'){
            let complete = this.container.querySelector('.completed'),
                $bar = this.container.querySelector('.bar');
            return (complete.clientWidth/$bar.clientWidth)*100;
        }
        if (type === 'hourglass-process'){
            let $sand = this.container.querySelector('.hourglass-top-sand'),
                $glass = this.container.querySelector('.hourglass-top');
            value = ($sand.offsetHeight/2)/($glass.offsetHeight/2)*100;
            return value;
        }
        if (type === 'circle-process'){
            let demo2 =  document.querySelector(".demo2"),
                circleLength = Math.floor(2 * Math.PI * demo2.getAttribute("r")),
                nowLen = demo2.getAttribute("stroke-dasharray").split(',')[0];
            value = (nowLen/circleLength)*100;
            return value;
        }
    }
    setProcess(){
        let value = document.querySelector('.processSet').value,
            type = this.option.type;
        if (type === 'bar-process'){
            let complete = this.container.querySelector('.completed'),
                $bar = this.container.querySelector('.bar');
            value = (value/100)*$bar.clientWidth;
            complete.style.width = value+'px';
        }
        if (type === 'hourglass-process'){
            var top = this.container.querySelector('.hourglass-top-sand');
            var bottom = this.container.querySelector('.hourglass-bottom-sand');
            var $glass = this.container.querySelector('.hourglass-top');
            value = $glass.offsetHeight/2-(value/100)*($glass.offsetHeight/2);
            top.style.borderWidth = value+'px';
            top.style.top = '-'+ value +'px';
            top.style.right = '-'+ value +'px';
            bottom.style.borderWidth = value+'px';
            bottom.style.top = '-'+ value +'px';
            bottom.style.right = '-'+ value +'px';
        }
        if (type === 'circle-process'){ 
            var demo2 =  document.querySelector(".demo2");
            var circleLength = Math.floor(2 * Math.PI * demo2.getAttribute("r"));
            var val = parseFloat(value).toFixed(2);
            val = Math.max(0,val);
            val = Math.min(100,val);
            demo2.setAttribute("stroke-dasharray","" + circleLength * val / 100 + ",10000");
        }

    }
    setAllColor({bacCor = '#ccc', froCor = '#aaa'} = {}) { // 这个函数接受一个对象，参数为背景色和前景色
        let doc = document;
        switch(this.option.type) {
            case 'bar-process': doc.querySelector('.bar').style.background = bacCor;
                                doc.querySelector('.completed').style.background = froCor;break;
            case 'hourglass-process': doc.querySelector('.hourglass-top').style.borderTopColor = bacCor;
                                doc.querySelector('.hourglass-top-sand').style.borderTopColor = froCor;
                                doc.querySelector('.hourglass-bottom').style.borderBottomColor = froCor;
                                doc.querySelector('.hourglass-bottom-sand').style.borderBottomColor = bacCor;break;
            case 'circle-process': doc.querySelectorAll('circle')[0].setAttribute('stroke',bacCor);
                                doc.querySelectorAll('circle')[1].setAttribute('stroke',froCor);break;
        }
    }
}
var container = document.querySelector('.process');
var loading = new Loading(container,{type : 'hourglass-process'});
loading.init();
loading.setAllColor();
document.querySelector('.processSet').onchange = function() {
            loading.setProcess();
            console.log(loading.getProcess());
}




