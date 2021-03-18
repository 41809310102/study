<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="denlu.aspx.cs" Inherits="WebApplication3.denlu" %>

<!DOCTYPE html>

<html>
	<head>
		<title>注册界面</title>
		<meta charset="UTF-8"/>
		<style type="text/css">

		body{background-image:url(./img/zhuche.png) ;
             width:100%;
             height:100%
            }

		font{color="darkgray"}

		tr{height:60px}
		</style>
		<!--声明js代码域-->
		<script type="text/javascript">
            //常见验证码
            function createCode() {
                //创建随机4位数字，math.floor向下取整
                var code = Math.floor(Math.random() * 9000 + 1000);
                //获取元素对象
                var span = document.getElementById("codeSpan");
                //将数字存放到span中
                span.innerHTML = code;
                //给span添加背景图片
            }
            //验证用户名
            function checkUname() {
                //获取用户获得用户名信息
                var uname = document.getElementById("uname").value;
                //创建校验规则,用户名2-4个
                var reg = /^[\u4e00-\u9fa5]{2,4}$/
                //获取span对象
                var unameSpan = document.getElementById("unameSpan");
                //开始交验
                if (unameSpan == "" || unameSpan == null) {
                    //输入校验结果
                    unameSpan.innerHTML = "*用户名不能为空";
                    unameSpan.style.color = "red";
                    return false;
                } else if (reg.test(uname)) {
                    //输入校验结果
                    unameSpan.innerHTML = "*用户名通过";
                    unameSpan.style.color = "green";
                    return true;
                } else {
                    //输入校验结果
                    unameSpan.innerHTML = "*用户名格式不符"
                    unameSpan.style.color = "red";
                    return false;
                }

            }
            //验证密码
            function checkPwd() {
                //获取用户获得用户名信息
                var upwd = document.getElementById("pwd").value;
                //创建校验规则,密码要求6-8位，首位为字母，后面5-7位是数字
                var reg = /^[a-z]\w{5,7}$/;
                //获取span对象
                var span = document.getElementById("pwdSpan");
                //开始交验
                if (span == "" || span == null) {
                    //输入校验结果
                    span.innerHTML = "*密码不能为空";
                    span.style.color = "red";
                    return false;
                } else if (reg.test(upwd)) {
                    //输入校验结果
                    span.innerHTML = "*密码通过";
                    span.style.color = "green";
                    return true;
                } else {
                    //输入校验结果
                    span.innerHTML = "*密码格式不符"
                    span.style.color = "red";
                    return false;
                }
                //第一次密码为a123456，第二次密码为a1234567，则修改的第一次密码，确认密码也会重新校验	
                checkPwd2();
            }
            //校验确认密码
            function checkPwd2() {
                //获取第一次校验密码
                var pwd = document.getElementById("pwd").value;
                //获取确认密码
                var pwd2 = document.getElementById("pwd2").value;
                //获取span对象
                var span = document.getElementById("pwd2Span");
                //比较前两次密码是否相同
                if (pwd2 == "" || pwd2 == null) {
                    //输入校验结果
                    span.innerHTML = "*密码不能为空";
                    span.style.color = "red";
                    return false;
                } else if (pwd === pwd2) {
                    //输入校验结果
                    span.innerHTML = "*密码通过";
                    span.style.color = "green";
                    return true;
                } else {
                    //输入校验结果
                    span.innerHTML = "*密码不同，请重新输入"
                    span.style.color = "red";
                    return false;
                }
            }
            //校验手机号
            function checkPhone() {
                return checkField("phone", /^1[3456789]\d{9}$/);
            }
            //校验邮箱
            function checkmail() {
                return checkField("mail", /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/)
            }
           
          
            //校验确认验证码------------------
            function checkCode() {
                //获取用户输入验证码
                var code = document.getElementById("code").value;
                //获取随机验证码
                var code2 = document.getElementById("codeSpan").innerHTML;
                //获取span对象
                var span = document.getElementById("codeSpan2");
                //比较前两次密码是否相同
                if (code == "" || code == null) {
                    //输入校验结果
                    span.innerHTML = "*验证码不能为空";
                    span.style.color = "red";
                    createCode();
                    return false;
                } else if (code == code2) {
                    //输入校验结果
                    span.innerHTML = "*验证码通过";
                    span.style.color = "green";
                    return true;
                } else {
                    //输入校验结果
                    span.innerHTML = "*验证码错误"
                    span.style.color = "red";
                    createCode();
                    return false;
                }
            }
           
            //提交判断
            function checkSub() {
                checkUname();
                checkPwd();
                checkPwd2();
                checkmail();
                checkPhone();       
                checkCode();
                return checkUname() && checkPwd() && checkPwd2() && checkmail() && checkPhone()  && checkCode(); 
            }
            //----------------------------------------------------------------------------------------------------------------------
            //封装校验：相同的保留，不同的传参
            function checkField(id, reg) {
                //获取用户数据
                var inp = document.getElementById(id);
                var va = inp.value;
                var alt = inp.alt;
                //创建校验规则
                //获取span对象
                var span = document.getElementById(id + "Span");
                //开始校验
                if (va == "" || va == null) {
                    //输入校验结果
                    span.innerHTML = "*" + alt + "不能为空";
                    span.style.color = "red";
                    return false;
                } else if (reg.test(va)) {
                    //输入校验结果
                    span.innerHTML = "*" + alt + "通过";
                    span.style.color = "green";
                    return true;
                } else {
                    //输入校验结果
                    span.innerHTML = "*" + alt + "格式不符";
                    span.style.color = "red";
                    return false;
                }
            }
        </script>
	</head>
	<body onload="createCode()">
		<h3 align="center" >注册界面</h3>
		<hr style="height: -82px; margin-bottom: 74px"  />
		<form action="#" method="get" onsubmit="return checkSub()">
			<table border="0px" cellspacing="0" cellpadding="2px" align="center">
				<tr>
					<td width="80px" >用户名：</td>
					<td width="400px">
						<input type="text" name="uname" id="uname" value="" onblur="checkUname()" alt="用户名"/>
						<span id="unameSpan">
							<font>2-4位汉字</font>
						</span>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td>
						<input type="password" name="pwd" id="pwd" value="" onblur="checkPwd()"/>
						<span id="pwdSpan">
						<font>要求6-8位密码，首位必须为字母</font>
						</span>
					</td>
				</tr>
				<tr>
					<td >确认密码：</td>
					<td>
						<input type="password" name="pwd2" id="pwd2" value="" " onblur="checkPwd2()"/>
						<span id="pwd2Span"></span>
					</td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td>
						<input type="text" name="mail" id="mail" value="" alt="邮箱" onblur="checkmail()"/>
						<span id="mailSpan"></span>
					</td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td>
						<input type="text" name="phone" id="phone" value="" alt="手机号" onblur="checkPhone()"/>
						<span id="phoneSpan"></span>
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						男<input type="radio" name="sex" id="sex" value="1"checked="checked" />
						女<input type="radio" name="sex" id="sex" value="0" />
					</td>
				</tr>
			
				
				<tr>
					<td>验证码：</td>
					<td>
						<input type="text" id="code" value="" style="width:100px;" onblur="checkCode()" />&nbsp;&nbsp;&nbsp;
						<span id="codeSpan" style="background-image: url(img/背景.png);color: black;" onclick="createCode()">
						</span>
						<span id="codeSpan2"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" id="sub" name="sub" value="注册" disabled="disabled" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
