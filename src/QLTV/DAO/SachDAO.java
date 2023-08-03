/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import QLTV.DTO.Sach;
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
public class SachDAO {

    public ArrayList<Sach> getListSach() {
        ArrayList<Sach> dssach = new ArrayList<>();
        try {
            String sql = "SELECT S.maSach, CONCAT(TG.maTacGia,'_',TG.tenTacGia) AS 'Tên tác giả', S.tenSach, S.nhaXuatBan, S.soLuong, S.giaTien FROM TACGIA AS TG, SACH AS S WHERE TG.maTacGia = S.maTacGia";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();

                s.setMaSach(rs.getString(1));
                s.setMaTacGia(rs.getString(2));
                s.setTenSach(rs.getString(3));
                s.setNxb(rs.getString(4));
                s.setSoLuong(rs.getInt(5));
                s.setGiaTien(rs.getInt(6));

                dssach.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dssach;
    }

    //xem theo: 1-So Luong, 2-Gia Tien, 3-TenSach
    //ASC : tăng dần, DESC : Giảm dần
    public ArrayList<Sach> getListMinMaxSoGia(boolean tangDan, int xemTheo) {
        ArrayList<Sach> dssach = new ArrayList<>();
        try {
            String sql = "SELECT S.maSach, CONCAT(TG.maTacGia,'_',TG.tenTacGia) AS 'Tên tác giả', S.tenSach, S.nhaXuatBan, S.soLuong, S.giaTien FROM TACGIA AS TG, SACH AS S WHERE TG.maTacGia = S.maTacGia";
            if (tangDan == true && xemTheo == 1) {
                sql += " ORDER BY S.soLuong ASC ";
            } else if (tangDan == false && xemTheo == 1) {
                sql += " ORDER BY S.soLuong DESC ";
            } else if (tangDan == true && xemTheo == 2) {
                sql += " ORDER BY S.giaTien ASC ";
            } else if (tangDan == true && xemTheo == 2) {
                sql += " ORDER BY S.giaTien ASC ";
            } else {
                sql += " ORDER BY S.tenSach ASC ";
            }
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();

                s.setMaSach(rs.getString(1));
                s.setMaTacGia(rs.getString(2));
                s.setTenSach(rs.getString(3));
                s.setNxb(rs.getString(4));
                s.setSoLuong(rs.getInt(5));
                s.setGiaTien(rs.getInt(6));

                dssach.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dssach;
    }

    public ArrayList<Sach> getListSachTheoMa(String ma, String NXB, boolean tg, boolean nxb) {
        ArrayList<Sach> dssach = new ArrayList<>();
        try {
            String sql = "SELECT S.maSach, CONCAT(TG.maTacGia,'_',TG.tenTacGia) AS 'Tên tác giả', S.tenSach, S.nhaXuatBan, S.soLuong, S.giaTien FROM TACGIA AS TG, SACH AS S WHERE TG.maTacGia = S.maTacGia ";
            if (tg == true && nxb == false) {
                sql = sql + "AND TG.tenTacGia Like N'%" + ma + "%' ";
            } else if (tg == false && nxb == true) {
                sql = sql + "AND S.nhaXuatBan Like N'%" + NXB + "%' ";
            } else if (tg == true && nxb == true) {
                sql = sql + "AND TG.tenTacGia Like N'%" + ma + "%' AND S.nhaXuatBan Like N'%" + NXB + "%' ";
            } else {
                sql += "AND S.maSach = '" + ma + "' ";
            }
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();

                s.setMaSach(rs.getString(1));
                s.setMaTacGia(rs.getString(2));
                s.setTenSach(rs.getString(3));
                s.setNxb(rs.getString(4));
                s.setSoLuong(rs.getInt(5));
                s.setGiaTien(rs.getInt(6));

                dssach.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dssach;
    }

    public ArrayList<String> getListNXB(){
        ArrayList<String> dsNXB = new ArrayList<>();
        try {
            String sql = " SELECT nhaXuatBan FROM Sach GROUP BY nhaXuatBan";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                dsNXB.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNXB;
    }
            
    public boolean themSach(Sach s) {
        try {
            String sql = "INSERT INTO Sach(maSach, maTacGia, tenSach, nhaXuatBan, soLuong, giaTien) values (?,?,?,?,?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, s.getMaSach());
            pre.setString(2, s.getMaTacGia());
            pre.setString(3, s.getTenSach());
            pre.setString(4, s.getNxb());
            pre.setInt(5, s.getSoLuong());
            pre.setInt(6, s.getGiaTien());

            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean suaSach(Sach s) {
        try {
            String sql = "Update Sach Set maTacGia = ? , tenSach = ? , nhaXuatBan = ?, soLuong = ?, giaTien = ? Where MaSach = ? ";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, s.getMaTacGia());
            pre.setString(2, s.getTenSach());
            pre.setString(3, s.getNxb());
            pre.setInt(4, s.getSoLuong());
            pre.setInt(5, s.getGiaTien());
            pre.setString(6, s.getMaSach());

            pre.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean xoaSach(String maSach) {
        try {
            String sql = "Delete From Sach Where MaSach = '"+maSach+"'";
            Statement st = MyConnect.conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

//boolean execute (String SQL): Trả về giá trị true nếu thực thi thành công câu lệnh SQL; 
//ngược lại sẽ trả về giá trị false. Sử dụng phương thức này để thực thi các câu lệnh SQL DDL như tạo cơ sở dữ liệu, tạo bảng, …
//int executeUpdate (String SQL): Trả về số dòng bị tác động khi thực thi các câu lệnh như INSERT, UPDATE hoặc DELETE.
//ResultSet executeQuery (String SQL): Trả về một đối tượng ResultSet khi bạn thực thi câu lệnh SELECT.


//Giao diện PreparedStatement là một giao diện con của Statement. Nó được sử dụng để thực hiện truy vấn được tham số hóa.
//Chuỗi sql= "chèn vào giá trị emp(?,?,?)" ;  