<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/admin1.css">
<title>Document</title>
</head>

<body>
	<input type="checkbox" id="nav-toggle">
	<div class="sidebar">
		<div class="sidebar-brand">
			<h2>
				<span class="lab la-accusoft"></span><span>Admin</span>
			</h2>
		</div>
		<div class="sidebar-menu">
			<ul>
				<li><a href="admin"><span class="las la-igloo"></span><span>Trang
							chủ</span></a></li>
				<li><a href="detai.jsp"><span class="las la-list"></span><span>Tạo
							đợt đăng ký đề tài</span></a></li>
				<li><a href="listTK" class="active"><span
						class="las la-user-circle"></span><span>Tài khoản</span></a></li>
				<li><a href="listHD"><span class="las la-campground"></span><span>Tạo
							hội đồng</span></a></li>
				<li><a href="logout"><span
						class="las la-arrow-alt-circle-left"></span><span>Đăng xuất</span></a></li>
			</ul>
		</div>
	</div>


	<div class="main-content">
		<header>
			<h2>
				<label for="nav-toggle"> <span class="las la-bars"></span>
				</label> Thêm tài khoản
			</h2>
		</header>
		<main>


			<div class="recent2-grid">
				<div class="projects">
					<c:if test="${not empty message}">
						<!-- Hiển thị thông báo -->
						<div class="card-header" style="background-color: #5F9EA0;">
							<h3>${message}</h3>
						</div>
					</c:if>

				</div>


			</div>
			<!-- Thêm tài khoản-->
			<div class="login-box">
				<h2>Thêm tài khoản</h2>
				<form action="addAccount" method="post">
					<div class="user-box">
						<input type="text" name="username" required autofocus> <label>Tên
							tài khoản</label>

					</div>
					<div class="user-box">
						<input type="text" name="pass" required autofocus> <label>Mật
							khẩu</label>

					</div>

					<div class="user-box">
						<input type="text" name="uid" required autofocus> <label>Mã
							user</label>

					</div>
					<div class="user-box">

						<input type="text" name="name" id="name" required autofocus>
						<label>Họ tên</label>
					</div>

					<div class="user-box">
						<input type="text" name="sdt" required> <label>Số
							điện thoại</label>

					</div>
					<div class="user-box">
						<input type="email" name="email" required> <label>Email</label>

					</div>
					<div class="user-box">
						<input type="text" name="address" required autofocus> <label>Địa
							chỉ</label>

					</div>

					<div class="user-box" style="margin-bottom: 15px">
						<span>Giới tính</span> <select name="gioiTinh">
							<option value="Nam">Nam</option>
							<option value="Nữ">Nữ</option>
						</select>

					</div>

					<div class="user-box">
						<span>Chuyên ngành</span> <select name="cn" id="cn"><option
								value="1">Công nghệ phần mềm</option>
							<option value="2">Mạng máy tính</option>
							<option value="3">Hệ thống thông tin</option>
							<option value="4">Kĩ thuật dữ liệu</option>
						</select>

					</div>
					<div class="user-box" style="margin-top: 15px">
						<span>Phân quyền</span> <select name="role"><option
								value="3">Sinh viên</option>
							<option value="2">Giảng viên</option>
							<option value="4">Trưởng bộ môn</option>
						</select>

					</div>



					<div id="container">
						<input id="tao-tk" value="Tạo tài khoản" type="submit"> </input> <a
							id="back" href="Account.html"> Quay về </a>

					</div>
				</form>
			</div>

		</main>

	</div>
</body>

</html>