package com.company;

import java.util.Vector;

public class Graphe {

    private String nomReseau;
    private Vector<Sommet> sommetVector = new Vector<>();

    public String getNomReseau() {
        return nomReseau;
    }
    public void setNomReseau(String nomReseau) {
        this.nomReseau = nomReseau;
    }

    public Vector<Sommet> getSommetVector() {
        return sommetVector;
    }

    public Sommet getSommet(String item){
        for (Sommet _SommetVector : sommetVector) {
            if (_SommetVector.getNomVille().equals(item)) {
                return _SommetVector;
            }
        }
        return null;
    }

    private void additionnerPoids(Sommet presentSommet, boolean dureeCout){
        for (Edge monEdge: presentSommet.getListeAdjacence()) {
            if (dureeCout) {
                if ((monEdge.getCout() + presentSommet.getPoidsDuree()) < monEdge.getDestination().getPoidsDuree()) {
                    monEdge.getDestination().setPoidsDuree(monEdge.getDuree() + presentSommet.getPoidsDuree());
                    monEdge.getDestination().setPredecesseur(presentSommet);
                }
            }else {
                if ((monEdge.getDuree()+presentSommet.getPoidsCout()) < monEdge.getDestination().getPoidsCout() ){
                    monEdge.getDestination().setPoidsCout(monEdge.getCout()+presentSommet.getPoidsCout());
                    monEdge.getDestination().setPredecesseur(presentSommet);
                }
            }
        }
        presentSommet.setEstConnu(true);

    }

    private Chemin cheminLePlusCourt(Sommet sommet, boolean dureeCout,Chemin cheminOptimal){

        if (sommet.getPredecesseur() != null) {
            cheminLePlusCourt(sommet.getPredecesseur(), dureeCout, cheminOptimal);
            if (dureeCout){
              cheminOptimal.dureeTotale = (float) sommet.getPoidsDuree();
            }else {
              cheminOptimal.coutTotal = (float) sommet.getPoidsCout();
            }
        }else {
            cheminOptimal.reussi = false;
        }

        cheminOptimal.listeVilles.add(sommet.getNomVille());
        cheminOptimal.reussi = true;
        return cheminOptimal;
    }

    private Sommet getSommetPlusPetitPoids (boolean dureeCout) {
        Sommet monPetitSommet = null;
        double plusPetitPoids = Double.MAX_VALUE;
        for (Sommet monSommet : sommetVector) {
            if (!monSommet.isEstConnu()){
                double poids = (dureeCout? monSommet.getPoidsDuree(): monSommet.getPoidsCout());
                if (poids < plusPetitPoids) {
                    plusPetitPoids = poids;
                    monPetitSommet = monSommet;
                }
            }
        }
        return monPetitSommet;
    }

    private void assignerPoidsSommetDepart(){
        for (int x = 0; x < sommetVector.size();x++) {
            sommetVector.get(x).setPoidsCout(Double.POSITIVE_INFINITY);
            sommetVector.get(x).setPoidsDuree(Double.POSITIVE_INFINITY);
            sommetVector.get(x).setEstConnu(false);
        }
    }

    public void addSommet(Sommet sommet){
        sommetVector.add(sommet);
    }

    // Retourne le plus court chemin selon l'algorithme de Dijkstra
    public Chemin rechercheCheminDijkstra(String origine, String destination, boolean dureeCout) {
        Sommet sommetFinal = getSommet(destination);
        Sommet sommetDepart = getSommet(origine);
        sommetDepart.setPredecesseur(null);
        assignerPoidsSommetDepart();

        if(sommetDepart == null || sommetFinal == null){
            Chemin chemin = new Chemin();
            chemin.reussi = false;
            return chemin;
        }

        if (dureeCout) {
            sommetDepart.setPoidsDuree(0);
        }else {
            sommetDepart.setPoidsCout(0);
        }

        while (!sommetFinal.isEstConnu()){
            Sommet presentSommet = getSommetPlusPetitPoids(dureeCout);
            additionnerPoids(presentSommet, dureeCout);
        }

        Chemin chemin = new Chemin();

        if (sommetFinal.getPredecesseur() == null){
            chemin.reussi = false;

        }else {
            return cheminLePlusCourt(sommetFinal, dureeCout, chemin);
        }
        return chemin;
    }

    @Override
    public String toString() {
        return nomReseau;
    }


}
