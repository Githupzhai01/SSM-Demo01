<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../../model.jsp" %>

<section id="main-content">
    <section class="wrapper">
        <div class="row">
            <div class="col-lg-12">
                <section class="panel">
                    <div class="col-lg-9 col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h2>
                                    <i class="fa fa-flag-o red"></i><strong>年卡用户</strong>
                                </h2>
                                <div class="panel-actions">
                                    <a href="index.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
                                    <a href="index.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
                                    <a href="index.html#" class="btn-close"><i class="fa fa-times"></i></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table class="table bootstrap-datatable countries">
                                    <thead>
                                    <tr>
                                        <th>车主</th>
                                        <th>联系方式</th>
                                        <th>车牌</th>
                                        <th>申请时间</th>
                                        <th>可选操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${page }" var="list">
                                        <tr>
                                            <td>${list.username }</td>
                                            <td>${list.phone }</td>
                                            <td>${list.carnumber }</td>
                                            <td>${list.starttimestring }</td>
                                            <td>
                                                <div class="btn-group">
                                                    <a class="btn btn-success" href="${pageContext.request.contextPath}/updCardre?cid=${list.cid }&type=1">
                                                        <i class="icon_check_alt2"></i></a>
                                                    <a class="btn btn-danger" href="${pageContext.request.contextPath }/DelCared?cid=${list.cid }&type=0">
                                                        <i class="icon_close_alt2"></i></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                    </tbody>
                                </table>
                            </div>

                        </div>


                    </div>
                </section>
            </div>
        </div>
        <!-- page end-->
    </section>
</section>
<!--main content end-->
