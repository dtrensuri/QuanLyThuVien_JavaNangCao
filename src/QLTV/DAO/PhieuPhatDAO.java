/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import QLTV.DTO.PhieuPhat;
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
public class PhieuPhatDAO {
    public ArrayList<PhieuPhat> getListPhieuPhat() {
        ArrayList<PhieuPhat> dsPhieuPhat = new ArrayList<>();
        try {

            String sql = "SELECT * FROM PhieuPhat";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                PhieuPhat pp = new PhieuPhat();
                pp.setMaPhieuPhat(rs.getString(1));
                pp.setMaThe(rs.getString(2));
                pp.setNgayLap(rs.getDate(3));
              
                dsPhieuPhat.add(pp);
            }
            return dsPhieuPhat;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean themPhieuPhat(PhieuPhat pp){
        try {
            String sql ="INSERT INTO phieuphat (maPhieuPhat,maThe,ngayLap) VALUES (?,?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, pp.getMaPhieuPhat().toUpperCase());
            pre.setString(2, pp.getMaThe());
            pre.setTimestamp(3, new Timestamp(pp.getNgayLap().getTime()));
            
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaPhieuPhat(PhieuPhat pp){
        try {
            String sql = "Update PhieuPhat SET NgayLap = ? Where MaPhieuPhat = ? AND MaThe = ? ";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            
            
            pre.setTimestamp(1, new Timestamp(pp.getNgayLap().getTime()));
            pre.setString(2, pp.getMaPhieuPhat());
            pre.setString(3, pp.getMaThe());
            
            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoaPhieuPhat(String maPhieuPhat){
        try {
            String sql = "DELETE FROM phieuphat WHERE maPhieuPhat = '"+maPhieuPhat+"'";
            Statement st = MyConnect.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
//    public static void main(String[] args) {
//        new MyConnect();
//        PhieuPhatDAO ppd = new PhieuPhatDAO();
//        ArrayList<PhieuPhat> lpp = ppd.getListPhieuPhat();
//        for(PhieuPhat pp : lpp){
//            System.out.println(""+pp.getMaThe());
//        }
//    }
}
