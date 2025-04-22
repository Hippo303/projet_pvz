package com.epf.core.model;

public class Map {
    private Integer id_map;
    private Integer ligne;
    private Integer colonne;
    private String chemin_image;

    public Map(Integer id_map, Integer ligne, Integer colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }
    public Integer getId() {
        return id_map;
    }
    public void setId(Integer id_map) {
        this.id_map = id_map;
    }
    public Integer getLigne() {
        return ligne;
    }
    public void setLigne(Integer ligne) {
        this.ligne = ligne;
    }
    public Integer getColonne() {
        return colonne;
    }
    public void setColonne(Integer colonne) {
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
