package co.edu.uniquindio.mercadouq.model;

public class Producto {

    /**
     * Atributos
     */
    private String nombre;
    private double precio;
    private TipoProducto tipoProducto;

    /**
     * Get Set Constructor
     */

    public Producto(String nombre, double precio, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
