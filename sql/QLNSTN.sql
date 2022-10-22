create database test1010
go

use test1010
go

--YYMMDDxxxx
create function auto_HoaDonID(@date as datetime)
returns varchar(15)
as
begin
	declare @id varchar(15)
	set @id = CONVERT(varchar,@date ,12)

	declare @count int
	select @count = count(maHD) from HoaDon where convert(varchar, thoiGianLap, 23) = convert(varchar, @date, 23)
	set @count += 1
	while len(@id) < (10 - len(CONVERT(varchar, @count)))
	begin
		set @id += '0'
	end
	set @id += CONVERT(varchar, @count)
	return @id
end
go

--YYMMxxxx
create function auto_NhanVienID(@date as date)
returns varchar(15)
as
begin
	declare @month varchar(15)
	set @month = month(@date)
	if len(@month) = 1
	set @month = '0' + @month

	declare @id varchar(15)
	set @id = convert(varchar, right(year(@date), 2))
	set @id += @month
	declare @count int
	declare @lastID varchar(15)
	select @count = count(maNV) from NhanVien where left(maNV, 4) = @id
	if @count = 0
		set @count += 1
	else 
		begin
			select @lastID = max(maNV) from NhanVien where left(maNV, 4) = @id
			set @count = CONVERT(int, right(@lastID, 4)) + 1
		end
	while len(@id) < (8 - len(CONVERT(varchar, @count)))
	begin
		set @id += '0'
	end
	set @id += CONVERT(varchar, @count)
	return @id
end
go

--YYxxxxxx
create function auto_KhachHangID() 
returns varchar(15)
as
begin
	declare @id varchar(15)
	set @id = right(convert(varchar, year(getdate())), 2)
	declare @count int
	declare @lastID varchar(15)
	select @count = count(maKH) from KhachHang where left(maKH, 2) = right(convert(varchar, year(getdate())), 2)
	if @count = 0
		set @count += 1
	else 
		begin
			select @lastID = max(maKH) from KhachHang where left(maKH, 2) = right(convert(varchar, year(getdate())), 2)
			set @count = CONVERT(int, right(@lastID, 6)) + 1
		end
	while len(@id) < (8 - len(CONVERT(varchar, @count)))
	begin
		set @id += '0'
	end
	set @id += CONVERT(varchar, @count)
	return @id
end
go

--maLoai : 1 sach 2 vpp
--maLoaixxx
--1001
create function auto_LoaiSanPhamID(@loai as int) 
returns varchar(15)
as
begin
	set @loai = left(convert(varchar, @loai), 1)
	declare @id varchar(15)
	set @id = convert(varchar, @loai)
	declare @count int
	declare @lastID varchar(15)
	select @count = count(maLoai) from LoaiSanPham where CONVERT(int,left(maLoai, 1)) = @loai
	if @count = 0
		set @count += 1
	else 
		begin
			select @lastID = max(maLoai) from LoaiSanPham where left(maLoai, 1) = @loai
			set @count = CONVERT(int, right(@lastID, 3)) + 1
		end
	while len(@id) < (4 - len(CONVERT(varchar, @count)))
	begin
		set @id += '0'
	end
	set @id += CONVERT(varchar, @count)
	return @id
end
go

--maLoai : 1 sach 2 vpp
--maLoaixxxxx
--100001
create function auto_SanPhamID(@loai as int)
returns varchar(15)
as
begin
	declare @id varchar(15)
	set @id = left(convert(varchar, @loai), 1)
	declare @count int
	declare @lastID varchar(15)
	select @count = count(maSP) from SanPham where left(maLoai,1) = @id
	if @count = 0
		set @count += 1
	else 
		begin
			select @lastID = max(maSP) from SanPham where left(maLoai,1) = @id
			set @count = CONVERT(int, right(@lastID, 5)) + 1
		end
	while len(@id) < (6 - len(CONVERT(varchar, @count)))
	begin
		set @id += '0'
	end
	set @id += CONVERT(varchar, @count)
	return @id
end
go


