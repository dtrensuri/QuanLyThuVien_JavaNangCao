/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.ChiTietPhieuPhatDAO;
import QLTV.DTO.ChiTietPhieuPhat;
import java.util.ArrayList;

/**
 *
 * @author chihi
 */
public class ChiTietPhieuPhatBUS {
    private ArrayList<ChiTietPhieuPhat> listChiTietPP ;
    private ChiTietPhieuPhatDAO chitietPPDAO = new ChiTietPhieuPhatDAO();

    public ChiTietPhieuPhatBUS() {
        docListChiTietPP();
    }
    
    public void docListChiTietPP(){
        this.listChiTietPP = chitietPPDAO.getListChiTietPP();
    }
    
    public ArrayList<ChiTietPhieuPhat> getListChiTietPP(){
        docListChiTietPP();
        return this.listChiTietPP;
    }
    
    public boolean ktrMaPhieuPhatTrung(String maPhieuPhat, String maSach){
        ArrayList<ChiTietPhieuPhat> ctppList = getListChiTietPP();
        if(ctppList != null){
            for(ChiTietPhieuPhat pp : ctppList){
                if(pp.getMaPhieuPhat().trim().equalsIgnoreCase(maPhieuPhat) && 
                        pp.getMaSach().trim().equalsIgnoreCase(maSach)){
                    return true;
                }
            }
            return false;
        }
         return false;
    }
    
    public boolean themChiTietPhieuPhat(String maPhieuPhat, String maSach, int tienPhat, String lyDo, String xuLy){
        if(ktrMaPhieuPhatTrung(maPhieuPhat, maSach)){
            new MyDialog("Phiếu phạt cho sách có mã "+maSach+" đã tồn tại !!!",MyCustom.MyDialog.WARNING_DIALOG);
            return false;
        }
        ChiTietPhieuPhat ctpp = new ChiTietPhieuPhat();
        ctpp.setMaPhieuPhat(maPhieuPhat.toUpperCase());
        ctpp.setMaSach(maSach.toUpperCase());
        ctpp.setTienPhat(tienPhat);
        ctpp.setLyDo(lyDo);
        ctpp.setXuLy(xuLy);
        
        if(chitietPPDAO.themChiTietPP(ctpp)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean suaChiTietPhieuPhat(String maPhieuPhat, String maSach, int tienPhat, String lyDo, String xuLy){
        
        ChiTietPhieuPhat ctpp = new ChiTietPhieuPhat();
        ctpp.setMaPhieuPhat(maPhieuPhat);
        ctpp.setMaSach(maSach);
        ctpp.setTienPhat(tienPhat);
        ctpp.setLyDo(lyDo);
        ctpp.setXuLy(xuLy);
        
        if(chitietPPDAO.suaChiTietPP(ctpp)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean xoaChiTietPhieuPhat(String maPhieuPhat, String maSach){      
        if(chitietPPDAO.xoaCTPP(maPhieuPhat,maSach)){
            return true;
        }else{
            return false;
        }
    }
}
