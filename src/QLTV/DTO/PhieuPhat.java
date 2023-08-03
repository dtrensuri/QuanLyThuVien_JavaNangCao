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
public class PhieuPhat {
    private String maPhieuPhat;
    private String maThe;
    private Date ngayLap;

    public PhieuPhat() {
    }

    public PhieuPhat(String maPhieuPhat, String maThe, Date ngayLap) {
        this.maPhieuPhat = maPhieuPhat;
        this.maThe = maThe;
        this.ngayLap = ngayLap;
    }

    public String getMaPhieuPhat() {
        return maPhieuPhat;
    }

    public void setMaPhieuPhat(String maPhieuPhat) {
        this.maPhieuPhat = maPhieuPhat;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
    
    
}
