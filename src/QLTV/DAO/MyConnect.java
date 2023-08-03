/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chihi
 */
public class MyConnect {
    
    public static Connection conn = null;

    public MyConnect() {             
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/csdl_qltv","root", "");
            if (conn!= null) {
                System.out.println("Kết nối thành công"); }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
