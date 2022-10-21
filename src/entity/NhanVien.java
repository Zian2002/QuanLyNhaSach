package entity;

import java.time.LocalDate;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String cMND;
	private LocalDate ngaySinh;
	private boolean gioiTinh;
	private String sDT;
	private String diaChi;
	private LocalDate ngayVaoLam;
	private ChucVu chucVu;
	private TaiKhoan taiKhoan;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
		this.taiKhoan = new TaiKhoan(maNV, "1111", 1);
	}
	
	public NhanVien(String maNV, String tenNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
	}

	public NhanVien(String maNV, String tenNV, String cMND, LocalDate ngaySinh, boolean gioiTinh, String sDT, String diaChi,
			LocalDate ngayVaoLam, ChucVu chucVu) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.cMND = cMND;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.chucVu = chucVu;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getcMND() {
		return cMND;
	}
	public void setcMND(String cMND) {
		this.cMND = cMND;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public ChucVu getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	@Override
	public String toString() {
		return maNV + " - " + tenNV;
	}
	
}
