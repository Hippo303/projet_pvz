package com.epf.core.model;

public class Plante {
    private Integer id_plante;
    private String nom;
    private Integer point_de_vie;
    private double attaque_par_seconde;
    private Integer degat_attaque;
    private Integer cout;
    private double soleil_par_seconde;
    private String effet;
    private String chemin_image;

    public Plante(Integer id_plante, String nom, Integer point_de_vie, double attaque_par_seconde, Integer degat_attaque, Integer cout, double soleil_par_seconde, String effet, String cheminImage) {
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
    public Integer getId() {
        return id_plante;
    }
    public void setId(Integer id_plante) {
        this.id_plante = id_plante;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Integer getpoint_de_vie() {
        return point_de_vie;
    }
    public void setpoint_de_vie(Integer point_de_vie) {
        this.point_de_vie = point_de_vie;
    }
    public double getattaque_par_seconde() {
        return attaque_par_seconde;
    }
    public void setattaque_par_seconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }
    public Integer getdegat_attaque() {
        return degat_attaque;
    }
    public void setdegat_attaque(Integer degat_attaque) {
        this.degat_attaque = degat_attaque;
    }
    public Integer getCout() {
        return cout;
    }
    public void setCout(Integer cout) {
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