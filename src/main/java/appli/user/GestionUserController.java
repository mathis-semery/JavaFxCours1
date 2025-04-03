package appli.user;

import Repository.UtilisateurRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Utilisateur;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestionUserController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableauUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[][] colonnes = {
                {"Id Utilisateur", "id"},
                {"Nom", "nom"},
                {"Prénom", "prenom"},
                {"Email", "email"},
                {"Rôle", "role"}
        };

        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonnes[i][0]);
            maCol.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>(colonnes[i][1]));
            tableauUser.getColumns().add(maCol);
        }

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        ArrayList<Utilisateur> user = utilisateurRepository.getTousLesUtilisateurs();
        System.out.println("Nombre d'utilisateurs récupérés : " + user.size());

        ObservableList<Utilisateur> observableUserList = FXCollections.observableArrayList(user);


        tableauUser.getItems().addAll(observableUserList);
    }
}
