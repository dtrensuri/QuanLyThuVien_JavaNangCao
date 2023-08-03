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
public class DocGia {
    private String maThe;
    private String hoTen;
    private Date ngaySinh;
    private String khoa;
    private String nienKhoa;
    private String lop;

    public DocGia() {
    }

    public DocGia(String maThe, String hoTen, Date ngaySinh, String khoa, String nienKhoa, String lop) {
        this.maThe = maThe;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.khoa = khoa;
        this.nienKhoa = nienKhoa;
        this.lop = lop;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    
    
    
    
    
}
