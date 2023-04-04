package view;

import java.util.ArrayList;

public class EtudiantIndex extends  View{
    public  EtudiantIndex() {
        super("Etudiant");
        addMenuItem("Ajouter un etudiant", "EtudiantController@store");
        addMenuItem("Modifier un etudiant", "EtudiantController@update");
        addMenuItem("Supprimer un etudiant", "EtudiantController@delete");
        addMenuItem("Affichier un etudiant", "EtudiantController@show");
    }
}
