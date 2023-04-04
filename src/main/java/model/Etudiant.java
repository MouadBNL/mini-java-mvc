package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Etudiant extends Model{
    private Integer id;
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

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
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

    @Override
    public boolean update() {
        if(this.id == null){
            System.out.println("Error: id must be set for the update.");
            return false;
        }
        try {

            PreparedStatement create_statement = this.conn.prepareStatement("UPDATE etudiants SET nom = ?, cne = ?, note = ?, tel = ? WHERE id = ?");
            create_statement.setString(1, this.nom);
            create_statement.setString(2, this.cne);
            create_statement.setFloat(3, this.note);
            create_statement.setString(4, this.tel);
            create_statement.setInt(5, this.id);

            create_statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete() {
        if(this.id == null){
            System.out.println("Error: id must be set for the delete.");
            return false;
        }
        try {

            PreparedStatement create_statement = this.conn.prepareStatement("DELETE FROM etudiants WHERE id = ?");
            create_statement.setInt(1, this.id);
            create_statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean list() {
        try {
            PreparedStatement create_statement = this.conn.prepareStatement("SELECT * from etudiants");
            ResultSet rs = create_statement.executeQuery();
            rs.next();
            while(rs.next()){
                Etudiant et = new Etudiant();
                et.setId(rs.getInt(1));
                et.setNom(rs.getString(2));
                et.setCne(rs.getString(3));
                et.setNote(rs.getFloat(4));
                et.setTel(rs.getString(5));
                System.out.println(et);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Model get(int id) {
        try {
            PreparedStatement create_statement = this.conn.prepareStatement("SELECT * from etudiants WHERE id = ?");
            create_statement.setInt(1, this.id);
            ResultSet rs = create_statement.executeQuery();
            rs.next();
            Etudiant et = new Etudiant();
            et.setId(rs.getInt(1));
            et.setNom(rs.getString(2));
            et.setCne(rs.getString(3));
            et.setNote(rs.getFloat(4));
            et.setTel(rs.getString(5));
            return et;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
