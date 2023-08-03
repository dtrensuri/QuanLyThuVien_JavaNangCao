/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDateFormat;
import MyCustom.MyDialog;
import QLTV.DAO.MyConnect;
import QLTV.DAO.PhieuMuonTraDAO;
import QLTV.DTO.PhieuMuon;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author chihi
 */
public class PhieuMuonTraBUS {
    private ArrayList<PhieuMuon> listPM, listPhieuMuon = new ArrayList<>();
    private PhieuMuonTraDAO phieuMuonTraDAO = new PhieuMuonTraDAO();
    private ArrayList<String> lPM = null;

    public PhieuMuonTraBUS() {
        docListPMuonTraEdit();
    }
    
//-----------------------------------------------------------------------------------------------------------------------------------
//                                                      Phần tìm kiếm phiếu mượn trả                                    
//-----------------------------------------------------------------------------------------------------------------------------------       
    public ArrayList<String> getListMTTK(){
        this.lPM = phieuMuonTraDAO.getListTimKiemMuonTra(0);
        return this.lPM;
    }
    
    public ArrayList<String> timKiemPhieuMuonTraTK(String yc, String bien){
        getListMTTK();
        ArrayList<String> list = new ArrayList<>();
        for(String pm : this.lPM){
            String[] a = pm.split("_");
            switch(yc){
                case "Mã phiếu mượn":
                    if(bien.trim().equalsIgnoreCase(a[0])){
                        list.add(pm);
                    }
                    break;
                case "Họ và tên":
                    String[] b = a[1].split("\\s");
                    for(int i=0; i<b.length;i++){
                        if(bien.trim().equalsIgnoreCase(b[i])){
                            list.add(pm);
                        }
                    }
                    break;
                case "Tên sách":
                    String[] c = a[2].split("\\s");
                    for(int i=0; i<c.length; i++){
                        if(bien.trim().equalsIgnoreCase(c[i])){
                            list.add(pm);
                        }
                    }                   
                    break;
                case "Tình trạng":
                    String tt = a[7];
                    String tinhtrang;
                    if(tt.equals("1")){
                        tinhtrang = "Đã trả";
                    }else{
                        tinhtrang = "Chưa trả";
                    }
                    
                    if(bien.equalsIgnoreCase(tinhtrang)){
                        list.add(pm);
                    }
//                    String[] d = tinhtrang.split("\\s");
//                    for(int i=0; i<d.length; i++){
//                        if(bien.trim().equalsIgnoreCase(d[i]) || tinhtrang.trim().equalsIgnoreCase(bien)){
//                            list.add(pm);
//                        }
//                    }
                    break;    
            }   
        }
        return list;       
    }
    
    public ArrayList<String> sapXepPhieuMuonTraTK(String yc){    
        ArrayList<String> lstSX = null;
        switch(yc){
            case "Ngày mượn":
                lstSX = phieuMuonTraDAO.getListTimKiemMuonTra(1);
                break;
            case "Ngày trả":
                lstSX = phieuMuonTraDAO.getListTimKiemMuonTra(2);
                break;
            case "Số lượng":
                lstSX = phieuMuonTraDAO.getListTimKiemMuonTra(3);
                break;
            case "Tiền cược":
                lstSX = phieuMuonTraDAO.getListTimKiemMuonTra(4);
                break;  
        }
        System.out.println(""+lstSX.get(0));
        return lstSX;
    }
    
//    public ArrayList<String> xemDGSapTraSachTK(boolean kt){
//        ArrayList<String> lxemDG = new ArrayList<>();
//        getListMTTK();
//        Calendar cal = Calendar.getInstance();
//        Date date = cal.getTime();
//       
//        for(String s : this.lPM){
//            String[] ls = s.split("_");
//            
//            Date date1 = MyDateFormat.getDateToString(ls[4]);
//            long dt = (date1.getTime() - date.getTime())/(24 * 3600 * 1000);
//            if(kt){
//                if(0 < dt && dt < 8 && ls[7].equals("0")){
//                    lxemDG.add(s);
//                }
//            }else{
//                if(dt < 0 && ls[7].equals("0")){
//                    lxemDG.add(s);
//                }
//            }
//        }
//        return lxemDG;
//    }

