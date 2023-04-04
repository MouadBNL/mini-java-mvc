package model;

public class Etudiant extends Model{
    private String nom;
    private String cne;
    private float note;

    private String tel;

    public Etudiant() {
        super();
    }

    public Etudiant(String nom, String cne, float note, String tel) {
        super();
        this.nom = nom;
        this.cne = cne;
        this.note = note;
        this.tel = tel;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public float getNote() {
        return note;
    }

    public String getCne() {
        return cne;
    }

    public String getNom() {
        return nom;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", cne='" + cne + '\'' +
                ", note=" + note +
                ", tel='" + tel + '\'' +
                '}';
    }
}
