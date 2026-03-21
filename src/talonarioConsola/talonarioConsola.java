package talonarioConsola;

import talonarioConsolaModel.talonarioModel;
import talonarioConsolaServices.talonarioServicesImpl;

public class talonarioConsola {

    public static void main(String[] args) { 
        System.out.println("--- Iniciando Proceso de Guardado ---");
        
    
        talonarioModel nuevoTalonario = new talonarioModel();
        nuevoTalonario.setCarnet("PG101524");
        nuevoTalonario.setDescripcion("Matricula, cuota 1");
        nuevoTalonario.setFecha("21-03-2026");
        nuevoTalonario.setEstado("A");

        talonarioServicesImpl servicio = new talonarioServicesImpl();
        boolean exito = servicio.guardar(nuevoTalonario);
        
      
        if(exito) {
            System.out.println("se guardó correctamente en MySQL.");
        } else {
            System.out.println(" Hubo un error al intentar guardar los datos.");
        }
    }
}