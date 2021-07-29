<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" class="page-fill" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title th:text="${login_title}+'-登录'"></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="智能停车场管理平台">
    <meta name="description" content="智能停车场管理平台">
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/login_new.css"/>
    <link rel="stylesheet" href="lib/layui/css/layui.css"/>
    <style>
        #adst {
            width: 100% !important;
            height: 44px !important;
            line-height: 44px !important;
            font-size: 16px !important;
            background-color: #5FB878 !important;
            font-weight: 550 !important;
            text-align: center;
        }
    </style>
</head>
<body background="images/login.svg">
<form class="layui-form" action="javascript:void(0);">
    <div class="layui-form-item">
        <img class="logo" src="images/logo.png" alt="" src="images/logo.png"/>
        <div class="title">停车系统</div>
        <div class="desc" th:text="${login_title}"></div>
    </div>
    <div class="layui-form-item">
        <input name="username" type="text" placeholder="用户名" value="admin" hover class="layui-input"/>
    </div>
    <div class="layui-form-item">
        <input name="password" type="password" placeholder="密 码" value="admin" hover class="layui-input"/>
    </div>
    <div class="layui-form-item">
        <%--        lay-submit lay-filter="login"--%>

        <div id="adst">
<%--            <a href="${APP_PATH}/SelectAllCar"> 登 入</a>--%>
    <a href="adminIndex.jsp">登 入</a>
        </div>


    </div>
</form>
<script th:src="@{/lib/layui/layui.js}" type=""></script>
</body>
</html>


