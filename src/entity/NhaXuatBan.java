package entity;

public class NhaXuatBan {
	private int maNXB;
	private String tenNXB;
	public NhaXuatBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaXuatBan(int maNXB, String tenNXB) {
		super();
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
	}
	public int getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(int maNXB) {
		this.maNXB = maNXB;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	@Override
	public String toString() {
		return "NhaXuatBan [maNXB=" + maNXB + ", tenNXB=" + tenNXB + "]";
	}
	
}
