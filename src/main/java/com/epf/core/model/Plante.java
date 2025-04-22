package com.epf.core.model;

public class Plante {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private double soleil_par_seconde;
    private String effet;
    private String chemin_image;

    public Plante(int id_plante, String nom, int point_de_vie, double attaque_par_seconde, int degat_attaque, int cout, double soleil_par_seconde, String effet, String cheminImage) {
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }
    public int getId() {
        return id_plante;
    }
    public void setId(int id_plante) {
        this.id_plante = id_plante;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getpoint_de_vie() {
        return point_de_vie;
    }
    public void setpoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }
    public double getattaque_par_seconde() {
        return attaque_par_seconde;
    }
    public void setattaque_par_seconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }
    public int getdegat_attaque() {
        return degat_attaque;
    }
    public void setdegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }
    public int getCout() {
        return cout;
    }
    public void setCout(int cout) {
        this.cout = cout;
    }
    public double getsoleil_par_seconde() {
        return soleil_par_seconde;
    }
    public void setsoleil_par_seconde(double soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }
    public String getEffet() {
        return effet;
    }
    public void setEffet(String effet) {
        this.effet = effet;
    }
    public String getCheminImage() {
        return chemin_image;
    }
    public void setCheminImage(String cheminImage) {
        this.chemin_image = cheminImage;
    }
    @Override
    public String toString() {
        return "Plantes{" +
                "id=" + id_plante +
                ", nom='" + nom + '\'' +
                ", point_de_vie=" + point_de_vie +
                ", attaque_par_seconde=" + attaque_par_seconde +
                ", degat_attaque=" + degat_attaque +
                ", cout=" + cout +
                ", soleil_par_seconde=" + soleil_par_seconde +
                ", effet='" + effet + '\'' +
                ", cheminImage='" + chemin_image + '\'' +
                '}';
    }

}