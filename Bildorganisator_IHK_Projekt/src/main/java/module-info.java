module com.example.bildorganisator_ihk_projekt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.bildorganisator_ihk_projekt to javafx.fxml;
    exports com.example.bildorganisator_ihk_projekt;
}