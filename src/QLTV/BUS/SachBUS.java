/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.SachDAO;
import QLTV.DTO.Sach;
import java.util.ArrayList;

/**
 *
 * @author chihi
 */
public class SachBUS {
    private  ArrayList<Sach> listSach = new ArrayList<>();   
    private final  SachDAO sachDAO = new SachDAO(); 
    
    public SachBUS() {
        getDuLieuSach();
        
    }
    
    public ArrayList<Sach> getDuLieuSach(){
        listSach = sachDAO.getListSach();
        return listSach;
    }
    
    public ArrayList<Sach> docDuLieuTimKiemSach(String ma,String NXB,boolean tg, boolean nxb){ 
        listSach = sachDAO.getListSachTheoMa(ma,NXB,tg,nxb);
        return listSach;
    }
    
    public ArrayList<String> getListNXB(){
        ArrayList<String> listTenNXB = sachDAO.getListNXB();
        return listTenNXB;
    }
     
    
    //kiểm tra trùng mã: trùng thì trả về true, không trùng hay mã nhập rỗng thì trả về false
    public boolean kiemTraTrungMaSach(String ma){
        getDuLieuSach();
        ArrayList<String> listMaSach = new ArrayList<>();
        for(Sach a : listSach){
            listMaSach.add(a.getMaSach());
        }
        
        for(String b : listMaSach){
            if(b.trim().equalsIgnoreCase(ma)){
                new MyDialog("Trùng mã sách, vui lòng chọn mã khác !!!", MyDialog.WARNING_DIALOG);
                return true;
            }
        }
        
        return false;
    }
    
    //xem theo: 1-So Luong, 2-Gia Tien, 3-TenSach
    public ArrayList<Sach> getListMinMaxSoGia(String selectedItem){
        if(selectedItem == " "){
            new MyDialog("Vui lòng chọn yêu cầu !!!", MyDialog.ERROR_DIALOG);
        }else{
            switch(selectedItem){
                case "ASC của số lượng":
                    listSach = sachDAO.getListMinMaxSoGia(true,1);
                    break;
                case "DESC của số lượng":
                    listSach = sachDAO.getListMinMaxSoGia(false,1);
                    break;
                case "ASC của giá tiền":
                    listSach = sachDAO.getListMinMaxSoGia(true,2);
                    break;
                case "DESC của giá tiền":
                    listSach = sachDAO.getListMinMaxSoGia(false,1);
                    break;
                case "ASC của tên sách":
                    listSach = sachDAO.getListMinMaxSoGia(true,3);
                    break;                       
            }
        }   
        return listSach;
    }
    
    
    //Them sách mới 
    //sử dụng phương thức toUpperCase() để in hoa các ký tự trong chuỗi
    public boolean themSachMoi(String maSach, String maTacGia, String tenSach, String nhaXuatBan, String soLuong, String giaTien){

        if(kiemTraTrungMaSach(maSach)){
            new MyDialog("Mã sách đã tồn tại", MyDialog.ERROR_DIALOG);
            return false;
        }

        Sach sach = new Sach();
        sach.setMaSach(maSach.toUpperCase());
        sach.setMaTacGia(maTacGia.toUpperCase());
        sach.setTenSach(tenSach);
        sach.setNxb(nhaXuatBan);
        sach.setSoLuong(Integer.parseInt(soLuong));
        sach.setGiaTien(Integer.parseInt(giaTien));

        if(sachDAO.themSach(sach) ){  
            return true;
        }else{
            return false; 
        }
    }
    
    public boolean xoaSach(String maSach){
        //trim() :Phương thức trim() được sử dụng để xóa khoảng trẳng ở đầu và cuối chuỗi
        if(maSach.trim().equals(" ")){
            new MyDialog("Vui lòng chọn sách muốn xóa !",MyDialog.ERROR_DIALOG);
            return false;
        }
        MyDialog md = new MyDialog("Bạn có thực sự muốn xóa sách mã "+maSach+" khoong ?", MyDialog.WARNING_DIALOG);
        if(md.getAction() == md.OK_OPTION){
            if(sachDAO.xoaSach(maSach)){
//                new MyDialog("Xóa sách mã "+maSach+" thành công !",MyDialog.INFO_DIALOG);
                return true;
             }else{
//                new MyDialog("Xóa thất bại !",MyDialog.ERROR_DIALOG);
                return false;
            }   
        }
        return false;
    }
    
    public boolean suaSach(String maSach,String maTacGia, String tenSach, String nhaXuatBan, String soLuong, String giaTien){
   

        Sach sach = new Sach();
        sach.setMaSach(maSach.toUpperCase());
        sach.setMaTacGia(maTacGia.toUpperCase());
        sach.setTenSach(tenSach);
        sach.setNxb(nhaXuatBan);
        sach.setSoLuong(Integer.parseInt(soLuong));
        sach.setGiaTien(Integer.parseInt(giaTien));
        
        if(sachDAO.suaSach(sach)){
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<String> getListTenSach(){
        getDuLieuSach();
        ArrayList<String> lstTenSach = new ArrayList<>();
        for(Sach s : listSach){
            lstTenSach.add(s.getMaSach()+" "+s.getTenSach());
        }
        return lstTenSach;
    }
    
    
}
