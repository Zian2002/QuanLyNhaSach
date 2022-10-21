package entity;

public class ChiTietDonDatHang {
	private SanPham sanPham;
	private double donGia;
	private int soLuong;
	public ChiTietDonDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChiTietDonDatHang(SanPham sanPham, double donGia, int soLuong) {
		super();
		this.sanPham = sanPham;
		this.donGia = donGia;
		this.soLuong = soLuong;
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
		return "ChiTietDonDatHang [sanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}
	public double getThanhTien() {
		return soLuong * donGia;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChiTietDonDatHang))
			return false;
		return ((ChiTietDonDatHang)obj).getSanPham().equals(this.getSanPham());
	}
	
	public ChiTietHoaDon convertToCTHD() {
		return new ChiTietHoaDon(sanPham, donGia, soLuong);
	}
}
