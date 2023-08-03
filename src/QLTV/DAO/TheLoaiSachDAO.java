/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import QLTV.BUS.TheLoaiSachBUS;
import QLTV.DTO.TheLoaiSach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chihi
 */
public class TheLoaiSachDAO {
     public boolean themTheLoaiSach(TheLoaiSach tls) {
        try {
            String sql = "INSERT INTO TheLoaiSach(maTheLoai, maSach) values (?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tls.getMaTheLoai());
            pre.setString(2, tls.getMaSach());

            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSachBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
    //(ma,true) xoá dữ liệu ở bảng thể loại sách có mã sách : ...
     //(ma,false) xóa dữ liệu ở bảng thể loại sách có mã thể loại : ...
    public boolean xoaTheLoaiSach(String ma, boolean maSach) {
        try {
             String sql;
            if(maSach){
                sql = "Delete From TheLoaiSach Where MaSach = '"+ma+"'";
            }else{
                sql = "Delete From TheLoaiSach Where MaTheLoai = '"+ma+"'";
            }            
            Statement st = MyConnect.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSachBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaTheLoaiSach(TheLoaiSach tls) {
        try {
            String sql = "Update TheLoaiSach Set maTheLoai = ? Where maSach = ? ";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tls.getMaTheLoai());
            pre.setString(2, tls.getMaSach());
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSachBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<TheLoaiSach> getListTheLoaiSach(){
        ArrayList<TheLoaiSach> listTheLoaiSach = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM TheLoaiSach";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                TheLoaiSach tls = new TheLoaiSach();
                tls.setMaTheLoai(rs.getString(1));
                tls.setMaSach(rs.getString(2));
                listTheLoaiSach.add(tls);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTheLoaiSach;
    }
}
