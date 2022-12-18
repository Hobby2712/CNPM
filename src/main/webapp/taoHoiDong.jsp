<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <li><a href="listTK"><span class="las la-user-circle"></span><span>Tài khoản</span></a></li>
                <li><a href="listHD" class="active"><span class="las la-campground"></span><span>Tạo hội đồng</span></a></li>
                <li><a href="logout"><span class="las la-arrow-alt-circle-left"></span><span>Đăng xuất</span></a></li>
            </ul>
        </div>
    </div>


    <div class="main-content">
        <header>
            <h2>
                <label for="nav-toggle"> <span class="las la-bars"></span>
            </label> Quản lý hội đồng
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

                    <div class="card-body">
                        <div class="table-responsive">
                            <table width="100%">

                                <thead>
                                    <tr>
                                        <td>Mã hội đồng</td>
                                        <td>Đề tài</td>
                                        <td>Ngày phản biện</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="hd">
                                        <tr>
                                            <td>${hd.id}</td>
                                            <td>${hd.getDT(hd.detai).tenDT}</td>
                                            <td>${hd.ngayPB}</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>


            </div>
            <div class="formBig">
                <form action="taoHD" method="post">
                    <div class="form">
                        <div class="action-role">
                            <h2>
                                <span>Tạo hội đồng</span>
                            </h2>
                        </div>
                        <div class="form-account">
                            <div class="input-box">
                                <h3>
                                    <span>Số Lượng</span>
                                </h3>
                                <input type="text" name="soLuong" placeholder="" required style="text-align: center;">
                            </div>
                        </div>
                        <div class="form-account2">
                            <div class="input-box">
                                <h3>
                                    <span>Ngày phản biện</span>
                                </h3>
                                <input type="date" name="ngayPB" placeholder="" required>
                            </div>
                        </div>

                        <div class="form-role">
                            <div class="input-box">
                                <h3>
                                    <span>Đề tài</span>
                                </h3>
                                <select name="deTai">
                                	<c:forEach items="${dt}" var="o">
                                    	<option value="${o.id}">${o.tenDT}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <button class="submit" type="submit">
                            <span>Xác nhận</span>
                        </button>
                    </div>
                </form>

                <form action="deleteHD" method="post">
                    <div class="form-2">
                        <div class="action-role" style="margin-left: -150px;">
                            <h2>
                                <span>Xóa hội đồng</span>
                            </h2>
                        </div>
                        <div class="form-account">
                            <div class="input-box" >
                                <h3 style="margin-left:90px; margin-top: 20px;">
                                    <span>Mã hội đồng</span>
                                </h3>
                                <input type="text" name="id" placeholder="" required style="margin-left:90px;margin-top: 20px;">
                            </div>
                        </div>
                        <button class="submit" type="submit" style="top: 82%">
                            <span>Xác nhận</span>
                        </button>
                    </div>
                </form>
            </div>
    </div>


    </main>

    </div>
</body>

</html>