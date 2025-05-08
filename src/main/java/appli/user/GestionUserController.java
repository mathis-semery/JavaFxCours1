package appli.user;

import Repository.UtilisateurRepository;
import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Utilisateur;

import java.awt.event.MouseEvent;
import java.io.IOException;
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

        tableauUser.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && tableauUser.getSelectionModel().getSelectedItem() != null) {
                Utilisateur utilisateur = tableauUser.getSelectionModel().getSelectedItem();
                try {
                    StartApplication.changeScene("user/Update");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }



    public void supprimer(ActionEvent actionEvent) {
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        String email =  tableauUser.getSelectionModel().getSelectedItem().getEmail();
        utilisateurRepository.deleteByEmail(email);
    }

    public void modifier(ActionEvent actionEvent) {

    }


}
