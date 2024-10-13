package org.example;

public class Fuvar {

    public int taxi;
    public String indulas;
    public int utazas;
    public double viteldij;
    public double tavolsag;
    public double borravalo;
    public String fizetes;

    public Fuvar(int taxi, String indulas, int utazas, double tavolsag, double viteldij, double borravalo, String fizetes) {
        this.taxi = taxi;
        this.indulas = indulas;
        this.utazas = utazas;
        this.tavolsag = tavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizetes = fizetes;
    }


    public Fuvar(String[] adatok) {
        this.taxi = Integer.parseInt(adatok[0]);
        this.indulas = adatok[1];
        this.utazas = Integer.parseInt(adatok[2]);
        this.tavolsag = Double.parseDouble(adatok[3]);
        this.viteldij = Double.parseDouble(adatok[4]);
        this.borravalo = Double.parseDouble(adatok[5]);
        this.fizetes = adatok[6];
    }

    public int getTaxi() {
        return taxi;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getUtazas() {
        return utazas;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetes() {
        return fizetes;
    }
}
