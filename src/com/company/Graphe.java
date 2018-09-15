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
        Sommet index;
        //int itemIndex = 0;
        for(int i = 0; i< sommetVector.size(); i++){
            if(sommetVector.get(i).getNomVille().equals(item)){
                return sommetVector.get(i);
            }
            /*if(itemIndex>=0 && itemIndex< sommetVector.size()) {
                return
            }else{
                return null;
            }*/
        }
        return null;
    }

    private double additionnerPoids(double poidsSommet, double poidsEdge){

        return (double) poidsSommet + poidsEdge;
    }

    public Sommet getItem (int itemIndex){
        if(itemIndex>=0 && itemIndex< sommetVector.size()) {
            return sommetVector.get(itemIndex);
        }else{
            return null;
        }

    }

    public int getIndexSommetPlusPetitPoids(){
        int index = 0;
        double petitPoids = Double.POSITIVE_INFINITY;
        for (int x = 0; x <sommetVector.size(); x++) {
            if (!sommetVector.get(x).isEstConnu()) {
                double poids = sommetVector.get(x).getPoidsDuree();
                if (poids < petitPoids) {
                    petitPoids = poids;
                    return index = x;
                }
            }
        }
        return index;
    }

    public void addSommet(Sommet sommet){
        sommetVector.add(sommet);
    }

    // Retourne le plus court chemin selon l'algorithme de Dijkstra
    public Chemin rechercheCheminDijkstra(String origine, String destination, boolean dureeCout) {
        double dureeTotal = 0;
        double coutTotal = 0;
        Sommet depart = getSommet(origine);
        Chemin chemin = new Chemin();
        Sommet arrive = getSommet(destination);
        depart.setPoidsDuree(0);
        depart.setPoidsCout(0);

        while (!arrive.isEstConnu()) {

            int indexSommet = getIndexSommetPlusPetitPoids();

            if (depart.getListeAdjacence().size() <= 0) {
                chemin.reussi = false;
                chemin.coutTotal = 0;
                chemin.dureeTotale = 0;
                return chemin;
            }

                int index = 0;
                for (Edge monEdge: sommetVector.get(indexSommet).getListeAdjacence()) {
                    dureeTotal = additionnerPoids(depart.getPoidsDuree(),depart.getListeAdjacence().get(index).getDuree() );
                    coutTotal = additionnerPoids(depart.getPoidsCout(),depart.getListeAdjacence().get(index).getCout());
                    monEdge.getDestination().setPoidsDuree(dureeTotal);
                    monEdge.getDestination().setPoidsCout(coutTotal);
                    monEdge.getDestination().setPredecesseur(getSommet(depart.getNomVille()));
                    index++;

                }
            sommetVector.get(indexSommet).setEstConnu(true);

                while (!sommetVector.get(index).getNomVille().equals(depart.getNomVille())){
                    float dureeTemp = 0;
                    float coutTemp = 0;
                    chemin.dureeTotale = (float) dureeTotal;
                    chemin.coutTotal = (float) coutTotal;

                }

                //chemin.listeVilles.add(arrive.getPredecesseur().getNomVille());

                //sommetVector.get(indexSommet).setPoidsDuree(Double.POSITIVE_INFINITY);

        }
        chemin.listeVilles.add(depart.getNomVille());
        chemin.listeVilles.add(arrive.getNomVille());
        chemin.reussi = true;
        return chemin; //et retournez autre chose que null  :-)
    }

    @Override
    public String toString() {
        return nomReseau;
    }


    /*getSommet(origine).setPoidsSommetDepart(0);
        if (depart.getPoidsSommetDepart() < depart.getListeAdjacence()
        .get(x).getDestination().getPoidsSommetDepart()){

        double dureeTotal = (float) (depart.getPoidsSommetDepart()+ depart.getListeAdjacence().get(x)
        .getDuree());
        double coutTotal = (float) (depart.getPoidsSommetDepart()+ depart.getListeAdjacence().get(x)
        .getCout());

        depart.getListeAdjacence().get(x).getDestination().setPoidsSommetDepart(dureeTotal);

        //chemin.dureeTotale = (float) dureeTotal;
        //chemin.coutTotal = (float) coutTotal;*/
}
