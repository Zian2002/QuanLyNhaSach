package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import database.ConnectDB;
import entity.DonViTinh;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.NhaSanXuat;
import entity.NhaXuatBan;
import entity.Sach;
import entity.SanPham;
import entity.TacGia;
import entity.VanPhongPham;

public class DAOSanPham {
	public ArrayList<SanPham> getDanhSachSach(){
		ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
		
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, \r\n"
					+ "		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, tg.maTG, tg.tenTG,\r\n"
					+ "		sp.soTrang, sp.namXuatBan, nxb.maNXB, nxb.tenNXB\r\n"
					+ "from SanPham sp \r\n"
					+ "	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai\r\n"
					+ "	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT\r\n"
					+ "	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "	inner join TacGia tg on sp.maTG = tg.maTG\r\n"
					+ "	inner join NhaXuatBan nxb on sp.maNXB = nxb.maNXB";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsSanPham.add(new Sach(rs.getString(1), rs.getString(2), 
						new LoaiSanPham(rs.getString(3), rs.getString(4)), 
						new DonViTinh(rs.getInt(5), rs.getString(6)), 
						rs.getDouble(7), rs.getDouble(8), rs.getInt(9), 
						new NhaCungCap(rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)), 
						new TacGia(rs.getInt(15), rs.getString(16)), rs.getInt(17), rs.getInt(18), 
						new NhaXuatBan(rs.getInt(19), rs.getString(20)))
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSanPham;
	}
	
	public ArrayList<SanPham> getDanhSachVPP(){
		ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, dvt.maDVT, dvt.tenDVT, sp.giaNhap, sp.giaBan, \r\n"
					+ "		sp.soLuongCon, ncc.maNCC, ncc.tenNCC, ncc.diaChi, ncc.sDT, ncc.email, nsx.maNSX, nsx.tenNSX\r\n"
					+ "from SanPham sp \r\n"
					+ "	inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai\r\n"
					+ "	inner join DonViTinh dvt on sp.maDVT = dvt.maDVT\r\n"
					+ "	inner join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "	inner join NhaSanXuat nsx on sp.maNSX = nsx.maNSX";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsSanPham.add(new VanPhongPham(rs.getString(1), rs.getString(2), 
						new LoaiSanPham(rs.getString(3), rs.getString(4)), 
						new DonViTinh(rs.getInt(5), rs.getString(6)), 
						rs.getDouble(7), rs.getDouble(8), rs.getInt(9), 
						new NhaCungCap(rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)), 
						new NhaSanXuat(rs.getInt(15), rs.getString(16)))
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSanPham;
	}
	
	public ArrayList<SanPham> getDanhsachSanPham(){
		ArrayList<SanPham> dsSach = getDanhSachSach();
		ArrayList<SanPham> dsVPP = getDanhSachVPP();
		dsSach.addAll(dsVPP);
		return dsSach;
	}

	public void banSanPham(String maSP, int soLuong) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "update SanPham set soLuongCon = soLuongCon - ?\r\n"
					+ "where maSP = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, soLuong);
			statement.setString(2, maSP);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
