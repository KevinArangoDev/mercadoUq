package co.edu.uniquindio.mercadouq.model;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    /**
     * Atributos
     */
    private int idFactura;
    private int idCliente;
    private List<TipoProducto> tipoProducto;
    private Double total;
    private List<Producto> productos;

    public Factura(int idFactura, int idCliente) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.total = 0.0;
        this.productos = new ArrayList<>();
    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Get, Constructor
     */

    public List<TipoProducto> getTipoProducto() {
        return tipoProducto;
    }
    public List<Producto> getProductos() {
        return productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setTipoProducto(List<TipoProducto> tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
