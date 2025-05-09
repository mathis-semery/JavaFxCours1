package Repository;

import modele.Liste;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import static Database.Database.getConnexion;


public class ListeRepository {

    private Connection cnx;

    public ListeRepository() {

        this.cnx = getConnexion();
    }

    public ArrayList<Liste> getToutesLesListes() {
        ArrayList<Liste> listes = new ArrayList<>();
        String sql = "SELECT * FROM liste";

        try (PreparedStatement stmt = this.cnx.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Liste liste = new Liste(
                        rs.getInt("id_liste"),
                        rs.getString("nom")
                );
                listes.add(liste);
            }

            if (listes.isEmpty()) {
                System.out.println("Aucune liste trouvée dans la base de données.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            e.printStackTrace();
        }

        return listes;
    }
    public boolean ajouterListe(String nom) {
        String sql = "INSERT INTO liste (nom) VALUES (?)";
        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean modifierListe(int idListe, String nouveauNom) {
        String sql = "UPDATE liste SET nom = ? WHERE id_liste = ?";
        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            pstmt.setString(1, nouveauNom);
            pstmt.setInt(2, idListe);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean supprimerListe(int idListe) {
        String sql = "DELETE FROM liste WHERE id_liste = ?";
        System.out.println("Tentative de suppression pour ID : " + idListe);

        try (PreparedStatement stmt = getConnexion().prepareStatement(sql)) {


            stmt.setInt(1, idListe);


            System.out.println("Requête SQL : " + stmt);


            int rowsAffected = stmt.executeUpdate();

            System.out.println("Nombre de lignes supprimées : " + rowsAffected);
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erreur SQL lors de la suppression : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
