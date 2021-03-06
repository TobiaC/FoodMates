package com.example.foodmates;

/**
 * {@link Recipe} Rappresenta una ricetta inserita dall'utente.
 * Contiene: titolo, durata, tag, canale di appartenenza, immagine, testo, difficoltà
 */

public class Recipe {

    private String titolo;
    private String durata;
    private String tag;
    private String canale;
    private int immagine;
    private String testo;
    private int difficoltà;

    public Recipe(String titolo, String durata, int difficoltà, String canale, String tag){

        this.titolo = titolo;
        this.durata = durata;
        this.difficoltà = difficoltà;
        this.canale = canale;
        this.tag = tag;

    }

    public String getTitolo() {
        return titolo;
    }

    public String getDurata() {
        return durata;
    }

    public int getDifficoltà() {
        return difficoltà;
    }

    public void setDifficoltà(int difficoltà) {
        this.difficoltà = difficoltà;
    }

    public String getTag() {
        return tag;
    }

    public String getCanale() {
        return canale;
    }
}
