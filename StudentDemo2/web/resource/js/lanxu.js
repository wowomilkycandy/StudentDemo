// 轮播图
var x=0;
var timer=null;
var img=document.getElementById('imgg');
function imggo(){
	 if(x==arr.length-1){
		      x=0;
	 }
	 else{
		      x+=1;
	 }
         img.src=arr[x];
}

clearInterval(timer);
timer=window.setInterval("imggo()",2500);

var arr= new Array();
arr[0]="resource/images/lun5.jpg";
arr[1]="resource/images/lun6.jpg";
arr[2]="resource/images/lun2.jpg";
arr[3]="resource/images/lun3.jpg";
arr[4]="resource/images/lun4.jpg";

var left=document.getElementById('left');
var right=document.getElementById('right');
left.onclick=function(){
	   if(x==0){
	      img.src=arr[4];
	      x=4;
     }
     else{
        img.src=arr[x-1];
        x=x-1;	
     }
    clearInterval(timer);
    timer=window.setInterval("imggo()",2500);
}

right.onclick=function(){
	   if(x==4){
	      img.src=arr[0];
	      x=0;
     }
     else{
        img.src=arr[x+1];
        x=x+1;	
     }
     clearInterval(timer);
     timer=window.setInterval("imggo()",2500);
}


//管理员小图标的运动
var oRun=document.getElementById('guanliyuan');
console.log(0);
console.log(oRun.offsetLeft);
oRun.onclick=function(e){
    console.log(4);
    startmove();
    console.log(1);
    e.stopPropagation();
}
document.onclick=function(){
    removeit()
}
var timerrr=null;
function startmove(){
     clearInterval(timerrr);
      console.log(2);
     timerrr=setInterval("miao()",30);
}
function  miao(){
      if(oRun.offsetLeft==960)
        {clearInterval(timerrr);}
      else
        {oRun.style.left=oRun.offsetLeft+10+'px';}
       console.log(3);
     }
var notimer=null;
function removeit(){
   clearInterval(notimer);
   clearInterval(timerrr)
   notimer=setInterval("jun()",30);
 }
 function jun()
   {
     if(oRun.offsetLeft==880)
        {clearInterval(notimer);}
    else
      {oRun.style.left=oRun.offsetLeft-10+'px'}
   }

//弹出蒙版层
var tututu=document.getElementById('tututu');
var range=document.getElementsByClassName('range');


for(var i=0;i<range.length;i++){
  range[i].onclick=function(){
    tututu.style.display="block";
  }
}
