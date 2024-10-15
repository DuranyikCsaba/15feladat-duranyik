package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Kutyak {
    public int kutyaId;
    public int fajtaId;
    public String fajtaNev;
    public int nevId;
    public String kutyaNev;
    public int eletkor;
    public Date ellenorzes;

    public Kutyak(String sor) {
        String[] sorelemek = sor.split(";");
        this.kutyaId = Integer.parseInt(sorelemek[0]);
        this.fajtaId = Integer.parseInt(sorelemek[1]);
        this.nevId = Integer.parseInt(sorelemek[2]);
        this.eletkor = Integer.parseInt(sorelemek[3]);
        try {
            this.ellenorzes = new SimpleDateFormat("yyyy.MM.dd").parse(sorelemek[4]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
