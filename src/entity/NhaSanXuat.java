package entity;

public class NhaSanXuat {
	private int maNSX;
	private String tenNSX;
	public NhaSanXuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaSanXuat(int maNSX, String tenNSX) {
		super();
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
	}
	public int getMaNSX() {
		return maNSX;
	}
	public void setMaNSX(int maNSX) {
		this.maNSX = maNSX;
	}
	public String getTenNSX() {
		return tenNSX;
	}
	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}
	@Override
	public String toString() {
		return "NhaSanXuat [maNSX=" + maNSX + ", tenNSX=" + tenNSX + "]";
	}
	
	
}
