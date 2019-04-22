var chaxun=document.getElementById('chaxun');
var zengjia=document.getElementById('zengjia');
var zz=document.getElementById('zz');
var cha=document.getElementById('cha'); 
var oBiaodan=document.getElementById('oBiaodan');

zz.onclick=function(){
	chaxun.style.display="none";
	zengjia.style.display="block";
	
}
cha.onclick=function(){
	chaxun.style.display="block";
	zengjia.style.display="none";
	oBiaodan.submit();
}



var kan=document.getElementById('kan');
kan.onclick=function(){
	window.parent.location.href='managerMingdan.html';

}

