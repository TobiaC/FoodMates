package com.example.foodmates;

/**
 * {@link Canale} Rappresenta una ricetta inserita dall'utente.
 * Contiene: titolo, durata, tag, canale di appartenenza, immagine, testo, difficoltà
 */

public class Canale {

    private String titolo;
    private String descrizione;

    public Canale(String titolo, String descrizione){

        this.titolo = titolo;
        this.descrizione = descrizione;

    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione(){ return descrizione;}
}
