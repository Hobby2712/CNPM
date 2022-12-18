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
			href="infoGV" class="list-group-item ">Quản trị tài khoản</a> <a
			href="listDT" class="list-group-item ">Danh sách đề tài</a>
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

									<a href="homeGV" class="list-group-item">Trang Chủ</a> <a
										href="infoGV" class="list-group-item active">Quản trị tài khoản</a>
									<a href="dkdt" class="list-group-item ">Đăng kí đề tài</a><a
										href="listDTHD" class="list-group-item ">Quản lý nhóm</a>
									<c:if test="${sessionScope.acc.role == 4}">
										<a href="listduyetDT" class="list-group-item ">Duyệt đề tài</a>
										<a href="listPB" class="list-group-item">Phân giáo viên phản biện</a>
									</c:if>
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

						<!-- Thông tin sinh viên -->
						<div class="panel panel-default">
							<div style="color: rgb(39, 86, 156);" class="panel-heading">
								<h4
									style="text-align: center; font-family: verdana; color: rgb(87, 87, 87);">
									Thông tin giảng viên</h4>
							</div>


							<div class="container row-inner  ">
								<div class="col-right">
									<table class="table table-hover footable-loaded footable">
										<tbody>
											<tr>
												<td>Tên</td>
												<td>${info.fullName}</td>
											</tr>
											<tr class=" success">
												<td>Mã số giảng viên</td>
												<td>${info.uId}</td>
											</tr>

											<tr>
												<td>Địa Chỉ</td>
												<td>${info.address}</td>
											</tr>

											<tr class=" success">
												<td>Giới tính</td>
												<td>${info.gioiTinh}</td>
											</tr>

											<tr>
												<td>Số điện thoại</td>
												<td>${info.phone}</td>
											</tr>
											<tr class=" success">
												<td>Email</td>
												<td>${info.email}</td>

											</tr>


											<tr>
												<td>Chuyên ngành</td>
												<c:if test="${info.chuyenNganh==1}">
													<td>Công nghệ phần mềm</td>
												</c:if>
												<c:if test="${info.chuyenNganh==2}">
													<td>Mạng máy tính</td>
												</c:if>
												<c:if test="${info.chuyenNganh==3}">
													<td>Hệ thống thông tin</td>
												</c:if>
												<c:if test="${info.chuyenNganh==4}">
													<td>Kỹ thuật dữ liệu</td>
												</c:if>
											</tr>

										</tbody>
									</table>
								</div>
								<div class="col-left">
									<img src="img/Avatar.png" alt="avatar">
										<div>
											<a href="loadEditInfo"><button
													class="back btn btn-success">Sửa thông tin</button></a><br>
												<a href="loadchangePass"><button
														class="edit-information btn btn-warning">Đổi mật
														khẩu</button></a>
										</div>
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