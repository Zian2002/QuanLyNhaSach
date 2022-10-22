package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;

import dao.DAODonDatHang;
import dao.DAOHoaDon;
import dao.DAOKhachHang;
import dao.DAOSanPham;
import database.ConnectDB;
import entity.ChiTietDonDatHang;
import entity.ChiTietHoaDon;
import entity.ChucVu;
import entity.DonDatHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Sach;
import entity.SanPham;
import uiMenu.GUIMenuQuanLy;
import uiQuanLy.GUIDanhSachDonDatHang;

public class main{
	public static void main(String[] args) {
		DAODonDatHang daoDonDatHang = new DAODonDatHang();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");	
			daoDonDatHang.capNhatDonDatHang();
			NhanVien nhanVien = new NhanVien("20020001", "Bùi Nhựt Duy", "6453245678", LocalDate.now(), true, "1000", "Bến Tre", LocalDate.now(), new ChucVu());
			new GUIMenuQuanLy(nhanVien).setVisible(true);		
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
}
