/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import MyCustom.MyDateFormat;
import QLTV.DTO.PhieuMuon;
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
public class PhieuMuonTraDAO {
    
    public ArrayList<PhieuMuon> getListPhieuMuonTra(){
        ArrayList<PhieuMuon> listPM = new ArrayList<>();
        try {
            String sql = "select PM.maPhieuMuon, CONCAT(DG.maThe,' ',DG.hoTen),PM.ngayMuon,PM.hanTra\n" +
                "FROM PhieuMuon AS PM, DocGia AS DG\n" +
                "WHERE PM.maThe = DG.maThe";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();

                pm.setMaPhieuMuon(rs.getString(1));
                pm.setMaThe(rs.getString(2));
                pm.setNgayMuon(rs.getDate(3));
                pm.setHanTra(rs.getDate(4));

                listPM.add(pm);
            }
            return listPM;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
 
    public ArrayList<String> getListTimKiemMuonTra(int a){
        ArrayList<String> listPM = new ArrayList<>();
        try {
            String sql = "SELECT PM.maPhieuMuon, concat(DG.maThe,' ',DG.hoTen) as 'Họ và tên',S.tenSach,PM.ngayMuon, PM.hanTra, CTPM.soLuong, CTPM.tienCuoc, CTPM.tinhTrang "
                    + "FROM PHIEUMUON AS PM, ChiTietPhieuMuon AS CTPM, DocGia AS DG, Sach AS S "
                    + "WHERE PM.maPhieuMuon = CTPM.maPhieuMuon AND PM.maThe = DG.maThe AND CTPM.maSach=S.maSach ";
            if(a==1){
                sql+="ORDER BY PM.ngayMuon ASC";
            }
            if(a==2){
                sql+="ORDER BY PM.hanTra ASC";
            }
            if( a==3){
                sql+="ORDER BY CTPM.soLuong ASC";
            }
            if( a==4){
                sql+="ORDER BY CTPM.tienCuoc ASC";
            }
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            
            while (rs.next()) {
                String str = rs.getString(1)+"_"+rs.getString(2)+"_"+rs.getString(3)+"_"+
                        MyDateFormat.getStringToDate(rs.getDate(4))+"_"+MyDateFormat.getStringToDate(rs.getDate(5))+"_"+rs.getInt(6)+"_"+rs.getInt(7)+"_"+rs.getByte(8);
                listPM.add(str);
            }
            return listPM;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    ------------------------------------------------------------------------
//                              Phan edit phieu muon
//    ------------------------------------------------------------------------
    public ArrayList<PhieuMuon> getPhieuMuonTra(){
        ArrayList<PhieuMuon> dspm = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PhieuMuon";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPhieuMuon(rs.getString(1));
                pm.setMaThe(rs.getString(2));
                pm.setNgayMuon(rs.getDate(3));
                pm.setHanTra(rs.getDate(4));
                
                dspm.add(pm);
            }
            return dspm;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dspm;
    }
    
    public boolean themPhieuMuonTra(PhieuMuon pm){
        try {
            String sql = "INSERT INTO PhieuMuon(maPhieuMuon,maThe,ngayMuon,hanTra) VALUES (?,?,?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, pm.getMaPhieuMuon());
            pre.setString(2, pm.getMaThe());
            pre.setTimestamp(3, new Timestamp(pm.getNgayMuon().getTime()));
            pre.setTimestamp(4, new Timestamp(pm.getHanTra().getTime()));
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaPhieuMuonTra(PhieuMuon pm){
        try {
            String sql = "UPDATE PhieuMuon SET maThe=?, ngayMuon=?, hanTra=? WHERE maPhieuMuon=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            
            pre.setString(1, pm.getMaThe());
            pre.setTimestamp(2, new Timestamp(pm.getNgayMuon().getTime()));
            pre.setTimestamp(3, new Timestamp(pm.getHanTra().getTime()));
            pre.setString(4, pm.getMaPhieuMuon());
            
            return pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoaPhieuMuonTra(String maPM){
        try {
            String sql = "DELETE FROm PhieuMuon WHERE maPhieuMuon = '"+maPM+"'";
            Statement st = MyConnect.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
   //
    public ArrayList<String> getListMaThe(){
        ArrayList<String> listMT = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT maThe FROM `phieumuon`";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            
            while (rs.next()) {
                listMT.add(rs.getString(1));
            }
            return listMT;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
