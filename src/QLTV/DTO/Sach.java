/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DTO;

/**
 *
 * @author chihi
 */
public class Sach {
    private String maSach;
    private String maTacGia;
    private String tenSach;
    private String nxb;
    private int soLuong;
    private int giaTien;

    public Sach() {
    }

    
    public Sach(String maSach, String maTacGia, String tenSach, String nxb, int soLuong, int giaTien) {
        this.maSach = maSach;
        this.maTacGia = maTacGia;
        this.tenSach = tenSach;
        this.nxb = nxb;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
    
    
}
