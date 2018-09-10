package com.company;

import java.util.LinkedList;

public class Edge {

    private Sommet destination;
    private Sommet source;
    private double duree;
    private double cout;

    public Sommet getSource() {
        return source;
    }

    public void setSource(Sommet source) {
        this.source = source;
    }

    public Sommet getDestination() {
        return destination;
    }

    public void setDestination(Sommet destination) {
        this.destination = destination;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public Edge(String destination, double duree, double cout, Graphe reseau){
        this.setCout(cout);
        this.setDuree(duree);
        this.setDestination(reseau.getSommet(destination));

    }

}
