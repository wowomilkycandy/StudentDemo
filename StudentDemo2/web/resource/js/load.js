//注册登录分页
var oLogin=document.getElementById('zhuce');
var oLoad=document.getElementById('load');

var duzi=document.getElementById('duzi'); 
var duzii=document.getElementById('duzii');

oLoad.onclick=function(){
	duzi.style.display="none";
	duzii.style.display="block";
}
oLogin.onclick=function(){
	duzi.style.display="block";
	duzii.style.display="none";
}
//注册表单
var oInput=document.getElementsByClassName('oInput');
var namea=oInput[0];
var oPassword=oInput[1];
var checkPassword=oInput[2];
// var phone=oInput[3];
var yanZhen=oInput[3];

var oSpan=document.getElementsByClassName('oSpan');
var tishi1=oSpan[0];
var tishi2=oSpan[1];
var tishi3=oSpan[2];
// var tishi4=oSpan[3];
var tishi5=oSpan[3];

var oSubmit=document.getElementById('tijiao');
var oBiaodan=document.getElementById('oBiaodan');

var nameaOK=0;
var oPasswordOK=0;
var checkPasswordOK=0;
var phoneOK=1;
var yanzhengOK=0;

oBiaodan.onsubmit=function(){return false;};
//name
//name
function getLength(str){
   	return str.replace(/[xoo-xff]/,"xx").length;
   }
namea.onfocus=function(){  
	tishi1.style.display="inline-block";
}
namea.onkeyup=function(){
      tishi1.style.display="inline-block";
      var name_length=getLength(this.value);
      tishi1.innerHTML=name_length+"个字符";
      tishi1.style.color="red";
}
namea.onblur=function(){
	 var name_length=getLength(this.value);
	if(name_length<3){
		tishi1.style.display="inline-block";
		tishi1.innerHTML="！必须输入大于2个字符";
		tishi1.style.color="#BE0C0C";
		nameaOK=0;
	}
	else{
		tishi1.style.display="inline-block";
		tishi1.innerHTML="√";
		tishi1.style.color="#2FF780";
		nameaOK=1;
	}
	if(nameaOK==1&&oPasswordOK==1&&checkPasswordOK==1&&phoneOK==1&&yanzhengOK==1){	
	     oBiaodan.onsubmit=function(){return true;};	  
      }
      else{
      	 oBiaodan.onsubmit=function(){return false;};
      }
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
	if(nameaOK==1&&oPasswordOK==1&&checkPasswordOK==1&&phoneOK==1&&yanzhengOK==1){	
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
	if(nameaOK==1&&oPasswordOK==1&&checkPasswordOK==1&&phoneOK==1&&yanzhengOK==1){	
	     oBiaodan.onsubmit=function(){return true;};	  
      }
      else{
      	 oBiaodan.onsubmit=function(){return false;};
      }
	
}
//phone
// phone.onblur=function(){
// 	var shu=/\d/;
// 	var shouji=/^1[34578]\d{9}$/
// 	if(shouji.test(this.value)){
// 		if(this.value.length==11){
//           tishi4.style.display="inline-block";
// 		  tishi4.innerHTML="√";
// 		  tishi4.style.color="#2FF780";
// 		  phoneOK=1;
// 		}
// 		else{
//           tishi4.style.display="inline-block";
//           tishi4.innerHTML="!请输入正确中国大陆手机号";
//           tishi4.style.color="#BE0C0C";
//           phoneOK=0;
// 		} 
// 	}
// 	else{
// 		tishi4.style.display="inline-block";
// 		tishi4.style.color="#BE0C0C";
// 		phoneOK=0;
// 	}
// 	if(nameaOK==1&&oPasswordOK==1&&checkPasswordOK==1&&phoneOK==1&&yanzhengOK==1){	
// 	     oBiaodan.onsubmit=function(){return true;};	  
//       }
//       else{
//       	  oBiaodan.onsubmit=function(){return false;};
//       }
// }

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
     if(nameaOK==1&&oPasswordOK==1&&checkPasswordOK==1&&phoneOK==1&&yanzhengOK==1){	
	     oBiaodan.onsubmit=function(){return true;}  
      }
      else{
      	 oBiaodan.onsubmit=function(){return false;}
      }
   }

	
  
 
}





//延迟提交。。弹出注册成功
var oSubmit=document.getElementById('tijiao');
var oBlack=document.getElementById('oBlack');
var shu=document.getElementById('shu');
var oBiaodan=document.getElementById('oBiaodan');
var aaaa=shu.innerHTML;
var bbbb=parseInt(aaaa);
var timermm=null;

function qwen(){
  if(nameaOK==1&&oPasswordOK==1&&checkPasswordOK==1&&phoneOK==1&&yanzhengOK==1){  
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