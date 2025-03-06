package appli.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController {
    @FXML
    private Label welcomeText;


    @FXML
    private Label bouton2;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void boutonDeux() {
        welcomeText.setText("Welcome to !");
    }
}