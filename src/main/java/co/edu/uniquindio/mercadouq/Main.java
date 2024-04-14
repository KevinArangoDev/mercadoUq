package co.edu.uniquindio.mercadouq;

import co.edu.uniquindio.mercadouq.model.Factura;
import co.edu.uniquindio.mercadouq.model.MercadoUQ;
import co.edu.uniquindio.mercadouq.utils.Persistencia;
import co.edu.uniquindio.mercadouq.viewController.MenuFacturasViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MercadoUQ");
        mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/co/edu/uniquindio/mercadouq/view/MenuFacturasView.fxml"));
            AnchorPane rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MercadoUQ mercado = new MercadoUQ();
        System.out.println("Bienvenido a MercadoUQ");
        System.out.println("Presione 1 para cargar las facturas o 2 para cargar los premios:");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            List<Factura> facturas = Persistencia.leerFacturasDesdeCSV();
            Persistencia.imprimirFacturas(facturas);
        } else if (opcion == 2) {
            mercado.cargarFacturas();
            mercado.imprimirFacturasEncoladas() ;
        } else {
            System.out.println("Opción no válida");
        }
        boolean iniciarJavaFX = false;
        if (iniciarJavaFX) {
            launch(args);
        }
    }
}