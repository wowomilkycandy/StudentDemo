
//增删改查分页
var myArr=document.getElementsByClassName('t');
var add=myArr[0];
var jian=myArr[1];
var change=myArr[2];
var gai=myArr[3];
var kan=myArr[4]


var oArr=document.getElementsByClassName('right');
var a=oArr[0];
var b=oArr[1];
var c=oArr[2];
var d=oArr[3];
var e=oArr[4];

add.onclick=function(){
	a.style.display="none";
    b.style.display="none";
    c.style.display="none";
    d.style.display="block";
    e.style.display="none";
}

jian.onclick=function(){
	a.style.display="none";
    b.style.display="none";
    c.style.display="block";
    d.style.display="none"; 
    e.style.display="none";
}
change.onclick=function(){
	a.style.display="none";
    b.style.display="block";
    c.style.display="none";
    d.style.display="none";
    e.style.display="none"; 
}
gai.onclick=function(){
	a.style.display="block";
    b.style.display="none";
    c.style.display="none";
    d.style.display="none" ;
    e.style.display="none";
}
kan.onclick=function(){
    a.style.display="none";
    b.style.display="none";
    c.style.display="none";
    d.style.display="none" ;
    e.style.display="block";
}
