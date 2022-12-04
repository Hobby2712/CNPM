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
Insert into dbo.chuyenNganh values (N'Tiểu luậnn chuyên ngành 2020')
Insert into dbo.chuyenNganh values (N'Tiểu luận chuyên ngành 2019')
Insert into dbo.chuyenNganh values (N'Tiểu luận chuyên ngành 2018')
Insert into dbo.chuyenNganh values (N'Đề tài tốt nghiệp 2020')
Insert into dbo.chuyenNganh values (N'Đề tài tốt nghiệp 2019')
Insert into dbo.chuyenNganh values (N'Đề tài tốt nghiệp 2018')


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
Insert into [user] values ('gv01',N'Nguyễn Văn Tài','vtn@gmail.com',N'Hồ Chí Minh','0912817722','Nam',1,'/uploads/user/hinh1.jpg')
Insert into [user] values ('admin',null,null,null,null,null,null,null)
GO
create table taiKhoan(
	Id int IDENTITY PRIMARY KEY not null,
	userName char(16),
	uPass char(16),
	uid char(10) references [user](uId),
	idRole int references [role](idRole),
)

GO
create table deTai(
	id int IDENTITY PRIMARY KEY not null,
	tenDT nvarchar(100),
	mucTieu nvarchar(max),
	yeuCau nvarchar(max),
	sanPham nvarchar(max),
	soLuong int,
	isKhacCN int,
	trangthai int,
	nienKhoa int,
	GVHD char(10) references [user](uId),
	GVPB char(10) references [user](uId),
	Diem float
)
