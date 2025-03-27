package appli.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import appli.StartApplication;
import modele.Utilisateur;
import Repository.UtilisateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    public void Inscription() throws IOException {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String role = "client";

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty() ) {
            errorLabel.setText("Tous les champs doivent être remplis.");
        } else if (utilisateurRepository.getUtilisateurByEmail(email) != null ) {;
            errorLabel.setText("l'email est deja utilisé ");
        }else {
            System.out.println("Inscription en cours ...");

            BCryptPasswordEncoder mdpH = new BCryptPasswordEncoder();
            String hPassword = mdpH.encode(password);
            Utilisateur user  = new Utilisateur(nom, prenom, email, hPassword, role);

            try {
                utilisateurRepository.ajouterUtilisateur(user);
            } catch (Exception e) {
                e.printStackTrace();
                errorLabel.setText("Une erreur est survenue lors de l'inscription.");
            }

            System.out.println("vous êtes bien Inscrit");
            StartApplication.changeScene("accueil/Login");
        }
    }

    @FXML
    public void RetourConnexion() throws IOException {
        StartApplication.changeScene("accueil/Login");
    }
}
