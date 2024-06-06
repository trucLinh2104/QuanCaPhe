package DTO;

public class Ban {
	String maBan;
	String status;
	int soNguoi;
	@Override
	public String toString() {
		return "Ban [maBan=" + maBan + ", status=" + status + ", soNguoi=" + soNguoi + "]";
	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	public Ban(String maBan, String status, int soNguoi) {
		super();
		this.maBan = maBan;
		this.status = status;
		this.soNguoi = soNguoi;
	}
	
	
}
