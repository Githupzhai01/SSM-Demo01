<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ include file="../../model.jsp" %>
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



<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">停车信息添加</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">公告信息</label>
						<div class="col-sm-10">
							<input type="text" name="noname" id="notime" class="form-control" id="noname_add_input"
								   placeholder="">
							<span class="help-block"></span>
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
			</div>
		</div>
	</div>
</div>


<!-- 员工修改的模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加公告信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">公告信息</label>
						<div class="col-sm-10">
							<p class="form-control-static" id="noname_update_static"></p>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
			</div>
		</div>
	</div>
</div>

<!-- 搭建显示页面 -->
<div class="container">
	<div style="margin-top: 110px">
		<div class="col-md-12">
			<p style="color: cornflowerblue;font-size: 20px"><a href="${APP_PATH}/CarList" style="font-size: 20px;text-decoration: none;font-family: Calibri">用户停车区</a></p>
		</div>
	</div>

	<!-- 显示表格数据 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="emps_table">
				<thead>
				<tr>
					<th>#</th>
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
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
	</div>


	<!-- 显示分页信息 -->
	<div class="row">
		<!--分页文字信息  -->
		<div class="col-md-6" id="page_info_area"></div>
		<!-- 分页条信息 -->
		<div class="col-md-6" id="page_nav_area">

		</div>
	</div>


</div>


<%--停车信息--%>
<script type="text/javascript">




	var totalRecord, currentPage;
	//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
	$(function () {
		//去首页
		to_page(1);
	});

	function to_page(pn) {
		$.ajax({
			url: "${APP_PATH}/emps",
			data: "pn=" + pn,
			type: "GET",
			success: function (result) {
				//console.log(result);
				//1、解析并显示员工数据
				build_emps_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
				build_page_nav(result);
			}
		});
	}

	function build_emps_table(result) {
		//清空table表格
		$("#emps_table tbody").empty();
		var emps = result.extend.pageInfo.list;
		$.each(emps, function (index, item) {
			var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
			var rid = $("<td></td>").append(item.rid);
			var carnumber = $("<td></td>").append(item.carnumber);
			var parkprice = $("<td></td>").append(item.parkprice);
			var intimestring = $("<td></td>").append(item.intimestring);
			var outtimestring = $("<td></td>").append(item.outtimestring);
			//outtimestring outtime
			var position = $("<td></td>").append("车位"+item.position);
			var carstatedes = $("<td></td>").append(item.carstatedes);


			/**
			 <button class="">
			 <span class="" aria-hidden="true"></span>
			 编辑
			 </button>
			 */
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			//为编辑按钮添加一个自定义的属性，来表示当前员工id
			editBtn.attr("edit-id", item.rid);
			var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			delBtn.attr("del-id", item.rid);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			//var delBtn =
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(checkBoxTd)
					.append(rid)
					.append(carnumber)
					.append(parkprice)
					.append(intimestring)
					.append(outtimestring)
					.append(position)
					.append(carstatedes)
					.append(btnTd)
					.appendTo("#emps_table tbody");
		});
	}

	//解析显示分页信息
	function build_page_info(result) {
		$("#page_info_area").empty();
		$("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总" +
				result.extend.pageInfo.pages + "页,总" +
				result.extend.pageInfo.total + "条记录");
		totalRecord = result.extend.pageInfo.total;
		currentPage = result.extend.pageInfo.pageNum;
	}

	//解析显示分页条，点击分页要能去下一页....
	function build_page_nav(result) {
		//page_nav_area
		$("#page_nav_area").empty();
		var ul = $("<ul></ul>").addClass("pagination");

		//构建元素
		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if (result.extend.pageInfo.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			//为元素添加点击翻页的事件
			firstPageLi.click(function () {
				to_page(1);
			});
			prePageLi.click(function () {
				to_page(result.extend.pageInfo.pageNum - 1);
			});
		}


		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
		if (result.extend.pageInfo.hasNextPage == false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			nextPageLi.click(function () {
				to_page(result.extend.pageInfo.pageNum + 1);
			});
			lastPageLi.click(function () {
				to_page(result.extend.pageInfo.pages);
			});
		}


		//添加首页和前一页 的提示
		ul.append(firstPageLi).append(prePageLi);
		//1,2，3遍历给ul中添加页码提示
		$.each(result.extend.pageInfo.navigatepageNums, function (index, item) {

			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if (result.extend.pageInfo.pageNum == item) {
				numLi.addClass("active");
			}
			numLi.click(function () {
				to_page(item);
			});
			ul.append(numLi);
		});
		//添加下一页和末页 的提示
		ul.append(nextPageLi).append(lastPageLi);

		//把ul加入到nav
		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav_area");
	}

	//单个删除
	$(document).on("click", ".delete_btn", function () {
		//1、弹出是否确认删除对话框
		var empName = $(this).parents("tr").find("td:eq(2)").text();
		var empId = $(this).attr("del-id");
		//alert($(this).parents("tr").find("td:eq(1)").text());
		if (confirm("确认删除【" + empId + "】吗？")) {
			//确认，发送ajax请求删除即可
			$.ajax({
				url: "${APP_PATH}/DeloneCar?rid=" + empId,
				type: "DELETE",
				success: function (result) {
					alert(result.msg);
					//回到本页
					to_page(currentPage);
				}
			});
		}
	});


	//点击新增按钮弹出模态框。
	$("#emp_add_modal_btn").click(function () {
		//清除表单数据（表单完整重置（表单的数据，表单的样式））
		// reset_form("#empAddModal form");
		//s$("")[0].reset();
		//发送ajax请求，查出部门信息，显示在下拉列表中
		// getDepts("#empAddModal select");
		//弹出模态框
		$("#empAddModal").modal({
			backdrop: "static"
		});
	});

	//点击保存，保存员工。
	$("#emp_save_btn").click(function () {
		//1、模态框中填写的表单数据提交给服务器进行保存
		//1、先对要提交给服务器的数据进行校验
		// if(!validate_add_form()){
		//     return false;
		// };
		//1、判断之前的ajax用户名校验是否成功。如果成功。
		// if($(this).attr("ajax-va")=="error"){
		//     return false;
		// }

		//2、发送ajax请求保存员工
		$.ajax({

			url: "${APP_PATH}/noticeAdd?notice=" + $("#notime").val(),
			type: "POST",
			data: $("#empAddModal form").serialize(),
			success: function (result) {
				alert(result.msg);
				if (result.code === 100) {

					// if(result.code){
					//员工保存成功；
					//1、关闭模态框
					$("#empAddModal").modal('hide');

					//2、来到最后一页，显示刚才保存的数据
					//发送ajax请求显示最后一页数据即可
					to_page(totalRecord);
				} else {
					//显示失败信息
					//console.log(result);
					//有哪个字段的错误信息就显示哪个字段的；
					// if(undefined != result.extend.errorFields.email){
					//显示邮箱错误信息
					// show_validate_msg("#password_add_input", "error", result.extend.errorFields.email);
					// }
					if (undefined != result.extend.errorFields.empName) {
						//显示员工名字的错误信息
						show_validate_msg("#empName_add_input", "error", result.extend.errorFields.empName);
					}
				}
			}
		});
	});
</script>
