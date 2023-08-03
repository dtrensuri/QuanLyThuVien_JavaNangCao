/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.BUS;

import MyCustom.MyDialog;
import QLTV.DAO.DocGiaDAO;
import QLTV.DAO.MyConnect;
import QLTV.DTO.DocGia;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chihi
 */
public class DocGiaBUS {
    private ArrayList<DocGia> listDocGia,listDocGiaYeuCau;
    private DocGiaDAO docGiaDAO = new DocGiaDAO();

    public DocGiaBUS() {
        getListDocGia();
    }
    
    public void getListDocGia(){
        this.listDocGia = docGiaDAO.getListDocGia();
    }
    
    public ArrayList<DocGia> getDanhSachDocGia() {
        return docGiaDAO.getListDocGia();
    }
    
    public boolean kiemTraTrungMa(String maThe){
        getDanhSachDocGia();
        for(DocGia dg : listDocGia){
            if(dg.getMaThe().trim().equalsIgnoreCase(maThe)){
                new MyDialog("Mã thẻ đã tồn tại, vui lòng chọn mã khác !!!",MyDialog.ERROR_DIALOG);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<DocGia> getDocGiaYeuCau(String hoTen){
        this.listDocGiaYeuCau = docGiaDAO.getDocGiaYeuCau(hoTen);
        return listDocGiaYeuCau;
    }
    
    public boolean themDocGia(String maThe, String hoTen, Date ngaySinh, String khoa,String nienKhoa, String lop){
        if(kiemTraTrungMa(maThe)){
            return false;
        }
        
        DocGia dg = new DocGia();
        dg.setMaThe(maThe);
        dg.setHoTen(hoTen);
        dg.setNgaySinh(ngaySinh);
        dg.setKhoa(khoa);
        dg.setNienKhoa(nienKhoa);
        dg.setLop(lop);
        
        if(docGiaDAO.themDocGia(dg)){
            new MyDialog("Thêm thông tin độc giả mới thành công !!!", MyDialog.INFO_DIALOG);
            return true;
        }else{
            new MyDialog("Thêm thông tin độc giả mới thất bại !!!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
    public boolean suaDocGia(String maThe, String hoTen, Date ngaySinh, String khoa,String nienKhoa, String lop){

        if (hoTen.equals("")) {
            new MyDialog("Vui lòng nhập họ và tên độc giả !!!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (ngaySinh==null) {
            new MyDialog("Vui lòng nhập ngày sinh của độc giả !!!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (khoa.equals("")) {
            new MyDialog("Vui lòng nhập tên khoa  !!!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (nienKhoa.equals("")) {
            new MyDialog("Vui lòng nhập niên khóa !!!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (lop.equals("")) {
            new MyDialog("Vui lòng nhập tên lớp !!!", MyDialog.ERROR_DIALOG);
            return false;
        }
        DocGia dg = new DocGia();
        dg.setMaThe(maThe);
        dg.setHoTen(hoTen);
        dg.setNgaySinh(ngaySinh);
        dg.setKhoa(khoa);
        dg.setNienKhoa(nienKhoa);
        dg.setLop(lop);
        
        if(docGiaDAO.suaDocGia(dg)){
            new MyDialog("Sửa thông tin độc giả mới thành công !!!", MyDialog.INFO_DIALOG);
            return true;
        }else{
            new MyDialog("Sửa thông tin độc giả mới thất bại !!!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }
    
     public boolean xoaDocGia(String maThe){
        if (maThe.equals("")) {
            new MyDialog("Vui lòng nhập mã thẻ mới !!!", MyDialog.WARNING_DIALOG);
            return false;
        }
        if(docGiaDAO.xoaDocGia(maThe)){
            new MyDialog("Xóa độc giả thành công !!!", MyDialog.SUCCESS_DIALOG);
            return true;
        }else{
            MyDialog mdg = new MyDialog("Độc giả đang sử dụng sách, bạn có muốn xóa thông tin độc giả không ???", MyDialog.ERROR_DIALOG);
            if(mdg.OK_OPTION == mdg.getAction()){
                //tap lenh xoa
            }
            return false;
        }
    }
    
}
