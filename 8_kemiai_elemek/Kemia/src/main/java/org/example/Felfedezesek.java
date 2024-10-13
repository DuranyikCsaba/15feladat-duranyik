package org.example;

public class Felfedezesek {
    private String ev;
    private String nev;
    private String vegyjel;
    private int rendszam;
    private String felfedezo;

    public Felfedezesek(String ev, String nev, String vegyjel, int rendszam, String felfedezo) {
        this.ev = ev;
        this.nev = nev;
        this.vegyjel = vegyjel;
        this.rendszam = rendszam;
        this.felfedezo = felfedezo;
    }

    public Felfedezesek(String[] adatok) {
        this.ev = adatok[0];
        this.nev = adatok[1];
        this.vegyjel = adatok[2];
        this.rendszam = Integer.parseInt(adatok[3]);
        this.felfedezo = adatok[4];
    }

    public String getEv() {
        return ev;
    }

    public String getNev() {
        return nev;
    }

    public String getVegyjel() {
        return vegyjel;
    }

    public int getRendszam() {
        return rendszam;
    }

    public String getFelfedezo() {
        return felfedezo;
    }
}
