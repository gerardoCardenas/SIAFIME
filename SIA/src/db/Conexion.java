/*

 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    public String db = "sia";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String password = "";
    
    /*
     *
     * @author Gerardo
    Fecha: 28/10/2017.
    Se hace la conexion a la base de datos.
    Copyright Sia.
    */
    
    public Connection conectar()
    {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url,this.user,this.password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " + e);
        }
        return link;
    }
}
