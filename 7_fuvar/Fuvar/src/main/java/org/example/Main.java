package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Fuvar1 {
    int taxi;
    String indulas;
    int utazas;
    double tavolsag;
    double viteldij;
    double borravalo;
    String fizetes;
}

public class Main {
    public static void main(String[] args) {

        Fuvar1[] fuvars = new Fuvar1[2000];
        int db = 0;

        try {
            Scanner sc = new Scanner(new File("fuvar.csv"));

            sc.nextLine();

            while (sc.hasNextLine()) {
                String sor = sc.nextLine();
                String[] adatok = sor.split(";");

                fuvars[db] = new Fuvar1();

                fuvars[db].taxi = Integer.parseInt(adatok[0]);
                fuvars[db].indulas = adatok[1];
                fuvars[db].utazas = Integer.parseInt(adatok[2]);
                fuvars[db].tavolsag = Double.parseDouble(adatok[3]);
                fuvars[db].viteldij = Double.parseDouble(adatok[4]);
                fuvars[db].borravalo = Double.parseDouble(adatok[5]);
                fuvars[db].fizetes = adatok[6];

                db++;
            }


            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println("A file nem található!");
            System.exit(1);
        }

        System.out.printf("3. feladat: %d fuvar\n", db);

        double bevetel = 0;
        double db1 = 0;

        for (int i = 0; i < db; i++) {
            if (fuvars[i].taxi == 6185){
                bevetel += fuvars[i].viteldij;
                db1++;
            }
        }

        System.out.printf("4. feladat: %.0f fuvar alatt: %.2f$\n", db1, bevetel);

        int bankkartya = 0;
        int keszpenz = 0;
        int vitatott = 0;
        int ingyenes = 0;
        int ismeretlen = 0;

        for (int i = 0; i < db; i++) {
            if (fuvars[i].fizetes.equals("bankkártya")){
                bankkartya++;
            }else if (fuvars[i].fizetes.equals("készpénz")){
                keszpenz++;
            }else if (fuvars[i].fizetes.equals("vitatott")){
                vitatott++;
            }else if (fuvars[i].fizetes.equals("ingyenes")){
                ingyenes++;
            }else if (fuvars[i].fizetes.equals("ismeretlen")){
                ismeretlen++;
            }
        }

        System.out.println("5. feladat:");

        System.out.printf("\t\tbankkártya: %d fuvar\n", bankkartya);
        System.out.printf("\t\tkeszpenz: %d fuvar\n", keszpenz);
        System.out.printf("\t\tvitatott: %d fuvar\n", vitatott);
        System.out.printf("\t\tingyenes: %d fuvar\n", ingyenes);
        System.out.printf("\t\tismeretlen: %d fuvar\n", ismeretlen);

        double km = 0;

        for (int i = 0; i < db; i++) {
            km += fuvars[i].tavolsag * 1.6;
        }

        System.out.printf("6. feladat: %.2fkm", km);

        System.out.println("7. feladat: A leghosszabb fuvar:");

        double max = 0;
        int index = 0;

        for (int i = 0; i < db; i++) {
            if (fuvars[i].utazas > max){
                max = fuvars[i].utazas;
                index = i;
            }
        }

        System.out.printf("\t\tFuvar hossza: %d másdoperc\n", fuvars[index].utazas);
        System.out.printf("\t\tTaxi azonosító: %d\n", fuvars[index].taxi);
        System.out.printf("\t\tMegtett távolság: %.1f km\n", fuvars[index].tavolsag);
        System.out.printf("\t\tViteldíj: %.2f$\n", fuvars[index].viteldij);


        System.out.println("8. feladat: hibak.txt");
    }
}
