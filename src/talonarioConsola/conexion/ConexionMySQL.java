package talonarioConsola.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMySQL {

    private final String user = "user01";                                    //Su usuario
    private final String password = "contra123";                              //Su contraseña
    private final String url = "jdbc:mysql://127.0.0.1:3306/talonario";      //Su BDD (registro)
    private final String driver = "com.mysql.cj.jdbc.Driver";                //Driver de mySQL
    private Connection con = null;

    public Connection getConexion() throws SQLException {  //Metodo para devolver la conexion
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(this.url, this.user, this.password);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
    public void close() { // meotodo para cerrar la conexion
        try {
            con.close();
        } catch (SQLException ex) {
       System.out.println("Error de conexion");  
        }
    }
}