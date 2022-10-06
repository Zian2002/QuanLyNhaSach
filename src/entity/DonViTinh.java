package entity;

public class DonViTinh {
	private int maDVT;
	private String tenDVT;
	public DonViTinh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonViTinh(int maDVT, String tenDVT) {
		super();
		this.maDVT = maDVT;
		this.tenDVT = tenDVT;
	}
	public int getMaDVT() {
		return maDVT;
	}
	public void setMaDVT(int maDVT) {
		this.maDVT = maDVT;
	}
	public String getTenDVT() {
		return tenDVT;
	}
	public void setTenDVT(String tenDVT) {
		this.tenDVT = tenDVT;
	}
	@Override
	public String toString() {
		return "DonViTinh [maDVT=" + maDVT + ", tenDVT=" + tenDVT + "]";
	}
	
}
