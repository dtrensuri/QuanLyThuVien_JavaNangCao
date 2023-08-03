/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.ThongKeDAO;
/**
 *
 * @author chihi
 */
public class ThongKeBUS {
     private ThongKeDAO thongKeDAO = new ThongKeDAO();
    public int getTongSachKho() {
        return thongKeDAO.getTongSachKho();
    }
    
    public int getTongSoDauSach() {
        int tg = thongKeDAO.getTongSoDauSach();
        if(tg==0){
            new MyDialog("Thông tin cập nhật bị lỗi",MyDialog.ERROR_DIALOG);
            return 0;
        }
        return tg;
    }
    
    public int getSoSachMuon(int nam, int quy) {
        if(nam==0){
            new MyDialog("Bạn chưa xác nhận năm thống kê",MyDialog.ERROR_DIALOG);
            return 0;
        }
        return thongKeDAO.getSoSachMuon(nam,quy);
    }
    
    public int getSoSachHong(int nam, int quy) {
        if(nam==0){
            new MyDialog("Bạn chưa xác nhận năm thống kê",MyDialog.ERROR_DIALOG);
            return 0;
        }
        return thongKeDAO.getSoSachHong(nam,quy);
    }
    
}
