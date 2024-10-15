package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Auto> autok = new ArrayList<>();
        ArrayList<Igeny> igenyek = new ArrayList<>();
        try {
            Scanner olvaso1 = new Scanner(new File("autok.csv"));
            Scanner olvaso2 = new Scanner(new File("igenyek.csv"));
            olvaso1.nextLine();
            olvaso2.nextLine();
            while (olvaso1.hasNextLine()){
                String sor = olvaso1.nextLine();
                String [] adatok = sor.split(";");
                autok.add(new Auto(adatok));
            }
            while (olvaso2.hasNextLine()){
                String sor = olvaso2.nextLine();
                String [] adatok = sor.split(";");
                igenyek.add(new Igeny(adatok));
            }
            olvaso1.close();
            olvaso2.close();
        }catch (FileNotFoundException exception){
            System.out.println("Sikertelen fájl beolvasás!");
            System.exit(1);
        }

        System.out.printf("2. feladat\n\t%d autós hirdet fuvart\n", autok.size());

        int db = 0;
        for (Auto elem : autok){
            if (elem.getIndulas().equals("Budapest") && elem.getCel().equals("Miskolc")){
                db += elem.getFerohely();
            }
        }
        System.out.printf("3. feladat\n\tÖsszesen %d férőhelyet hirdettek az autósok Budapestről Miskolcra\n", db);

        int max = Integer.MIN_VALUE;
        String indulas = "";
        String cel = "";
        for (Auto elem : autok){
            if (elem.getFerohely()>max){
                max = elem.getFerohely();
                indulas = elem.getIndulas();
                cel = elem.getCel();
            }
        }
        System.out.printf("4. feladat\n\tA legtöbb férőhelyet (%d-ot) az %s-%s útvonalon ajánlották fel a hirdetők\n", max, indulas, cel);

        System.out.println("5. feladat");
        for (Igeny elemigeny : igenyek){
            for (Auto elemauto : autok){
                if (elemigeny.getIndulas().equals(elemauto.getIndulas()) && elemigeny.getCel().equals(elemauto.getCel()) && elemigeny.getSzemelyek() == elemauto.getFerohely()){
                    System.out.printf("\t%s => %s\n", elemigeny.getAzonosito(), elemauto.getRendszam());
                }
            }
        }
        try {
            PrintWriter iro = new PrintWriter("utasuzenetek.txt");
            for (Igeny elemigeny : igenyek){
                boolean volte = false;
                Auto talalt = null;
                for (Auto elemauto : autok){
                    if (elemigeny.getIndulas().equals(elemauto.getIndulas()) && elemigeny.getCel().equals(elemauto.getCel()) && elemigeny.getSzemelyek() == elemauto.getFerohely()){
                        volte = true;
                        talalt = elemauto;
                        break;
                    }
                }
                if (volte){
                    iro.printf("%s: Rendszám: %s, Telefonszám: %s \n", elemigeny.getAzonosito(), talalt.getRendszam(), talalt.getTelefonszam());
                }else {
                    iro.printf("%s: Sajnos nem sikerült autót találni\n", elemigeny.getAzonosito());
                }
            }
            iro.close();
        }catch (IOException e){
            System.out.println("A fájl írása sikertelen");
            System.exit(1);
        }
    }
}