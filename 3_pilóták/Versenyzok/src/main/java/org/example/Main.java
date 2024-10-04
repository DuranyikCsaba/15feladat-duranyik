package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pilotak> pilotak = new ArrayList<>();

        try {
            Scanner read = new Scanner(new File("pilotak.csv"));
            read.nextLine();

            while (read.hasNextLine()){
                String sor = read.nextLine();
                String[] adatok = sor.split(";");

                pilotak.add(new Pilotak(adatok));
            }

            read.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        //3. feladat:

        System.out.printf("3. feladat: %d\n", pilotak.size());

        //4. feladat:

        System.out.printf("4. feladat: %s\n", pilotak.get(pilotak.size() - 1).getNev());

        //5. feladat:
        System.out.println("5. feladat:");

        for (Pilotak elem : pilotak){
            String[] datum = elem.getSzulDatum().split("\\.");
            int ev = Integer.parseInt(datum[0].trim());
            if (ev < 1901){
                System.out.printf("\t\t%s (%s)\n",elem.getNev(), elem.getSzulDatum());
            }
        }

        //6. feladat:

        int minRajtszam = Integer.MAX_VALUE;
        int minPilota = -1;

        for (Pilotak elem : pilotak){
            if (elem.getRajtszam() != null && elem.getRajtszam() < minRajtszam){
                minRajtszam = elem.getRajtszam();
                minPilota = pilotak.indexOf(elem);
            }
        }

        System.out.printf("6. feladat: %s\n", pilotak.get(minPilota).getNemzetiseg());

        //7. feladat:

        Map<Integer, Integer> rajtszamok = new HashMap<>();
        for (Pilotak pilota : pilotak) {
            if (pilota.getRajtszam() != null) {
                rajtszamok.put(pilota.getRajtszam(), rajtszamok.getOrDefault(pilota.getRajtszam(), 0) + 1);
            }
        }


        System.out.print("7. feladat: ");
        boolean vanTobbPilota = false;

        for (Map.Entry<Integer, Integer> entry : rajtszamok.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.printf("%d ", entry.getKey(), entry.getValue());
                vanTobbPilota = true;
            }
        }

    }
}