--99xxxxxx
--99000001
create function auto_NhaCungCapID()
returns varchar(15)
as
begin
	declare @id varchar(15)
	set @id = '99'
	declare @count int
	declare @lastID varchar(15)
	select @count = count(maNCC) from NhaCungCap
	if @count = 0
		set @count += 1
	else 
		begin
			select @lastID = max(maNCC) from NhaCungCap
			set @count = CONVERT(int, right(@lastID, 6)) + 1
		end
	while len(@id) < (8 - len(CONVERT(varchar, @count)))
	begin
		set @id += '0'
	end
	set @id += CONVERT(varchar, @count)
	return @id
end
go

--4ddtxxxx
--67670001
create function auto_DonDatHangID(@sdt as varchar(15))
returns varchar(15)
as
begin
	declare @id varchar(15)
	set @id = right(@sdt, 4)
	declare @count int
	declare @lastID varchar(15)
	select @count = count(maDDH) from DonDatHang where left(maDDH, 4) like @id
	if @count = 0
		set @count += 1
	else 
		begin
			select @lastID = max(maDDH) from DonDatHang where left(maDDH, 4) like @id
			set @count = CONVERT(int, right(@lastID, 4)) + 1
		end
	while len(@id) < (8 - len(CONVERT(varchar, @count)))
	begin
		set @id += '0'
	end
	set @id += CONVERT(varchar, @count)
	return @id
end
go

go
create table DonViTinh(
	maDVT int primary key identity(1, 1),
	tenDVT nvarchar(50) not null
)
go


create table LoaiSanPham(
	maLoai varchar(15) primary key,
	tenLoai nvarchar(50) not null
)
go

create table NhaCungCap(
	maNCC varchar(15) primary key,
	tenNCC nvarchar(100),
	diaChi nvarchar(200),
	sDT varchar(15),
	email varchar(50)
)
go

create table NhaSanXuat(
	maNSX int primary key identity(1, 1),
	tenNSX nvarchar(100) not null,
)
go

create table NhaXuatBan(
	maNXB int identity(1,1) primary key,
	tenNXB nvarchar(100) not null
)
go


create table TacGia(
	maTG int identity(1,1) primary key,
	tenTG nvarchar(100) not null,
	ngaySinh date
)
go

create table SanPham(
	maSP varchar(15) primary key,
	tenSP nvarchar(100),
	maLoai varchar(15) foreign key references LoaiSanPham(maLoai) on delete cascade,
	maDVT int foreign key references DonViTinh(maDVT) on delete cascade,
	giaNhap float(1),
	giaBan float(1),
	soLuongCon int,
	maNCC varchar(15) foreign key references NhaCungCap(maNCC) on delete cascade,
	maNSX int foreign key references NhaSanXuat(maNSX) on delete cascade,
	maTG int foreign key references TacGia(maTG) on delete cascade,
	soTrang int,
	namXuatBan int,
	maNXB int foreign key references NhaXuatBan(maNXB) on delete cascade
)
go

create table ChucVu(
	maChucVu int primary key,
	tenChucVu nvarchar(50)
)
go

create table KhachHang (
	maKH varchar(15) primary key,
	hoTen nvarchar(100),
	sDT nvarchar(15),
	ngaySinh date,
	gioiTinh bit,-- nam:1, nu:0
	diaChi nvarchar(100)
)
go

create table NhanVien (
	maNV varchar(15) primary key,
	hoTen nvarchar(100),
	cMND nvarchar(15),
	sDT nvarchar(15),
	ngaySinh date,
	gioiTinh bit,-- nam:1, nu:0
	diaChi nvarchar(100),
	ngayVaoLam date,
	maChucVu int foreign key references ChucVu(maChucVu) on delete cascade
)
go

create table TaiKhoan(
	taiKhoan varchar(15) primary key foreign key references NhanVien(maNV),
	matKhau varchar(100) not null,
	quyen int default 1
)
go

create table HoaDon(
	maHD varchar(15) primary key default dbo.auto_HoaDonID(getdate()),
	maNV varchar(15) foreign key references NhanVien(maNV) on delete cascade,
	maKH varchar(15) foreign key references KhachHang(maKH) on delete cascade,
	thoiGianLap datetime not null
)
go

