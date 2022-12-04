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

<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/fontawesome.min.css">

<title>Document</title>
</head>

<body>

	<input type="checkbox" id="nav-toggle">
	<div class="sidebar">
		<div href="admin.html" class="sidebar-brand">
			<h2>
				<span class="lab la-accusoft"></span><span>Giảng Viên</span>
			</h2>
		</div>
		<div class="sidebar-menu">
			<ul>
				<li><a href="teacherRegister.html"><span
						class="las la-igloo"></span><span>Trang chủ</span></a></li>
				<li><a href="register.html" class="active"><span
						class="las la-list"></span><span>Đăng kí đề tài</span></a></li>
				<li><a href=""><span class="las la-users"></span><span>Chọn
							sinh viên</span></a></li>
				<li><a href=""><span class="las la-list"></span><span>Lịch
							sử đăng kí</span></a></li>

			</ul>
		</div>
	</div>


	<div class="main-content">
		<header>
			<h2>
				<label for="nav-toggle"> <span class="las la-bars"></span>
				</label> Đăng kí đề tài
			</h2>
			<div class="search-wrapper">
				<span class="las la-search"></span> <input type="search"
					placeholder="Search here" id="">
			</div>
			<div class="user-wrapper">
				<img src="" alt="" width="40px" height="40px">
				<div>
					<h4>Name</h4>
					<small>Giảng viên</small>
				</div>
			</div>
		</header>
		<main>


			<div class="recent-grid">
				<div class="projects">
					<div class="card">
						<div class="card-header">
							<h3>Đăng kí đề tài</h3>

						</div>
						<c:if test="${not empty message}">
							<!-- Hiển thị thông báo -->
							<div class="card-header" style="background-color: #5F9EA0;">
								<h3>${message}</h3>
							</div>
						</c:if>
						<div class="container">
							<div class="title">Điền thông tin</div>
							<div class="content">
								<form action="dangki" method="post">
									<div class="name-project">
										<div class="input-box">
											<span class="details">Tên đề tài *</span> <input type="text"
												name="tenDT" placeholder="" required>
										</div>
									</div>
									<div class="user-details">
										<div class="input-box">
											<span class="details">Niên khóa</span> <input type="text"
												name="nienKhoa" placeholder="" required>
										</div>
										<div class="input-box">
											<span class="details">Số lượng sinh viên</span> <input
												type="text" name="soLuong" placeholder="" required>
										</div>
										<div class="input-box">
											<span class="details">Được phép đăng ký khác chuyên
												ngành</span> <select name="isKhacCN">
												<option value="1">Có</option>
												<option value="0">Không</option>
											</select>
										</div>
										<div class="input-box">
											<span class="details">Sản phẩm</span> <input type="text"
												name="sanPham" placeholder="" required>
										</div>
										<div class="input-box">
											<span class="details">Loại đề tài</span> <select
												name="loaiDT">
												<option value="1">Tiểu luậnn chuyên ngành</option>
												<option value="2">Đề tài tốt nghiệp</option>
											</select>
										</div>
									</div>

									<div class="name-project">
										<div class="input-box">
											<span class="details">Mục tiêu đề tài</span> <input
												type="text" name="mucTieu" placeholder="" required>
										</div>
									</div>
									<div class="name-project">
										<div class="input-box">
											<span class="details">Yêu cầu</span> <input type="text"
												name="yeuCau" placeholder="" required>
										</div>
									</div>

									<div class="name-project">
										<div class="input-box">
											<span class="details">Chú thích</span> <input type="text"
												name="chuThich" placeholder="">
										</div>
									</div>

									<div class="button">
										<input type="submit" value="Đăng kí">
									</div>
								</form>
							</div>
						</div>
					</div>



				</div>
			</div>
		</main>
	</div>

</body>

</html>