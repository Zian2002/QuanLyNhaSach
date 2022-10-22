-- Danh sách sáchư
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


use QuanLyNhaSach
select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, 
		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, tg.maTG, tg.tenTG,
		sp.soTrang, sp.namXuatBan, nxb.maNXB, nxb.tenNXB
from SanPham sp 
	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai
	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT
	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC
	inner join TacGia tg on sp.maTG = tg.maTG
	inner join NhaXuatBan nxb on sp.maNXB = nxb.maNXB

-- Danh sách VPP
select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, 
		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, nsx.maNSX, nsx.tenNSX
from SanPham sp 
	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai
	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT
	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC
	inner join NhaSanXuat nsx on sp.maNSX = nsx.maNSX

-- danh sách nhân viên
select nv.*, cv.tenChucVu
from NhanVien nv inner join ChucVu cv on nv.maChucVu = cv.maChucVu

-- danh sách khách hàng
select * from KhachHang

update DonDatHang set trangThai = -1 
where trangThai = 0  and dateadd(day, 7, ngayDat) < getdate()

select ddh.maDDH, kh.*, format(ddh.ngayDat, 'yyyy-MM-dd HH:mm:ss'), ddh.trangThai from DonDatHang ddh
inner join KhachHang kh on ddh.maKH = kh.maKH order by ngayDat desc

select ctddh.maSP, ctddh.soLuong from DonDatHang ddh
inner join ChiTietDonDatHang ctddh on ddh.maDDH = ctddh.maDDH
where trangThai = 0  and dateadd(day, 7, ngayDat) < getdate()

update DonDatHang set trangThai = -1 
where trangThai = 0  and dateadd(day, 7, ngayDat) < getdate()


select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, 
		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, tg.maTG, tg.tenTG,
		sp.soTrang, sp.namXuatBan, nxb.maNXB, nxb.tenNXB
from SanPham sp 
	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai
	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT
	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC
	inner join TacGia tg on sp.maTG = tg.maTG
	inner join NhaXuatBan nxb on sp.maNXB = nxb.maNXB
where sp.tenSP like N'%l%' and tg.tenTG like N'%Lam%' and namXuatBan like '%9%'




