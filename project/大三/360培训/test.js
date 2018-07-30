//沙漏进度条
class HourGlassProgress {
    constructor(container){
        this.container = container;
    }
    getProgressHtml(){
        const html = `<div class='shape'><div class="hourglass-top">
                            <div class="hourglass-top-sand"></div>
                        </div>
                        <div class="hourglass-bottom">
                            <div class="hourglass-bottom-sand"></div>
                       </div></div>`;
        return html;
    }
    getProgressValue(){
        let $sand = this.container.querySelector('.hourglass-top-sand'),
            $glass = this.container.querySelector('.hourglass-top');
        value = ($sand.offsetHeight/2)/($glass.offsetHeight/2)*100;
        return value;
    }
    setProgressValue(value){
        var $glass = this.container.querySelector('.hourglass-top');
        value = $glass.offsetHeight/2-(value/100)*($glass.offsetHeight/2);
        this.changeProgressStyle(value);
    }
    changeProgressStyle(value){
        var top = this.container.querySelector('.hourglass-top-sand');
        var bottom = this.container.querySelector('.hourglass-bottom-sand');
        top.style.borderWidth = value+'px';
        top.style.top = '-'+ value +'px';
        top.style.right = '-'+ value +'px';
        bottom.style.borderWidth = value+'px';
        bottom.style.top = '-'+ value +'px';
        bottom.style.right = '-'+ value +'px';
    }
}
//条形进度条
class BarProgress {
    constructor(container){
        this.container = container;
    }
    getProgressHtml(){
        const html = '<div class="bar">'+
            '            <div class="completed"></div>'+
            '        </div>';
        return html;
    }
    getProgressValue(){
        var $complete = this.container.querySelector('.completed');
        var $bar = this.container.querySelector('.bar');
        return ($complete.clientWidth/$bar.clientWidth)*100;
    }
    setProgressValue(value){
        var $bar = this.container.querySelector('.bar');
        value = (value/100)*$bar.clientWidth;
        this.changeProgressStyle(value);
    }
    changeProgressStyle(value){
        var complete = this.container.querySelector('.completed');
        complete.style.width = value+'px';
    }
}
//圆环进度条
class RingProgress {
    constructor(container){
        this.container = container;
    }
    getProgressHtml(){
        const html = '<svg xmlns="http://www.w3.org/200/svg" height="150" width="110">'+
            '            <circle cx="55" cy="55" r="50" fill="none" stroke="grey" stroke-width="5" stroke-linecap="round"/>'+
            '            <circle class="demo2" id="J_demo2" cx="55" cy="55" r="50" fill="none" stroke="red" stroke-width="5" stroke-dasharray="0,10000"/>'+
            '        </svg>';
        return html;
    }
    getProgressValue(){
        //todo
    }
    setProgressValue(value){
        var val = parseFloat(value).toFixed(2);
        val = Math.max(0,val);
        val = Math.min(100,val);
        this.changeProgressStyle(val);
    }
    changeProgressStyle(value){
        var demo2 =  document.querySelector("#J_demo2");
        var circleLength = Math.floor(2 * Math.PI * demo2.getAttribute("r"));
        demo2.setAttribute("stroke-dasharray","" + circleLength * value / 100 + ",10000");
    }
}
class Progress{
    constructor(container,opt){
        this.container = container;
        this.option = opt || '';
    }
    init(){
        this.render();
    }
    getProgressFromType(type){
        if (type === 'hourglass-progress'){
            return new HourGlassProgress(this.container);
        }
        if (type === 'bar-progress'){
            return new BarProgress(this.container);
        }
        if (type === 'ring-progress'){
            return new RingProgress(this.container);
        }
    }
    render(){
        var html = '';
        var type = this.option.type;
        var progress = this.getProgressFromType(type);
        html += progress.getProgressHtml();
        this.container.innerHTML = html;
    }
    getProgress(){
        var type = this.option.type;
        var progress = this.getProgressFromType(type);
        progress.getProgressValue(value);
    }
    setProgress(value){
        var type = this.option.type;
        var progress = this.getProgressFromType(type);
        progress.setProgressValue(value);
    }
}
var container = document.querySelector('.process');
var progress = new Progress(container,{type : 'bar-progress'});
progress.init();