package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int choix = 1;						//Choix de l'utilisateur dans le menu initialisé à 1.
        String villeDepart;				//Chaîne de caractères représentant la ville de départ.
        String villeDestination;		//Chaîne de caractères représentant la ville de d'arrivée.
        Graphe reseau=null;
        Scanner sc=new Scanner(System.in);


        System.out.println("Bienvenu dans votre réseau aérien");

        //Affichage du menu
        System.out.println("------------------ Menu --------------------------------");
        System.out.println("1 - Charger le réseau");
        System.out.println("2 - Trouver le plus court chemin");
        System.out.println("3 - Quitter");
        System.out.println("--------------------------------------------------------");

        while (choix != 0) {
            do {
                System.out.println("Entrez votre choix (1 à 3): ");
                choix = Integer.parseInt(sc.nextLine());
                if(choix <1 || choix>3) {
                    System.out.println("***Option invalide!***");
                }
            }while(choix <1 || choix>3);

            try {
                switch (choix) {
                    case 1: //Charger le réseau à partir d'un fichier texte.
                        File file = new File("ReseauAerien.txt");
                        reseau = chargerReseau(file);
                        System.out.println("Le réseau a été chargé !");
                        System.out.println("Affichage du réseau: " + reseau.getNomReseau());  //Substitution de Graphe.toString() ici
                        break;

                    case 2: //Trouver le plus court chemin avec Dijkstra.
                        System.out.println("Recherche du plus court chemin.");
                        System.out.println("Entrez le nom de la ville de départ: ");
                        villeDepart = sc.nextLine();
                        System.out.println("Entrez le nom de la ville de destination: ");
                        villeDestination = sc.nextLine();

                        Chemin ch1 = reseau.rechercheCheminDijkstra(villeDepart, villeDestination, true);
                        if(ch1.reussi) {
                            System.out.println("Liste des villes du plus court chemin en utilisant la durée du vol: ");
                            for(String ville :  ch1.listeVilles){
                                System.out.println(ville + " ");
                            }
                            System.out.println("Durée totale du plus court chemin:  " + ch1.dureeTotale);
                        }
                        else {
                            System.out.println("Aucun chemin trouvé.");
                        }

                        Chemin ch2 = reseau.rechercheCheminDijkstra(villeDepart, villeDestination, false);
                        if(ch2.reussi) {
                            System.out.println("Liste des villes du plus court chemin en utilisant le coût du vol: ");
                            for(String ville :  ch2.listeVilles){
                                System.out.println(ville + " ");
                            }
                            System.out.println("Coût total du plus court chemin: " + ch2.coutTotal + "$");
                        }
                        else {
                            System.out.println("Aucun chemin trouvé.");
                        }
                        break;

                    case 3:
                        //Quitter
                        System.out.println("***Merci et au revoir !***");
                        return;
                }
            }
            catch(Exception ex){
                System.out.println("ERREUR: " + ex.getMessage());
            }
        }
    }


    // Charger un réseau à partir d'un fichier texte en entrée.
    // Construit un réseau routier à partir d'une liste de villes ainsi que leurs liens.
    public static Graphe chargerReseau(File file) {
        Graphe valeurRetour = null;
        try
        {
            valeurRetour = new Graphe();
            Scanner sc = new Scanner(file);

            //Nom du réseau
            //valeurRetour.setNomReseau();
            valeurRetour.setNomReseau(sc.nextLine());

            //Obtient le nombre de villes que le code doit s'attendre à traiter
            int nbrVilles = Integer.parseInt(sc.nextLine());

            //Récupère les informations des villes
            for(int i=0; i<nbrVilles; i++) {
                String nomVille = sc.nextLine();
                double latitude = Double.parseDouble( sc.nextLine());
                double longitude = Double.parseDouble(sc.nextLine());

                valeurRetour.addSommet(new Sommet(nomVille,latitude,longitude));

            }

            //Récupère les trajets, durées et coûts
            while(sc.hasNextLine()) {

                String nomVilleSource = sc.nextLine();
                String nomVilleDest = sc.nextLine();
                double duree = Double.parseDouble(sc.nextLine());
                double cout = Double.parseDouble(sc.nextLine());

                valeurRetour.getSommet(nomVilleSource).ajouterArc(nomVilleDest,duree,cout,valeurRetour);

            }

            //Fermeture du fichier
            sc.close();
        }
        catch (FileNotFoundException ex) {
            String st = ex.getMessage();
        }
        catch (Exception ex){
            String st = ex.getMessage();
        }
        finally {
            return valeurRetour;
        }
    }


}
