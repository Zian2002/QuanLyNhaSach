package entity;

public class Sach extends SanPham {
	private TacGia tacGia;
	private int soTrang;
	private int namXuatBan;
	private NhaXuatBan nhaXuatBan;
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Sach(String maSP, String tenSP, LoaiSanPham loaiSP, DonViTinh donViTinh) {
		super(maSP, tenSP, loaiSP, donViTinh);
		// TODO Auto-generated constructor stub
	}



	public Sach(String maSP, String tenSP, LoaiSanPham loaiSP, DonViTinh donViTinh, double giaNhap, double giaBan,
			int soLuongCon, NhaCungCap nhaCungCap, TacGia tacGia, int soTrang, int namXuatBan, NhaXuatBan nhaXuatBan) {
		super(maSP, tenSP, loaiSP, donViTinh, giaNhap, giaBan, soLuongCon, nhaCungCap);
		this.tacGia = tacGia;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.nhaXuatBan = nhaXuatBan;
	}
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	
}
