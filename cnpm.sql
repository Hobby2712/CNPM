go
Create database CNPM
go
use CNPM 
go
create table dbo.[role](
	idRole int IDENTITY PRIMARY KEY not null,
	nameRole nvarchar(50)
)
go
Insert into dbo.[role] values ('admin')
Insert into dbo.[role] values ('giangVien')
Insert into dbo.[role] values ('sinhVien')
Insert into dbo.[role] values ('truongBoMon')

go
create table dbo.trangThai(
	id int IDENTITY PRIMARY KEY not null,
	tThai nvarchar(50)
)
go 
insert into trangThai values(N'Đang chờ duyệt');
insert into trangThai values(N'Đã được duyệt');
insert into trangThai values(N'Đã từ chối');

go
create table dbo.chuyenNganh(
	id int IDENTITY PRIMARY KEY not null,
	nameCN nvarchar(50)
)
go
Insert into dbo.chuyenNganh values (N'Công nghệ phần mềm')
Insert into dbo.chuyenNganh values (N'Mạng máy tính')
Insert into dbo.chuyenNganh values (N'Hệ thống thông tin')
Insert into dbo.chuyenNganh values (N'Kĩ thuật dữ liệu')

create table dbo.danhMuc(
	id int IDENTITY PRIMARY KEY not null,
	nameDM nvarchar(50)
)
go
Insert into dbo.danhMuc values (N'Tiểu luận chuyên ngành')
Insert into dbo.danhMuc values (N'Đề tài tốt nghiệp')


GO
create table [user](
	uId char(10) PRIMARY KEY not null,
	uFullName nvarchar(50),
	uEmail varchar(50),
	uAddress nvarchar(150),
	uPhone char(11),
	uGioiTinh char(4),
	uChuyenNganh int references chuyenNganh(id),
	uImage nvarchar(max),
)

go
Insert into [user] values ('20110627',N'Nguyễn Khắc Dương','ngkhacduong@gmail.com',N'Hồ Chí Minh','0982712772','Nam',1,'/uploads/user/hinh1.jpg')
Insert into [user] values ('20110628',N'Nguyễn Văn A','ngvana@gmail.com',N'Hồ Chí Minh','0918182222','Nam',1,null)
Insert into [user] values ('20110629',N'Nguyễn Văn B','ngvanb@gmail.com',N'Hồ Chí Minh','0918182223','Nam',1,null)
Insert into [user] values ('20110621',N'Nguyễn Văn C','ngvanc@gmail.com',N'Hồ Chí Minh','0918182224','Nam',1,null)
Insert into [user] values ('20110622',N'Nguyễn Văn D','ngvand@gmail.com',N'Hồ Chí Minh','0918182225','Nam',1,null)
Insert into [user] values ('gv01',N'Nguyễn Văn Tài','vtn@gmail.com',N'Hồ Chí Minh','0912817722','Nam',1,'/uploads/user/hinh1.jpg')
Insert into [user] values ('gv02',N'Nguyễn Văn Sáng','vsn@gmail.com',N'Hồ Chí Minh','0912817724','Nam',1,'/uploads/user/hinh1.jpg')
Insert into [user] values ('admin',null,null,null,null,null,null,null)
GO
create table taiKhoan(
	Id int IDENTITY PRIMARY KEY not null,
	userName char(16),
	uPass char(16),
	uid char(10) references [user](uId),
	idRole int references [role](idRole),
)
go
Insert into taiKhoan values ('sinhvien','12345','20110627',3)
Insert into taiKhoan values ('giangvien','12345','gv01',2)
Insert into taiKhoan values ('truongbomon','12345','gv02',4)
Insert into taiKhoan values ('admin','12345','admin',1)

GO
create table deTai(
	id int IDENTITY PRIMARY KEY not null,
	tenDT nvarchar(100),
	mucTieu nvarchar(max),
	yeuCau nvarchar(max),
	sanPham nvarchar(max),
	chuThich nvarchar(max),
	soLuong int,
	loaiDT int references danhmuc(id),
	isKhacCN int,
	chuyenNganh int references chuyenNganh(id),
	trangthai int references trangThai(id),
	nienKhoa int,
	GVHD char(10) references [user](uId),
	GVPB char(10) references [user](uId),
	Diem float
)
go
Insert into deTai values(N'Hệ thống nhúng IOT', N'Hoàn thành tốt', N'Hoàn thành tốt', N'Tài liệu', null, 2, 1, 1, 1, 1, 2022, 'gv01', null,null)
go
Insert into deTai values(N'Tìm hiểu bài toán khai phá luật kết hợp trên chuỗi thời gian', N'Tìm hiểu bài toán khai phá luật kết hợp trên chuỗi thời gian', N'Có kiến thức về data warehouse và DBMS', N'Báo cáo và demo', null, 2, 1, 1, 2, 1, 2022, 'gv01', null,null)
go
Insert into deTai values(N'Xây dựng ứng dụng quản lý nhân sự trực tuyến sử dụng PHP.',N'Hiểu được ứng dụng quản lý', N'Đọc hiểu tài liệu tiếng Anh', N'Báo cáo về phương pháp', null, 2, 1, 1, 3, 1, 2022, 'gv01', null,null)

Insert into deTai values(N'Tìm hiểu về phương pháp Group testing',N'Tìm hiểu về phương pháp Group testing', N'Hoàn thành tốt', N'Tài liệu', null, 2, 1, 1, 1, 1, 2022, 'gv01', null,null)

Insert into deTai values(N'Tìm hiểu SparkR', N'Tìm hiểu PySpark, viết chương trình minh họa', N'Đọc hiểu Tiếng Anh tốt, Lập trình tốt', N'Báo cáo tiểu luận', null, 2, 1, 1,4, 1, 2022, 'gv01', null,null)
go
Insert into deTai values(N'Tìm hiểu .NET MVC',N'Tìm hiểu công nghệ .NET MVC Phát triển website', N'Có khả năng lập trình tốt', N'Website, báo cáo khoa học', null, 2, 1, 1,3, 1, 2022, 'gv02', null,null)

go
create table dotDangKy(
	id int IDENTITY PRIMARY KEY not null,
	ngayBD datetime,
	ngayKT datetime,
	isSV int
)

go
create table nhom(
	id int IDENTITY PRIMARY KEY not null,
	detai int references deTai(id),
	uid char(10) references [user](uid),
	isTruongNhom int
)

go
create table dbo.duyetDeTai(
	id int IDENTITY PRIMARY KEY not null,
	idDT int references deTai(id),
	tThai int references trangThai(id)
)

go
create table dbo.svQuanTam(
	id int IDENTITY PRIMARY KEY not null,
	detai int references deTai(id),
	uid char(10) references [user](uid),
)
go 
Insert into svQuanTam values (1,'20110628');
Insert into svQuanTam values (1,'20110629');
Insert into svQuanTam values (1,'20110621');

go
create table dbo.hoidong(
	id int IDENTITY PRIMARY KEY not null,
	detai int references deTai(id),
	soLuong int,
	ngayPB date
)

create table dbo.hoidong_info(
	id int IDENTITY PRIMARY KEY not null,
	hd int references hoidong(id),
	gv char(10) references [user](uId)
)