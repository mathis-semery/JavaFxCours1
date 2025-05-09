package appli.accueil;

import Repository.ListeRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import modele.Liste;

import java.util.List;

public class ListeController {

    @FXML
    private TableView<Liste> tableListes;

    @FXML
    private TableColumn<Liste, Integer> colId;

    @FXML
    private TableColumn<Liste, String> colNom;

    @FXML
    private TextField nomField;

    private final ListeRepository repository = new ListeRepository();

    private ObservableList<Liste> listeObservable = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tableListes.setItems(listeObservable);
        chargerListesDepuisBase();
    }

    private void chargerListesDepuisBase() {
        listeObservable.setAll(repository.getToutesLesListes());
    }

    @FXML

    public void ajouterListe(ActionEvent event) {
        String nom = nomField.getText().trim();
        if (nom.isEmpty()) {
            System.out.println("Le champ Nom est vide !");
            return;
        }

        boolean success = repository.ajouterListe(nom);
        if (success) {
            chargerListesDepuisBase();
            System.out.println("Liste ajoutée et affichée !");
            nomField.clear();
        } else {
            System.out.println("Erreur : ajout échoué.");
        }
    }

    @FXML
    public void ListeModifier(ActionEvent event) {
        Liste selectedListe = tableListes.getSelectionModel().getSelectedItem();
        if (selectedListe == null) {
            System.out.println("Veuillez sélectionner une liste.");
            return;
        }

        String newNom = nomField.getText().trim();
        if (newNom.isEmpty()) {
            System.out.println("Le champ Nom est vide !");
            return;
        }

        boolean success = repository.modifierListe(selectedListe.getId(), newNom);
        if (success) {
            chargerListesDepuisBase();
            System.out.println("Liste modifiée !");
            nomField.clear();
        } else {
            System.out.println("Erreur lors de la modification.");
        }
    }

    @FXML
    public void ListeSupprimer(ActionEvent event) {
        Liste selectedListe = tableListes.getSelectionModel().getSelectedItem();
        if (selectedListe == null) {
            System.out.println("Veuillez sélectionner une liste à supprimer.");
            return;
        }

        boolean success = repository.supprimerListe(selectedListe.getId());
        if (success) {
            listeObservable.remove(selectedListe);
            System.out.println("Liste supprimée !");
        } else {
            System.out.println("Erreur lors de la suppression.");
        }
    }
}

