package co.edu.uniquindio.mercadouq.utils;
import co.edu.uniquindio.mercadouq.model.TipoProducto;
import com.opencsv.CSVReader;
import co.edu.uniquindio.mercadouq.model.Factura;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    public static final String RUTA_FACTURAS = "src/main/resources/co.edu.uniquindio.persistencia/facturas.csv";

    public static List<Factura> leerFacturasDesdeCSV() {
        List<Factura> facturas = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(RUTA_FACTURAS))) {
            String[] linea;
            while ((linea = reader.readNext()) != null) {
                int idFactura = Integer.parseInt(linea[0]);
                int idCliente = Integer.parseInt(linea[1]);
                String[] categorias = linea[2].split("\\|\\|");
                double total = Double.parseDouble(linea[3]);

                Factura factura = new Factura(idFactura, idCliente);
                factura.setTotal(total);
                List<TipoProducto> tiposProductos = new ArrayList<>();
                for (String categoria : categorias) {
                    TipoProducto tipoProducto = TipoProducto.valueOf(categoria);
                    tiposProductos.add(tipoProducto);
                }
                factura.setTipoProducto(tiposProductos);
                facturas.add(factura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facturas;
    }

    public static void imprimirFacturas(List<Factura> facturas) {
        for (Factura factura : facturas) {
            System.out.println("ID Factura: " + factura.getIdFactura());
            System.out.println("ID Cliente: " + factura.getIdCliente());
            System.out.println("Total: " + factura.getTotal());
            System.out.println("Tipo de Producto: " + factura.getTipoProducto());
            System.out.println("--------------------");
        }
    }




}
