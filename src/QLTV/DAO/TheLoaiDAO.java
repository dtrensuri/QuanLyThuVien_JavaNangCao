/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import QLTV.DTO.TheLoai;
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
public class TheLoaiDAO {
    public ArrayList<TheLoai> getListTheLoai(){
        ArrayList<TheLoai> dstl = new ArrayList<>();
        try {
            String sql = " SELECT * FROM TheLoai";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();           
            while(rs.next()){
                TheLoai tl = new TheLoai();           
                tl.setMaTheLoai(rs.getString(1));
                tl.setTenTheLoai(rs.getString(2));
                dstl.add(tl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstl;
    }
    
    public ArrayList<String> getTenTheLoai(){
        ArrayList<String> ttl = new ArrayList<>();
        try {
            String sql = "SELECT tenTheLoai FROM TheLoai";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();           
            while(rs.next()){
                ttl.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ttl;
    }
    
    public boolean themTheLoai(TheLoai tl){
        try {
            String sql = "Insert into TheLoai(maTheLoai,tenTheLoai) Values(?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tl.getMaTheLoai());
            pre.setString(2, tl.getTenTheLoai());
            
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaTheLoai(TheLoai tl){
        
        try {
            String sql = "Update TheLoai Set tenTheLoai = ? Where maTheLoai = ?  ";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tl.getTenTheLoai());
            pre.setString(2, tl.getMaTheLoai());
                      
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoaTheLoai(String maTheLoai){
        try {
            String sql = "Delete From TheLoai Where maTheLoai = '"+maTheLoai+"'";
            Statement st = MyConnect.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
    
     
     
  
}
