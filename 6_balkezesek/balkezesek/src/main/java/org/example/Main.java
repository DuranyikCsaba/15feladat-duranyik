package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Balkezesek> balkezeseks = new ArrayList<>();

        try{
            Scanner sc = new Scanner(new File("balkezesek.csv"));

            sc.nextLine();

            while (sc.hasNextLine()){
                String sor = sc.nextLine();
                String[] adatok = sor.split(";");
                balkezeseks.add(new Balkezesek(adatok));
            }


        }catch(FileNotFoundException ex){
            System.out.println("Nem tanáhaó a fáljlkjljj");
            System.exit(1);
        }

        System.out.printf("3. feladat: %d\n", balkezeseks.size());


        System.out.println("4. feladat:");

        for (int i = 0; i < balkezeseks.size(); i++) {
            if (balkezeseks.get(i).getUtolso().contains("1999-10-")){
                System.out.printf("\t\t%s, %.1f cm\n", balkezeseks.get(i).getNev(), balkezeseks.get(i).getMagassag()*2.54);
            }
        }

        System.out.println("5. feladat");

        int bekert = 0;

        Scanner sc2 = new Scanner(System.in);

        System.out.println("Kérek egy 1990 és 1999 közötti évszámot!: ");
        bekert = sc2.nextInt();

        while (!((1990 <= bekert)&&(bekert <= 1999))){
            System.out.println("Hibás adat! Kérek egy 1990 és 1999 közötti évszámot!: ");
            bekert = sc2.nextInt();
        }

        double db = 0;
        double ossz = 0;
        int ev1 = 0;
        int ev2 = 0;

        for (int i = 0; i < balkezeseks.size(); i++) {
            ev1 = Integer.parseInt(balkezeseks.get(i).getElso().substring(0, 4));
            ev2 = Integer.parseInt(balkezeseks.get(i).getUtolso().substring(0, 4));
            if (( ev1 <= bekert ) && ( ev2 >= bekert )){
                ossz += balkezeseks.get(i).getSuly();
                db++;
            }
        }

        System.out.printf("6. feladat: %.2f font \n", ossz/db);


    }
}