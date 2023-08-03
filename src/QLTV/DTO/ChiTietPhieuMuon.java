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
public class ChiTietPhieuMuon {
    private String maPhieuMuon;
    private String maSach;
    private int soLuong;
    private int tienCuoc;
    private String tinhTrang;

    public ChiTietPhieuMuon() {
    }

    public ChiTietPhieuMuon(String maPhieuMuon, String maSach, int soLuong, int tienCuoc, String tinhTrang) {
        this.maPhieuMuon = maPhieuMuon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.tienCuoc = tienCuoc;
        this.tinhTrang = tinhTrang;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTienCuoc() {
        return tienCuoc;
    }

    public void setTienCuoc(int tienCuoc) {
        this.tienCuoc = tienCuoc;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
