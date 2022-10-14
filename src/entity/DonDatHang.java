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
	}
	public DonDatHang(String maDDH, KhachHang khachHang, LocalDateTime ngayDat, int trangThaiDonHang) {
		super();
		this.maDDH = maDDH;
		this.khachHang = khachHang;
		this.ngayDat = ngayDat;
		this.trangThaiDonHang = trangThaiDonHang;
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
				+ ", trangThaiDonHang=" + trangThaiDonHang + "]";
	}
	
}
