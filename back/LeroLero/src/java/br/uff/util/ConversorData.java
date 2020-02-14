package br.uff.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class ConversorData {
     
    public static Date convert(java.util.Date data) {
        
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = df.format(data);
            
        java.sql.Date newDate = Date.valueOf(stringDate);
        
        return newDate;
    }
    
}