    public ArrayList<String> getListTenSachTK(String maPhieuMuon){
        getListMTTK();
        ArrayList<String> lxemDG = new ArrayList<>();         
        for(String s : this.lPM){
            String[]ls = s.split("_");
            if(ls[0].equalsIgnoreCase(maPhieuMuon) && ls[7].equals("0") ){
                lxemDG.add(ls[2]);
            }
        }
        return lxemDG;
    }
    
    public ArrayList<String> getTienSoLuongTK(String maPhieuMuon){
        getListMTTK();
        ArrayList<String> tsl = new ArrayList<>();   
        int soluong = 0;
        Double tien = 0D;
        for(String s : this.lPM){
            String[]ls = s.split("_");
            
            if(ls[0].equalsIgnoreCase(maPhieuMuon) && ls[7].equals("0")){
                soluong += Integer.parseInt(ls[5]);
                tien += Double.parseDouble(ls[6]);
            }
        }
        String str = String.valueOf(soluong) +"_"+String.valueOf(tien);
        tsl.add(str);
        return tsl;
    }

//-----------------------------------------------------------------------------------------------------------------------------------
//                                                      Phần thiết lập phiếu mượn trả                                    
//-----------------------------------------------------------------------------------------------------------------------------------    
    public void docListPMuonTraEdit(){
        this.listPM = phieuMuonTraDAO.getListPhieuMuonTra();
    }
    
    public ArrayList<PhieuMuon> getListPMuonTraEdit(){
        this.listPM = phieuMuonTraDAO.getListPhieuMuonTra();
        return this.listPM;
    }
    
     public ArrayList<PhieuMuon> docDanhSachPhMuTraEdit(){
        if(listPhieuMuon == null){
            this.listPhieuMuon = phieuMuonTraDAO.getPhieuMuonTra();
            return listPhieuMuon;
        }
        return listPhieuMuon;
    }
     
    public boolean kiemTraTrungMa(String maPhieuMuon){
        getListPMuonTraEdit();
        for(PhieuMuon pm : listPM){
            if(maPhieuMuon.trim().equalsIgnoreCase(pm.getMaPhieuMuon())){   
                return true;
            }
        }
        return false;
    }
    
    public boolean themPhieuMuonTra(String maPhieuMuon,String maThe,Date ngayMuon,Date hanTra){
        if(kiemTraTrungMa(maPhieuMuon)){
            new MyDialog("Mã phiếu mượn đã tồn tại !!!",MyDialog.ERROR_DIALOG);
            return false;
        }
        PhieuMuon pm = new PhieuMuon();
        pm.setMaPhieuMuon(maPhieuMuon.toUpperCase());
        pm.setMaThe(maThe.toUpperCase());
        pm.setNgayMuon(ngayMuon);
        pm.setHanTra(hanTra);
        if(phieuMuonTraDAO.themPhieuMuonTra(pm)){
            return true;
        }
        return false;
    }
    
    public boolean suaPhieuMuonTra(String maPhieuMuon,String maThe,Date ngayMuon,Date hanTra){

        PhieuMuon pm = new PhieuMuon();
        pm.setMaPhieuMuon(maPhieuMuon);
        pm.setMaThe(maThe);
        pm.setNgayMuon(ngayMuon);
        pm.setHanTra(hanTra);
        if(phieuMuonTraDAO.suaPhieuMuonTra(pm)){
            return true;
        }
        return false;
    }
    
    public boolean xoaPhieuMuonTra(String maPhieuMuon){
        if(phieuMuonTraDAO.xoaPhieuMuonTra(maPhieuMuon)){
            return true;
        }
        return false;
    }
    
//--------------------------------------------------------------------------------------------------------------------------
//                                                          Phần phiếu trả sách
//--------------------------------------------------------------------------------------------------------------------------------
    
 
    public ArrayList<PhieuMuon> getPhieuMuonTheoMa(String maThe){
        ArrayList<PhieuMuon> listPM = new ArrayList<>();
        this.listPM = phieuMuonTraDAO.getListPhieuMuonTra();
        for(PhieuMuon pm : this.listPM){
            String[] strPM = pm.getMaThe().split("\\s");
            if(strPM[0].trim().equals(maThe)){
                listPM.add(pm);
                System.out.println(""+pm.getMaThe());
            }
        }
        return listPM;
    }
    
    
    //--------------------------------------------------------------------------------------
    //
    //---------------------------------------------------------------------------------------
    public ArrayList<String> getMaTheMuon(){
        ArrayList<String> maTheList = phieuMuonTraDAO.getListMaThe();
        
        return maTheList;
    }

}
