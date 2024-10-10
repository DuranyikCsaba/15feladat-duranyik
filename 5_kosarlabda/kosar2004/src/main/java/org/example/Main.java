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
        ArrayList<Eredmenyek> eredmenyeks = new ArrayList<>();

        try{
            Scanner sc = new Scanner(new File("eredmenyek.csv"));
            sc.nextLine();

            while (sc.hasNextLine()){
                String sor = sc.nextLine();
                String[] adatok = sor.split(";");

                eredmenyeks.add(new Eredmenyek(adatok));
            }

            sc.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
            System.exit(1);
        }



        int rmdbHazai = 0;
        int rmdbIdegen = 0;

        for (Eredmenyek elem : eredmenyeks){
            if (elem.getIdegen().equals("Real Madrid")){
                rmdbIdegen++;
            } else if (elem.getHazai().equals("Real Madrid")) {
                rmdbHazai++;
            }
        }

        System.out.printf("3.feladat: Real Madrid: Hazai: %d, Idegen: %d\n", rmdbHazai, rmdbIdegen);

        boolean voltE = false;

        for (Eredmenyek elem : eredmenyeks){
            if (elem.getHazaiPont() == elem.getIdegenPont()){
                voltE = true;
                break;
            }
        }
        if (voltE){
            System.out.println("4. feladat: Volt döntetlen? igen");
        }else {
            System.out.println("4. feladat: Volt döntetlen? nem");
        }

        for (Eredmenyek elem : eredmenyeks){
            if (elem.getHazai().contains("Barcelona")){
                System.out.printf("5. feladat: barcelonai csapat neve: %s\n", elem.getHazai());
                break;
            }
        }

        System.out.println("6.feladat:");
        for(Eredmenyek elem : eredmenyeks){
            if (elem.getIdopont().equals("2004-11-21")){
                System.out.printf("\t\t%s - %s (%d:%d)\n", elem.getHazai(), elem.getIdegen(), elem.getHazaiPont(), elem.getIdegenPont());
            }
        }


        System.out.println("7.feladat");
        Map<String , Integer> helyszinek = new HashMap<>();

            for (Eredmenyek elem : eredmenyeks){
                String helyszin = elem.getHelyszin();
                helyszinek.put(helyszin, helyszinek.getOrDefault(helyszin, 0) +1);
            }


            for (Map.Entry<String, Integer> entry : helyszinek.entrySet()){
                if (entry.getValue() >= 20){
                    System.out.printf("\t\t%s: %d\n", entry.getKey(), entry.getValue());
                }
            }

    }
}