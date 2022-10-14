package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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
				String mKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String sDT = rs.getString(3);
				LocalDate date = LocalDate.parse(rs.getDate(4).toString());
				Boolean gioiTinh = rs.getBoolean(5);
				String diaChi = rs.getString(6);
				dsKH.add(new KhachHang(mKH, tenKH, sDT, date, gioiTinh, diaChi));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	
	}
}
