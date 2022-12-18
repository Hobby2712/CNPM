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
			DANH MỤC</li> <a href="home" class="list-group-item ">Trang Chủ</a> <a
			href="info" class="list-group-item ">Quản trị tài khoản</a> <a
			href="listDT" class="list-group-item ">Đăng kí đề tài</a><a
			href="loadTV" class="list-group-item active">Quản lý nhóm</a> <a
			href="nopBC" class="list-group-item ">Nộp báo cáo</a>
		<hr />
	</div>
	</div>

	<div id="container">

		<div id="mobile-bar">
			<span style="cursor: pointer;" class="pull-left" href="javascript:;"
				onclick="slideMenu(); return false;" id="slideicon"><i
				class="icon-reorder"></i></span> <span data-toggle="modal"
				href="loginAccount" class="pull-right btn btn-default btn-sm" id="#">Đăng
				nhập</span>
			<p style="text-align: center; font-weight: bold;">Đăng ký đề tài</p>
		</div>

		<div id="navigation">
			<div id="banner-desktop">
				<div class="container">
					<div id="banner">
						<c:if test="${sessionScope.acc == null}">
							<div id="login-area">
								<a data-toggle="modal" href="loginAccount"> Đăng nhập</a>
							</div>
						</c:if>
						<c:if test="${sessionScope.acc != null}">
							<div id="login-area">
								<a data-toggle="modal" href="logout"> Đăng xuất</a>
							</div>
						</c:if>
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


									<a href="home" class="list-group-item ">Trang Chủ</a> <a
										href="info" class="list-group-item ">Quản trị tài khoản</a> <a
										href="listDT" class="list-group-item ">Đăng kí đề tài</a><a
										href="loadTV" class="list-group-item active">Quản lý nhóm</a>
									<a href="nopBC" class="list-group-item ">Nộp báo cáo</a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-9">
						<ol class="breadcrumb">
							<li><a href="#"> <marquee width="100%" behavior="scroll"
										direction="left"> <img height="15px" width="15px"
										src="img/thongbao.png" alt="thong bao"> Thông báo khóa
										k2020 nộp bằng tốt nghiệp trước ngày 21-12-2022 | Sinh viên
										nghỉ tết dương lịch 2023 2 ngày 01-01-2022 và 02-01-2022 |
										Sinh viên sẽ kết thúc học kì 1 năm học 2022 trước ngày
										09-01-2022 </marquee>
							</a></li>

						</ol>
						<c:if test="${not empty message}">
							<!-- Hiển thị thông báo -->
							<div class="panel-heading"
								style="background-color: #25d78a !important; border-radius: 12px !important;">
								<h3 style="margin: 0 !important; font-size: 20px;">${message}</h3>
							</div>
						</c:if>
						<!-- Danh sách giảng viên-->
						<table class="table footable-loaded footable tablet breakpoint"
							data-page-size="5">
							<thead>
								<tr>
									<th data="true" class="footable-first-column">MSSV</th>
									<th data="true">Tên sinh viên</th>
									<th data="true" style="width: 170px !important;">Chuyên
										ngành</th>
									<th data-hide="phone" class="footable-last-column">Hành
										động</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="o">
									<tr class="">
										<td class="footable-first-column"><span
											class="footable-toggle"></span><span class="text-info">${o.uId}</span></td>
										<td><span class="name"></span>${o.fullName}</td>
										<c:if test="${o.chuyenNganh==1}">
											<td>Công nghệ phần mềm</td>
										</c:if>
										<c:if test="${o.chuyenNganh==2}">
											<td>Mạng máy tính</td>
										</c:if>
										<c:if test="${o.chuyenNganh==3}">
											<td>Hệ thống thông tin</td>
										</c:if>
										<c:if test="${o.chuyenNganh==4}">
											<td>Kỹ thuật dữ liệu</td>
										</c:if>
										<td><a href="addTV?uid=${o.uId}"
											class="btn btn-success btn-xs">Thêm vào nhóm</a></td>
									</tr>
								</c:forEach>

							</tbody>
							<tfoot>
								<tr>
									<td colspan="6">

										<div class="pagination-container">
											<ul class="pagination">
												<ul class="pagination">
													<a href="loadTV"><button type="button"
															class="btn btn-warning"
															style="text-align: center !important;">Quay lại</button></a>
												</ul>

											</ul>
										</div>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	<footer>
	<div class="container-fluid">© Copyright 2022 | UTE University</div>

	<a href="#" class="back-to-top"> <i class="fa-solid fa-chevron-up"></i>
	</a> </footer>

	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>

</html>