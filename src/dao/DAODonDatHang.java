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
import entity.ChiTietDonDatHang;
import entity.ChiTietHoaDon;
import entity.DonDatHang;
import entity.DonViTinh;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVien;
import entity.Sach;
import entity.VanPhongPham;

public class DAODonDatHang {

	public DAODonDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<DonDatHang> getDSDonDatHang(){
		ArrayList<DonDatHang> dsDonDatHang = new ArrayList<DonDatHang>();
		try {
			ConnectDB.getInstance();
			Connection connection = ConnectDB.getConnection();
			String sql = "select ddh.maDDH, kh.*, format(ddh.ngayDat, 'yyyy-MM-dd HH:mm:ss'), ddh.trangThai from DonDatHang ddh\r\n"
					+ "inner join KhachHang kh on ddh.maKH = kh.maKH";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maDDH = rs.getString(1);
				DonDatHang donDatHang = new DonDatHang(maDDH, new KhachHang(rs.getString(2), rs.getString(3), rs.getString(4),
						LocalDate.parse(rs.getString(5), DateTimeFormatter.ofPattern("yyyy-MM-dd")), rs.getBoolean(6), rs.getString(7)), 
						LocalDateTime.parse(rs.getString(8), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), rs.getInt(9));
				
				String sqlCT = "select cthd.maDDH, sp.maSP, sp.tenSP, lsp.maLoai, lsp.tenLoai, \r\n"
						+ "		dvt.maDVT, dvt.tenDVT, cthd.donGia, cthd.soLuong\r\n"
						+ "from ChiTietDonDatHang cthd\r\n"
						+ "inner join SanPham sp on cthd.maSP = sp.maSP\r\n"
						+ "inner join LoaiSanPham lsp on sp.maLoai = lsp.maLoai\r\n"
						+ "inner join DonViTinh dvt on sp.maDVT = dvt.maDVT\r\n"
						+ "where maDDH = ?";
				
				PreparedStatement statement2 = connection.prepareStatement(sqlCT);
				statement2.setString(1, maDDH);
				ResultSet rs2 = statement2.executeQuery();
				while (rs2.next()) {
					String maLoai = rs2.getString(4);
					if (maLoai.startsWith("1"))
						donDatHang.addCTHD((new ChiTietDonDatHang(new Sach(rs2.getString(2), rs2.getString(3), 
										new LoaiSanPham(rs2.getString(4), rs2.getString(5)), 
										new DonViTinh(rs2.getInt(6), rs2.getString(7))), 
										rs2.getDouble(8), rs2.getInt(9))));
					else
						donDatHang.addCTHD(new ChiTietDonDatHang(new VanPhongPham(rs2.getString(2), rs2.getString(3), 
								new LoaiSanPham(rs2.getString(4), rs2.getString(5)), 
								new DonViTinh(rs2.getInt(6), rs2.getString(7))), 
								rs2.getFloat(8), rs2.getInt(9)));
				}
				dsDonDatHang.add(donDatHang);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDonDatHang;
	}
	
	public String getMaDonDatHang(String sDT) {
		String maDDH = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select dbo.auto_DonDatHangID('"+sDT+"')";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				maDDH = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maDDH;
	}
	
	public boolean themDonDatHang(DonDatHang donDatHang) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "";
		String maDDH = getMaDonDatHang(donDatHang.getKhachHang().getsDT());
		try {
			sql = "insert into DonDatHang values (dbo.auto_DonDatHangID(?), ?, getdate(), 0)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, donDatHang.getKhachHang().getsDT());
			statement.setString(2, donDatHang.getKhachHang().getMaKH());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		sql = "insert into ChiTietDonDatHang values (?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			for (ChiTietDonDatHang chiTietDonDatHang : donDatHang.getdSCTDonDatHang()) {
				statement.setString(1, maDDH);
				statement.setString(2, chiTietDonDatHang.getSanPham().getMaSP());
				statement.setDouble(3, chiTietDonDatHang.getDonGia());
				statement.setInt(4, chiTietDonDatHang.getSoLuong());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}
}
