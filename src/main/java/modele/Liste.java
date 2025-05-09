package modele;

public class Liste {
    private int id ;


    private  String nom;


    public Liste(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Liste( String nom) {
        this.nom = nom;
    }
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


    @Override
    public String toString() {
        return "Liste{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
