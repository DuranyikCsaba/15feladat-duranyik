package org.example;

import java.io.*;
import java.util.*;

    public static void Main(String[] args) throws IOException {
        Map<String, Termek> raktar = new HashMap<>();
        List<Megrendeles> megrendelesek = new ArrayList<>();
        Map<String, Integer> beszerzes = new HashMap<>();

        Scanner raktarOlvaso = new Scanner(new File("raktar.csv"));
        while (raktarOlvaso.hasNextLine()) {
            String[] sor = raktarOlvaso.nextLine().split(";");
            raktar.put(sor[0], new Termek(sor[0], sor[1], Integer.parseInt(sor[2]), Integer.parseInt(sor[3])));
        }
        raktarOlvaso.close();

        Scanner rendelesOlvaso = new Scanner(new File("rendeles.csv"));
        Megrendeles aktualisRendeles = null;
        while (rendelesOlvaso.hasNextLine()) {
            String sor = rendelesOlvaso.nextLine();
            if (sor.startsWith("M")) {
                if (aktualisRendeles != null) {
                    megrendelesek.add(aktualisRendeles);
                }
                aktualisRendeles = new Megrendeles(sor.split(";")[1]);
            } else if (sor.startsWith("T")) {
                String[] tetelAdatok = sor.split("/");
                String kod = tetelAdatok[0].trim();
                int mennyiseg = Integer.parseInt(tetelAdatok[1].trim());
                Tetel tetel = new Tetel(kod, mennyiseg);

                if (!raktar.containsKey(kod) || raktar.get(kod).keszlet < mennyiseg) {
                    aktualisRendeles.teljesitheto = false;
                } else {
                    aktualisRendeles.osszeg += raktar.get(kod).ar * mennyiseg;
                }
                aktualisRendeles.tetelek.add(tetel);
            }
        }
        if (aktualisRendeles != null) {
            megrendelesek.add(aktualisRendeles);
        }
        rendelesOlvaso.close();

        PrintWriter levelekKiir = new PrintWriter("levelek.csv", "UTF-8");
        for (Megrendeles rendeles : megrendelesek) {
            if (rendeles.teljesitheto) {
                levelekKiir.println(rendeles.email + ";A rendelését két napon belül szállítjuk. A rendelés értéke: " + rendeles.osszeg + " Ft");
                for (Tetel tetel : rendeles.tetelek) {
                    Termek termek = raktar.get(tetel.termekkod);
                    termek.keszlet -= tetel.mennyiseg;
                }
            } else {
                levelekKiir.println(rendeles.email + ";A rendelése függő állapotba került. Hamarosan értesítjük a szállítás időpontjáról.");
                for (Tetel tetel : rendeles.tetelek) {
                    beszerzes.put(tetel.termekkod, beszerzes.getOrDefault(tetel.termekkod, 0) + tetel.mennyiseg);
                }
            }
        }
        levelekKiir.close();

        PrintWriter beszerzesKiir = new PrintWriter("beszerzes.csv", "UTF-8");
        for (Map.Entry<String, Integer> entry : beszerzes.entrySet()) {
            beszerzesKiir.println(entry.getKey() + ";" + entry.getValue());
        }
        beszerzesKiir.close();
    }
}