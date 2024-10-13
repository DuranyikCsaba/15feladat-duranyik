package org.example;

public class Balkezesek {

    private String nev;
    private String elso;
    private String utolso;
    private int magassag;
    private int suly;


    public Balkezesek(String nev, String elso, String utolso, int magassag, int suly) {
        this.nev = nev;
        this.elso = elso;
        this.utolso = utolso;
        this.suly = suly;
        this.magassag = magassag;
    }

    public Balkezesek(String[] adatok) {
        this.nev = adatok[0];
        this.elso = adatok[1];
        this.utolso = adatok[2];
        this.suly = Integer.parseInt(adatok[3]);
        this.magassag = Integer.parseInt(adatok[4]);
    }

    public String getNev() {
        return nev;
    }

    public String getElso() {
        return elso;
    }

    public String getUtolso() {
        return utolso;
    }

    public int getMagassag() {
        return magassag;
    }

    public int getSuly() {
        return suly;
    }
}