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
<link rel="stylesheet" type="text/css" href="css/admin.css">
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
				<li><a href="admin"><span class="las la-igloo"></span><span>Trang chủ</span></a></li>
                <li><a href="detai.jsp"><span class="las la-list"></span><span>Tạo đợt đăng ký đề tài</span></a></li>
                <li><a href="listTK" class="active"><span class="las la-user-circle"></span><span>Tài khoản</span></a></li>
                <li><a href="listHD"><span class="las la-campground"></span><span>Tạo hội đồng</span></a></li>
                <li><a href="logout"><span class="las la-arrow-alt-circle-left"></span><span>Đăng xuất</span></a></li>
			</ul>
		</div>
	</div>


	<div class="main-content">
		<header>
			<h2>
				<label for="nav-toggle"> <span class="las la-bars"></span>
				</label> Quan ly de tai khoa hoc
			</h2>
			<div class="search-wrapper">
				<span class="las la-search"></span> <input type="search"
					placeholder="Search here" id="">
			</div>
			<div class="user-wrapper">
				<img src="" alt="" width="40px" height="40px">
				<div>
					<h4>Name</h4>
					<small>Admin</small>
				</div>
			</div>
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
					<div class="card">
						<div class="card-header">
							<h3>Quản lý tài khoản</h3>
							<a href="listTKadd"><button>
								Thêm tài khoản <span class="las la-arrow-right"></span>
							</button></a>
						</div>
					</div>

					<div class="card-body">
						<div class="table-responsive">
							<table width="100%">

								<thead>
									<tr>
										<td>Tài khoản</td>
										<td>Mật khẩu</td>
										<td>Phân quyền</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listTK}" var="o">
										<tr>
											<td>${o.userName}</td>
											<td>${o.pass}</td>
											<c:if test="${o.role == 2}">
												<td>Giảng viên</td>
											</c:if>
											<c:if test="${o.role == 3}">
												<td>Sinh Viên</td>
											</c:if>
											<c:if test="${o.role == 4}">
												<td>Trưởng bộ môn</td>
											</c:if>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>


			</div>
			<div class="formBig">
				<form action="updateRole" method="post">
					<div class="form">
						<div class="action-role">
							<h2 style="width: 400px; margin-left: -160px;">
								<span>Phân quyền tài khoản</span>
							</h2>
						</div>
						<div class="form-account">
							<div class="input-box">
								<h3>
									<span>Tên tài khoản</span>
								</h3>
								<input type="text" name="tk" placeholder="" required
									style="width: 635px;">
							</div>
						</div>
						<div class="form-role">
							<div class="input-box">
								<h3>
									<span>Phân quyền</span>
								</h3>
								<select name="role">
									<option value="2">Giảng viên</option>
									<option value="3">Sinh viên</option>
									<option value="4">Trưởng bộ môn</option>
								</select>
							</div>
						</div>
						<button class="submit" type="submit">
							<span>Xác nhận</span>
						</button>
					</div>
				</form>

				<form action="delAcc" method="post">
					<div class="form-2">
						<div class="action-role">
							<h2 style="margin-left: -250px">
								<span>Xóa tài khoản</span>
							</h2>
						</div>
						<div class="form-account">
							<div class="input-box">
								<h3 style="margin-left: 90px; margin-top: 20px;">
									<span>Tên tài khoản</span>
								</h3>
								<input type="text" name="tk" placeholder="" required
									style="margin-left: 90px; margin-top: 20px;">
							</div>
						</div>
						<button class="submit" type="submit" style="top: 82%">
							<span>Xac nhan</span>
						</button>
					</div>
				</form>
			</div>
	</div>


	</main>

	</div>
</body>

</html>