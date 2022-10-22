package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import database.ConnectDB;
import entity.ChiTietHoaDon;
import entity.DonViTinh;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVien;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;

public class DAOHoaDon {

	private DAOSanPham daoSanPham;
	
	public DAOHoaDon() {
		super();
		// TODO Auto-generated constructor stub
		daoSanPham = new DAOSanPham();
	}
	
	public ArrayList<HoaDon> getDSHoaDon(){
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection connection = ConnectDB.getConnection();
			String sql = "select hd.maHD, nv.maNV, nv.hoTen,\r\n"
					+ "		kh.maKH, kh.hoTen, format(hd.thoiGianLap, 'yyyy-MM-dd HH:mm:ss')\r\n"
					+ "from HoaDon hd\r\n"
					+ "	inner join NhanVien nv on hd.maNV = nv.maNV\r\n"
					+ "	inner join KhachHang kh on hd.maKH = kh.maKH order by thoiGianLap desc";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				HoaDon hoaDon = new HoaDon(maHD, new NhanVien(rs.getString(2), rs.getString(3)), 
						new KhachHang(rs.getString(4), rs.getString(5)), 
				LocalDateTime.parse(rs.getString(6), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
				
				String sqlCT = "select cthd.maHD, sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, \r\n"
						+ "		dvt.maDVT, dvt.tenDVT, cthd.donGia, cthd.soLuong\r\n"
						+ "from ChiTietHoaDon cthd\r\n"
						+ "inner join SanPham sp on cthd.maSP = sp.maSP\r\n"
						+ "inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai\r\n"
						+ "inner join DonViTinh dvt on sp.maDVT = dvt.maDVT\r\n"
						+ "where maHD = ?";
				
				PreparedStatement statement2 = connection.prepareStatement(sqlCT);
				statement2.setString(1, maHD);
				ResultSet rs2 = statement2.executeQuery();
				while (rs2.next()) {
					String maLoai = rs2.getString(4);
					if (maLoai.startsWith("1"))
						hoaDon.addCTHD(new ChiTietHoaDon(new Sach(rs2.getString(2), rs2.getString(3), 
										new LoaiSanPham(rs2.getString(4), rs2.getString(5)), 
										new DonViTinh(rs2.getInt(6), rs2.getString(7))), 
										rs2.getDouble(8), rs2.getInt(9)));
					else
						hoaDon.addCTHD(new ChiTietHoaDon(new VanPhongPham(rs2.getString(2), rs2.getString(3), 
								new LoaiSanPham(rs2.getString(4), rs2.getString(5)), 
								new DonViTinh(rs2.getInt(6), rs2.getString(7))), 
								rs2.getFloat(8), rs2.getInt(9)));
				}
				dsHoaDon.add(hoaDon);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	
	public boolean themHoaDonMoi(HoaDon hoaDon, boolean dDH) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "";
		try {
			sql = "insert into HoaDon values (dbo.auto_HoaDonID(getdate()), ?, ?, getdate())";
			statement = connection.prepareStatement(sql);
			statement.setString(1, hoaDon.getNhanVien().getMaNV());
			statement.setString(2, hoaDon.getKhachHang().getMaKH());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		sql = "insert into ChiTietHoaDon values (?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getdSCTHoaDon()) {
				statement.setString(1, hoaDon.getMaHD());
				statement.setString(2, chiTietHoaDon.getSanPham().getMaSP());
				statement.setDouble(3, chiTietHoaDon.getDonGia());
				statement.setInt(4, chiTietHoaDon.getSoLuong());
				statement.executeUpdate();
				if (!dDH)
					daoSanPham.capNhatSoLuong(chiTietHoaDon.getSanPham().getMaSP(), chiTietHoaDon.getSoLuong()*-1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}
	
	
	public String getMaHoaDon() {
		String maHD = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select dbo.auto_HoaDonID(getdate())";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				maHD = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maHD;
	}
	
	public String getMaHoaDon(LocalDate localDate) {
		String maHD = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String date = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String sql = "select dbo.auto_HoaDonID('"+date+"')";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				maHD = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maHD;
	}
}