create table ChiTietHoaDon(
	maHD varchar(15) foreign key references HoaDon(maHD) on delete cascade,
	maSP varchar(15) foreign key references SanPham(maSP) on delete cascade,
	donGia float(1) not null,
	soLuong int not null
)
go

create table DonDatHang (
	maDDH varchar(15) primary key,
	maKH varchar(15) foreign key references KhachHang(maKH) on delete cascade,
	ngayDat datetime not null,
	trangThai int -- 0: chưa thanh toán; 1: đã thanh toán; -1: bị hủy
)
go

create table ChiTietDonDatHang(
	maDDH varchar(15) foreign key references DonDatHang(maDDH) on delete cascade,
	maSP varchar(15) foreign key references SanPham(maSP) on delete cascade,
	donGia float(1) not null,
	soLuong int not null
)
go

-- chức vụ
insert into ChucVu values (1, N'Nhân viên bán hàng')
insert into ChucVu values (2, N'Nhân viên quản lý')

--quyển, hộp, cây, cái, tờ, cuộn, xấp, thùng
insert into DonViTinh values (N'Quyển'), (N'Hộp'), (N'Cái'), (N'Cây'), (N'Tờ'), (N'Cuộn'), (N'Xấp'), (N'Thùng')

-- tiểu thuyết, tạp chí, truyện tranh, sách giáo khoa, sách tham khảo, sách nước ngoài, sách văn học, sách khác
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(1), N'Tiểu thuyết')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(1), N'Tạp chí')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(1), N'Truyện tranh')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(1), N'Sách giáo khoa')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(1), N'Sách tham khảo')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(1), N'Sách văn học')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(1), N'Sách nước ngoài')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(1), N'Sách khác')

-- viết, vở, thước, tẩy, quà lưu niệm, giấy, bao bì, túi đựng, mực
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Viết')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Vở')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Thước kẻ')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Tẩy')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Quà lưu niệm')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Giấy')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Bao bì')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Túi đựng')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Mực')
insert into LoaiSanPham values (dbo.auto_LoaiSanPhamID(2), N'Khác')

-- Nha xuat ban
insert into NhaXuatBan values
(N'NXB Trẻ'), 
(N'NXB Kim Đồng'),
(N'NXB Tổng hợp TP.HCM'),
(N'NXB Hội Nhà văn'),
(N'NXB Chính trị quốc gia Sự thật'),
(N'NXB Phụ nữ Việt Nam'),
(N'NXB Lao Động'),
(N'NXB Nhã Nam'),
(N'NXB Đinh Tỵ Book'),
(N'NXB Đông A')


--tac gia
insert into TacGia values
(N'Kim Lân', '1920-8-1'),
(N'Vũ Trọng Phụng', '1912'),
(N'Thạch Lam', '1910'),
(N'Nam Cao', '1915'),
(N'Xuân Diệu', '1916'),
(N'Tố Hữu', '1920-10-4'),
(N'Nguyễn Minh Châu', '1930-10-20'),
(N'Nguyễn Tuân', '1910-07-10'),
(N'Tô Hoài', '1920-09-27'),
(N'Nguyên Hồng','1918-11-05')

--Nhân viên
insert into NhanVien values
(dbo.auto_NhanVienID('2020-02-04'), N'Bùi Nhựt Duy', N'083675311654', '0909765419', '2002-01-01', 1, N'Quang Trung, Gò Vấp, Hồ Chí Minh', '2020-02-04', 2),
(dbo.auto_NhanVienID('2021-02-04'), N'Võ Minh Chiến', N'095728281654', '0876876545', '2002-08-15', 1, N'Quang Trung, Gò Vấp, Hồ Chí Minh', '2021-02-04', 1),
(dbo.auto_NhanVienID('2022-02-04'), N'Lê Quốc Thịnh', N'083622997755', '0956435417', '2002-10-01', 1, N'Bình Chánh, Hồ Chí Minh', '2022-02-04', 1)

