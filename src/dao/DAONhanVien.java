package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import database.ConnectDB;
import entity.ChucVu;
import entity.KhachHang;
import entity.NhanVien;


public class DAONhanVien{
	
	public ArrayList<NhanVien> getDanhsachNhanVien(){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select nv.*, cv.tenChucVu\r\n"
					+ "from NhanVien nv inner join ChucVu cv on nv.maChucVu = cv.maChucVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String cMND = rs.getString(3);
				String sDT = rs.getString(4);
				LocalDate ngaySinh = LocalDate.parse(rs.getDate(5).toString());
				Boolean gioiTinh = rs.getBoolean(6);
				String diaChi = rs.getString(7);
				LocalDate ngayVaoLam = LocalDate.parse(rs.getDate(8).toString());
				int maChucVu = rs.getInt(9);
				String tenChucVu = rs.getString(10);
				
				dsNV.add(new NhanVien(maNV, tenNV, cMND, ngaySinh, gioiTinh, sDT, diaChi, ngayVaoLam, new ChucVu(maChucVu, tenChucVu)));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
		
	
	public ArrayList<ChucVu> getDanhsachChucVu(){
		ArrayList<ChucVu> dsCV = new ArrayList<ChucVu>();
		
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from ChucVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				Integer maCV = rs.getInt(1);
				String tenCV = rs.getString(2);
				
				
				dsCV.add(new ChucVu(maCV, tenCV));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCV;
	}
		


	public void them_NV(NhanVien nhanVien) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into NhanVien values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, nhanVien.getMaNV());
			statement.setString(2, nhanVien.getTenNV());
			statement.setString(3, nhanVien.getcMND());
			statement.setString(4, nhanVien.getsDT());
			statement.setString(5, nhanVien.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			statement.setBoolean(6, nhanVien.isGioiTinh());
			statement.setString(7, nhanVien.getDiaChi());
			statement.setString(8, nhanVien.getNgayVaoLam().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			statement.setInt(9, nhanVien.getChucVu().getMaChucVu());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
			}
		}
	public String getMaNV() {
		String maNV = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select dbo.auto_NhanVienID(getdate())";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				maNV = rs.getString(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return maNV;
	}
	
	public boolean xoa_NV(String maKH) throws SQLException {
			
			Connection connection = ConnectDB.getConnection();
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement statement = null;
			int n = 0;
			
			try {
				String sql = "delete from NhanVien where maNV =?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, maKH);
				n = statement.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			} finally {
				statement.close();
				
			}
			return n > 0 ;
		}
	
	public boolean  capNhat(NhanVien nhanVien) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "update NhanVien set  hoTen=?, cMND=?, sDT=?, ngaySinh=?, "
					+ "gioiTinh=?, diaChi=?, ngayVaoLam=?, maChucVu=? where maNV=?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, nhanVien.getTenNV());
			statement.setString(2, nhanVien.getcMND());
			statement.setString(3, nhanVien.getsDT());
			statement.setString(4, nhanVien.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			statement.setBoolean(5, nhanVien.isGioiTinh());
			statement.setString(6, nhanVien.getDiaChi());
			statement.setString(7, nhanVien.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			statement.setInt(8, nhanVien.getChucVu().getMaChucVu());
			statement.setString(9, nhanVien.getMaNV());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
		return false;
		
	}
	
	public ArrayList<NhanVien> timKiemNhanVien(String tenNV, String cMND, 
			String ngaySinh, boolean gioiTinh) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		
	
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select nv.*, cv.tenChucVu "
					+ " from NhanVien nv inner join ChucVu cv on nv.maChucVu = cv.maChucVu "
					+ " where nv.hoTen like N'%"+tenNV+"%'"
					+ " and nv.cMND like '%"+cMND+"%'"
					+ " and format(nv.ngaySinh,'yyyy-MM-dd') like '%"+ngaySinh+"%'"
					+ " and nv.gioiTinh = " + String.valueOf(gioiTinh?1:0);
//			System.out.println(sql);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {					
				String maNV = rs.getString(1);
				String tenNVs = rs.getString(2);
				String cMNDs = rs.getString(3);
				String sDT = rs.getString(4);
				LocalDate ngaySinhs = LocalDate.parse(rs.getDate(5).toString());
				Boolean gioiTinhs = rs.getBoolean(6);
				String diaChi = rs.getString(7);
				LocalDate ngayVaoLam = LocalDate.parse(rs.getDate(8).toString());
				int maChucVu = rs.getInt(9);
				String tenChucVu = rs.getString(10);
				
				dsNV.add(new NhanVien(maNV, tenNVs, cMNDs, ngaySinhs, gioiTinh, sDT, diaChi, ngayVaoLam, 
						new ChucVu(maChucVu, tenChucVu)));

			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNV;		
	}
	
}
	

