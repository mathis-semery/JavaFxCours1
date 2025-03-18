package appli.accueil;

import Repository.UtilisateurRepository;
import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import modele.Utilisateur;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    public void btnConnection(ActionEvent event) {
        String email = emailField.getText();
        String mdp = passwordField.getText();
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

        if (email.isEmpty() || mdp.isEmpty()) {
            errorLabel.setText("Tous les champs sont obligatoires !");
            errorLabel.setVisible(true);
        } else if (utilisateurRepository.ConnectionUser(email , mdp) != null ) {
         System.out.println("Connexion réussi !");
            errorLabel.setVisible(false);
        } else {
            errorLabel.setText("Identifiants incorrects !");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    protected void boutonInscription() throws IOException {
        System.out.println("Redirection vers la page d'inscription !");
        StartApplication.changeScene("accueil/Inscription");

    }

    @FXML
    protected void boutonMdpOublier() {
        System.out.println("Redirection vers la récupération de mot de passe !");
    }
}
