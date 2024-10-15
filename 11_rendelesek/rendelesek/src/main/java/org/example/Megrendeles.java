package org.example;

import java.util.ArrayList;
import java.util.List;

public class Megrendeles {
    String email;
    List<Tetel> tetelek = new ArrayList<>();
    boolean teljesitheto = true;
    int osszeg = 0;

    public Megrendeles(String email) {
        this.email = email;
    }
}
