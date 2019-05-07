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
    private String difficoltà;

    public Recipe(String titolo, String durata){

        this.titolo = titolo;
        this.durata = durata;

    }

    public String getTitolo() {
        return titolo;
    }

    public String getDurata() {
        return durata;
    }
}
