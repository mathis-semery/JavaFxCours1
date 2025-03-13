package modele;

public class Utilisateur {
    private  int id;
private String nom;
private String prenom;
private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private String mdp;

public Utilisateur(int id, String nom, String prenom, String email, String mdp) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.mdp = mdp;

}
public Utilisateur(String nom, String prenom, String email, String mdp) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.mdp = mdp;
}
public Utilisateur(String email, String mdp) {
    this.email = email;
    this.mdp = mdp;
}

    @Override
    public String toString() {
        return super.toString();
    }
}
