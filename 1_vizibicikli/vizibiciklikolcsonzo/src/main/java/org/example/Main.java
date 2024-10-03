package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        ArrayList<Kolcsonzes> kolcsonzesek = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("src/kolcsonzesek.txt"));
            sc.nextLine();
            while (sc.hasNextLine()) {
                Kolcsonzes k = new Kolcsonzes(sc.nextLine());
                kolcsonzesek.add(k);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //5.feladat

        System.out.println("5.feladat: Napi kolcsonzesek szama: " + kolcsonzesek.size());

        //6.feladat

          Scanner be = new Scanner(System.in);
        System.out.println("6. feladat: Kérek egy nevet: ");
        String nev6 = be.nextLine();
        boolean vaneredmeny = false;

        for (Kolcsonzes k : kolcsonzesek) {
            if (k.getNev().equals(nev6)) {
                if (!vaneredmeny) {
                    System.out.println(nev6 + " kölcsönzései:");
                    vaneredmeny = true;
                }
                // Vezető nullák hozzáadása egyjegyű órák és percek előtt
                String elvitel = String.format("%02d:%02d", k.getEOra(), k.getEPerc());
                String visszahozatal = String.format("%02d:%02d", k.getVOra(), k.getVPerc());

                System.out.println(elvitel + " - " + visszahozatal);
            }
        }

        if (!vaneredmeny) {
            System.out.println("Nem volt ilyen nevű kölcsönző!");
        }

        //7. feladat

        System.out.println("Kerek egy idopontot ora:perc alakban: ");

        String[] ido = be.nextLine().split(":");
        int keresettOra = Integer.parseInt(ido[0]);
        int keresettPerc = Integer.parseInt(ido[1]);

        for (Kolcsonzes k : kolcsonzesek) {
            if ((keresettOra > k.getEOra() || (keresettOra == k.getEOra() && keresettPerc >= k.getEPerc())) &&
                    (keresettOra < k.getVOra() || (keresettOra == k.getVOra() && keresettPerc <= k.getVPerc()))) {
                System.out.printf("%02d:%02d - %02d:%02d : %s\n", k.getEOra(), k.getEPerc(), k.getVOra(), k.getVPerc(), k.getNev());
            }
        }

        //8. feladat

        int keresettpenz = 0;

        for (Kolcsonzes k : kolcsonzesek){
            int eperc = k.getEOra() * 60 + k.getEPerc();
            int vperc = k.getVOra() * 60 + k.getVPerc();
            int idotartam = vperc - eperc;

            int felorak = (int) Math.ceil(idotartam/30.0);
            keresettpenz += felorak * 2400;
        }

        System.out.printf("8. feladat: Napi bevetel : %d Ft", keresettpenz);

        //9. feladat

        try (PrintWriter writer = new PrintWriter("F.txt", "UTF-8")) {
            for (Kolcsonzes k : kolcsonzesek) {
                if (k.getJAzon() == 'F') {
                    writer.printf("%02d:%02d - %02d:%02d : %s\n", k.getEOra(), k.getEPerc(), k.getVOra(), k.getVPerc(), k.getNev());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //10. feladat


        Map<Character, Integer> statisztika = new TreeMap<>();

        for (Kolcsonzes k : kolcsonzesek) {
            statisztika.put(k.getJAzon(), statisztika.getOrDefault(k.getJAzon(), 0) + 1);
        }

        System.out.println("10. feladat: Statisztika");
        for (Map.Entry<Character, Integer> entry : statisztika.entrySet()) {
            System.out.printf("\t\t%S : %d\n",entry.getKey(), entry.getValue());
        }






    }
}