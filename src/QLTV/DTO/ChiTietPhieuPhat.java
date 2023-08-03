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
public class ChiTietPhieuPhat {
    private String maPhieuPhat;
    private String maSach;
    private int tienPhat;
    private String lyDo;
    private String xuLy;

    public ChiTietPhieuPhat() {
    }

    public ChiTietPhieuPhat(String maPhieuPhat, String maSach, int tienPhat, String lyDo, String xuLy) {
        this.maPhieuPhat = maPhieuPhat;
        this.maSach = maSach;
        this.tienPhat = tienPhat;
        this.lyDo = lyDo;
        this.xuLy = xuLy;
    }

    public String getMaPhieuPhat() {
        return maPhieuPhat;
    }

    public void setMaPhieuPhat(String maPhieuPhat) {
        this.maPhieuPhat = maPhieuPhat;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getXuLy() {
        return xuLy;
    }

    public void setXuLy(String xuLy) {
        this.xuLy = xuLy;
    }
    
    
}
