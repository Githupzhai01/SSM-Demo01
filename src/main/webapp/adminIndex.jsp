<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="model.jsp"%>

<script>
function queding(newsid){
	
	 var r=confirm("确定删除吗")
	  if (r==true)
	    {
		  //alert(blogId);
		  window.location.href="${pageContext.request.contextPath }/deleteBlog.action?newsid="+newsid;
	    }
	  else
	    {
		 return false;
	    }
	
}
</script>
<!--sidebar end-->

<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
				<div class="info-box blue-bg">
					<i class="fa fa-cloud-download"></i>
					<div class="count" id="ysr">${monthCount}</div>
					<div class="title">月收入</div>
				</div>
				<!--/.info-box-->
			</div>
			<!--/.col-->

			<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
				<div class="info-box brown-bg">
					<i class="fa fa-shopping-cart"></i>
					<div class="count" id="nksl">${cardCount}</div>
					<div class="title">办卡数量</div>
				</div>
				<!--/.info-box-->
			</div>
			<!--/.col-->

			<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
				<div class="info-box dark-bg">
					<i class="fa fa-thumbs-o-up"></i>
					<div class="count" id="kycw">${freePosition}</div>
					<div class="title">空余车位</div>
				</div>
				<!--/.info-box-->
			</div>
			<!--/.col-->

			<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
				<div class="info-box green-bg">
					<i class="fa fa-cubes"></i>
					<div class="count" id="yycw">${usingPosition}</div>
					<div class="title">已用车位</div>
				</div>
				<!--/.info-box-->
			</div>
			<!--/.col-->
		</div>
		<!--/.row-->




		<!-- 搭建显示页面   class="container" -->
		<div >
			<!-- 标题 -->
			<p style="color: cornflowerblue;font-size: 20px">停车信息</p>
			<!-- 显示表格数据 -->
			<div class="row">
				<div class="col-md-9">
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
<%--							<th>操 作</th>--%>
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




			<%--    //显示公告信息--%>
			<div class="row">
				<div class="col-md-9">
					<!-- 按钮 -->
