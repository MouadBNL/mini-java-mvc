package model;

import java.sql.PreparedStatement;

public class Etudiant extends Model{
    private String nom;
    private String cne;
    private float note;

    private String tel;

    public Etudiant() {
        init();
    }

    public Etudiant(String nom, String cne, float note, String tel) {
        init();
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

    @Override
    public boolean create() {
        try {
            PreparedStatement create_statement = this.conn.prepareStatement("INSERT INTO etudiants(nom, cne, note, tel) VALUES (?,?,?,?);");
            create_statement.setString(1, this.nom);
            create_statement.setString(2, this.cne);
            create_statement.setFloat(3, this.note);
            create_statement.setString(4, this.tel);

            create_statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
