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
public class TheLoaiSach {
    private String maTheLoai;
    private String maSach;

    public TheLoaiSach() {
    }

    public TheLoaiSach(String maTheLoai, String maSach) {
        this.maTheLoai = maTheLoai;
        this.maSach = maSach;
    }

    
    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    
    
}
