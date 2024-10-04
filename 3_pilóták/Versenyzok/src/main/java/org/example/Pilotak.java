package org.example;

public class Pilotak {

    private String nev;
    private String szulDatum;
    private String nemzetiseg;
    private Integer rajtszam;

    public Pilotak(String nev, String szulDatum, String nemzetiseg, Integer rajtszam) {
        this.nev = nev;
        this.szulDatum = szulDatum;
        this.nemzetiseg = nemzetiseg;
        this.rajtszam = rajtszam;
    }

    public Pilotak(String[] adatok){
        this.nev = adatok[0];
        this.szulDatum = adatok[1];
        this.nemzetiseg = adatok[2];

        if (adatok.length > 3 && !adatok[3].isEmpty()) {
            this.rajtszam = Integer.parseInt(adatok[3]);
        } else {
            this.rajtszam = null;
        }
    }


    public String getNev() {
        return nev;
    }

    public String getSzulDatum() {
        return szulDatum;
    }

    public String getNemzetiseg() {
        return nemzetiseg;
    }

    public Integer getRajtszam() {
        return rajtszam;
    }
}
