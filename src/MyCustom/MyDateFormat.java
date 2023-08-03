/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCustom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chihi
 */
public class MyDateFormat {
    public static String getStringToDate(Date date){
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        return fm.format(date);
    }
    
    public static Date getDateToString(String date){
        try {
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
            return fm.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MyDateFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
