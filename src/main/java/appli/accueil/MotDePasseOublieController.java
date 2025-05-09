package appli.accueil;

import Repository.UtilisateurRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Utilisateur;
import service.EmailService;


public class MotDePasseOublieController {
    @FXML
    private TextField emailField;


    @FXML
    private void envoyerCode() {
        String email = emailField.getText();
        if (email.isEmpty()) {
            System.out.println("Veuillez entrer une adresse e-mail.");
            return;
        }

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        Utilisateur user = utilisateurRepository.getUtilisateurByEmail(email);
        if (user == null) {
            System.out.println("Aucun utilisateur trouvé avec cette adresse e-mail.");
            return;
        }

        String code = EmailService.genererCode();
        EmailService.envoyerEmail(email, "Réinitialisation de mot de passe", "Votre code de réinitialisation est : " + code);
        System.out.println("Code envoyé à : " + email);
    }
} 