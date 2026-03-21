package talonarioConsola;

import talonarioConsolaModel.talonarioModel;
import talonarioConsolaServices.talonarioServicesImpl;

public class talonarioConsola {

    public static void main(String[] args) { 
  
        // guardar(); 
        modificar(); 
    }

    private static void guardar() {
        System.out.println("--- Iniciando Proceso de Guardado ---");
        talonarioModel nuevoTalonario = new talonarioModel();
        nuevoTalonario.setCarnet("PG101524"); // Tu carnet
        nuevoTalonario.setDescripcion("Matricula, cuota 1");
        nuevoTalonario.setFecha("21-03-2026");
        nuevoTalonario.setEstado("A");

        talonarioServicesImpl servicio = new talonarioServicesImpl();
        boolean exito = servicio.guardar(nuevoTalonario);
        
        if(exito) {
            System.out.println("Registro guardado correctamente en MySQL.");
        } else {
            System.out.println("Hubo un error al intentar guardar los datos.");
        }
    }

    private static void modificar() {
        System.out.println("--- Iniciando Proceso de Modificación ---");
        talonarioModel talonario = new talonarioModel();
        talonarioServicesImpl servicio = new talonarioServicesImpl();

  
        talonario.setCarnet("PG101524"); 
        talonario.setDescripcion("Pago de Laboratorio - Modificado"); 
        talonario.setFecha("25-03-2026");
        talonario.setEstado("M");

        talonarioModel resultado = servicio.modificar(talonario);

        if (resultado != null) {
            System.out.println("Registro modificado correctamente para el carnet: " + resultado.getCarnet());
        } else {
            System.out.println("Error al modificar: carnet no encontrado.");
        }
    }
}