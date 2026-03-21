package talonarioConsolaServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import talonarioConexion.ConexionMySQL;
import talonarioConsolaModel.talonarioModel;

public class talonarioServicesImpl implements ITalonarioService {

    private ConexionMySQL conexionDB = new ConexionMySQL();

    @Override
    public boolean guardar(talonarioModel talonario) {
        String sql = "INSERT INTO talonario (carnet, descripcion, fecha, estado) VALUES (?, ?, ?, ?)";
        try (Connection con = conexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, talonario.getCarnet());
            ps.setString(2, talonario.getDescripcion());
            ps.setString(3, talonario.getFecha());
            ps.setString(4, talonario.getEstado());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public talonarioModel modificar(talonarioModel talonario) {
        ConexionMySQL conexion = new ConexionMySQL();
  
        String sql = "UPDATE talonario SET descripcion=?, fecha=?, estado=? WHERE carnet=?";
        
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, talonario.getDescripcion());
            ps.setString(2, talonario.getFecha());
            ps.setString(3, talonario.getEstado());
            ps.setString(4, talonario.getCarnet());
            
            int filas = ps.executeUpdate();
            if (filas > 0) return talonario; 
            
        } catch (SQLException e) {
            System.out.println("Error en SQL: " + e);
        }
        return null;
    }

    @Override
    public List<talonarioModel> recuperarTalonarios() {
        List<talonarioModel> lista = new LinkedList<>();
        String sql = "SELECT * FROM talonario";
        try (Connection con = conexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                talonarioModel t = new talonarioModel();
                t.setId(rs.getInt("id"));
                t.setCarnet(rs.getString("carnet"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setFecha(rs.getString("fecha"));
                t.setEstado(rs.getString("estado"));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar lista: " + e.getMessage());
        }
        return lista;
    }

  
    
    @Override
    public boolean eliminar(talonarioModel talonario) {
        String sql = "DELETE FROM talonario WHERE id = ?";
        try (Connection con = conexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, talonario.getId());
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public talonarioModel recuperar(talonarioModel talonario) {
        String sql = "SELECT * FROM talonario WHERE id = ?";
        try (Connection con = conexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, talonario.getId());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                talonarioModel t = new talonarioModel();
                t.setId(rs.getInt("id"));
                t.setCarnet(rs.getString("carnet"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setFecha(rs.getString("fecha"));
                t.setEstado(rs.getString("estado"));
                return t;
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar uno: " + e.getMessage());
        }
        return null;
    }
}