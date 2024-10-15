package org.example;

public class Kutyafajtak {
    public int fajtaid;
    public String fajtanev;
    public String eredetifajtanev;

    public Kutyafajtak(String sor) {
        String[] sorelemek = sor.split(";");
        this.fajtaid = Integer.parseInt(sorelemek[0]);
        this.fajtanev = sorelemek[1];
        this.eredetifajtanev = sorelemek[2];
    }
}