-- Tài khoản
insert into TaiKhoan values 
('20020001', 'MTExMQ==', 2),
('21020001', 'MTExMQ==', 1),
('22020001', 'MTExMQ==', 1)

--Khách hàng
insert into KhachHang values
(dbo.auto_KhachHangID(), N'Phạm Đình Nam', N'0965377639', '1990-1-7', 1, N'724 Đường Bác Ái, Phường Bến Thành, Quận Bình Tân, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Lê Khánh Vân', N'0123142249', '2001-6-9', 0, N'135 Đường Nguyễn Tuân, Phường Cát Lái, Quận 10, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Huỳnh Gia Trung', N'0122787266', '1997-5-15', 1, N'217 Đường Huỳnh Khương An, Phường Bình Khánh, Quận Tân Bình, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Bùi Thiên Duy', N'0125825245', '2005-7-26', 1, N'252 Đường Đoàn Kết, Phường An Phú Đông, Quận Phú Nhuận, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Đinh Văn Việt', N'0126494646', '1992-3-4', 1, N'528 Đường Thống Nhất, Phường Nguyễn Cư Trinh, Quận 12, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Ngô Đình Nguyên', N'0938595684', '1990-1-27', 0, N'743 Đường Trần Thị Nghỉ, Phường Long Bình, Quận 6, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Phan Mộng Nguyên', N'0126083670', '1998-12-18', 0, N'627 Đường Bác Ái, Phường Bình Trưng Tây, Quận Tân Bình, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Trần Thị Huy', N'0122699175', '1999-7-20', 0, N'873 Đường Đoàn Kết, Phường Sơn Kỳ, Quận 8, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Nguyễn Thị Duy', N'0165834894', '2003-10-17', 1, N'661 Đường Cầu Bình Đức, Phường Linh Trung, Quận Thủ Đức, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Nguyên Thiên Bé', N'0165709877', '1996-5-24', 1, N'604 Đường Xa Lộ Hà Nội, Phường Phú Hữu, Quận 2, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Huỳnh Kim Huy', N'0128937242', '1990-7-11', 0, N'696 Đường Einstein, Phường Phước Long A, Quận Tân Phú, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Võ Tuấn Việt', N'0162933534', '1999-6-12', 0, N'294 Đường Bùi Văn Thêm, Phường Tam Phú, Quận 10, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Bùi Thành Xinh', N'0121316844', '1996-6-16', 1, N'824 Đường Tam Hà, Phường Tân Định, Quận 8, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Đỗ Thu Nam', N'0124012038', '2001-2-28', 0, N'565 Đường Nguyễn Bỉnh Khiêm, Phường Trường Thạnh, Quận 1, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Ngô Gia Nguyên', N'0165186873', '1996-5-22', 1, N'373 Đường Phạm Văn Đồng, Phường An Khánh, Quận Thủ Đức, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Đặng Thị Sơn', N'0125709373', '1992-9-15', 1, N'818 Đường Nguyên Hồng, Phường Tây Thạnh, Quận 1, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Bùi Hoàng Sơn', N'0894906610', '1993-6-28', 1, N'528 Đường Bùi Quang Là, Phường Phú Trung, Quận 8, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Phan Thị Hiếu', N'0128622538', '1991-8-14', 1, N'39 Đường Nguyễn Thái Sơn, Phường Cô Giang, Quận 3, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Hồ Như Huy', N'0967894509', '2003-7-27', 1, N'662 Đường Phổ Quang, Phường Cầu Ông Lãnh, Quận 7, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Huỳnh Thu Nam', N'0936848644', '1998-10-1', 1, N'48 Đường Độc Lập, Phường Tân Hưng Thuận, Quận 8, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Bùi Như Xinh', N'0166726828', '2001-3-22', 1, N'612 Đường Thiên Hộ Dương, Phường An Phú Đông, Quận 2, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Võ Đức Sơn', N'0122626391', '1998-8-1', 0, N'171 Đường Lê Thị Hoa, Phường Hiệp Phú, Quận 9, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Phan Mộng Đạt', N'0894428766', '1993-1-1', 1, N'558 Đường Trương Đăng Quế, Phường An Khánh, Quận Phú Nhuận, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Trần Đức Xinh', N'0164651102', '1994-4-1', 0, N'288 Đường Hồng Đức, Phường Bình Khánh, Quận Tân Phú, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Trần Gia Huy', N'0122763434', '2005-2-9', 0, N'532 Đường Lê Lợi, Phường Thủ Thiêm, Quận 7, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Nguyễn Mộng Trang', N'0167180996', '1990-2-20', 1, N'671 Đường Phạm Ngũ Lão, Phường Hiệp Bình Chánh, Quận 10, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Hồ Quang Hoàng', N'0123296651', '2003-8-5', 1, N'169 Đường Lê Quang Định, Phường Tân Sơn Nhì, Quận Gò Vấp, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Hồ Kim Đạt', N'0120996077', '1991-2-6', 1, N'516 Đường Gò Dưa, Phường Tân Hưng Thuận, Quận 11, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Võ Quang Duy', N'0907324478', '2001-10-16', 1, N'848 Đường Nguyễn Thái Sơn, Phường Tăng Nhơn Phú B, Quận 1, TP.Hồ Chí Minh'),
(dbo.auto_KhachHangID(), N'Trần Thu Hiệp', N'0934688582', '1993-6-3', 1, N'457 Đường Lê Đức Thọ, Phường Tân Thới Nhất, Quận 3, TP.Hồ Chí Minh')

