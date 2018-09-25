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

    //Constructeur de Sommet
    public Sommet(String nomVille, double latitude, double longitude){
        this.setNomVille(nomVille);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        listeAdjacence = new LinkedList<Edge>();
    }

    //Ajouter Arc
    public void ajouterArc(String source, String destination, double duree, double cout, Graphe reseau){
        Edge nouvelArc = new Edge(source, destination,duree,cout,reseau);
        this.listeAdjacence.add(nouvelArc);
    }


}