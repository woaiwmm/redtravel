//console.log( window.innerWidth );    1366
//console.log( window.innerHeight );   654  /  643

//container : 1100 * 600   ( 如果想适应更多的分辨率，让效果展示的更好，利用css3 media query 来做响应式布局 , bootStrap )

window.onload = function(){content
    var oHeader = $('header');
    var oNav = $('nav');
    var oArrow = $('arrow');
    var oList = $('list');
    var oContent = $('content');
    var aLiNav = oNav.getElementsByTagName('li');
    var aLiList = getByClass( oList , 'liList' );
    var aDivList = getByClass( oList , 'divList' );

    var oMenu = $('menu');
    var aLiMenu = oMenu.getElementsByTagName('li');
    var oLoading = $('loading');

    var iNow = 0;
    var prevIndex = 0;
    var iContentHeight = 0;

    showLoading();
    contentAuto();
    listContentAuto();
    bindNav();
    mouseWheel();

    window.onresize = fnResize;

    //toMove(4);

    function showLoading(){/*进入网页的加载动画*/
        var oSpan = oLoading.getElementsByTagName('span')[0];
        var aDiv = oLoading.getElementsByTagName('div');
        var arr = ['bg.png','home_gruen.png','home_red.png','logo-red.png','icon1.png','icon2.png','icon3.png','menuIndicator.png','tam.png'];
        var iNow = 0;

        for(var i=0;i<arr.length;i++){

            var objImg = new Image();
            objImg.src = 'img/'+arr[i];
            objImg.onload = function(){
                iNow++;
                oSpan.style.width = iNow/arr.length*100 + '%';
            };
        }
        oSpan.addEventListener('webkitTransitionend',spanChange,false);
        oSpan.addEventListener('transitionend',spanChange,false);

        function spanChange(){
            if(oSpan.style.width == '100%'){
                oSpan.style.display = 'none';
                aDiv[0].style.height = 0;
                aDiv[1].style.height = 0;
            }
        }

        aDiv[0].addEventListener('webkitTransitionend',divChange,false);
        aDiv[0].addEventListener('transitionend',divChange,false);

        function divChange(){
            oLoading.parentNode.removeChild(oLoading);
        }
    }

    function bindNav(){

        var oDiv = aLiNav[0].getElementsByTagName('div')[0];
        oDiv.style.width = '100%';
        oArrow.style.left = aLiNav[0].offsetLeft + aLiNav[0].offsetWidth/2 - oArrow.offsetWidth/2 + 'px';

        for(var i=0;i<aLiNav.length;i++){
            aLiNav[i].index = i;
            aLiNav[i].onmousedown = function(){
                prevIndex = iNow;
                iNow = this.index;
                // toMove( this.index );
            };
        }
        for(var i=0;i<aLiMenu.length;i++){
            aLiMenu[i].index = i;
            aLiMenu[i].onclick = function(){
                prevIndex = iNow;
                iNow = this.index;
                toMove( this.index );
            };
        }
    }
    
    function toMove(index){/*屏幕滑动*/

        for(var i=0;i<aLiNav.length;i++){
            var oDiv = aLiNav[i].getElementsByTagName('div')[0];
            oDiv.style.width = '';
        }
        var oDiv = aLiNav[index].getElementsByTagName('div')[0];
        oDiv.style.width = '100%';

        oArrow.style.left = aLiNav[index].offsetLeft + aLiNav[index].offsetWidth/2 - oArrow.offsetWidth/2 + 'px';

        oList.style.top = - index * iContentHeight + 'px';
        for(var i=0;i<aLiMenu.length;i++){
            aLiMenu[i].className = '';
        }
        aLiMenu[index].className = 'active';
}

    function contentAuto(){
        iContentHeight = viewHeight() - oHeader.offsetHeight;
        oContent.style.height = iContentHeight + 'px';
        for(var i=0;i<aLiList.length;i++){
            aLiList[i].style.height = iContentHeight + 'px';
        }
        oList.style.top = - iNow * iContentHeight + 'px';
    }

    function listContentAuto(){
        var mt = (iContentHeight - 520)/2;
        for(var i=0;i<aDivList.length;i++){
            aDivList[i].style.marginTop = mt + 'px';
        }
    }

    function fnResize(){
        contentAuto();
        listContentAuto();
    }

    function mouseWheel(){
        //火狐 : DOMMouseScroll( DOM事件必须用绑定事件的方式去写 addEventListener )
        //IE ,  谷歌 : mousewheel
        var bBtn = true;
        var timer = null;
        if(oContent.addEventListener){
            oContent.addEventListener('DOMMouseScroll',function(ev){
                var ev = ev || window.event;
                clearTimeout(timer);
                timer = setTimeout(function(){
                    toChange(ev);
                },200);
            },false);
        }
        oContent.onmousewheel = function(ev){
            var ev = ev || window.event;
            clearTimeout(timer);
            timer = setTimeout(function(){
                toChange(ev);
            },200);
        };

        function toChange(ev){
            //alert(ev.detail);  //↓ 3  ↑ -3
            //alert(ev.wheelDelta); //↓ -120  ↑ 120

            if(ev.detail){
                bBtn = ev.detail > 0 ? true : false;
            }
            else{
                bBtn = ev.wheelDelta < 0 ? true : false;
            }

            if( (iNow == 0 && !bBtn) || (iNow == aLiList.length-1 && bBtn) ){return;}

            prevIndex = iNow;
            if(bBtn){   //↓
                if(iNow != aLiList.length-1){
                    iNow++;
                }
                toMove(iNow);
            }
            else{   //↑
                if(iNow != 0){
                    iNow--;
                }
                toMove(iNow);
            }

            if(ev.preventDefault){
                ev.preventDefault();
            }
            else{
                return false;
            }
        }

    }

    function $(id){
        return document.getElementById(id);
    }

    function viewWidth(){
        return window.innerWidth || document.documentElement.clientWidth;
    }

    function viewHeight(){
        return window.innerHeight || document.documentElement.clientHeight;
    }

    function getByClass(oParent,sClass){
        var aElem = oParent.getElementsByTagName('*');
        var arr = [];
        for(var i=0;i<aElem.length;i++){
            if( aElem[i].className == sClass ){
                arr.push( aElem[i] );
            }
        }
        return arr;
    }


};