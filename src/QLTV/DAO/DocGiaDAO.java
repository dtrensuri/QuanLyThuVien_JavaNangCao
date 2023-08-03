/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import QLTV.DTO.DocGia;
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
public class DocGiaDAO {
    
    public ArrayList<DocGia> getListDocGia() {
        ArrayList<DocGia> dsdocgia = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DocGia";       
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                DocGia dg = new DocGia();
                dg.setMaThe(rs.getString(1));
                dg.setHoTen(rs.getString(2));
                dg.setNgaySinh(rs.getDate(3));
                dg.setKhoa(rs.getString(4));
                dg.setNienKhoa(rs.getString(5));
                dg.setLop(rs.getString(6));
                
                dsdocgia.add(dg);
            }
            return dsdocgia;
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;           
    }
    
    public ArrayList<DocGia> getDocGiaYeuCau(String hoTen) {
        ArrayList<DocGia> dsdocgia = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DocGia WHERE HoTen LIKE '%"+hoTen+"'";       
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                DocGia dg = new DocGia();
                dg.setMaThe(rs.getString(1));
                dg.setHoTen(rs.getString(2));
                dg.setNgaySinh(rs.getDate(3));
                dg.setKhoa(rs.getString(4));
                dg.setNienKhoa(rs.getString(5));
                dg.setLop(rs.getString(6));
                
                dsdocgia.add(dg);
            }
            return dsdocgia;
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;           
    }

    public boolean themDocGia(DocGia dg){
        try {
            String sql ="INSERT INTO DocGia(MaThe, HoTen, NgaySinh, Khoa, NienKhoa, Lop) VALUES(?,?,?,?,?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, dg.getMaThe());
            pre.setString(2, dg.getHoTen());
            pre.setTimestamp(3, new Timestamp(dg.getNgaySinh().getTime()));
            pre.setString(4, dg.getKhoa());
            pre.setString(5, dg.getNienKhoa());
            pre.setString(6, dg.getLop());
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaDocGia(DocGia dg){
        try {
            String sql ="UPDATE DocGia SET HoTen=?, NgaySinh=?, Khoa=?, NienKhoa=?, Lop=? WHERE MaThe=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            
            pre.setString(1, dg.getHoTen());
            pre.setTimestamp(2, new Timestamp(dg.getNgaySinh().getTime()));
            pre.setString(3, dg.getKhoa());
            pre.setString(4, dg.getNienKhoa());
            pre.setString(5, dg.getLop());
            pre.setString(6, dg.getMaThe());
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoaDocGia(String maDG){
        try {
            String sql = "DELETE FROM DocGia WHERE MaThe = ?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, maDG);
            return pre.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
