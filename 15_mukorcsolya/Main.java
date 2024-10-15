package org.example;

import java.io.*;
import java.util.*;

public class main {
    public static ArrayList<Helsinki2017.Versenyzo> beolvasVersenyzok(String fileNev) throws FileNotFoundException {
        ArrayList<Helsinki2017.Versenyzo> versenyzok = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(fileNev), "UTF-8");
        while (fileScanner.hasNextLine()) {
            String[] adatok = fileScanner.nextLine().split(";");
            String nev = adatok[0];
            String orszag = adatok[1];
            double technikaiPont = Double.parseDouble(adatok[2]);
            double komponensPont = Double.parseDouble(adatok[3]);
            double hibaPont = Double.parseDouble(adatok[4]);
            versenyzok.add(new Helsinki2017.Versenyzo(nev, orszag, technikaiPont, komponensPont, hibaPont));
        }
        fileScanner.close();
        return versenyzok;
    }

    public static boolean tovabbjutottE(ArrayList<Helsinki2017.Versenyzo> rovidprogram, ArrayList<Helsinki2017.Versenyzo> donto, String orszagKod) {
        for (Helsinki2017.Versenyzo v : donto) {
            if (v.orszag.equals(orszagKod)) {
                return true;
            }
        }
        return false;
    }

    public static Helsinki2017.Versenyzo keresVersenyzot(String nev, ArrayList<Helsinki2017.Versenyzo> rovidprogram, ArrayList<Helsinki2017.Versenyzo> donto) {
        for (Helsinki2017.Versenyzo v : rovidprogram) {
            if (v.nev.equals(nev)) {
                return v;
            }
        }
        return null;
    }

    public static double osszPontszam(Helsinki2017.Versenyzo versenyzo, ArrayList<Helsinki2017.Versenyzo> donto) {
        for (Helsinki2017.Versenyzo v : donto) {
            if (v.nev.equals(versenyzo.nev)) {
                return versenyzo.osszPontszam + v.osszPontszam;
            }
        }
        return versenyzo.osszPontszam;
    }

    public static void tovabbjutottOrszagok(ArrayList<Helsinki2017.Versenyzo> rovidprogram, ArrayList<Helsinki2017.Versenyzo> donto) {
        Map<String, Integer> orszagok = new HashMap<>();
        for (Helsinki2017.Versenyzo v : donto) {
            orszagok.put(v.orszag, orszagok.getOrDefault(v.orszag, 0) + 1);
        }
        for (String orszag : orszagok.keySet()) {
            int versenyzokSzama = orszagok.get(orszag);
            if (versenyzokSzama > 1) {
                System.out.println(orszag + ": " + versenyzokSzama + " versenyző");
            }
        }
    }

    public static void vegeeredmenyKiirasa(String fileNev, ArrayList<Helsinki2017.Versenyzo> rovidprogram, ArrayList<Helsinki2017.Versenyzo> donto) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileNev, false), true);
        ArrayList<Helsinki2017.Versenyzo> mindenVersenyzo = new ArrayList<>(rovidprogram);
        mindenVersenyzo.addAll(donto);
        mindenVersenyzo.sort((v1, v2) -> Double.compare(v2.osszPontszam, v1.osszPontszam));

        int helyezes = 1;
        for (Helsinki2017.Versenyzo v : mindenVersenyzo) {
            writer.println(helyezes + ";" + v.nev + ";" + v.orszag + ";" + v.osszPontszam);
            helyezes++;
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Helsinki2017.Versenyzo> rovidprogramVersenyzok = beolvasVersenyzok("rovidprogram.csv");
        ArrayList<Helsinki2017.Versenyzo> dontoVersenyzok = beolvasVersenyzok("donto.csv");

        System.out.println("Rövidprogramban elindult versenyzők száma: " + rovidprogramVersenyzok.size());

        boolean magyarTovabbjutott = tovabbjutottE(rovidprogramVersenyzok, dontoVersenyzok, "HUN");
        System.out.println("Magyar versenyző bejutott a kűrbe: " + (magyarTovabbjutott ? "Igen" : "Nem"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Adjon meg egy versenyző nevét: ");
        String nev = scanner.nextLine();
        Helsinki2017.Versenyzo keresettVersenyzo = keresVersenyzot(nev, rovidprogramVersenyzok, dontoVersenyzok);

        if (keresettVersenyzo != null) {
            System.out.println("A versenyző összpontszáma: " + osszPontszam(keresettVersenyzo, dontoVersenyzok));
        } else {
            System.out.println("Ilyen nevű induló nem volt.");
            keresettVersenyzo = keresVersenyzot("Amy LIN", rovidprogramVersenyzok, dontoVersenyzok);
            if (keresettVersenyzo != null) {
                System.out.println("Amy LIN összpontszáma: " + osszPontszam(keresettVersenyzo, dontoVersenyzok));
            }
        }

        tovabbjutottOrszagok(rovidprogramVersenyzok, dontoVersenyzok);

        vegeeredmenyKiirasa("vegeredmeny.csv", rovidprogramVersenyzok, dontoVersenyzok);
    }
}
