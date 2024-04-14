package co.edu.uniquindio.mercadouq.model;

import co.edu.uniquindio.mercadouq.utils.Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MercadoUQ {

    private PriorityQueue<Factura> colaFacturas;
    private Map<TipoProducto, Queue<Producto>> bodegaPremios;
    private Map<TipoProducto, Integer> contadorCategorias;

    public MercadoUQ() {
        colaFacturas = new PriorityQueue<>(Comparator.comparingInt(this::calcularPrioridadFactura));
        bodegaPremios = new HashMap<>();
        contadorCategorias = new HashMap<>();
        inicializarBodegaPremios();
        inicializarContadorCategorias();
    }

    private void inicializarBodegaPremios() {
        for (TipoProducto categoria : TipoProducto.values()) {
            Queue<Producto> pilaProductos = new LinkedList<>();
            pilaProductos.offer(new Producto(categoria.toString() + "-1", 0.0, categoria));
            pilaProductos.offer(new Producto(categoria.toString() + "-2", 0.0, categoria));
            pilaProductos.offer(new Producto(categoria.toString() + "-3", 0.0, categoria));
            bodegaPremios.put(categoria, pilaProductos);
        }
    }
    private void inicializarContadorCategorias() {
        for (TipoProducto categoria : TipoProducto.values()) {
            contadorCategorias.put(categoria, 0);
        }
    }
    private int calcularPrioridadFactura(Factura factura) {
        Cliente cliente = obtenerClientePorId(factura.getIdCliente());
        if (cliente != null) {
            int prioridadPais;
            if ("Colombia".equals(cliente.getPais()) || "México".equals(cliente.getPais())) {
                prioridadPais = 1;
            } else if ("País en calamidad".equals(cliente.getPais())) {
                prioridadPais = 2;
            } else {
                prioridadPais = 3;
            }
            int prioridadSexo;
            if ("M".equals(cliente.getSexo())) {
                prioridadSexo = 2;
            } else if ("F".equals(cliente.getSexo())) {
                prioridadSexo = 1;
            } else {
                prioridadSexo = 3;
            }
            return prioridadPais * 10 + prioridadSexo;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    private Cliente obtenerClientePorId(int idCliente) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/co.edu.uniquindio.persistencia/clientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[3].trim());
                if (id == idCliente) {
                    return new Cliente(partes[0].trim(), Integer.parseInt(partes[1].trim()), partes[2].trim(), partes[3].trim(), partes[4].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void cargarFacturas() {
        List<Factura> facturas = Persistencia.leerFacturasDesdeCSV();
        for (Factura factura : facturas) {
            colaFacturas.offer(factura);
        }
    }
    public void otorgarPremios(int idCliente) {
        inicializarContadorCategorias();
        TipoProducto categoriaMasComun = obtenerCategoriaMasComun(idCliente);
        if (categoriaMasComun != null) {
            Queue<Producto> pilaProductos = bodegaPremios.get(categoriaMasComun);
            if (pilaProductos != null && !pilaProductos.isEmpty()) {
                Producto producto = pilaProductos.poll();
                System.out.println("Prioridad de premio: " + contadorCategorias.get(categoriaMasComun));
                System.out.println("Se otorga premio de " + categoriaMasComun + ": " + producto.getNombre());
                if (pilaProductos.isEmpty()) {
                    bodegaPremios.remove(categoriaMasComun);
                }
            }
        }
    }

    private TipoProducto obtenerCategoriaMasComun(int idCliente) {
        TipoProducto categoriaMasComun = null;
        int maxContador = 0;
        for (Factura factura : colaFacturas) {
            if (factura.getIdCliente() == idCliente) {
                for (TipoProducto categoria : factura.getTipoProducto()) {
                    int contador = contadorCategorias.getOrDefault(categoria, 0);
                    contadorCategorias.put(categoria, contador + 1);
                    if (contador + 1 > maxContador) {
                        maxContador = contador + 1;
                        categoriaMasComun = categoria;
                    }
                }
            }
        }
        return categoriaMasComun;
    }

    public void imprimirFacturasEncoladas() {
        PriorityQueue<Factura> colaCopia = new PriorityQueue<>(colaFacturas);
        System.out.println("Facturas encoladas por prioridad del cliente:");
        while (!colaCopia.isEmpty()) {
            Factura factura = colaCopia.poll();
            Cliente cliente = obtenerClientePorId(factura.getIdCliente());
            if (cliente != null && factura.getTotal() > 100000 && !factura.getTipoProducto().contains(TipoProducto.ALIMENTOS)) {
                System.out.println("ID Factura: " + factura.getIdFactura());
                System.out.println("ID Cliente: " + factura.getIdCliente());
                System.out.println("Cliente: " + cliente.getNombre());
                System.out.println("Pais: " + cliente.getPais());
                System.out.println("Sexo: " + cliente.getSexo());
                System.out.println("--------------------");
                System.out.println("Premio otorgado: ");
                otorgarPremios(factura.getIdCliente()); // Pasar el idCliente de la factura actual
                System.out.println("--------------------");
            }
        }
    }
}
