/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import QLTV.DTO.Sach;
import QLTV.DTO.TacGia;
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
public class TacGiaDAO {
    public ArrayList<TacGia> getListTacGia(){
        ArrayList<TacGia> dstg = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TacGia ORDER BY maTacGia ASC";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();           
            while(rs.next()){
                TacGia tg = new TacGia();
                tg.setMaTacGia(rs.getString(1));
                tg.setTenTacGia(rs.getString(2));
                dstg.add(tg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstg;
    }
    
    public boolean themTacGia(TacGia tg){ 
        try {
            String sql = "INSERT INTO TacGia(maTacGia, tenTacGia) values (?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tg.getMaTacGia());
            pre.setString(2, tg.getTenTacGia()); 
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaTacGia(TacGia tg){
        try {
            String sql = "Update TacGia Set tenTacGia = ? Where maTacGia = ? ";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tg.getTenTacGia());
            pre.setString(2, tg.getMaTacGia());
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
    public boolean xoaTacGia(String maTacGia){
        try {
            String sql = "Delete From TacGia Where maTacGia = '"+maTacGia+"'";
            Statement st = MyConnect.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}