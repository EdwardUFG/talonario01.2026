package talonarioConsolaModel; 

public class talonarioModel {
	
    private int id;
    private String carnet;
    private String descripcion;
    private String fecha;

    // Constructor vacío corregido
    public talonarioModel() {
    }

    // Constructor con parámetros corregido
    public talonarioModel(int id, String carnet, String descripcion, String fecha) {
        this.id = id;
        this.carnet = carnet;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}