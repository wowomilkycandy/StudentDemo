//延迟提交。。弹出成功
var oSubmit=document.getElementById('tijiao');
var oBlack=document.getElementById('oBlack');
var shu=document.getElementById('shu');
var oBiaodan=document.getElementById('oBiaodan');
var aaaa=shu.innerHTML;
var bbbb=parseInt(aaaa);
var timermm=null;

function qwen(){
  if(oPasswordOK==1&&checkPasswordOK==1&&yanzhengOK==1){   
    oBlack.style.display="block";
     timermm=setInterval("moveaaaa()",1000);
    setTimeout("mooy()",3000);
   }
}

function mooy(){
    oBiaodan.submit();
}
function moveaaaa(){
    shu.innerHTML=bbbb-1;
    bbbb=bbbb-1;
}









var yanZhen=document.getElementById('yanzheng');
var tishi5=document.getElementById('oTishi');
var oBiaodan=document.getElementById('oBiaodan');

var oPassword=document.getElementById('newmima');
var checkPassword=document.getElementById('mmi');


var tishi2=document.getElementById('newmimatishi');
var tishi3=document.getElementById('mmitishi');

var oPasswordOK=0;
var checkPasswordOK=0;
var yanzhengOK=0;

function getLength(str){
    return str.replace(/[xoo-xff]/,"xx").length;
   }


//password
oPassword.onfocus=function(){
  tishi2.style.display="inline-block";
}
oPassword.onkeyup=function(){
      tishi2.style.display="inline-block";
      var password_length=getLength(this.value);
      tishi2.innerHTML=password_length+"个字符";
      tishi2.style.color="red";
      if(this.value.length>6){
         checkPassword.removeAttribute("disabled");
       }
       else{
         checkPassword.setAttribute("disabled","true");
       }
}

oPassword.onblur=function(){
  var password_length=getLength(this.value);
  if(password_length<7){
    tishi2.style.display="inline-block";
    tishi2.innerHTML="！必须输入大于6个字符";
    tishi2.style.color="#BE0C0C";
    oPasswordOK=0;
  }
  else{
    tishi2.style.display="inline-block";
    tishi2.innerHTML="√";
    tishi2.style.color="#2FF780";
      oPasswordOK=1;
  }
  if(oPasswordOK==1&&checkPasswordOK==1&&yanzhengOK==1){  
       oBiaodan.onsubmit=function(){return true;};    
      }
      else{
         oBiaodan.onsubmit=function(){return false;};
      }
     if(this.value!=checkPassword.value){
    tishi3.style.display="inline-block";
        tishi3.style.color="#BE0C0C";
        tishi3.innerHTML="*两次密码输入不一致";
         checkPasswordOK=0;
  }
}
//checkpassword
checkPassword.onblur=function(){
  if(this.value!=null){
  if(this.value!=oPassword.value){
    tishi3.style.display="inline-block";
        tishi3.style.color="#BE0C0C";
        tishi3.innerHTML="*两次密码输入不一致";
         checkPasswordOK=0;
  }
  else{
    tishi3.style.display="inline-block";
    tishi3.innerHTML="√";
    tishi3.style.color="#2FF780";
      checkPasswordOK=1;
  }
}
  else{
    tishi3.style.display="inline-block";
        tishi3.style.color="#BE0C0C";
        tishi3.innerHTML="*两次密码输入不一致";
         checkPasswordOK=0;
  }
  if(oPasswordOK==1&&checkPasswordOK==1&&yanzhengOK==1){  
       oBiaodan.onsubmit=function(){return true;};    
      }
      else{
         oBiaodan.onsubmit=function(){return false;};
      }
  
}

//验证码
 var code;
function createCode() 
{
 code = "";
 var codeLength = 6; //验证码的长度
 var checkCode = document.getElementById("checkCode");
 var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
 for(var i = 0; i < codeLength; i++) 
 {
  var charNum = Math.floor(Math.random() * 52);
  code += codeChars[charNum];
 }
 if(checkCode) 
 {
  checkCode.className = "code";
  checkCode.innerHTML = code;
 }
}

// tishi5.innerHTML="请输入验证码";
yanZhen.onblur=function(){
	var inputCode=yanZhen.value;
	if(inputCode.length <= 0) 
   {
   	 tishi5.style.display="inline-block";
     tishi5.innerHTML="×";
     tishi5.style.color="#BE0C0C";
   }
   else if(inputCode.toUpperCase() != code.toUpperCase()) 
  {
     tishi5.style.display="inline-block";
     tishi5.innerHTML="×";
     tishi5.style.color="#BE0C0C";
     createCode();
   }
    else 
   {
      tishi5.style.display="inline-block";
      tishi5.innerHTML="√";
     tishi5.style.color="#2FF780";
     yanzhengOK=1;  
     if(oPasswordOK==1&&checkPasswordOK==1&&yanzhengOK==1){	
	     oBiaodan.onsubmit=function(){return true;}  
      }
      else{
      	 oBiaodan.onsubmit=function(){return false;}
      }
   }

	
  
 
}
 if(oPasswordOK==1&&checkPasswordOK==1&&yanzhengOK==1){ 
       oBiaodan.onsubmit=function(){return true;}  
      }
      else{
         oBiaodan.onsubmit=function(){return false;}
      }