--NCC
insert into NhaCungCap values 
(dbo.auto_NhaCungCapID(), N'Văn phòng phẩm Sang Hà', N'Số 7, Đường T4B, P.Tây Thạnh, Q.Tân Phú,TP.HCM', '0309345786', 'sangha@sangha.vn'),
(dbo.auto_NhaCungCapID(), N'Kim Biên Toàn Cầu', N'525/46 Tô Hiến Thành , P 14, Q 10, HCM.', '0906860038', ' infor@kimbientoancau.com'),
(dbo.auto_NhaCungCapID(), N'Văn phòng phẩm An Phát', N'525/46 Tô Hiến Thành , P 14, Q 10, HCM.', '0906860038', 'vanphongphamquan12@gmail.com'),
(dbo.auto_NhaCungCapID(), N'Văn phòng phẩm Hồng Hà', N'C12/1 Ấp 3, Xã Tân Kiên, Quận Bình Chánh', '0283756258', 'dvkh@vpphongha.com.vn'),
(dbo.auto_NhaCungCapID(), N'Vinacom', N'275 Bạch Đằng, Quận Bình Thạnh, TPHCM', '0935368668', 'vinacom@gmail.com'),
(dbo.auto_NhaCungCapID(), N'Nhà sách Ánh Sáng', N'96 Đông Hồ, Phường 8, Quận Tân Bình, TPHCM', '0914513068', 'anhsangvn@gmail.com'),
(dbo.auto_NhaCungCapID(), N'An Thiên Phước', N'33 đường số 17, Quận Thủ Đức, TPHCM', '0916649029', 'vanphongphamanphuoc@gmail.com'),
(dbo.auto_NhaCungCapID(), N'An Lộc Việt', N'479/37 Phan Văn Trị, Phường 5, Quận Gò Vấp, TPHCM', '0962896219', 'vppanlocviet@gmail.com'),
(dbo.auto_NhaCungCapID(), N'Văn phòng phẩm Tân Tiến', N'15E Nguyễn Thị Minh Khai, Phường Bến Nghé, Quận 1', '0973025310', 'vanphongphamtantien@gmail.com'),
(dbo.auto_NhaCungCapID(), N'Văn phòng phẩm Hoàng Hà', N'247/13 Độc Lập, Quận Tân Phú, TPHCM', '0919542541', 'vpphoangha48@gmail.com')


