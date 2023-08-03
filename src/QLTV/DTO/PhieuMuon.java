/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DTO;

import java.util.Date;

/**
 *
 * @author chihi
 */
public class PhieuMuon {
    private String maPhieuMuon;
    private String maThe;
    private Date ngayMuon;
    private Date hanTra;

    public PhieuMuon() {
    }

    public PhieuMuon(String maPhieuMuon, String maThe, Date ngayMuon, Date hanTra) {
        this.maPhieuMuon = maPhieuMuon;
        this.maThe = maThe;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    

   
    
    
}
