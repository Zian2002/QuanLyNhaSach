package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DonDatHang {
	private String maDDH;
	private KhachHang khachHang;
	private LocalDateTime ngayDat;
	private int trangThaiDonHang;
	private ArrayList<ChiTietDonDatHang> dSCTDonDatHang;

	public DonDatHang() {
		super();
		// TODO Auto-generated constructor stub
		this.dSCTDonDatHang = new ArrayList<ChiTietDonDatHang>();
	}
	public DonDatHang(String maDDH, KhachHang khachHang, LocalDateTime ngayDat, int trangThaiDonHang) {
		super();
		this.maDDH = maDDH;
		this.khachHang = khachHang;
		this.ngayDat = ngayDat;
		this.trangThaiDonHang = trangThaiDonHang;
		this.dSCTDonDatHang = new ArrayList<ChiTietDonDatHang>();
	}
	public String getMaDDH() {
		return maDDH;
	}
	public void setMaDDH(String maDDH) {
		this.maDDH = maDDH;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public LocalDateTime getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(LocalDateTime ngayDat) {
		this.ngayDat = ngayDat;
	}
	public int getTrangThaiDonHang() {
		return trangThaiDonHang;
	}
	public void setTrangThaiDonHang(int trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}
	
	public ArrayList<ChiTietDonDatHang> getdSCTDonDatHang() {
		return dSCTDonDatHang;
	}
	public void setdSCTDonDatHang(ArrayList<ChiTietDonDatHang> dSCTDonDatHang) {
		this.dSCTDonDatHang = dSCTDonDatHang;
	}
	
	public DonDatHang(String maDDH, KhachHang khachHang, LocalDateTime ngayDat, int trangThaiDonHang,
			ArrayList<ChiTietDonDatHang> dSCTDonDatHang) {
		super();
		this.maDDH = maDDH;
		this.khachHang = khachHang;
		this.ngayDat = ngayDat;
		this.trangThaiDonHang = trangThaiDonHang;
		this.dSCTDonDatHang = dSCTDonDatHang;
	}
	
	
	@Override
	public String toString() {
		return "DonDatHang [maDDH=" + maDDH + ", khachHang=" + khachHang + ", ngayDat=" + ngayDat
				+ ", trangThaiDonHang=" + trangThaiDonHang + ", dSCTDonDatHang=" + dSCTDonDatHang + "]";
	}
	public ArrayList<ChiTietHoaDon> convertToCTHDList() {
		ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
		for (ChiTietDonDatHang chiTietDonDatHang : dSCTDonDatHang) {
			dsCTHD.add(chiTietDonDatHang.convertToCTHD());
		}
		return dsCTHD;
	}
	public void addCTHD(ChiTietDonDatHang chiTietDonDatHang) {
		for (ChiTietDonDatHang cthd : dSCTDonDatHang) {
			if (cthd.equals(chiTietDonDatHang)) {
				cthd.setSoLuong(cthd.getSoLuong() + chiTietDonDatHang.getSoLuong());
				return;
			}
		}
		dSCTDonDatHang.add(chiTietDonDatHang);
	}
	
	public int getTongSoLuong() {
		int soLuong = 0;
		for (ChiTietDonDatHang chiTietHoaDon : dSCTDonDatHang) {
			soLuong += chiTietHoaDon.getSoLuong();
		}
		return soLuong;
	}
	
	public double getTongThanhTien() {
		double thanhTien = 0;
		for (ChiTietDonDatHang chiTietHoaDon : dSCTDonDatHang) {
			thanhTien += chiTietHoaDon.getThanhTien();
		}
		return thanhTien;
	}
}
