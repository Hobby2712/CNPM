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
        <div href="admin.html" class="sidebar-brand">
            <h2><span class="lab la-accusoft"></span><span>Admin</span></h2>
        </div>
        <div class="sidebar-menu">
            <ul>
                <li><a href="admin" class="active"><span class="las la-igloo"></span><span>Trang chủ</span></a></li>
                <li><a href="detai.jsp"><span class="las la-list"></span><span>Tạo đợt đăng ký đề tài</span></a></li>
                <li><a href="listTK"><span class="las la-user-circle"></span><span>Tài khoản</span></a></li>
                <li><a href="listHD"><span class="las la-campground"></span><span>Tạo hội đồng</span></a></li>
                <li><a href="logout"><span class="las la-arrow-alt-circle-left"></span><span>Đăng xuất</span></a></li>
            </ul>
        </div>
    </div>


    <div class="main-content">
        <header>
            <h2>
                <label for="nav-toggle">
                    <span class="las la-bars"></span>
                </label>
                Quản lý đề tài nghiên cứu khoa học
            </h2>
            <div class="search-wrapper">
                <span class="las la-search"></span>
                <input type="search" placeholder="Search here" id="">
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
            <div class="cards">
                <div class="card-single">
                    <div>
                        <h1>${countDT}</h1>
                        <span>Đề tài</span>
                    </div>
                    <div>
                        <span class="las la-clipboard"></span>
                    </div>
                </div>

                <div class="card-single">
                    <div>
                        <h1>${countTK}</h1>
                        <span>Tài khoản</span>
                    </div>
                    <div>
                        <span class="las la-user-circle"></span>
                    </div>
                </div>


            </div>

            <div class="recent2-grid">
                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>Tất cả đề tài</h3>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">
                            <table width="100%">

                                <thead>
                                    <tr>
                                        <td>Tên đề tài</td>
                                        <td>Giáo viên hướng dẫn</td>
                                        <td>Trạng thái</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="o">
                                        <tr>
                                            <td>${o.tenDT}</td>
                                            <td>${o.GVHD}</td>
                                            <c:if test="${o.trangThai == 1}">
                                                <td>Chưa được duyệt</td>
                                            </c:if>
                                            <c:if test="${o.trangThai == 2}">
                                                <td>Đã được duyệt</td>
                                            </c:if>
                                            <c:if test="${o.trangThai == 3}">
                                                <td>Không được duyệt</td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                </div>
        </main>
    </div>

</body>

</html>