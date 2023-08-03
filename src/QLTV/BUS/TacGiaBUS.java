/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.MyConnect;
import QLTV.DAO.TacGiaDAO;
import QLTV.DTO.TacGia;
import java.util.ArrayList;

/**
 *
 * @author chihi
 */
public class TacGiaBUS {
    private ArrayList<TacGia> listTacGia ;
    private TacGiaDAO tacGiaDAO = new TacGiaDAO();
    

    public TacGiaBUS() {
        getListTacGia();
    }
       
    public ArrayList<TacGia> getListTacGia(){
        listTacGia = tacGiaDAO.getListTacGia();
        return listTacGia; 
    }
    //nhap vao (TenTacGia,true) : cho ra ten tacgia theo yêu cầu
    //nhap vao (MatacGia,false) : cho ra ma tacgia theo yêu cầu
    
    public ArrayList<String> getListTenTacGia(){
        getListTacGia();
        ArrayList<String> listTen = new ArrayList<>();
        for(TacGia tg : listTacGia){
            listTen.add(tg.getTenTacGia());
        }
        return listTen; 
    }
    
    public String layMaOrTenTacGia(String maOrTen,boolean tenTG){
        getListTacGia();
        if(tenTG){
            for(TacGia tg : listTacGia){
                if(maOrTen.trim().equals(tg.getTenTacGia())){
                  return tg.getMaTacGia();
                }                   
            } 
        }else{
            for(TacGia tg : listTacGia){
                if(maOrTen.trim().equals(tg.getMaTacGia())){
                  return tg.getTenTacGia();
                }                   
            } 
        }
        return null;
    }
    
    public boolean kiemTraTrungMaTacGia(String ma){
        getListTacGia();
        for(TacGia tg : listTacGia){
            if(ma.trim().equalsIgnoreCase(tg.getMaTacGia())){
                new MyDialog("Mã tác giả đã tồn tại, vui lòng chọn mã khác !!!", MyDialog.WARNING_DIALOG);
                return true;
            }
        }
        return false;
    }
    
    public boolean themTacGia(String maTG, String tenTG){
        if(maTG.trim().equals("")){
            new MyDialog("Mã tác giả không được để trống",MyDialog.ERROR_DIALOG);
            return false;
        }
        if(tenTG.trim().equals("")){
            new MyDialog("Tên tác giả không được để trống",MyDialog.ERROR_DIALOG);
            return false;
        }
        if(kiemTraTrungMaTacGia(maTG)){
            return false;
        }
        TacGia tg = new TacGia();
        tg.setMaTacGia(maTG.toUpperCase());
        tg.setTenTacGia(tenTG);
        if(tacGiaDAO.themTacGia(tg)){
            new MyDialog("Thêm tác giả thành công !!!",MyDialog.INFO_DIALOG);
            return true;
        }else{
            new MyDialog("Thêm tác giả thất bại !!!",MyDialog.INFO_DIALOG);
            return false;
        }
    }
    
    public boolean suaTTTacGia(String maTG,String tenTG){
        if(maTG.trim().equals("")){
            new MyDialog("Vui lòng chọn tác giả muốn sửa thông tin !!!",MyDialog.ERROR_DIALOG);
            return false;
        }
        TacGia tg = new TacGia();
        tg.setMaTacGia(maTG);
        tg.setTenTacGia(tenTG);

        if(tacGiaDAO.suaTacGia(tg)){
            new MyDialog("Sửa thông tin tác giả thành công ",MyDialog.INFO_DIALOG);
            return true;
        }else{
            new MyDialog("Sửa thông tin tác giả thất bại ",MyDialog.INFO_DIALOG);
            return false;
        }
    }
    
    public boolean xoaTTTacGia(String maTG){
        if(maTG.trim().equals("")){
            new MyDialog("Mã tác giả không được để trống",MyDialog.ERROR_DIALOG);
            return false;
        }
        
        MyDialog md = new MyDialog("Xác nhận xóa tác giả có mã : "+maTG+" !!!",MyDialog.WARNING_DIALOG);
        if(md.getAction() == md.OK_OPTION){
            if(tacGiaDAO.xoaTacGia(maTG)){
                new MyDialog("Xóa tác giả thành công ",MyDialog.INFO_DIALOG);
                return true;
            }else{
                new MyDialog("Xóa tác giả thất bại ",MyDialog.INFO_DIALOG);
                return false;
            } 
        }
        return false;   
    }
}