<%--					<button class="btn btn-primary" id="emp_add_modal_btn">添加公告</button>--%>
					<p style="color: cornflowerblue;font-size: 20px">公告信息</p>
					<table class="table table-hover" id="emps_table1">
						<thead>
						<tr>
							<th>#</th>
							<th>公告信息</th>
							<th>公告时间</th>
						</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
			</div>

		</div>

		<%--公告信息--%>
		<script type="text/javascript">

			var totalRecord1, currentPage1;
			//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
			$(function () {
				//去首页
				to_page1(1);
				to_tape2();
			});
			function to_tape2(){
				$.ajax({
					url: "${APP_PATH}/selectMsg",
					type: "GET",
					success: function (result) {
						$("#ysr").text(result.extend.money);
						$("#nksl").text(result.extend.carNum);
						$("#kycw").text(result.extend.ke);
						$("#yycw").text(result.extend.yi);
					}
				});
			}

			function to_page1(pn) {
				$.ajax({
					url: "${APP_PATH}/notsel",
					data: "pn=" + pn,
					type: "GET",
					success: function (result) {
						//console.log(result);
						//1、解析并显示员工数据
						build_emps_table1(result);
						//2、解析并显示分页信息
						build_page_info(result);
						//3、解析显示分页条数据
						build_page_nav(result);
					}
				});
			}

			function build_emps_table1(result) {
				//清空table表格
				$("#emps_table1 tbody").empty();
				var emps = result.extend.noticeList.list;
				$.each(emps, function (index, item) {
					// var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
					var noid = $("<td></td>").append(item.noid);
					var noname = $("<td></td>").append(item.noname);
					var notime = $("<td></td>").append(item.notime);


					/**
					 <button class="">
					 <span class="" aria-hidden="true"></span>
					 编辑
					 </button>
					 */

					var editBtn1 = $("").append("编辑");
					//为编辑按钮添加一个自定义的属性，来表示当前员工id
					editBtn1.attr("edit-id", item.noid);
					var delBtn1 = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn1")
							.append($("<span></span>").addClass("")).append("删除");
					//为删除按钮添加一个自定义的属性来表示当前删除的员工id
					delBtn1.attr("del-idno", item.noid);
					var btnTd = $("<td></td>").append(editBtn1).append(" ").append(delBtn1);
					//var delBtn =
					//append方法执行完成以后还是返回原来的元素
					$("<tr></tr>")
							.append(noid)
							.append(noname)
							.append(notime)
							.append(editBtn1)
							.append(delBtn1)
							.appendTo("#emps_table1 tbody");
				});
			}

			//单个删除
			$(document).on("click", ".delete_btn1", function () {
				//1、弹出是否确认删除对话框
				var noid = $(this).attr("del-idno");
				//alert($(this).parents("tr").find("td:eq(1)").text());
				if (confirm("确认删除这条公告吗？")) {
					//确认，发送ajax请求删除即可
					$.ajax({
						url: "${APP_PATH}/DelNo?noid=" + noid,
						type: "DELETE",
						success: function (result) {
							alert(result.msg);
							//回到本页
							to_page();
							to_page1(1);
							to_tape2();
						}
					});
				}
			});


		</script>
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
					url: "${APP_PATH}/emp",
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
							.append($("<span></span>").addClass("")).append("编辑");
					//为编辑按钮添加一个自定义的属性，来表示当前员工id
					editBtn.attr("edit-id", item.rid);
					var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
							.append($("<span></span>").addClass("")).append("删除");
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
							// .append(btnTd)
							.appendTo("#emps_table tbody");
				});
			}

			//解析显示分页信息
			function build_page_info(result) {
				$("#page_info_area").empty();
				$("#page_info_area").append("当前" +result.extend.pageInfo.pageNum+ "页,总" +
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




		</script>




	</section>

</section>
<!--main content end-->
<!-- container section start -->

<!-- javascripts -->
<script src="js/jquery.js"></script>
<script src="js/jquery-ui-1.10.4.min.js"></script>
<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
<!-- bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<!-- charts scripts -->
<script src="assets/jquery-knob/js/jquery.knob.js"></script>
<script src="js/jquery.sparkline.js" type="text/javascript"></script>
<script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="js/owl.carousel.js"></script>
<!-- jQuery full calendar -->
<script src="js/fullcalendar.min.js"></script>
<!-- Full Google Calendar - Calendar -->
<script src="assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
<!--script for this page only-->
<script src="js/calendar-custom.js"></script>
<script src="js/jquery.rateit.min.js"></script>
<!-- custom select -->
<script src="js/jquery.customSelect.min.js"></script>
<script src="assets/chart-master/Chart.js"></script>

<!--custome script for all page-->
<script src="js/scripts.js"></script>
<!-- custom script for this page-->
<script src="js/sparkline-chart.js"></script>
<script src="js/easy-pie-chart.js"></script>
<script src="js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="js/jquery-jvectormap-world-mill-en.js"></script>
<script src="js/xcharts.min.js"></script>
<script src="js/jquery.autosize.min.js"></script>
<script src="js/jquery.placeholder.min.js"></script>
<script src="js/gdp-data.js"></script>
<script src="js/morris.min.js"></script>
<script src="js/sparklines.js"></script>
<script src="js/charts.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<script>



      //knob
      $(function() {
        $(".knob").knob({
          'draw' : function () { 
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
          $("#owl-slider").owlCarousel({
              navigation : true,
              slideSpeed : 300,
              paginationSpeed : 400,
              singleItem : true

          });
      });

      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });
	  
	  /* ---------- Map ---------- */
	$(function(){
	  $('#map').vectorMap({
	    map: 'world_mill_en',
	    series: {
	      regions: [{
	        values: gdpData,
	        scale: ['#000', '#842525'],
	        normalizeFunction: 'polynomial'
	      }]
	    },
		backgroundColor: '#eef3f7',
	    onLabelShow: function(e, el, code){
	      el.html(el.html()+' (GDP - '+gdpData[code]+')');
	    }
	  });
	});



  </script>

</body>
</html>
