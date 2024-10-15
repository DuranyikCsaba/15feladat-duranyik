package org.example;

public class Igeny {
    private String azonosito;
    private String indulas;
    private String cel;
    private int szemelyek;

    public Igeny(String azonosito, String indulas, String cel, int szemelyek) {
        this.azonosito = azonosito;
        this.indulas = indulas;
        this.cel = cel;
        this.szemelyek = szemelyek;
    }

    public Igeny(String[] adatok){
        this.azonosito = adatok[0];
        this.indulas = adatok[1];
        this.cel = adatok[2];
        this.szemelyek = Integer.parseInt(adatok[3]);
    }

    public String getAzonosito() {
        return azonosito;
    }

    public String getIndulas() {
        return indulas;
    }

    public String getCel() {
        return cel;
    }

    public int getSzemelyek() {
        return szemelyek;
    }
}
