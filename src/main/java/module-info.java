module co.edu.uniquindio.mercadouq {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    requires com.opencsv;
    requires org.mapstruct;



    opens co.edu.uniquindio.mercadouq to javafx.fxml;
    exports co.edu.uniquindio.mercadouq;
    exports co.edu.uniquindio.mercadouq.viewController;
    opens co.edu.uniquindio.mercadouq.viewController to javafx.fxml;
    exports co.edu.uniquindio.mercadouq.controller;
    //exports co.edu.uniquindio.mercadouq.mapping.dto;
    exports co.edu.uniquindio.mercadouq.mapping.mappers;
    exports co.edu.uniquindio.mercadouq.model;
    opens co.edu.uniquindio.mercadouq.controller to javafx.fxml;
}