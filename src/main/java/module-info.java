module com.escuela.escuelamaven {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires java.desktop;

    opens com.escuela.escuelamaven to javafx.fxml;
    exports com.escuela.escuelamaven;
}