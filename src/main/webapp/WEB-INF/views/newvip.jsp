<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<script type="text/javascript"
		src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
		href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
		rel="stylesheet">
<script
		src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>


<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>停车</title>
<link rel="stylesheet" type="text/css" href="../../moban/css/index.css" />
<link rel="stylesheet" type="text/css" href="../../moban/css/animate-custom.css" />
</head>
<body style="background: #fff url(/moban/images/bg.jpg) repeat top left;">

<div id="container_demo">
	<a class="hiddenanchor" id="toregister"></a>
	
	<div id="wrapper">
		<div class="animate form" id="login">
			<form action=""  method="post">
				<a href="${APP_PATH}/findnewvip"><h1>易停车</h1> </a>
					<h2 style="font-size: 15px;">办理年卡，<font color="red">1000</font>/年</h2>
				<p> 
				<label class="uname" data-icon="u" for="username">输入车牌</label>
					<input  id="carnumber" name="carnumber"  required="required" type="text" />
				</p>
				<p> 
				<label class="uname" data-icon="u" for="username">输入姓名</label>
					<input  id="username" name="username"  required="required" type="text" />
				</p>
				<p> 
				<label class="uname" data-icon="u" for="username">输入手机号</label>
					<input  id="phone" name="phone"  required="required" type="text" />
				</p>
				<p> 
					<span style="color: red;font-size: 18px">${message }</span>
				</p>
				<p class="login button"> 
					<input type="button" id="newsubmit" value="确定" />
				</p>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	$("#newsubmit").click(function () {
		//2、发送ajax请求保存员工
		$.ajax({
			url: "${APP_PATH}/addNewCard",
			type: "GET",
			data: $("#login form").serialize(),
			success: function (result) {
				alert(result.msg);
				location.href="${APP_PATH}/Cardresel";
			}
		});
	});
</script>


</body>
			


