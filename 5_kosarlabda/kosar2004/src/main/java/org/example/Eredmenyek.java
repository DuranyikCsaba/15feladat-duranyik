package org.example;

public class Eredmenyek {
    private String hazai;
    private String idegen;
    private int hazaiPont;
    private int idegenPont;
    private String helyszin;
    private String idopont;

    public Eredmenyek(String hazai, String idegen, int hazaiPont, int idegenPont, String helyszin, String idopont) {
        this.hazai = hazai;
        this.idegen = idegen;
        this.hazaiPont = hazaiPont;
        this.idegenPont = idegenPont;
        this.helyszin = helyszin;
        this.idopont = idopont;
    }

    public Eredmenyek(String[] adatok){
        this.hazai = adatok[0];
        this.idegen = adatok[1];
        this.hazaiPont = Integer.parseInt(adatok[2]);
        this.idegenPont = Integer.parseInt(adatok[3]);
        this.helyszin = adatok[4];
        this.idopont = adatok[5];
    }

    public String getHazai() {
        return hazai;
    }

    public void setHazai(String hazai) {
        this.hazai = hazai;
    }

    public String getIdegen() {
        return idegen;
    }

    public void setIdegen(String idegen) {
        this.idegen = idegen;
    }

    public int getHazaiPont() {
        return hazaiPont;
    }

    public void setHazaiPont(int hazaiPont) {
        this.hazaiPont = hazaiPont;
    }

    public int getIdegenPont() {
        return idegenPont;
    }

    public void setIdegenPont(int idegenPont) {
        this.idegenPont = idegenPont;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public String getIdopont() {
        return idopont;
    }

    public void setIdopont(String idopont) {
        this.idopont = idopont;
    }
}
