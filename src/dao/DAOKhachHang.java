package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import database.ConnectDB;
import entity.KhachHang;

public class DAOKhachHang {
	
	public ArrayList<KhachHang> getDanhsachKhachHang(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String sDT = rs.getString(3);
				LocalDate ngaySinh = LocalDate.parse(rs.getDate(4).toString());
				Boolean gioiTinh = rs.getBoolean(5);
				String diaChi = rs.getString(6);
				dsKH.add(new KhachHang(maKH, tenKH, sDT, ngaySinh, gioiTinh, diaChi));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dsKH;
	
	}
	
	
	
	public void them_KH(KhachHang khachHang) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into KhachHang values (?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, khachHang.getMaKH());
			statement.setString(2, khachHang.getTenKH());
			statement.setString(4, khachHang.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			statement.setBoolean(5, khachHang.isGioiTinh());
			statement.setString(3, khachHang.getsDT());
			statement.setString(6, khachHang.getDiaChi());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
	
	public boolean xoa_KH(String maKH) throws SQLException {
		
		Connection connection = ConnectDB.getConnection();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		
		try {
			String sql = "delete from KhachHang where maKH =?";
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
		
		
		public String getMaKH() {
			String maKH = "";
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "Select dbo.auto_KhachHangID()";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					maKH = rs.getString(1);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return maKH;
		}
		
		
		public boolean capNhat(KhachHang khachHang) throws SQLException {
			ConnectDB.getInstance();
			Connection connection = ConnectDB.getConnection();
			PreparedStatement statement = null;
			String sql = "update KhachHang set hoTen=?, sDT=?, ngaySinh=?, gioiTinh=?, diaChi=? where maKH=?";
			
			try {
				
				statement = connection.prepareStatement(sql);				
				statement.setString(1, khachHang.getTenKH());
				statement.setString(2, khachHang.getsDT());
				statement.setString(3, khachHang.getNgaySinh().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				statement.setBoolean(4, khachHang.isGioiTinh());			
				statement.setString(5, khachHang.getDiaChi());
				statement.setString(6, khachHang.getMaKH());
				statement.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				statement.close();
			}
			return false;
			
		}
		
		
		public ArrayList<KhachHang> timKiemKhachHang(String tenKH, String sDT, 
				String ngaySinh, boolean gioiTinh) {
			ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
			
		
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				
				String sql = "Select * from KhachHang kh where kh.hoTen like '%"+tenKH+"%'"
						+ "and kh.sDT like '%"+sDT+"%'"
						+ "and format(kh.ngaySinh,'yyyy-MM-dd') like '%"+ngaySinh+"%'"
						+ "and kh.gioiTinh  = " + String.valueOf(gioiTinh?1:0);
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {					
					dsKH.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3),
							LocalDate.parse(rs.getString(4),DateTimeFormatter.ofPattern("yyyy-MM-dd")),
							rs.getBoolean(5), rs.getString(6)));
	
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dsKH;		
		}	
	}

	
