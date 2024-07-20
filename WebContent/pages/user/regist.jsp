<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>COCO会员注册页面</title>
		<%@include file="../common/head.jsp"%>
		<script>
			$(function (){
				// 开始逻辑
				$("#sub_btn").click(function () {
					// 用户名验证
					var username = $("#username").val();
					var usernamett = /^\w{5,12}$/;
					if(!usernamett.test(username)){
						$("span.errorMsg").text("用户名不合法！");

						return false;
					}

					// 密码验证
					var password = $("#password").val();
					var passwordtt = /^\w{5,12}$/;
					if(!passwordtt.test(password)){
						$("span.errorMsg").text("密码不合法！");

						return false;
					}

					// 重复密码
					var repord = $("#repwd").val();
					if(repord != password){
						$("span.errorMsg").text("密码不一致！")
						return false;
					}

					// 邮箱逻辑
					var email = $("#email").val();
					var emailtt = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
					if(!emailtt.test(email)){
						$("span.errorMsg").text("邮箱不合法！")
						return false;
					}

					// 验证码不能为空
					var code = $("#code").val();
					code = $.trim(code);
					if(code == null || code == ""){
						$("span.errorMsg").text("验证码不能为空！");
						return false;
					}


					$("span.errorMsg").text("");

				});
			});
		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<a href="index.jsp"><img class="logo_img" alt="" src="static/img/apple.svg" ></a>

		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<a href="pages/user/login.jsp">立即登录</a>
<!-- 								EL表达式 -->
								<span class="errorMsg">${requestScope.msg }</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
								<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username" value=${requestScope.username }>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email" value=${requestScope.mail }>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/foot.jsp"%>
	</body>
</html>