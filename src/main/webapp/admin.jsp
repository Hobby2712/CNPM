<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <title>Document</title>
</head>
<body>

    <input type="checkbox" id="nav-toggle">
    <div class="sidebar">
        <div href="admin.html" class="sidebar-brand"><h2><span class="lab la-accusoft"></span><span>Admin</span></h2></div>
        <div class="sidebar-menu">
            <ul>
                <li><a href="admin.jsp" class="active"><span class="las la-igloo"></span><span>Trang chủ</span></a></li>
                <li><a href="student.html"><span class="las la-users"></span><span>Sinh viên</span></a></li>
                <li><a href="teacher.html"><span class="las la-users"></span><span>Giảng viên</span></a></li>
                <li><a href="detai.jsp"><span class="las la-list"></span><span>Tạo đợt đăng ký đề tài</span></a></li>
                <li><a href="listTK"><span class="las la-user-circle"></span><span>Tài khoản</span></a></li>
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
            <div class="user-wrapper" >
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
                        <h1>54</h1>
                        <span>Sinh viên</span>
                    </div>
                    <div>
                        <span class="las la-users"></span>
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>60</h1>
                        <span>Giảng viên</span>
                    </div>
                    <div>
                        <span class="las la-users"></span>
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>79</h1>
                        <span>Đề tài</span>
                    </div>
                    <div>
                        <span class="las la-clipboard"></span>
                    </div>
                </div>

                <div class="card-single">
                    <div>
                        <h1>179</h1>
                        <span>Tài khoản</span>
                    </div>
                    <div>
                        <span class="las la-user-circle"></span>
                    </div>
                </div>

                    
            </div>

            <div class="recent-grid">
                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>Danh sách đề tài</h3>
                            <button>Xem tất cả <span class="las la-arrow-right"></span></button>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="table-responsive">
                            <table width="100%">
                                <thead>
                                    <tr>
                                        <td>Tên đề tài</td>
                                        <td>GVHD</td>
                                        <td>Trạng thái</td>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Name</td>
                                        <td>Name</td>
                                        <td>
                                            <span class = "status"></span>
                                            review
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Name</td>
                                        <td>Name</td>
                                        <td>
                                            <span class = "status"></span>
                                            review
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="sinhviens">
                    <div class="card">
                        <div class="card-header">
                            <h3>Sinh viên</h3>
                            <button>Xem tất cả <span class="las la-arrow-right"></span></button>
                        </div>

                        <div class="card-body">
                            <div class="sinhvien">
                                <div class="info">
                                    <img src="" alt="" width="40px" height="40px">
                                    <div>
                                        <h4>Name</h4>
                                        <small>Class</small>
                                    </div>
                                </div>
                                <div class="contact">
                                    <span class="las la-user-circle"></span>
                                    <span class="las la-comment"></span>
                                    <span class="las la-phone"></span>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    
</body>
</html>