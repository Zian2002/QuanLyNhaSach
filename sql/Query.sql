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











