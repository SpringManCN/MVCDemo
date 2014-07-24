<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>

<title>登录页面</title>
<spring:url value="resources/css/login_style.css" var="login_style_css" />
<link rel="stylesheet" href="${login_style_css}">

<script type="text/javascript">
	function check(name) {
		var nameDiv = document.getElementById("nameError");
		var name = document.getElementById("Name");
		var pwd = document.getElementById("password");
		if (name.value == "" || pwd.value == "") {
			nameDiv.innerHTML = "用户名或密码不能为空!!";
			return false;
		} else {
			nameDiv.innerHTML = "";
			return true;
		}

	}
</script>

</head>
<body>
	<section class="container">
		<div class="login" style="border-radius: 25px">
			<h1 style="border-radius: 25px">登录主数据管理系统</h1>
			<form action="/Demo/login/login" method="post"
				onsubmit="return check(this)">
				<p>
					<input type="text" id="Name" name="user.loginname" value=""
						placeholder="请输入用户名">
				</p>
				<p>
					<input type="password" id="password" name="user.password" value=""
						placeholder="请输入密码">
				</p>

				<p class="submit">
					<input type="submit" name="login" value="登录">
			</form>
		</div>

		<div class="login-help">
			<div id="nameError" style="font-size: 20px;"></div>
			<div id="pwdError" style="font-size: 20px;"></div>
			<div id="loginError" style="font-size: 20px;">
				${loginError }
			</div>
		</div>
		
	</section>
</body>
</html>
