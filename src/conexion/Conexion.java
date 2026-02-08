package conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection conex = null;

    public static Connection establecerConexion() {
        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            
            conex = DriverManager.getConnection(url, "system", "system");

            //JOptionPane.showMessageDialog(null,
            //        "Conexión exitosa a Oracle");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error de conexión a Oracle:\n" + e.getMessage());
        }
        return conex;
    }

    public static void main(String[] args) {
        establecerConexion();
    }
}