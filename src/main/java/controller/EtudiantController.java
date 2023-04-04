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


        if(etudiant.create()) {
            System.out.println(etudiant);
            System.out.println("Etudiant sauvgarder avec success");
        } else {
            System.out.println("Error de sauvgarde");
        }
        return view("EtudiantIndex");
    }

    public String update() {
        Etudiant etudiant = new Etudiant();
        Scanner sc = new Scanner(System.in);
        System.out.println("ID de l'etudiant: ");
        etudiant.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Nom de l'etudiant: ");
        etudiant.setNom(sc.nextLine().trim());
        System.out.println("CNE de l'etudiant: ");
        etudiant.setCne(sc.nextLine().trim());
        System.out.println("Note de l'etudiant: ");
        etudiant.setNote(sc.nextFloat());
        sc.nextLine();
        System.out.println("Tel de l'etudiant: ");
        etudiant.setTel(sc.nextLine().trim());


        if(etudiant.update()) {
            System.out.println(etudiant);
            System.out.println("Etudiant mis a jour avec success");
        } else {
            System.out.println("Error de mis a jour");
        }
        return view("EtudiantIndex");
    }

    public String delete() {
        Etudiant etudiant = new Etudiant();
        Scanner sc = new Scanner(System.in);
        System.out.println("ID de l'etudiant: ");
        etudiant.setId(sc.nextInt());
        sc.nextLine();
        etudiant.delete();
        return view("EtudiantIndex");
    }

    public String show() {
        Etudiant etudiant = new Etudiant();
        Scanner sc = new Scanner(System.in);
        System.out.println("ID de l'etudiant: ");
        etudiant.setId(sc.nextInt());
        sc.nextLine();
        etudiant.get(etudiant.getId());
        System.out.println(etudiant);
        return view("EtudiantIndex");
    }

    public String list() {
        Etudiant etudiant = new Etudiant();
        etudiant.list();
        return view("EtudiantIndex");
    }
}
