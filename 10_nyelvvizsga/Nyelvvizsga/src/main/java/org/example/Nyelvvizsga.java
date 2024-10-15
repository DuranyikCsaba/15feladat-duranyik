package org.example;

import java.io.*;
import java.util.*;

public class Nyelvvizsga {

    // 1. Adatok beolvasása a sikeres és sikertelen fájlokból
    public static ArrayList<Vizsga> beolvasAdatok(String sikeresFajl, String sikertelenFajl) throws FileNotFoundException {
        ArrayList<Vizsga> vizsgak = new ArrayList<>();

        Scanner sikeresScanner = new Scanner(new File(sikeresFajl), "UTF-8");
        Scanner sikertelenScanner = new Scanner(new File(sikertelenFajl), "UTF-8");

        sikeresScanner.nextLine();  // Fejléc átugrása
        sikertelenScanner.nextLine();  // Fejléc átugrása

        while (sikeresScanner.hasNextLine() && sikertelenScanner.hasNextLine()) {
            String sikeresSor = sikeresScanner.nextLine();
            String sikertelenSor = sikertelenScanner.nextLine();

            String[] sikeresAdatok = sikeresSor.split(";");
            String[] sikertelenAdatok = sikertelenSor.split(";");
            String nyelv = sikeresAdatok[0];

            int[] sikeresVizsgak = new int[9];
            int[] sikertelenVizsgak = new int[9];

            for (int i = 1; i <= 9; i++) {
                sikeresVizsgak[i - 1] = Integer.parseInt(sikeresAdatok[i]);
                sikertelenVizsgak[i - 1] = Integer.parseInt(sikertelenAdatok[i]);
            }

            vizsgak.add(new Vizsga(nyelv, sikeresVizsgak, sikertelenVizsgak));
        }

        sikeresScanner.close();
        sikertelenScanner.close();

        return vizsgak;
    }

    // 2. Legnépszerűbb nyelvek meghatározása
    public static ArrayList<String> legnepszerubbNyelvek(ArrayList<Vizsga> vizsgak) {
        HashMap<String, Integer> osszesVizsga = new HashMap<>();
        for (Vizsga vizsga : vizsgak) {
            int osszVizsga = Arrays.stream(vizsga.getSikeresVizsgak()).sum() + Arrays.stream(vizsga.getSikertelenVizsgak()).sum();
            osszesVizsga.put(vizsga.getNyelv(), osszVizsga);
        }

        ArrayList<Map.Entry<String, Integer>> rendezes = new ArrayList<>(osszesVizsga.entrySet());
        rendezes.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        ArrayList<String> topNyelvek = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            topNyelvek.add(rendezes.get(i).getKey());
        }

        return topNyelvek;
    }

    // 3. Év bekérése
    public static int evBekeres() {
        Scanner scanner = new Scanner(System.in);
        int ev;
        while (true) {
            System.out.println("Kérem adjon meg egy évet (2009-2017): ");
            ev = scanner.nextInt();
            if (ev >= 2009 && ev <= 2017) {
                break;
            } else {
                System.out.println("Hibás év, próbálja újra!");
            }
        }
        return ev;
    }

    // 4. Legnagyobb sikertelen arányú nyelv meghatározása
    public static void legnagyobbSikertelenArany(ArrayList<Vizsga> vizsgak, int ev) {
        int evIndex = ev - 2009;
        String legrosszabbNyelv = "";
        double legnagyobbArany = -1;

        for (Vizsga vizsga : vizsgak) {
            int sikeres = vizsga.getSikeresVizsgak()[evIndex];
            int sikertelen = vizsga.getSikertelenVizsgak()[evIndex];
            int osszes = sikeres + sikertelen;

            if (osszes > 0) {
                double sikertelenArany = (double) sikertelen / osszes;
                if (sikertelenArany > legnagyobbArany) {
                    legnagyobbArany = sikertelenArany;
                    legrosszabbNyelv = vizsga.getNyelv();
                }
            }
        }

        System.out.printf("A %d-es évben a legnagyobb sikertelen arányú nyelv: %s (%.2f%%)\n", ev, legrosszabbNyelv, legnagyobbArany * 100);
    }

    // 5. Nyelvek, amelyekből nem volt vizsgázó
    public static ArrayList<String> nyelvekVizsgaNelkul(ArrayList<Vizsga> vizsgak, int ev) {
        int evIndex = ev - 2009;
        ArrayList<String> nyelvekVizsgaNelkul = new ArrayList<>();

        for (Vizsga vizsga : vizsgak) {
            int osszesVizsga = vizsga.getSikeresVizsgak()[evIndex] + vizsga.getSikertelenVizsgak()[evIndex];
            if (osszesVizsga == 0) {
                nyelvekVizsgaNelkul.add(vizsga.getNyelv());
            }
        }

        return nyelvekVizsgaNelkul;
    }

    // 6. Összesítés mentése CSV fájlba
    public static void osszesitesMentese(ArrayList<Vizsga> vizsgak) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("osszesites.csv"));

        for (Vizsga vizsga : vizsgak) {
            int osszesVizsga = Arrays.stream(vizsga.getSikeresVizsgak()).sum() + Arrays.stream(vizsga.getSikertelenVizsgak()).sum();
            int sikeresVizsga = Arrays.stream(vizsga.getSikeresVizsgak()).sum();
            double sikeresArany = (double) sikeresVizsga / osszesVizsga * 100;

            writer.printf("%s; %d; %.2f%%\n", vizsga.getNyelv(), osszesVizsga, sikeresArany);
        }

        writer.close();
    }
}
