package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Felfedezesek> felfedezeseks = new ArrayList<>();

        try{
            Scanner sc = new Scanner(new File("felfedezesek.csv"));
            sc.nextLine();
            while (sc.hasNextLine()){
                String sor = sc.nextLine();
                String[] adatok = sor.split(";");

                felfedezeseks.add(new Felfedezesek(adatok));
            }
            sc.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
            System.exit(1);
        }

        System.out.printf("3. feladat: Elemek szama: %d\n", felfedezeseks.size());

        int okor  = 0;

        for (Felfedezesek elem : felfedezeseks){
            if (elem.getEv().equals("Ókor")){
                okor++;
            }
        }

        System.out.printf("4. feladat: Felfedezések száma az ókorban: %d\n", okor);

        Scanner in  = new Scanner(System.in);
        String vegyjel;
        boolean ervenyeE = false;

        do {
            System.out.println("5.feladat: Kérek egy vegyjelet: ");
            vegyjel = in.nextLine().trim();
            ervenyeE = vegyjel.matches("[a-zA-z]{1,2}");
            if (!ervenyeE){
                System.out.println("Hibás vegyjel");
            }
        }while (!ervenyeE);

        boolean megtalalt = false;
        for (Felfedezesek elem : felfedezeseks){
            if (elem.getVegyjel().equalsIgnoreCase(vegyjel)){
                megtalalt = true;
                System.out.printf("6.feladat: Keresés:\n" +
                        "\t\tElem vagyjele: %s\n" +
                        "\t\tAz elem neve: %s\n" +
                        "\t\tRendszáma: %d\n" +
                        "\t\tFelfedezés éve: %s\n" +
                        "\t\tFelfedezo: %s\n", elem.getVegyjel(), elem.getNev(), elem.getRendszam(), elem.getEv(), elem.getFelfedezo());
                break;
            }
        }
        if (!megtalalt){
            System.out.println("6. feladat: Nincs ilyen elem az adatforrásban!");
        }

        int maxIdo = 0;
        int elozoEv = 0;

        for (Felfedezesek elem :felfedezeseks){
            if (!elem.getEv().equals("Ókor")){
                int aktualisEv = Integer.parseInt(elem.getEv());
                if (elozoEv != 0){
                    int kulonbseg = aktualisEv - elozoEv;
                    if (kulonbseg > maxIdo){
                        maxIdo = kulonbseg;
                    }
                }
                elozoEv = aktualisEv;
            }
        }
        System.out.printf("7. feladat: %d év volt a dleghosszabb idő 2 elem felfedezése között.\n", maxIdo);

        Map<String, Integer> evSzamlalo = new HashMap<>();

        for (Felfedezesek elem : felfedezeseks) {
            if (!elem.getEv().equals("Ókor")) {
                evSzamlalo.put(elem.getEv(), evSzamlalo.getOrDefault(elem.getEv(), 0) + 1);
            }
        }

        System.out.println("8. feladat: Évek, amikor több mint három elemet fedeztek fel:");
        for (Map.Entry<String, Integer> entry : evSzamlalo.entrySet()) {
            if (entry.getValue() > 3) {
                System.out.printf("%s: %d elem\n", entry.getKey(), entry.getValue());
            }
        }
    }
}