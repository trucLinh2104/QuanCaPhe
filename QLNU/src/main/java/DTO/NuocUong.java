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



    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = Float.parseFloat(gia);
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public NuocUong(String ma, String ten, String loai, Float gia, String dvt, int soluong) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.gia = gia;
        this.dvt = dvt;
        this.soluong = soluong;
    }

    public NuocUong() {
        this.ma = "";
        this.ten = "";
        this.loai = "";
        this.gia = 0F;
        this.dvt = "";
        this.soluong = 0;
    }

    @Override
    public String toString() {
        return "NuocUong{" + "ma=" + ma + ", ten=" + ten + ", loai=" + loai + ", gia=" + gia + ", dvt=" + dvt + ", soluong=" + soluong + '}';
    }

   
    private String ma;
    private String ten;
    private String loai;
    private Float gia;
    private String dvt;
    private int soluong;

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    }