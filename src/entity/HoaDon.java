package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HoaDon {
	private String maHD;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private LocalDateTime thoiGianLap;
	private ArrayList<ChiTietHoaDon> dSCTHoaDon;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHD, NhanVien nhanVien, KhachHang khachHang, LocalDateTime thoiGianLap,
			ArrayList<ChiTietHoaDon> dSCTHoaDon) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.thoiGianLap = thoiGianLap;
		this.dSCTHoaDon = dSCTHoaDon;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", thoiGianLap="
				+ thoiGianLap + ", dSCTHoaDon=" + dSCTHoaDon + "]";
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public LocalDateTime getThoiGianLap() {
		return thoiGianLap;
	}
	public void setThoiGianLap(LocalDateTime thoiGianLap) {
		this.thoiGianLap = thoiGianLap;
	}
	public ArrayList<ChiTietHoaDon> getdSCTHoaDon() {
		return dSCTHoaDon;
	}
	public void setdSCTHoaDon(ArrayList<ChiTietHoaDon> dSCTHoaDon) {
		this.dSCTHoaDon = dSCTHoaDon;
	}
	
}
