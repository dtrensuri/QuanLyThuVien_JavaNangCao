/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import QLTV.DTO.ChiTietPhieuMuon;
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
public class ChiTietPhieuMuonTraDAO {
    public ArrayList<ChiTietPhieuMuon> getListCTPM() {
        ArrayList<ChiTietPhieuMuon> dsctpm = new ArrayList<>();
        try {     
            String sql = "SELECT * FROM ChiTietPhieuMuon";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
                ctpm.setMaPhieuMuon(rs.getString(1));
                ctpm.setMaSach(rs.getString(2));
                ctpm.setSoLuong(rs.getInt(3));
                ctpm.setTienCuoc(rs.getInt(4));
                if(String.valueOf(rs.getByte(5)).trim().equalsIgnoreCase("0")){
                    ctpm.setTinhTrang("Chưa trả");
                }else{
                    ctpm.setTinhTrang("Đã trả");
                }
                
                dsctpm.add(ctpm);
            }
            return dsctpm;        
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    
    public ArrayList<ChiTietPhieuMuon> getListCTPMAndSach() {
        ArrayList<ChiTietPhieuMuon> dsctpm = new ArrayList<>();
        try {     
            String sql = "SELECT CTPM.maPhieuMuon,CONCAT(S.maSach,'_',S.tenSach),CTPM.soLuong,CTPM.tienCuoc,CTPM.tinhTrang FROM ChiTietPhieuMuon AS CTPM, Sach AS S WHERE CTPM.maSach = S.maSach";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
                ctpm.setMaPhieuMuon(rs.getString(1));
                ctpm.setMaSach(rs.getString(2));
                ctpm.setSoLuong(rs.getInt(3));
                ctpm.setTienCuoc(rs.getInt(4));
                if(String.valueOf(rs.getByte(5)).trim().equalsIgnoreCase("0")){
                    ctpm.setTinhTrang("Chưa trả");
                }else{
                    ctpm.setTinhTrang("Đã trả");
                }
                dsctpm.add(ctpm);
            }
            return dsctpm;        
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    
    
    public ArrayList<String> getListMaSach(){
        ArrayList<String> listMS = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT maSach FROM chitietphieumuon where tinhTrang = '1'";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            
            while (rs.next()) {
                listMS.add(rs.getString(1));
            }
            return listMS;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public boolean themChiTietPhieuMuon(ChiTietPhieuMuon ctpm){
        try {
            String sql = "INSERT INTO ChiTietPhieuMuon(maPhieuMuon,maSach,soLuong,tienCuoc,tinhTrang) VALUES (?,?,?,?,?) ";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, ctpm.getMaPhieuMuon());
            pre.setString(2, ctpm.getMaSach());
            pre.setInt(3, ctpm.getSoLuong());
            pre.setInt(4, ctpm.getTienCuoc());
            pre.setByte(5, Byte.parseByte(ctpm.getTinhTrang()));
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaChiTietPhieuMuon(ChiTietPhieuMuon ctpm){
        try {
            String sql = "UPDATE ChiTietPhieuMuon SET soLuong=?, tienCuoc=?, tinhTrang=? WHERE  maPhieuMuon=? AND maSach = ?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            
            pre.setInt(1, ctpm.getSoLuong());
            pre.setInt(2, ctpm.getTienCuoc());
            pre.setByte(3, Byte.parseByte(ctpm.getTinhTrang()));
            pre.setString(4, ctpm.getMaPhieuMuon());
            pre.setString(5, ctpm.getMaSach());
            
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoaChiTietPhieuMuon(String mapm ,String mas){
        try {
            String sql = "DELETE FROM ChiTietPhieuMuon WHERE ";
            if(mapm == ""){
                sql+="maSach = '"+mas+"'";
            }
            if(mas == ""){
                sql+="maPhieuMuon = '"+mapm+"'";
            }
            if(mapm.equals("")==false && mas.equals("")==false){
                sql+="maPhieuMuon = '"+mapm+"' AND maSach = '"+mas+"'";
            }
            Statement st = MyConnect.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
