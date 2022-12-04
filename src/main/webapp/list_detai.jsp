<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="icon" href="#" type="" />
	<link rel="shortcut icon" href="#" />
	<title>::. Th&#244;ng b&#225;o .::</title>
	<link rel="stylesheet" media="all" type="text/css"
		href="css/bootstrap.min.css" />
	<link rel="stylesheet" media="all" type="text/css" href="css/style.css" />
	<link rel="stylesheet" media="all" type="text/css"
		href="css/footable.core.css" />
	<link rel="stylesheet" media="all" type="text/css"
		href="css/footable.standalone.css" />
	<link href="css/font-awesome.min.css" rel="stylesheet" />
	<link href="css/font-awesome.css" rel="stylesheet" />
	<link rel="stylesheet" href="fontawesome/css/all.min.css">

		<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="js/footable.js"></script>
		<script type="text/javascript" src="js/myjs.js"></script>
		<script src="js/ckeditor.js"></script>
		<link href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
		<script src="js/jquery.simple-dtpicker.js"></script>
</head>

<body>
	<div id="menu">
		<li class="list-group-item"
			style="text-align: center; font-weight: bold; font-family: verdana; background-color: #efefef; color: cadetblue;">
			DANH MỤC</li> <a href="home" class="list-group-item">Trang Chủ</a> <a
			href="listDT" class="list-group-item ">Danh sách đề tài</a> <a
			href="#" class="list-group-item ">Thông tin giảng viên</a> <a
			href="#" class="list-group-item ">Thông tin sinh viên</a> <a href="#"
			class="list-group-item ">Thống kê</a> <a data-toggle="modal"
			href="#seach_box" class="list-group-item"> Tìm kiếm</a>
		<hr />
	</div>

	<div id="container">

		<div id="mobile-bar">
			<span style="cursor: pointer;" class="pull-left" href="javascript:;"
				onclick="slideMenu(); return false;" id="slideicon"><i
				class="icon-reorder"></i></span> <span data-toggle="modal"
				href="#dang_nhap" class="pull-right btn btn-default btn-sm" id="#">Đăng
				nhập</span>
			<p style="text-align: center; font-weight: bold;">Đăng ký đề tài</p>
		</div>

		<div id="navigation">
			<div id="banner-desktop">
				<div class="container">
					<div id="banner">
						<div id="login-area">
							<a data-toggle="modal" href="Login.html"> Đăng nhập</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="wrapper">
			<div class="container">
				<div class="row">
					<div id="left-content">
						<div class="col-md-3">
							<!-- Menu desktop -->
							<div id="desktop-menu">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 id="mobile_home">Danh Mục</h4>
									</div>

									<a href="home" class="list-group-item active">Trang Chủ</a> <a
										href="listDT" class="list-group-item active "> Danh sách
										đề tài</a> <a href="#" class="list-group-item active ">Thông
										tin giảng viên</a> <a href="#" class="list-group-item active ">
										Thông tin sinh viên</a> <a data-toggle="modal" href="#"
										class="list-group-item active"> Tìm kiếm</a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-9">
						<ol class="breadcrumb">
							<li><a href="#"> <marquee width="100%" behavior="scroll"
										direction="left">
									<img height="15px" width="15px" src="img/thongbao.png"
										alt="thong bao"> Thông báo khóa k2020 nộp bằng tốt
										nghiệp trước ngày 21-12-2022 | Sinh viên nghỉ tết dương lịch
										2023 2 ngày 01-01-2022 và 02-01-2022 | Sinh viên sẽ kết thúc
										học kì 1 năm học 2022 trước ngày 09-01-2022 </marquee>
							</a></li>

						</ol>

						<!-- List Đề Tài -->
						<table class="table footable-loaded footable tablet breakpoint"
							data-page-size="5">
							<thead>
								<tr>
									<th data="true" class="footable-first-column"
										style="width: 140px !important;">ID</th>
									<th data="true">Tên đề tài</th>
									<th data="true" style="width: 140px !important;">GVHD</th>
									<th data-hide="phone" class="footable-last-column"
										style="width: 80px !important;">Chi tiết</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="o">

									<tr class="">
										<td class="footable-first-column"><span
											class="footable-toggle"></span><span class="text-info">${o.id}</span></td>
										<td>${o.tenDT}</td>
										<td>${o.GVHD}</td>
										<td class="footable-last-column"><a target="_blank"
											href="detail?id=${o.id}" class="btn btn-success btn-xs">Xem</a>
										</td>

									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="6">

										<!-- <div class="pagination-container">
											<ul class="pagination">
												<li class="active"><a>1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">5</a></li>
												<li><a href="#">6</a></li>
												<li><a href="#">7</a></li>
												<li><a href="#">8</a></li>
												<li><a href="#">9</a></li>
												<li><a href="#">10</a></li>
												<li class="disabled PagedList-ellipses"><a>…</a></li>
												<li class="PagedList-skipToNext"><a href="#" rel="next">»</a>
												</li>
												<li class="PagedList-skipToLast"><a href="#">»»</a></li>
											</ul>
										</div> -->
									</td>
								</tr>
							</tfoot>
						</table>


					</div>
				</div>
			</div>
			<footer>
			<div class="container-fluid">© Copyright 2022 | UTE University
			</div>

			<a href="#" class="back-to-top"> <i
				class="fa-solid fa-chevron-up"></i>
			</a> </footer>

			<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>

</html>