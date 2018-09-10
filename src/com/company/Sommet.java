package com.company;

import java.util.LinkedList;

public class Sommet {

    private String nomVille;
    private double latitude;
    private double longitude;
    private int poidsSommetDepart;
    private LinkedList<Edge> listeAdjacence;

    public LinkedList<Edge> getListeAdjacence() {
        return listeAdjacence;
    }

    public void setListeAdjacence(LinkedList<Edge> listeAdjacence) {
        this.listeAdjacence = listeAdjacence;
    }

    public int getPoidsSommetDepart() {
        return poidsSommetDepart;
    }

    public void setPoidsSommetDepart(int poidsSommetDepart) {
        this.poidsSommetDepart = poidsSommetDepart;
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
        this.setPoidsSommetDepart((int)Double.POSITIVE_INFINITY);
        listeAdjacence = new LinkedList<Edge>();
    }

    //Ajouter Arc
    /*public void ajouterArc(String destination, double duree, double cout){

        Edge nouvelArc = new Edge();
        nouvelArc.setDestination(destination);
        nouvelArc.setDuree(duree);
        nouvelArc.setCout(cout);
        this.listeAdjacence.add(nouvelArc);
    }*/


}