package talonarioConsola;

import java.sql.Connection;
import talonarioConexion.ConexionMySQL; // Importamos tu clase de conexión

public class PruebaConexion {

    public static void main(String[] args) {
        System.out.println("--- Iniciando prueba de conexión a MySQL ---");
        
    
        ConexionMySQL db = new ConexionMySQL();
        
        try {
           
            Connection con = db.getConexion();
            
           
            if (con != null) {
                System.out.println("Se ha establecido la conexión con 'talonario'.");
                
              
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            } else {
                System.out.println("Error en la conexión ");
            }
            
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado:");
            e.printStackTrace();
        }
    }
}