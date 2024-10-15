package org.example;

public class Kutyanevek {
    public int nevekid;
    public String kutyanevek;

    public Kutyanevek(String sor) {
        String[] sorelemek = sor.split(";");
        this.nevekid = Integer.parseInt(sorelemek[0]);
        this.kutyanevek = sorelemek[1];
    }
}
