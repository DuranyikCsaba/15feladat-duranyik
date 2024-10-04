package org.example;

public class Verseny {
    private int year;
    private int races;
    private int wins;
    private int podiums;
    private int poles;
    private int fastests;

    public Verseny(int year, int races, int wins, int podiums, int poles, int fastests) {
        this.year = year;
        this.races = races;
        this.wins = wins;
        this.podiums = podiums;
        this.poles = poles;
        this.fastests = fastests;
    }

    public Verseny(String[] adatok){
        this.year = Integer.parseInt(adatok[0]);
        this.races = Integer.parseInt(adatok[1]);
        this.wins = Integer.parseInt(adatok[2]);
        this.podiums = Integer.parseInt(adatok[3]);
        this.poles = Integer.parseInt(adatok[4]);
        this.fastests = Integer.parseInt(adatok[5]);
    }

    public int getYear() {
        return year;
    }

    public int getRaces() {
        return races;
    }

    public int getWins() {
        return wins;
    }

    public int getPodiums() {
        return podiums;
    }

    public int getPoles() {
        return poles;
    }

    public int getFastests() {
        return fastests;
    }
}
