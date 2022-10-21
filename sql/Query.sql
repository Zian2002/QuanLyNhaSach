-- Danh sách sáchư

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

--HoaDon
select hd.maHD, nv.maNV, nv.hoTen,
		kh.maKH, kh.hoTen, format(hd.thoiGianLap, 'yyyy-MM-dd HH:mm:ss')
from HoaDon hd
	inner join NhanVien nv on hd.maNV = nv.maNV
	inner join KhachHang kh on hd.maKH = kh.maKH



--CTHD
select cthd.maHD, sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, 
		dvt.maDVT, dvt.tenDVT, cthd.donGia, cthd.soLuong
from ChiTietHoaDon cthd
inner join SanPham sp on cthd.maSP = sp.maSP
inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai
inner join DonViTinh dvt on sp.maDVT = dvt.maDVT
where maHD = '2210140001'

--CTDDH
select cthd.maDDH, sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, 
		dvt.maDVT, dvt.tenDVT, cthd.donGia, cthd.soLuong
from ChiTietDonDatHang cthd
inner join SanPham sp on cthd.maSP = sp.maSP
inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai
inner join DonViTinh dvt on sp.maDVT = dvt.maDVT
where maDDH = '2210140001'


--maHD
select dbo.auto_HoaDonID(getdate())

select * from SanPham

update SanPham set soLuongCon = soLuongCon + 1
where maSP = '100001'


use QuanLyNhaSach
select ddh.maDDH, kh.*, format(ddh.ngayDat, 'yyyy-MM-dd HH:mm:ss'), ddh.trangThai from DonDatHang ddh
inner join KhachHang kh on ddh.maKH = kh.maKH