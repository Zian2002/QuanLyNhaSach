package entity;

import java.time.LocalDate;

public class TacGia {
	private int maTG;
	private String tenTG;
	private LocalDate ngaySinh;
	public TacGia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TacGia(int maTG, String tenTG) {
		super();
		this.maTG = maTG;
		this.tenTG = tenTG;
	}
	public int getMaTG() {
		return maTG;
	}
	public void setMaTG(int maTG) {
		this.maTG = maTG;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	
}
