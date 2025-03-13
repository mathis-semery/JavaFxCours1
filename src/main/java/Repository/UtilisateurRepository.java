package Repository;
import Database.Database;

import java.sql.Connection;

public class UtilisateurRepository {
    private Connection connexion;

    public UtilisateurRepository() {
        this.connexion = Database.getConnexion();
    }

    public Connection getConnexion() {
        return connexion;
    }
}
