package entity;

public class ChiTietHoaDon {
	private SanPham sanPham;
	private double donGia;
	private int soLuong;
	public ChiTietHoaDon(SanPham sanPham, double donGia, int soLuong) {
		super();
		this.sanPham = sanPham;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [sanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}
	
}
