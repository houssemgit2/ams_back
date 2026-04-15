package com.sip.ams.dto;

public class ArticleDTO {
    private int id;
    private String libelle;
    private double price;

    public ArticleDTO() {
    }

    public ArticleDTO(String libelle, double price, int idProvider) {
        this.libelle = libelle;
        this.price = price;
        this.idProvider = idProvider;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrice() {
        return price;
    }

    public int getIdProvider() {
        return idProvider;
    }

    private int idProvider;

}
