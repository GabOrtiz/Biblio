
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class Conectar {
    
    
    
    public static Connection conectar(){
        Properties p = new Properties();
        try {
            
            p.load(new FileInputStream("propriedades.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(p);
        String url = p.getProperty("url");
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, p);
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
