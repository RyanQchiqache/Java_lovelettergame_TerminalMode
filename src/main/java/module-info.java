module GUI {
    requires javafx.fxml;
    requires javafx.controls;


    opens GUI to javafx.fxml;
    exports GUI;
}