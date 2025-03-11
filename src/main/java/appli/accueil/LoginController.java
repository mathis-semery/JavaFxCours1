package appli.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.awt.event.ActionEvent;

public class LoginController {
    @FXML
    private Label welcomeText;


    @FXML
    private Label lblMdp;
    @FXML
    private PasswordField mdp;

    @FXML
    protected void setMdp (ActionEvent event) {
        this.mdp = mdp ;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    public void btnConnection(ActionEvent event) {


    }

    @FXML
    protected void boutonInscription() {
        welcomeText.setText("Welcome to !");
    }

    @FXML
    protected void boutonMdpOublier() {
        welcomeText.setText(" sa arrive!");
    }

    public set
    public void btnConnection(javafx.event.ActionEvent actionEvent) {
        String email = Connection.getText();
        String mdp = PasswordField.getText();
        System.out.println("email = " + email);
        if (mdp.equals("123") && email.equals("mathis@gmail.com")) {}
        if (mdp.isEmpty()  && email.isEmpty()) {
            System.out.println(" toute les champs sont obligatoires!");
        } else
    }
}