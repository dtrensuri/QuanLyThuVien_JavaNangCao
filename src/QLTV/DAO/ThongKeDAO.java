/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author chihi
 */
public class ThongKeDAO {
     public int getTongSachKho() {
        try {
            String sql = "select sum(soluong)from sach";
            Statement pre = MyConnect.conn.createStatement();
            ResultSet rs = pre.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int getTongSoDauSach() {
        try {
            String sql = "select count(maSach) from sach";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int a = 0;
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException ex) {
        }
        return 0;
    }
    
    public int getSoSachMuon(int nam, int quy) {
        try {
            String quyThang = "";
            switch(quy){
                case 1 :
                    quyThang = "1,2,3";
                    break;
                case 2 :
                    quyThang = "4,5,6";
                    break;
                case 3 :
                    quyThang = "7,8,9";
                    break;
                case 4 :
                    quyThang = "10,11,12";
                    break;
            }
            String sql = "select sum(ctpm.soluong) from ChiTietPhieuMuon as ctpm , PhieuMuon as pm\n" +
"where ctpm.maPhieuMuon = pm.maPhieuMuon AND YEAR(pm.ngayMuon) = '"+nam+"' AND Month(pm.ngayMuon) IN ("+quyThang+")";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int a = 0;
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException ex) {
        }
        return 0;
    }
    
    public int getSoSachHong(int nam, int quy) {
        try {
            String quyThang = "";
            switch(quy){
                case 1 :
                    quyThang = "1,2,3";
                    break;
                case 2 :
                    quyThang = "4,5,6";
                    break;
                case 3 :
                    quyThang = "7,8,9";
                    break;
                case 4 :
                    quyThang = "10,11,12";
                    break;
            }
            String sql = "Select sum(SL)\n" +
                "from (\n" +
                "	Select count(pp.maPhieuPhat) as 'SL'\n" +
                "	from PhieuPhat as pp Left Join ChiTietPhieuPhat as ctpp On pp.maPhieuPhat = ctpp.maPhieuPhat\n" +
                "	Where ctpp.lyDo not like N'%Trả muộn' AND YEAR(pp.ngayLap)='"+nam+"' AND Month(pp.ngayLap) IN ("+quyThang+")\n" +
                "	group by pp.maPhieuPhat\n" +
                "	)as subquery";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int a = 0;
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException ex) {
        }
        return 0;
    }
}
