<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="icon" href="#" type="" />
    <link rel="shortcut icon" href="#" />
    <title>::. Th&#244;ng b&#225;o .::</title>
    <link rel="stylesheet" media="all" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" media="all" type="text/css" href="css/update4.css" />

    <link rel="stylesheet" media="all" type="text/css" href="css/footable.core.css" />
    <link rel="stylesheet" media="all" type="text/css" href="css/footable.standalone.css" />
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
            style="text-align:center;font-weight:bold;font-family:verdana;background-color:#efefef;color: cadetblue;">
            DANH MỤC</li>
        <a href="CNPM.html" class="list-group-item">Trang Chủ</a>
        <a href="quantritaikhoan.html" class="list-group-item ">Quản trị tài khoản</a>
        <a href="list_de_tai.html" class="list-group-item ">Danh sách đề tài</a>
        <a href="list_giang_vien.html" class="list-group-item ">Thông tin
            giảng viên</a>
        <a href="list_sinh_vien.html" class="list-group-item ">Thông tin
            sinh viên</a>
        <a href="phanbien.html" class="list-group-item ">Phân giáo viên phản biện</a>
        <a href="phanbien.html" class="list-group-item ">Danh sách đề tài đang chờ phê duyệt</a>

        <a data-toggle="modal" href="#seach_box" class="list-group-item">
            Tìm kiếm</a>
        <hr />
    </div>

    <div id="container">

        <div id="mobile-bar">
            <span style="cursor: pointer;" class="pull-left" href="javascript:;" onclick="slideMenu(); return false;"
                id="slideicon"><i class="icon-reorder"></i></span>
            <span data-toggle="modal" href="#dang_nhap" class="pull-right btn btn-default btn-sm" id="#">Đăng
                nhập</span>
            <p style="text-align: center;font-weight:bold;">Đăng ký đề tài</p>
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


                                    <a href="homeGV" class="list-group-item ">Trang Chủ</a> <a
										href="infoGV" class="list-group-item ">Quản trị tài khoản</a>
									<a href="dkdt" class="list-group-item ">Đăng kí đề tài</a><a
										href="listDTHD" class="list-group-item ">Quản lý nhóm</a>
									<c:if test="${sessionScope.acc.role == 4}">
										<a href="listduyetDT" class="list-group-item active">Duyệt đề tài</a>
										<a href="listPB" class="list-group-item ">Phân giáo viên phản biện</a>
									</c:if>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-9">
                        <ol class="breadcrumb">
                            <li><a href="#">
                                    <marquee width="100%" behavior="scroll" direction="left"><img height="15px"
                                            width="15px" src="img/thongbao.png" alt="thong bao"> Thông báo khóa
                                        k2020 nộp bằng tốt nghiệp trước
                                        ngày 21-12-2022 | Sinh viên nghỉ tết dương lịch 2023 2 ngày 01-01-2022 và
                                        02-01-2022 | Sinh viên sẽ
                                        kết thúc học kì 1 năm học 2022 trước ngày 09-01-2022
                                    </marquee>
                                </a></li>

                        </ol>
						<c:if test="${not empty message}">
							<!-- Hiển thị thông báo -->
							<div class="panel-heading"
								style="background-color: #25d78a !important; border-radius: 12px !important;">
								<h3 style="margin: 0 !important; font-size: 20px;">${message}</h3>
							</div>
						</c:if>
                        <!-- Thông báo -->
                        <div class="panel panel-default">
                            <div style="color: rgb(39, 86, 156);" class="panel-heading">
                                <h4 style="text-align:center;font-family: verdana;color:rgb(87,87,87);"> Đề tài : 
                                </h4>
                            </div>
                        </div>
                        <div class="recent-grid">
                            <div class="projects">
                                <div class="card">
                                    <div class="container">
                                        
                                        <div class="content">
                                            <form action="#">
                                                <div class="user-details">

                                                    <div class="input-box">
                                                        <span class="details">Mã số đề tài</span>
                                                        <input type="text" value="${dt.id}" placeholder="" required>
                                                    </div>
                                                    <div class="input-box">
                                                        <span class="details">Giáo viên hướng dẫn</span>
                                                        <input type="text" value="${dt.GVHD}" placeholder="" required>
                                                    </div>
                                                    <div class="input-box">
                                                        <span class="details">Niên khóa</span>
                                                        <input type="text" value="${dt.nienKhoa}" placeholder="" required>
                                                    </div>
                                                    <div class="input-box">
                                                        <span class="details">Sản phẩm</span>
                                                        <input type="text" value="${dt.sanPham}" placeholder="" required>
                                                    </div>
                                                    <div class="input-box">
                                                        <span class="details">Số lượng SV</span>                
                                                        	<input type="text" value="${dt.soLuong}" placeholder="" required>
                                                    </div>
                                                    <div class="input-box">
                                                        <span class="details">Được phép đăng kí khác chuyên ngành</span>
                                                        <c:if test="${dt.isKhacCN == 1}">
                                                        	<input type="text" value="Có" placeholder="" required>
                                                        </c:if>
                                                        <c:if test="${dt.isKhacCN == 0}">
                                                        	<input type="text" value="Không" placeholder="" required>
                                                        </c:if>
                                                    </div>
                                                    <div class="input-box">
                                                        <span class="details">Chuyên ngành</span>
                                                        <c:if test="${dt.chuyenNganh == 1}">
                                                        	<input type="text" value="Công nghệ phần mềm" placeholder="" required>
                                                        </c:if>
                                                        <c:if test="${dt.chuyenNganh == 2}">
                                                        	<input type="text" value="Mạng máy tính" placeholder="" required>
                                                        </c:if>
                                                        <c:if test="${dt.chuyenNganh == 3}">
                                                        	<input type="text" value="Hệ thống thông tin" placeholder="" required>
                                                        </c:if>
                                                        <c:if test="${dt.chuyenNganh == 4}">
                                                        	<input type="text" value="Kĩ thuật dữ liệu" placeholder="" required>
                                                        </c:if>
                                                    </div>
                                                    <div class="input-box">
                                                        <span class="details">Loại đề tài</span>
                                                        <c:if test="${dt.loaiDT == 1}">
                                                        	<input type="text" value="Tiểu luận chuyên ngành" placeholder="" required>
                                                        </c:if>
                                                        <c:if test="${dt.loaiDT == 2}">
                                                        	<input type="text" value="Đề tài tốt nghiệp" placeholder="" required>
                                                        </c:if>
                                                    </div>
                                                    
                                                </div>

                                                <div class="name-project">
                                                    <div class="input-box">
                                                        <span class="details">Mục tiêu đề tài</span>
                                                        <input type="text" value="${dt.mucTieu}" placeholder="" required>
                                                    </div>
                                                </div>
                                                <div class="name-project">
                                                    <div class="input-box">
                                                        <span class="details">Yêu cầu</span>
                                                        <input type="text" value="${dt.yeuCau}" placeholder="" required>
                                                    </div>
                                                </div>
                                                <div class="name-project">
                                                    <div class="input-box">
                                                        <span class="details">Chú thích</span>
                                                        <input type="text" value="${dt.chuThich}" placeholder="" required>
                                                    </div>
                                                </div>
                                               

                                                <div class="button">
                                                    <input onclick="location.href='duyetDT?id=${dt.id}';" style="text-align:center" value="Xác nhận phê duyệt">
                                                </div>
                                                <div class="button">
                                                    <input onclick="location.href='https://google.com';" style="text-align:center" value="Từ chối phê duyệt">
                                                </div>
                                            </form>
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
            <div class="container-fluid">
                © Copyright 2022 | UTE University
            </div>

            <a href="#" class="back-to-top">
                <i class="fa-solid fa-chevron-up"></i>
            </a>
        </footer>
    </div>
    </div>
    </div>


    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>

</html>