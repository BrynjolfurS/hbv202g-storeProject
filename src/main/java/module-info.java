module com.example.shopsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.shopsystem to javafx.fxml;
    exports com.example.shopsystem;
    exports com.example.shopsystem.controllers;
    opens com.example.shopsystem.controllers to javafx.fxml;
}