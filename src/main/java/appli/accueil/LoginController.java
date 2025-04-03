package appli.accueil;

import Repository.UtilisateurRepository;
import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import modele.Utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import session.SessionUtilisateur;


import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;



    public void btnConnection(ActionEvent event) {
        String email = emailField.getText();
        String mdp = passwordField.getText();
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        Utilisateur user = utilisateurRepository.getUtilisateurByEmail(email);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (email.isEmpty() || mdp.isEmpty()) {
            errorLabel.setText("Tous les champs sont obligatoires !");
            errorLabel.setVisible(true);
        } else if (user != null && passwordEncoder.matches(mdp, user.getMdp())) {
            System.out.println("Connexion réussie !");
            SessionUtilisateur.getInstance().sauvegardeSession(user);
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

    protected void handleLogout() {
        SessionUtilisateur.getInstance().deconnecter();
        System.out.println("Utilisateur déconnecté.");

    }
}
