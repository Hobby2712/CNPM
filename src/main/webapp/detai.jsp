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
                <li><a href="detai.jsp" class="active"><span class="las la-list"></span><span>Tạo đợt đăng ký đề tài</span></a></li>
                <li><a href="listTK"><span class="las la-user-circle"></span><span>Tài khoản</span></a></li>
                <li><a href="listHD"><span class="las la-campground"></span><span>Tạo hội đồng</span></a></li>
                <li><a href="logout"><span class="las la-arrow-alt-circle-left"></span><span>Đăng xuất</span></a></li>
			</ul>
		</div>
	</div>


	<div class="main-content">
		<header>
			<h2>
				<label for="nav-toggle"> <span class="las la-bars"></span>
				</label> Quản lý đề tài
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
						<div
							style="background-color: rgb(33, 165, 33); padding: 10px; font-size: 120%;">${message}</div>
						<br>
					</c:if>
					<div class="card">
						<div class="card-header">
							<h3>Tất cả đề tài</h3>
							<button>
								Xem tat ca <span class="las la-arrow-right"></span>
							</button>
						</div>
					</div>

					<div class="card-body">
						<div class="table-responsive">
							<table width="100%">
								<thead>
									<tr>
										<td>Đối tượng</td>
										<td>Thời gian đăng kí</td>
										<td>Hạn chót đăng kí</td>
										<td>Tạo đề tài đăng kí</td>
									</tr>
								</thead>
								<tbody>
									<form action="dotDangKySV" method="post">
										<tr>
											<td>Sinh Viên</td>
											<td><input type="datetime-local" id="firstdaytime"
												name="ngayBD"></td>
											<td><input type="datetime-local" id="lastdaytime"
												name="ngayKT"></td>
											<td><button type="submit" class="Make">Tạo</button></td>
										</tr>

									</form>
									<form action="dotDangKyGV" method="post">
										<tr>
											<td>Giảng Viên</td>
											<td><input type="datetime-local" id="firstdaytime"
												name="ngayBD"></td>
											<td><input type="datetime-local" id="lastdaytime"
												name="ngayKT"></td>
											<td><button type="submit" class="Make">Tạo</button></td>
										</tr>
									</form>
								</tbody>
							</table>
						</div>
					</div>
				</div>


			</div>
	</div>
	</main>
	</div>
</body>
</html>