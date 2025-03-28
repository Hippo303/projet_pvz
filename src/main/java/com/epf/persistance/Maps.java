package com.epf.persistance;

public class Maps {
    private int id;
    private int ligne;
    private int colonne;
    private String cheminImage;

    public Maps(int id, int ligne, int colonne, String cheminImage) {
        this.id = id;
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        return cheminImage;
    }
    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", ligne=" + ligne +
                ", colonne=" + colonne +
                ", cheminImage='" + cheminImage + '\'' +
                '}';
    }


}
