package org.example;

public class Vizsga {
    private String nyelv;
    private int[] sikeresVizsgak;
    private int[] sikertelenVizsgak;

    public Vizsga(String nyelv, int[] sikeresVizsgak, int[] sikertelenVizsgak) {
        this.nyelv = nyelv;
        this.sikeresVizsgak = sikeresVizsgak;
        this.sikertelenVizsgak = sikertelenVizsgak;
    }

    public String getNyelv() {
        return nyelv;
    }

    public int[] getSikeresVizsgak() {
        return sikeresVizsgak;
    }

    public int[] getSikertelenVizsgak() {
        return sikertelenVizsgak;
    }
}
