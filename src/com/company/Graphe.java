package com.company;

import java.util.Vector;

public class Graphe {

    private String nomReseau;
    private Vector<Sommet> sommets = new Vector<>();

    public String getNomReseau() {
        return nomReseau;
    }
    public void setNomReseau(String nomReseau) {
        this.nomReseau = nomReseau;
    }

    public Vector<Sommet> getSommets() {
        return sommets;
    }

    public Sommet getSommet(String  item){
        Sommet index;
        for(int i=0;i<sommets.size(); i++){
            if(sommets.get(i).getNomVille()==item){
               return index = getItem(i);
            }
        }
        return null;
    }

    public Sommet getItem (int itemIndex){
        if(itemIndex>=0 && itemIndex< sommets.size()) {
            return sommets.get(itemIndex);
        }else{
            return null;
        }

    }

    public void addSommet(Sommet sommet){
        sommets.add(sommet);
    }

    // Retourne le plus court chemin selon l'algorithme de Dijkstra
    public Chemin rechercheCheminDijkstra(String origine, String destination, boolean dureeCout){
        //TODO Implémentez votre algorithme Dijkstra ici
        return null; //et retournez autre chose que null  :-)
    }

    @Override
    public String toString() {
        return nomReseau;
    }
}
