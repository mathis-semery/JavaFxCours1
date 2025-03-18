package modele;

public class Liste {
    private String id ;


    private  String nom;


    public Liste(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Liste( String nom) {
        this.nom = nom;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Liste{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
