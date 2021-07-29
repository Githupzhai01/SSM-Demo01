<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/1
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据展示页面</title>
    <% pageContext.setAttribute("APP_PATH",request.getContextPath());%>
</head>
<body>

<div style="margin-left: 200px;">
    <%--    搭建显示页面--%>
    <div class="container">
        <%--        标题--%>
        <div class="col-md-12"><h1>SSM-CRUD-DEMO1</h1></div>
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button class="btn btn-primary" id="emp_add_modal_btn" ><a href="../../CarAdd.jsp" style="text-decoration: none; color: white">新增</a></button>
                <button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
            </div>
        </div>


    </div>
    <%--    显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>编号</th>
                    <th>车牌号</th>
                    <th>结算价格</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>车位数</th>
<%--                    <th>状态(0/1)</th>--%>
                    <th>状态(停车/结束)</th>
                    <th>操 作</th>
                </tr>
                <c:forEach items="${requestScope.page.list}" var="emp">
                    <tr>
                        <th>${emp.rid}</th>
                        <th>${emp.carnumber}</th>
                        <th>${emp.parkprice}</th>
                        <th>${emp.intimestring}</th>
                        <th>${emp.outtimestring}</th>
                        <th>${emp.position}</th>
<%--                        <th>${emp.carstate}</th>--%>
                        <th>${emp.carstatedes}</th>
                        <th>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <button class="btn btn-danger btn-sm"  onclick="Del(${emp.rid})">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"  ></span>
                                <a style="text-decoration: none; color: white" >删除</a>
                            </button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <%--显示分页--%>
    <div>
        <div class="col-md-6">当前${requestScope.page.pageNum}页,总${requestScope.page.pages}页,总${requestScope.page.total}</div>
        <%--        分页条信息--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation"></nav>
            <ul class="pagination">
                <li><a href="${APP_PATH}/SelectAllCar?pn=1">首页</a></li>
                <c:if test="${requestScope.page.hasPreviousPage}">
                    <li><a href="${APP_PATH}/SelectAllCar?pn=${requestScope.page.pageNum-1}" aria-label="Previous">
                        <span aria-hidden="true">上一页</span></a></li>
                </c:if>
                <c:forEach items="${requestScope.page.navigatepageNums}" var="page_Num">
                    <c:if test="${page_Num==page.pageNum}">
                        <li class="active"><a href="#">${page_Num}</a></li>
                    </c:if>
                    <c:if test="${page_Num!=page.pageNum}">
                        <li><a href="${APP_PATH}/SelectAllCar?pn=${page_Num}">${page_Num}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${requestScope.page.hasNextPage}">
                    <li>
                        <a href="${APP_PATH}/SelectAllCar?pn=${requestScope.page.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">下一页</span></a>
                    </li>
                </c:if>
                <li><a href="${APP_PATH}/SelectAllCar?pn=${requestScope.page.pages}">末页</a></li>
            </ul>
        </div>

    </div>
</div>

<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">

   function Del(id){
        if(confirm("确认删除这条信息吗？")){
            //确认，发送ajax请求删除即可
            $.ajax({
                url:"${APP_PATH}/DeloneCar?rid="+id,
                type:"DELETE",
                success:function(result){
                    // alert(result.msg);
                    alert("删除成功!!!")
                    //回到本页
                    // to_page(currentPage);

                }
            });
        }
    }



</script>


</body>
</html>
