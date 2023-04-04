package view;

import java.util.ArrayList;
import java.util.Scanner;

public class IndexView extends View{
    public IndexView() {
        super("Index");
        addMenuItem("Action Etudiant", "EtudiantController@index");
        addMenuItem("Action Bibliotheque", "LibraryController@index");
    }
}
