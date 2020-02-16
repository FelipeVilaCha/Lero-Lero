package br.uff.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class ConversorData {
     
    public static Date convertToUtil(String data) throws ParseException {
        Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(data);
        return newDate;
    }
    
    public static java.sql.Date convertToSQL(java.util.Date data) throws ParseException {
        java.sql.Date newDate = new java.sql.Date(data.getTime());
        return newDate;
    }
    
}
