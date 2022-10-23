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
import uiQuanLy.GUIDanhSachSach;
import uiQuanLy.GUIDanhSachVPP;

public class main{
	public static void main(String[] args) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");	
			
			NhanVien nhanVien = new NhanVien("20020001", "Bùi Nhựt Duy", "6453245678", LocalDate.now(), true, "1000", "Bến Tre", LocalDate.now(), new ChucVu());
			new GUIMenuQuanLy(nhanVien).setVisible(true);	
			GUIMenuQuanLy.showPanel(new GUIDanhSachSach());
//			GUIMenuQuanLy.showPanel(new GUIDanhSachVPP());
			
		} catch (Exception e) {
			e.printStackTrace();
		};

		DAODonDatHang daoDonDatHang=new DAODonDatHang();
//		ArrayList<DonDatHang>dsDDH = daoDonDatHang.getDSDonDatHang();
//		for (DonDatHang donDatHang : dsDDH) {
//			System.out.println(donDatHang.toString());
//		}
//		String maString = daoDonDatHang.getMaDonDatHang("05287548962");
//		System.out.println(maString);
	}
}
