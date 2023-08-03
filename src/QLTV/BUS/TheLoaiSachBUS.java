/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.TheLoaiSachDAO;
import QLTV.DTO.TheLoaiSach;
import java.util.ArrayList;


/**
 *
 * @author chihi
 */
public class TheLoaiSachBUS {
    private TheLoaiSachDAO theLoaiSachDAO = new TheLoaiSachDAO();
    private ArrayList<TheLoaiSach> listTheLoaiSach;

    public TheLoaiSachBUS() {
        getListTheLoaiSach();
    }
    
    public ArrayList<TheLoaiSach> getListTheLoaiSach(){
        listTheLoaiSach = theLoaiSachDAO.getListTheLoaiSach();
        return listTheLoaiSach;
    }
    
    public boolean kiemTraTonTai(String maTheLoai, String maSach){
        getListTheLoaiSach();
        for(TheLoaiSach tls: listTheLoaiSach){
            boolean a = tls.getMaTheLoai().trim().equalsIgnoreCase(maTheLoai);
            boolean b = tls.getMaSach().trim().equalsIgnoreCase(maSach);
            if(a==true && b==true ){
                return true;
            }
        }
        return false;
    }
    
    public boolean themTheLoaiSach(String maTheLoai, String maSach){
        if(maTheLoai == null){
           new MyDialog("Vui lòng xác nhận tên thể loại !!! ", MyDialog.WARNING_DIALOG);
           return false;
        }
        TheLoaiSach tls = new TheLoaiSach();
        tls.setMaTheLoai(maTheLoai);
        tls.setMaSach(maSach);
        if (theLoaiSachDAO.themTheLoaiSach(tls)) {
            return true;
        }
        return false;
    }
    
    //(ma,maSach = true) : thì xóa dữ liệu trong bảng thể loại sách theo mã sách
    //(ma,maSach = false) : thì xóa dữ liệu trong bảng thể loại sách theo mã thể loại
    public boolean xoaTheLoaiSach(String ma,boolean maSach){
        if(theLoaiSachDAO.xoaTheLoaiSach(ma, maSach)){
            return true;
        }
        return false;     
    }
    
    public boolean suaTheLoaiSach(String maTheLoai,String maSach){
        TheLoaiSach tls = new TheLoaiSach();
        tls.setMaTheLoai(maTheLoai.toUpperCase());
        tls.setMaSach(maSach.toUpperCase());
        if(theLoaiSachDAO.suaTheLoaiSach(tls)){
            return true;
        }else{
            return false;
        }
    }
    
    //lay ra ma the loai : thi nhap masach va true
    //lay ra ma sach : thi nhap matheloai va false
    public String soSachLayRaMa(String maSach, boolean ms){
        getListTheLoaiSach();
        if(ms){
            for(TheLoaiSach a : listTheLoaiSach){
                if(a.getMaSach().trim().equalsIgnoreCase(maSach)){
                    return a.getMaTheLoai();
                }
            }
            return null;
        }else{
            for(TheLoaiSach a : listTheLoaiSach){
                if(a.getMaTheLoai().trim().equalsIgnoreCase(maSach)){
                    return a.getMaSach();
                }
            }
            return null;
        }
    }
    
}
