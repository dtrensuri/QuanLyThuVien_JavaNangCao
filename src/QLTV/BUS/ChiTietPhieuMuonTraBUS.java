/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.ChiTietPhieuMuonTraDAO;
import QLTV.DAO.MyConnect;
import QLTV.DTO.ChiTietPhieuMuon;
import java.util.ArrayList;

/**
 *
 * @author chihi
 */
public class ChiTietPhieuMuonTraBUS {
    private ArrayList<ChiTietPhieuMuon> listCTPM = new ArrayList<>();
    private ChiTietPhieuMuonTraDAO ctpmDAO = new ChiTietPhieuMuonTraDAO();

    public ChiTietPhieuMuonTraBUS() {
        docDuLieuCTPM();
    }
    
    public void docDuLieuCTPM(){
        this.listCTPM = ctpmDAO.getListCTPM();
    }
    
    public ArrayList<ChiTietPhieuMuon> getDuLieuChiTietPhieuMuon(){
        this.listCTPM = ctpmDAO.getListCTPM();
        return this.listCTPM;
    }
    
    public ArrayList<String> getMaSachDaTra(){
        ArrayList<String> maSachList = ctpmDAO.getListMaSach();
        return maSachList;
    }
    
    public boolean kiemTraTrungMa(String maPM,String maS){
        ArrayList<ChiTietPhieuMuon> lctpm = ctpmDAO.getListCTPM();
        for(ChiTietPhieuMuon ct : lctpm){
            if(maPM.trim().equalsIgnoreCase(ct.getMaPhieuMuon()) && maS.trim().equalsIgnoreCase(ct.getMaSach())){
                return true;
            }
        }
        return false;
    }
    
    public boolean themChiTietPhieuMuon(String maPM, String maS, int soLuong, int tienCuoc, String tinhTrang){
        if(kiemTraTrungMa(maPM, maS)){
            new MyDialog("Mã phiếu mượn và mã sách đã tạo sẵn", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
        ctpm.setMaPhieuMuon(maPM.toUpperCase());
        ctpm.setMaSach(maS.toUpperCase());
        ctpm.setSoLuong(soLuong);
        ctpm.setTienCuoc(tienCuoc);
        
        if(tinhTrang.trim().equals("Chưa trả")){
            ctpm.setTinhTrang("0");
        }else{
            ctpm.setTinhTrang("1");              
        }
        
        if(ctpmDAO.themChiTietPhieuMuon(ctpm)){
            return true;
        }
        return false;
    }
    
    public boolean suaChiTietPhieuMuon(String maPM, String maS, int soLuong, int tienCuoc, String tinhTrang){
        ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
        ctpm.setMaPhieuMuon(maPM.toUpperCase());
        ctpm.setMaSach(maS.toUpperCase());
        ctpm.setSoLuong(soLuong);
        ctpm.setTienCuoc(tienCuoc);
        
        if(tinhTrang.trim().equals("Chưa trả")){
            ctpm.setTinhTrang("0");
        }else{
            ctpm.setTinhTrang("1");              
        }
        
        if(ctpmDAO.suaChiTietPhieuMuon(ctpm)){
            return true;
        }
        return false;
    }
    
    public boolean suaChiTietPhieuTra(String maPM, String maS, String tinhTrang){
        this.listCTPM = ctpmDAO.getListCTPM();
        //
        ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
        ctpm.setMaPhieuMuon(maPM.toUpperCase());
        ctpm.setMaSach(maS.toUpperCase());
        //
        for(ChiTietPhieuMuon timCTPM : this.listCTPM){
            if(maPM.trim().equalsIgnoreCase(timCTPM.getMaPhieuMuon()) && maS.trim().equalsIgnoreCase(timCTPM.getMaSach())){
                ctpm.setSoLuong(timCTPM.getSoLuong());
                ctpm.setTienCuoc(timCTPM.getTienCuoc());
            }
        }
        //
        if(tinhTrang.trim().equals("Chưa trả")){
            ctpm.setTinhTrang("0");
        }else{
            ctpm.setTinhTrang("1");              
        }
        
        if(ctpmDAO.suaChiTietPhieuMuon(ctpm)){
            return true;
        }
        return false;
    }
    
    public boolean xoaChiTietPhieuMuon(String maPM, String maS){
        if(ctpmDAO.xoaChiTietPhieuMuon(maPM, maS)){
            return true;
        }
        return false;
    }
    
    public String getMaSach(String maPhieu, boolean chuaTra){
        ArrayList<ChiTietPhieuMuon> lctpm = ctpmDAO.getListCTPM();
        String str = "";      
        for(ChiTietPhieuMuon ct: lctpm){  
            if(chuaTra){
                if(ct.getMaPhieuMuon().equals(maPhieu) && ct.getTinhTrang().equalsIgnoreCase("Chưa trả")){
                    str += ct.getMaSach()+" ";
                }
            }else{
                if(ct.getMaPhieuMuon().equals(maPhieu) && ct.getTinhTrang().equalsIgnoreCase("Đã trả")){
                    str += ct.getMaSach()+" ";
                }
            }
        }
        return str;
    }
    
    public ArrayList<ChiTietPhieuMuon> getCTPMToMaPhieu(String maPhieu){
        ArrayList<ChiTietPhieuMuon> lctpm = ctpmDAO.getListCTPM();
        ArrayList<ChiTietPhieuMuon> getList = new ArrayList<>();
        for(ChiTietPhieuMuon ct : lctpm){
            if(maPhieu.trim().equalsIgnoreCase(ct.getMaPhieuMuon())){   
                getList.add(ct);
            } 
        }
        return getList;
    }
    
//   -------------------------------------Phieu tra sach----------------------------------------------------------------
    
    public ArrayList<ChiTietPhieuMuon> getCTPMTheoMaPhieu(String maPhieuMuon){
        ArrayList<ChiTietPhieuMuon> listToMaPhieu = new ArrayList<>();
        ArrayList<ChiTietPhieuMuon> listPhieuSach = ctpmDAO.getListCTPMAndSach();
        for(ChiTietPhieuMuon ctpm : listPhieuSach){
            if(ctpm.getMaPhieuMuon().equalsIgnoreCase(maPhieuMuon)){
                listToMaPhieu.add(ctpm);
            }
        }
        return listToMaPhieu;
    }
    
     
}
