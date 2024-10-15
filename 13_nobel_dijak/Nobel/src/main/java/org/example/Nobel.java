package org.example;

public class Nobel {

    private int evszam;

    private String tipus;

    private String kereszt;

    private String vezetek;

    public Nobel(int evszam, String tipus, String kereszt, String vezetek) {
        this.evszam = evszam;
        this.tipus = tipus;
        this.kereszt = kereszt;
        this.vezetek = vezetek;
    }

    public Nobel(String[] adatok) {
        if (adatok.length == 3){
            this.evszam = Integer.parseInt(adatok[0]);
            this.tipus = adatok[1];
            this.kereszt = adatok[2];
        }else{
            this.evszam = Integer.parseInt(adatok[0]);
            this.tipus = adatok[1];
            this.kereszt = adatok[2];
            this.vezetek = adatok[3];
        }
    }



    public int getEvszam() {
        return evszam;
    }

    public String getTipus() {
        return tipus;
    }

    public String getKereszt() {
        return kereszt;
    }

    public String getVezetek() {
        return vezetek;
    }
}
