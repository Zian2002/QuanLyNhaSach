package entity;

public class ChiTietDonDatHang {
	private SanPham sanPham;
	private int soLuong;
	public ChiTietDonDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietDonDatHang(SanPham sanPham, int soLuong) {
		super();
		this.sanPham = sanPham;
		this.soLuong = soLuong;
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
		return "ChiTietDonDatHang [sanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}
	
}
