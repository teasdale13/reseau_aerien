package com.company;

import java.util.LinkedList;

public class Sommet {

    private String nomVille;
    private double latitude;
    private double longitude;
    private double poidsDuree;
    private double poidsCout;
    private LinkedList<Edge> listeAdjacence;
    private boolean estConnu;
    private Sommet predecesseur;

    public double getPoidsDuree() {
        return poidsDuree;
    }

    public void setPoidsDuree(double poidsDuree) {
        this.poidsDuree = poidsDuree;
    }

    public double getPoidsCout() {
        return poidsCout;
    }

    public void setPoidsCout(double poidsCout) {
        this.poidsCout = poidsCout;
    }

    public Sommet getPredecesseur() {
        return predecesseur;
    }

    public void setPredecesseur(Sommet predecesseur) {
        this.predecesseur = predecesseur;
    }

    public boolean isEstConnu() {
        return estConnu;
    }

    public void setEstConnu(boolean estConnu) {
        this.estConnu = estConnu;
    }

    public LinkedList<Edge> getListeAdjacence() {
        return listeAdjacence;
    }

    public void setListeAdjacence() {
        this.listeAdjacence = listeAdjacence;
    }


    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Sommet(String nomVille, double latitude, double longitude){
        this.setNomVille(nomVille);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setPoidsCout(Double.POSITIVE_INFINITY);
        this.setPoidsDuree(Double.POSITIVE_INFINITY);
        listeAdjacence = new LinkedList<Edge>();
        this.setEstConnu(false);
    }

    //Ajouter Arc
    public void ajouterArc(String destination, double duree, double cout, Graphe reseau){

        Edge nouvelArc = new Edge(destination,duree,cout,reseau);
        this.listeAdjacence.add(nouvelArc);
    }


}