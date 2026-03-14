package talonarioConsolaServices; 

import java.util.List;
// Corregido: Importamos el paquete y la clase correcta
import talonarioConsolaModel.talonarioModel; 

public interface ITalonarioService {
    
    // Corregido: Cambiamos "Talonario" por "talonarioModel"
    public boolean guardar(talonarioModel talonario);
    
    public talonarioModel recuperar(talonarioModel talonario);
    
    public List<talonarioModel> recuperarTalonarios();
    
    public talonarioModel modificar(talonarioModel talonario);
    
    public boolean eliminar(talonarioModel talonario);
}