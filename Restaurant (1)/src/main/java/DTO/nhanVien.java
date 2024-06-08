package DTO;

public class nhanVien {
	String maNV;
	String HoVaTen;
	String ngaySinh;
	String gioiTinh;
	String sdt;
	String diaChi;
	String taiKhoan;
	String matKhau;
	String chucVu;
	
	public nhanVien(String maNV,String HoVaTen, String ngaySinh, String gioiTinh, String sdt, String diaChi, String taiKhoan,
			String matKhau, String chucVu) {
		super();
		this.maNV = maNV;
		this.HoVaTen=HoVaTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.chucVu = chucVu;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getHoVaTen() {
		return HoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		HoVaTen = hoVaTen;
	}

	@Override
	public String toString() {
		return "nhanVien [maNV=" + maNV + ", HoVaTen=" + HoVaTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", sdt=" + sdt + ", diaChi=" + diaChi + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau
				+ ", chucVu=" + chucVu + "]";
	}


	
	

	
}
