package appli.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import appli.StartApplication;

import java.io.IOException;

public class IncriptionController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    public void RetourInscription() throws IOException {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();


        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty() ) {
            errorLabel.setText("Tous les champs doivent être remplis.");
            return;
        }


        if (email.equals("test@example.com")) {
            errorLabel.setText("Cet email est déjà utilisé.");
            return;
        }

        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Email: " + email);
        System.out.println("Mot de passe: " + password);

        System.out.println("vous êtes bien Inscrit");
        StartApplication.changeScene("accueil/Login");
    }

    @FXML
    public void RetourConnexion() throws IOException {
        StartApplication.changeScene("accueil/Login");
    }
}
