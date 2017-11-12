/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Gerardo
 */
public class Fechas {
    public String obtenerFecha(){
        Date d1 = new Date(System.currentTimeMillis());
        LocalDate ld = d1.toLocalDate();
        return "" + ld.getDayOfMonth()+"/"+ld.getMonthValue()+"/" + ld.getYear();
    }
}
