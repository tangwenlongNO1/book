<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COCO会员注册成功页面</title>
	<%@include file="../common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<a href=index.jsp><img class="logo_img" alt="" src="static/img/apple.svg" ></a>
				<span class="wel_word"></span>
			<%@include file="../common/login_success_memu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="index.jsp">转到主页</a></h1>
	
		</div>

		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>