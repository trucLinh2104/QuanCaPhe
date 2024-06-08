package DTO;

public class hoaDon {
	String tenNuoc;
	int Soluong;
	int thanhTien;
	
	
	
	public hoaDon(String tenNuoc, int soluong, int thanhTien) {
		super();
		this.tenNuoc = tenNuoc;
		Soluong = soluong;
	
		this.thanhTien = thanhTien;
	}
	
	
	public String getTenNuoc() {
		return tenNuoc;
	}
	public void setTenNuoc(String tenNuoc) {
		this.tenNuoc = tenNuoc;
	}
	public int getSoluong() {
		return Soluong;
	}
	public void setSoluong(int soluong) {
		Soluong = soluong;
	}


	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	
	

}
