<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<%@ include file="../../model.jsp" %>
<section id="main-content">
    <section class="wrapper">

        <div class="row">
            <div class="col-lg-15">
                <section class="panel">
                    <div class="panel-body" id="NoticeA">
                        <form class="form-validate form-horizontal"  method="post">
                            <div class="form-group ">
                                <%--@declare id="cname"--%><label for="cname" class="control-label col-lg-2">公告信息<span
                                        class="required">*</span></label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="notime"  minlength="2"
                                           type="text" required/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <button class="btn btn-primary" type="button" id="Noticesubmit">保存</button>
                                </div>
                            </div>
                        </form>

                    </div>
                </section>
            </div>
        </div>
        <!-- page end-->
    </section>

    <script type="text/javascript">
        $("#Noticesubmit").click(function () {
            $.ajax({
                url: "${APP_PATH}/noticeAdd?notice=" + $("#notime").val(),
                type: "POST",
                data: $("#empAddModal form").serialize(),
                success: function (result) {
                    alert(result.msg);
                    window.location.href="../../adminIndex.jsp";

                }
            });
        });
    </script>

</section>
<!--main content end-->
