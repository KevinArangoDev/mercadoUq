package co.edu.uniquindio.mercadouq.controller;

import co.edu.uniquindio.mercadouq.model.Factura;
import co.edu.uniquindio.mercadouq.model.MercadoUQ;

import java.util.List;

public class ModelFactoryController {

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {
        System.out.println("Invocación clase singleton");
        }




}
