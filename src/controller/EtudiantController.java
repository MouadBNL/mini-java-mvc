package controller;

import model.Etudiant;

import java.util.Scanner;

public class EtudiantController extends Controller {

    public String index() {
        return view("EtudiantIndex");
    }

    public String store() {
        Etudiant etudiant = new Etudiant();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom de l'etudiant: ");
        etudiant.setNom(sc.nextLine().trim());
        System.out.println("CNE de l'etudiant: ");
        etudiant.setCne(sc.nextLine().trim());
        System.out.println("Note de l'etudiant: ");
        etudiant.setNote(sc.nextFloat());
        sc.nextLine();
        System.out.println("Tel de l'etudiant: ");
        etudiant.setTel(sc.nextLine().trim());

        System.out.println(etudiant);
        return view("EtudiantIndex");
    }
}
