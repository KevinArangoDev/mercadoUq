
package co.edu.uniquindio.mercadouq.viewController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.mercadouq.controller.MenuFacturasController;
import co.edu.uniquindio.mercadouq.model.Factura;
import co.edu.uniquindio.mercadouq.model.Producto;
import co.edu.uniquindio.mercadouq.model.TipoProducto;
import co.edu.uniquindio.mercadouq.utils.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MenuFacturasViewController {



    @FXML
    void initialize() {

    }

    private void initView() {

    }

    private void obtenerFacturas() {

    }
    @FXML
    private Button btnCargarFacturas;

    @FXML
    private TableView<Factura> tableFacturas;

    @FXML
    private TableColumn<Factura, Integer> tbcIdFactura;

    @FXML
    private TableColumn<Factura, Integer> tbcIdCliente;

    @FXML
    private TableColumn<Factura, TipoProducto> tbcTipoProd;

    @FXML
    private TableColumn<Factura, Double> tbcValor;

    @FXML
    private TableColumn<Factura, List<Producto>> tcbProducto;


    @FXML
    void CargarFacturas(ActionEvent event) {
    }
}
