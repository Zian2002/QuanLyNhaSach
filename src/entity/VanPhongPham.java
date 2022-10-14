package entity;

public class VanPhongPham extends SanPham{
	private NhaSanXuat nhaSanXuat;

	public VanPhongPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VanPhongPham(String maSP, String tenSP, LoaiSanPham loaiSP, DonViTinh donViTinh, double giaNhap,
			double giaBan, int soLuongCon, NhaCungCap nhaCungCap, NhaSanXuat nhaSanXuat) {
		super(maSP, tenSP, loaiSP, donViTinh, giaNhap, giaBan, soLuongCon, nhaCungCap);
		this.nhaSanXuat = nhaSanXuat;
	}

	public NhaSanXuat getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}
	
}
