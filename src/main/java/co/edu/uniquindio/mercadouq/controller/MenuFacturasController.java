package co.edu.uniquindio.mercadouq.controller;

import co.edu.uniquindio.mercadouq.model.Factura;

import java.util.List;

public class MenuFacturasController {

    ModelFactoryController modelFactoryController;
    public MenuFacturasController() {
        try {
            modelFactoryController = ModelFactoryController.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*public List<Factura> obtenerFacturas() {
        return modelFactoryController.obtenerFacturas();
    }*/
}
