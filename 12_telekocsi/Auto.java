package org.example;

public class Auto {
    private String indulas;
    private String cel;
    private String rendszam;
    private String telefonszam;
    private int ferohely;

    public Auto(String indulas, String cel, String rendszam, String telefonszam, int ferohely) {
        this.indulas = indulas;
        this.cel = cel;
        this.rendszam = rendszam;
        this.telefonszam = telefonszam;
        this.ferohely = ferohely;
    }

    public Auto(String [] adatok){
        this.indulas = adatok[0];
        this.cel = adatok[1];
        this.rendszam = adatok[2];
        this.telefonszam = adatok[3];
        this.ferohely = Integer.parseInt(adatok[4]);
    }

    public String getIndulas() {
        return indulas;
    }

    public String getCel() {
        return cel;
    }

    public String getRendszam() {
        return rendszam;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public int getFerohely() {
        return ferohely;
    }
}
