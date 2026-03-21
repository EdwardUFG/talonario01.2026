package talonarioConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private final String user = "user01";
    private final String password = "contra123";
    private final String url = "jdbc:mysql://127.0.0.1:3306/talonario";
    private Connection con = null;

    public Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    public void close() {
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar");
        }
    }
}