--NSX
insert into NhaSanXuat values 
(N' Công Ty TNHH Thương Mại Dịch Vụ Anh Phước'),
(N'Công Ty TNHH MTV Giấy Nhám Cường Thịnh Phát'),
(N'Công Ty TNHH MTV Thương Mại Dịch Vụ Thế Gia'),
(N'Công Ty TNHH Thương Mại Thịnh Đại Phát'),
(N'Công Ty TNHH Thương Mại Văn Phòng Phẩm Phú Thịnh'),
(N'Công Ty TNHH Toàn Trẻ'),
(N'Công Ty TNHH MTV Văn Phòng Phẩm Nam Tân Uyên'),
(N'Công Ty TNHH SX TM DV Phương Văn'),
(N'Công Ty TNHH Công Nghệ Và Dịch Vụ Minh Phong'),
(N'Công Ty TNHH Thiết Bị Văn Phòng Khang Minh')


--VPP
insert into SanPham (maSP, tenSP, maLoai, maDVT, giaNhap, giaBan, soLuongCon, maNCC, maNSX) values 
(dbo.auto_SanPhamID(2), N'Bút Bi 0.5 mm Thiên Long TL-027 - Mực Xanh', '2001', 4, 3000, 5000, 800, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Bút Bi 0.5 mm Treeden - Thiên Long TL-079 - Mực Xanh', '2001', 4, 4000, 5000, 999, '99000003', 2),
(dbo.auto_SanPhamID(2), N'Bút Xóa 12 ml - Thiên Long CP-02 - Xanh Mint', '2001', 4, 25000, 30000, 700, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Bút Lông Dầu Thiên Long PM-09 - Mực Xanh', '2001', 4, 10000, 12000, 550, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Bút Chì Gỗ 2B Neon Pencil - Colokit GP-C01', '2001', 4, 8000, 10000, 800, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Hộp 20 Bút Bi 0.5 mm Thiên Long TL-089 - Mực Xanh', '2001', 2, 85000, 90000, 800, '99000001', 4),
(dbo.auto_SanPhamID(2), N'Vở Freely Life - B5 Kẻ Ngang 120 Trang', '2002', 1, 18000, 20000, 3000, '99000004', 3),
(dbo.auto_SanPhamID(2), N'Vở Dancing Letters - B5 Kẻ Ngang Có Chấm 200 Trang', '2002', 1, 33000, 37000, 800, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Vở Souvenir Kẻ Ngang 80 Trang ', '2002', 1, 8000, 10000, 800, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Vở 4 Ly Ngang 96 Trang 80gsm Class Heoboo ', '2002', 1, 10000, 12000, 800, '99000001', 4),
(dbo.auto_SanPhamID(2), N'Vở Lò Xo Eco 200 Trang ', '2002', 1, 28000, 30000, 800, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Thước M-Tech Slim 30 cm', '2003', 3, 8000, 10000, 800, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Thước Nhôm 30 cm', '2003', 3, 8000, 10000, 800, '99000001', 2),
(dbo.auto_SanPhamID(2), N'Thước Đo Độ Tam Giác ', '2003', 3, 24000, 30000, 800, '99000004', 2),
(dbo.auto_SanPhamID(2), N'Thước Parabol 12 x 7 cm', '2003', 3, 23500, 25000, 800, '99000005', 2),
(dbo.auto_SanPhamID(2), N'Thước Đo Góc 360 độ 12 cm', '2003', 3, 30000, 35000, 800, '99000007', 4),
(dbo.auto_SanPhamId(2), N'Túi đeo chéo đứng T-23', '2005', 3, 37000, 50000, 30, '99000008', 3),
(dbo.auto_SanPhamId(2), N'Ly Nước Hai Lớp Mihi', '2005', 3, 165000, 180000, 55, '99000010', 2),
(dbo.auto_SanPhamId(2), N'Móc Khoá Gấu Aka Hoodie Party Thỏ Bảy Màu', '2005', 3, 75000, 80000, 132, '99000003', 4),
(dbo.auto_SanPhamId(2), N'Cờ Việt Nam Cầm Tay', '2005', 3, 8000, 10000, 999, '99000001', 1),
(dbo.auto_SanPhamId(2), N'Giấy Paper one A4/70', '2006', 2, 80000, 87000, 3987, '99000003', 2),
(dbo.auto_SanPhamId(2), N'Giấy Photo Paper One A3 70', '2006', 2, 155000, 170000, 234, '99000003', 2),
(dbo.auto_SanPhamId(2), N'Giấy Note 5 Màu', '2006', 7, 20000, 22000, 657, '99000003', 2),
(dbo.auto_SanPhamId(2), N'Giấy Kiểm Tra 4 Ly Ngang', '2006', 5, 900, 1200, 555, '99000003', 2)

--Sach
insert into SanPham (maSP, tenSP, maLoai, maDVT, giaNhap, giaBan, soLuongCon, maNCC, maTG, soTrang, namXuatBan, maNXB) values
(dbo.auto_SanPhamID(1), N'Toán lớp 5', '1004', 1, 10000, 15000, 145, '99000001', 3, 142, 2009, 5),
(dbo.auto_SanPhamID(1), N'Tiếng Việt lớp 5', '1004', 1, 12000, 18000, 123, '99000002', 3, 153, 2011, 5),
(dbo.auto_SanPhamID(1), N'Sách giải Toán lớp 5', '1005', 1, 16000, 23000, 156, '99000003', 7, 142, 2013, 9),
(dbo.auto_SanPhamID(1), N'Sách giải Ngữ Văn 9', '1005', 1, 25000, 28000, 165, '99000004', 4, 123, 2018, 2),
(dbo.auto_SanPhamID(1), N'Số đỏ', '1006', 1, 145000, 150000, 156, '99000005', 6, 124, 2002, 10),
(dbo.auto_SanPhamID(1), N'Tôi thấy hoa vàng trên cỏ xanh', '1006', 1, 140000, 170000, 164, '99000006', 7, 164, 2009, 2),
(dbo.auto_SanPhamID(1), N'English and things', '1007', 1, 180000, 200000, 54, '99000007', 4, 176, 2020, 8),
(dbo.auto_SanPhamID(1), N'Love and orther drugs', '1007', 1, 200000, 230000, 213, '99000008', 3, 147, 2021, 2),
(dbo.auto_SanPhamID(1), N'1000 câu hỏi vì sao', '1008', 1, 180000, 200000, 198, '99000009', 4, 173, 2002, 10),
(dbo.auto_SanPhamID(1), N'Top những câu hỏi hack não', '1008', 1, 234000, 250000, 164, '99000010', 1, 235, 2002, 1)

insert into HoaDon values
(dbo.auto_HoaDonID('2022-10-14'), '20020001', '22000006' , '2022-10-14'),
(dbo.auto_HoaDonID('2022-10-14'), '21020001', '22000009' , '2022-10-14')

insert into ChiTietHoaDon values
('2210140001', '100007', 20000, 5),
('2210140001', '200003', 30000, 3),
('2210140001', '200005', 10000, 2),
('2210140001', '100001', 15000, 1)

insert into ChiTietHoaDon values
('2210140002', '100009', 20000, 4),
('2210140002', '200001', 5000, 10),
('2210140002', '200007', 20000, 5),
('2210140002', '100001', 15000, 1)

insert into DonDatHang values
(dbo.auto_DonDatHangID('0165834894'), '22000009', getdate(), 0),
(dbo.auto_DonDatHangID('0124012038'), '22000014', getdate(), 0)

insert into ChiTietDonDatHang values
('20380001', '100009', 20000, 4),
('20380001', '200001', 5000, 10),
('20380001', '200007', 20000, 5),
('20380001', '100001', 15000, 1),
('48940001', '200003', 30000, 3),
('48940001', '200005', 10000, 2),
('48940001', '100001', 15000, 1)

use QuanLyNhaSach
select * from DonViTinh
select * from LoaiSanPham
select * from NhaCungCap
select * from NhaSanXuat
select * from NhaXuatBan
select * from TacGia
select * from SanPham
select * from NhanVien
select * from KhachHang
select * from TaiKhoan
select * from HoaDon
select * from ChiTietHoaDon
select * from DonDatHang
select * from ChiTietDonDatHang