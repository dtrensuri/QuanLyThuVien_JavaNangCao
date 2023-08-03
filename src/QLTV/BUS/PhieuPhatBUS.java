/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.MyConnect;
import QLTV.DAO.PhieuPhatDAO;
import QLTV.DTO.PhieuPhat;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chihi
 */
public class PhieuPhatBUS {
    private ArrayList<PhieuPhat> listPhieuPhat;
    private PhieuPhatDAO phieuPhatDAO = new PhieuPhatDAO();

    public PhieuPhatBUS() {
        docListPhieuPhat();
    }
    
    public void docListPhieuPhat(){
        this.listPhieuPhat = phieuPhatDAO.getListPhieuPhat();
    }
    
    public ArrayList<PhieuPhat> getListPhieuPhat(){
        docListPhieuPhat();
        return this.listPhieuPhat;
    }
    
//    public String getMaPhieuMuon(String maThe){
//        String maPhieu = "";
//        for(PhieuPhat pp : this.listPhieuPhat){
//            if(pp.getMaThe().trim().equalsIgnoreCase(maThe)){
//                return maPhieu;
//            }
//        }
//        return null;
//    }
    
    public boolean ktrMaPhieuTrung(String maPhieuPhat){
         ArrayList<PhieuPhat> ppList = getListPhieuPhat();
        if(ppList!=null){
            for(PhieuPhat pp : listPhieuPhat){
                if(pp.getMaPhieuPhat().trim().equalsIgnoreCase(maPhieuPhat)){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    public boolean themPhieuPhat(String maPhieuPhat,String maThe,Date ngayLap){
        if(ktrMaPhieuTrung(maPhieuPhat)){
            new MyDialog("Phiếu phạt cho độc giả mã "+maThe+" đã tồn tại !!!",MyCustom.MyDialog.WARNING_DIALOG);
            return false;
        }
        PhieuPhat pp = new PhieuPhat();
        pp.setMaPhieuPhat(maPhieuPhat.toUpperCase());
        pp.setMaThe(maThe.toUpperCase());
        pp.setNgayLap(ngayLap);
        
        if(phieuPhatDAO.themPhieuPhat(pp)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean suaPhieuPhat(String maPhieuPhat, String maThe, Date ngayLap){
        PhieuPhat pp = new PhieuPhat();
        pp.setMaPhieuPhat(maPhieuPhat);
        pp.setMaThe(maThe);
        pp.setNgayLap(ngayLap);
        
        if(phieuPhatDAO.suaPhieuPhat(pp)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean xoaPhieuPhat(String maPhieuPhat){      
        if(phieuPhatDAO.xoaPhieuPhat(maPhieuPhat)){
            return true;
        }else{
            return false;
        }
    }
//    
//    public static void main(String[] args) {
//        new MyConnect();
//        PhieuPhatBUS ppb = new PhieuPhatBUS();
//        ArrayList<PhieuPhat> ppList = ppb.getListPhieuPhat();
//        for(PhieuPhat pp : ppList){
//            System.out.println(""+pp.getMaThe());
//        }
//        
//    }
}
