package talonarioConsolaModel; 

public class talonarioModel {
    
    private int id;
    private String carnet;
    private String descripcion;
    private String fecha;
    private String estado; 

    // Constructor vacío
    public talonarioModel() {
    }


    public talonarioModel(String carnet, String descripcion, String fecha, String estado) {
        this.carnet = carnet;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}