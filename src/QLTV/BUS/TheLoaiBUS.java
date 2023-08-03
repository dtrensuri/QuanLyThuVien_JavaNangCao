/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.TheLoaiDAO;
import QLTV.DTO.TheLoai;
import java.util.ArrayList;

/**
 *
 * @author chihi
 */
public class TheLoaiBUS {
    private ArrayList<TheLoai> listTheLoai ;
    private TheLoaiDAO theLoaiDAO = new TheLoaiDAO();

    public TheLoaiBUS() {
        getListTheLoai();
    }
    
    public ArrayList<TheLoai> getListTheLoai(){
        listTheLoai = theLoaiDAO.getListTheLoai();
        return listTheLoai;
    }
    
    public ArrayList<String> getListTenTheLoai(){
        getListTheLoai();
        ArrayList<String> listTenTheLoai = new ArrayList<>();
        for(TheLoai tl : listTheLoai){
            listTenTheLoai.add(String.valueOf(tl.getTenTheLoai()));
        }
        return listTenTheLoai;
    }
    
    //tenTheLoai : true thì hàm nhận tên thể loại đưa ra mã thể loại của tên đó
    //..tenTheLoai : false thì hàm nhận mã thể loại trả về tên thể loại đó.
    public String layMaOrTenTheLoai(String maOrTen, boolean tenTheLoai){
        getListTheLoai();
        if(tenTheLoai){
            for(TheLoai tl : listTheLoai){
                if(maOrTen.trim().equalsIgnoreCase(tl.getTenTheLoai())){
                    return tl.getMaTheLoai();
                }                   
            }
            return null;
        }else{
            for(TheLoai tl : listTheLoai){
                if(maOrTen.trim().equalsIgnoreCase(tl.getMaTheLoai())){
                    return tl.getTenTheLoai();
                }                   
            }
            return null;
        }
    }
    
     public boolean kiemTraTrungMaTheLoai(String ma){
        getListTheLoai();
        for(TheLoai tl : listTheLoai){
            if(ma.trim().equalsIgnoreCase(tl.getMaTheLoai())){
                new MyDialog("Mã thể loại đã tồn tại, vui lòng chọn mã khác !!!", MyDialog.WARNING_DIALOG);
                return true;
            }
        }
        return false;
    }
    
    public boolean themTheLoai(String maTL,String tenTL){
        if(maTL.trim().equals("")){
            new MyDialog("Mã thể loại không được để trống",MyDialog.ERROR_DIALOG);
            return false;
        }
        if(kiemTraTrungMaTheLoai(maTL)){
            return false;
        }
        if(tenTL.trim().equals("")){
            new MyDialog("Tên thể loại không được để trống",MyDialog.ERROR_DIALOG);
            return false;
        }
        TheLoai tl = new TheLoai();
        tl.setMaTheLoai(maTL);
        tl.setTenTheLoai(tenTL);
        if(theLoaiDAO.themTheLoai(tl)){
            new MyDialog("Thêm thể loại thành công ",MyDialog.INFO_DIALOG);
            return true;
        }else{
            new MyDialog("Thêm thể loại thất bại ",MyDialog.INFO_DIALOG);
            return false;
        }
    }
    
    public boolean suaTheLoai(String maTL,String tenTL){
        if(maTL.trim().equals("")){
            new MyDialog("Vui lòng chọn thể loại cần sửa thông tin !!!",MyDialog.ERROR_DIALOG);
            return false;
        }
        TheLoai tl = new TheLoai();
        tl.setMaTheLoai(maTL);
        tl.setTenTheLoai(tenTL);
        if(theLoaiDAO.suaTheLoai(tl)){
            new MyDialog("Sửa thể loại thành công ", MyDialog.INFO_DIALOG);
            return true;
        }else{
            new MyDialog("Sửa thể loại thất bại ", MyDialog.INFO_DIALOG);
            return false;
        }        
    }
    
    //Xóa một thể loại chia 2 trường hợp:
//            Trường hợp 1: Thể loại mới tạo chưa có liên kết đến các bảng khác, xóa trực tiếp đc
//            Trường hợp 2: Thể loại đã có liên kết vs bảng khác, áp dụng công thức: cái nào thêm vào sau thì xóa trước. 
//                                        Trường hợp 2.1 : Nếu 'dữ liệu chứa liên kết' đó không cần nữa thì xóa cả nó đi
//                                        Trường hợp 2.2 : Nếu 'dữ liệu chứa liên kết' vẫn dùng thì cần sửa đổi cái mã dữ liệu sửa thành null  (nên dùng) 
    public boolean xoaTheLoai(String maTL){
        if(maTL.trim().equals("")){
            new MyDialog("Vui lòng chọn thể loại muốn xóa !!!",MyDialog.ERROR_DIALOG);
            return false;
        }
        MyDialog md = new MyDialog("Xác nhận xóa thể loại có mã : "+maTL+" !!!",MyDialog.WARNING_DIALOG);
        if(md.getAction() == md.OK_OPTION){
            //--
            if(theLoaiDAO.xoaTheLoai(maTL) ){
                new MyDialog("Xóa thể loại thành công ",MyDialog.INFO_DIALOG);
                return true;
            }else{
                new MyDialog("Xóa thể loại thất bại ",MyDialog.INFO_DIALOG);
                return false;
            }
        }
        return false;   
    }
}
