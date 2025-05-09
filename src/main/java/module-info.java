module appli.todolistfx {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.crypto;
    requires java.sql;
    requires spring.security.crypto;
    requires jakarta.mail;

    opens appli to javafx.fxml;
    exports appli;
    exports appli.accueil;
    exports appli.user;
    opens appli.accueil to javafx.fxml;
    opens appli.user to javafx.fxml;
    opens modele to javafx.fxml;
    exports modele;

}