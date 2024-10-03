package org.example;

public class Kolcsonzes {
    private String nev;
    private char JAzon;
    private int EOra;
    private int EPerc;
    private int VOra;
    private int VPerc;


    public Kolcsonzes(String sor) {
        String[] adatok = sor.split(";");
        this.nev = adatok[0];  // Név
        this.JAzon = adatok[1].charAt(0);
        this.EOra = Integer.parseInt(adatok[2]);
        this.EPerc = Integer.parseInt(adatok[3]);
        this.VOra = Integer.parseInt(adatok[4]);
        this.VPerc = Integer.parseInt(adatok[5]);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public char getJAzon() {
        return JAzon;
    }

    public void setJAzon(char JAzon) {
        this.JAzon = JAzon;
    }

    public int getEOra() {
        return EOra;
    }

    public void setEOra(int EOra) {
        this.EOra = EOra;
    }

    public int getEPerc() {
        return EPerc;
    }

    public void setEPerc(int EPerc) {
        this.EPerc = EPerc;
    }

    public int getVOra() {
        return VOra;
    }

    public void setVOra(int VOra) {
        this.VOra = VOra;
    }

    public int getVPerc() {
        return VPerc;
    }

    public void setVPerc(int VPerc) {
        this.VPerc = VPerc;
    }
}
