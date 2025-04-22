package com.epf.core.model;

public class Zombie {
    private Integer id_zombie;
    private String nom;
    private Integer point_de_vie;
    private double attaque_par_seconde;
    private Integer degat_attaque;
    private double vitesse_de_deplacement;
    private String chemin_image;
    private Integer id_map;

    public Zombie(Integer id_zombie, String nom, Integer point_de_vie,double attaque_par_seconde,Integer degat_attaque,double vitesse_de_deplacement,String chemin_image,Integer id_map) {
        this.id_zombie = id_zombie;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
        this.id_map = id_map;
    }


    public Integer getId() {
        return id_zombie;
    }
    public void setId(Integer id_zombie) {
        this.id_zombie = id_zombie;
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
    public double getvitesse_de_deplacement() {
        return vitesse_de_deplacement;
    }
    public void setvitesse_de_deplacement(double vitesse_de_deplacement) {
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }
    public String getchemin_image() {
        return chemin_image;
    }
    public void setchemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
    public Integer getid_map() {
        return id_map;
    }
    public void setid_map(Integer id_map) {
        this.id_map = id_map;
    }
    @Override
    public String toString() {
        return "Zombie{" +
                "id=" + id_zombie +
                ", nom='" + nom + '\'' +
                ", point_de_vie=" + point_de_vie +
                ", attaque_par_seconde=" + attaque_par_seconde +
                ", degat_attaque=" + degat_attaque +
                ", vitesse_de_deplacement=" + vitesse_de_deplacement +
                ", chemin_image='" + chemin_image + '\'' +
                ", id_map=" + id_map +
                '}';
    }

}
