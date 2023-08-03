/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import QLTV.DTO.ChiTietPhieuPhat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chihi
 */
public class ChiTietPhieuPhatDAO {
    public ArrayList<ChiTietPhieuPhat> getListChiTietPP() {
        ArrayList<ChiTietPhieuPhat> dsChiTietPP = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ChiTietPhieuPhat";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                ChiTietPhieuPhat ctpp = new ChiTietPhieuPhat();
                ctpp.setMaPhieuPhat(rs.getString(1));
                ctpp.setMaSach(rs.getString(2));
                ctpp.setTienPhat(rs.getInt(3));
                ctpp.setLyDo(rs.getString(4));
                ctpp.setXuLy(rs.getString(5));
              
                dsChiTietPP.add(ctpp);
            }
            return dsChiTietPP;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuPhatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean themChiTietPP(ChiTietPhieuPhat ctpp){
        try {
            String sql ="INSERT INTO ChiTietPhieuPhat(MaPhieuPhat, MaSach, TienPhat, LyDo, XuLy) VALUES(?,?,?,?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, ctpp.getMaPhieuPhat());
            pre.setString(2, ctpp.getMaSach());
            pre.setInt(3, ctpp.getTienPhat());
            pre.setString(4, ctpp.getLyDo());
            pre.setString(5, ctpp.getXuLy());
            
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuPhatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaChiTietPP(ChiTietPhieuPhat ctpp){
        try {
            String sql = "Update ChiTietPhieuPhat SET TienPhat = ?, LyDo = ?, XuLy=? Where MaPhieuPhat = ? AND MaSach = ?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            
            
            pre.setInt(1, ctpp.getTienPhat());
            pre.setString(2, ctpp.getLyDo());
            pre.setString(3, ctpp.getXuLy());
            pre.setString(4, ctpp.getMaPhieuPhat());
            pre.setString(5, ctpp.getMaSach());
            
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuPhatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoaCTPP(String maPhieuPhat,String maSach){
        try {
            String sql = "Delete From ChiTietPhieuPhat Where MaPhieuPhat = ? AND MaSach = ?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            
            pre.setString(1, maPhieuPhat);
            pre.setString(2, maSach);
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuPhatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
