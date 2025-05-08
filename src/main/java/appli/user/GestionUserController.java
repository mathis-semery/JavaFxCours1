package appli.user;

import Repository.UtilisateurRepository;
import appli.StartApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import modele.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestionUserController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableauUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurerColonnes();

        chargerLesUtilisateurs();
        tableauUser.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && tableauUser.getSelectionModel().getSelectedItem() != null) {
                try {
                    StartApplication.changeScene("user/modificationUser");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void configurerColonnes() {

        tableauUser.setEditable(true);


        TableColumn<Utilisateur, Integer> idColonne = new TableColumn<>("Id Utilisateur");
        idColonne.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColonne.setEditable(false); // On ne modifie pas l'ID

        TableColumn<Utilisateur, String> nomColonne = new TableColumn<>("Nom");
        nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nomColonne.setCellFactory(TextFieldTableCell.forTableColumn());
        nomColonne.setOnEditCommit(event -> {
            // Récupérer l'utilisateur et mettre à jour le champ "nom"
            Utilisateur utilisateur = event.getRowValue();
            utilisateur.setNom(event.getNewValue());

            new UtilisateurRepository().updateUtilisateur(utilisateur);
        });


        TableColumn<Utilisateur, String> prenomColonne = new TableColumn<>("Prénom");
        prenomColonne.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        prenomColonne.setCellFactory(TextFieldTableCell.forTableColumn());
        prenomColonne.setOnEditCommit(event -> {
            Utilisateur utilisateur = event.getRowValue();
            utilisateur.setPrenom(event.getNewValue());

         
            new UtilisateurRepository().updateUtilisateur(utilisateur);
        });

    
        TableColumn<Utilisateur, String> emailColonne = new TableColumn<>("Email");
        emailColonne.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColonne.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColonne.setOnEditCommit(event -> {
            Utilisateur utilisateur = event.getRowValue();
            utilisateur.setEmail(event.getNewValue());


            new UtilisateurRepository().updateUtilisateur(utilisateur);
        });


        TableColumn<Utilisateur, String> roleColonne = new TableColumn<>("Rôle");
        roleColonne.setCellValueFactory(new PropertyValueFactory<>("role"));
        roleColonne.setCellFactory(TextFieldTableCell.forTableColumn());
        roleColonne.setOnEditCommit(event -> {
            Utilisateur utilisateur = event.getRowValue();
            utilisateur.setRole(event.getNewValue());

      
            new UtilisateurRepository().updateUtilisateur(utilisateur);
        });

        tableauUser.getColumns().addAll(idColonne, nomColonne, prenomColonne, emailColonne, roleColonne);
    }



    private void chargerLesUtilisateurs() {
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        ArrayList<Utilisateur> listeUtilisateurs = utilisateurRepository.getTousLesUtilisateurs();

        ObservableList<Utilisateur> listeObservable = FXCollections.observableArrayList(listeUtilisateurs);
        tableauUser.setItems(listeObservable);
    }


    public void supprimer(ActionEvent actionEvent) {
        Utilisateur utilisateurSelectionne = tableauUser.getSelectionModel().getSelectedItem();

        if (utilisateurSelectionne == null) {
            System.out.println("Veuillez sélectionner un utilisateur à supprimer !");
            return;
        }

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        utilisateurRepository.deleteByEmail(utilisateurSelectionne.getEmail());

        tableauUser.getItems().remove(utilisateurSelectionne);
        System.out.println("Utilisateur supprimé avec succès !");
    }

    public void modifier(ActionEvent actionEvent) {
        System.out.println("La fonctionnalité de modification via bouton est à implémenter.");
    }
}