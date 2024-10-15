package org.example;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            ArrayList<Vizsga> vizsgak = Nyelvvizsga.beolvasAdatok("sikeres.csv", "sikertelen.csv");

            ArrayList<String> topNyelvek = Nyelvvizsga.legnepszerubbNyelvek(vizsgak);
            System.out.println("A három legnépszerűbb nyelv:");
            for (String nyelv : topNyelvek) {
                System.out.println(nyelv);
            }

            int ev = Nyelvvizsga.evBekeres();

            Nyelvvizsga.legnagyobbSikertelenArany(vizsgak, ev);

            ArrayList<String> nyelvekVizsgaNelkul = Nyelvvizsga.nyelvekVizsgaNelkul(vizsgak, ev);
            if (nyelvekVizsgaNelkul.isEmpty()) {
                System.out.println("Minden nyelvből volt vizsgázó");
            } else {
                System.out.println("A következő nyelvekből nem volt vizsgázó:");
                for (String nyelv : nyelvekVizsgaNelkul) {
                    System.out.println(nyelv);
                }
            }

            Nyelvvizsga.osszesitesMentese(vizsgak);
            System.out.println("Az összesítés mentésre került az osszesites.csv fájlba.");

        } catch (IOException e) {
            System.out.println("Hiba történt a fájlok beolvasása során: " + e.getMessage());
        }
    }
}
