package com.epf.core.model;

public class Map {
    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;

    public Map(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }
    public int getId() {
        return id_map;
    }
    public void setId(int id_map) {
        this.id_map = id_map;
    }
    public int getLigne() {
        return ligne;
    }
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
    public int getColonne() {
        return colonne;
    }
    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
    public String getCheminImage() {
        return chemin_image;
    }
    public void setCheminImage(String cheminImage) {
        this.chemin_image = cheminImage;
    }
    @Override
    public String toString() {
        return "Map{" +
                "id=" + id_map +
                ", ligne=" + ligne +
                ", colonne=" + colonne +
                ", cheminImage='" + chemin_image + '\'' +
                '}';
    }


}
