/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author linh
 */
    public class NuocUong{
        String maNuoc;
	String loaiNuoc;
	String tenNuoc;
	float giaBan;
	String donVi;
	float soLuong;
        public NuocUong() {
		super();
		this.maNuoc ="";
		this.tenNuoc = "";
		this.loaiNuoc="";
		this.giaBan = 0F;
		this.donVi = "";
		this.soLuong = 0F;
	}
	public NuocUong(String maNuoc,String loaiNuoc, String tenNuoc, float giaBan, String donVi, float soLuong) {
		super();
		this.maNuoc = maNuoc;
		this.tenNuoc = tenNuoc;
		this.loaiNuoc=loaiNuoc;
		this.giaBan = giaBan;
		this.donVi = donVi;
		this.soLuong = soLuong;
	}
	public String getMaNuoc() {
		return maNuoc;
	}
	public void setMaNuoc(String maNuoc) {
		this.maNuoc = maNuoc;
	}
	public String getTenNuoc() {
		return tenNuoc;
	}
	public void setTenNuoc(String tenNuoc) {
		this.tenNuoc = tenNuoc;
	}
	public float  getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public float getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(float soLuong) {
		this.soLuong = soLuong;
	}
	
	public String getLoaiNuoc() {
		return loaiNuoc;
	}
	public void setLoaiNuoc(String loaiNuoc) {
		this.loaiNuoc = loaiNuoc;
	}
    }