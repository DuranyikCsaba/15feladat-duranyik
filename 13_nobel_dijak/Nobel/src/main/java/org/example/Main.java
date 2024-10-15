package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Nobel> nobels = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("nobel.csv"));

            sc.nextLine();

            while (sc.hasNextLine()) {
                String sor = sc.nextLine();
                String[] adatok = sor.split(";");

                nobels.add(new Nobel(adatok));
            }

            sc.close();
        }catch (FileNotFoundException ex){
            System.out.println("tg szefos");
            System.exit(1);
        }

        System.out.println("3. feladat: ");

        String feladat3 = "";

        for (int i  = 0; i < nobels.size(); i++)
            if ((nobels.get(i).getKereszt()).equals("Arthur B.")&&(nobels.get(i).getVezetek()).equals("McDonald")){
            feladat3 = nobels.get(i).getTipus();
        }
        System.out.printf("3. feladat: %s\n", feladat3);

        ArrayList<String> feladat4 = new ArrayList<>();
        String vez = "";
        String ker = "";

        for (int i = 0; i < nobels.size(); i++) {
            if (nobels.get(i).getTipus().equalsIgnoreCase("irodalmi") && nobels.get(i).getEvszam()==2017){
                ker = nobels.get(i).getKereszt();
                vez = nobels.get(i).getVezetek();
                feladat4.add(ker+" "+vez);
            }
        }

        System.out.println("4. feladat");
        for (int i = 0; i < feladat4.size(); i++) {
            System.out.println(feladat4.get(i));
        }

        System.out.println("5. feladat");


        for (int i = 0; i < nobels.size(); i++) {
            if ((nobels.get(i).getEvszam() > 1989) && (nobels.get(i).getVezetek() == null || nobels.get(i).getVezetek().isEmpty())){
                System.out.printf("\t\t%d: %s\n", nobels.get(i).getEvszam(), nobels.get(i).getKereszt());
            }
        }

        System.out.println("6. feladat");

        for (int i = 0; i < nobels.size(); i++) {
            String vezetek = nobels.get(i).getVezetek();
            if (vezetek != null && vezetek.contains("Curie")) {
                System.out.printf("\t%d: %s %s(%s)\n", nobels.get(i).getEvszam(), nobels.get(i).getKereszt(), nobels.get(i).getVezetek(), nobels.get(i).getTipus() );
            }
        }


        System.out.println("7. feladat");

        int fizikai = 0;
        int beke = 0;
        int kemiai = 0;
        int orvosi = 0;
        int kozgazdasagtani = 0;
        int irodalmi = 0;

        for (int i = 0; i < nobels.size(); i++) {
            if (nobels.get(i).getTipus() != null && nobels.get(i).getTipus().contains("fizikai")){
                fizikai++;
            } else if (nobels.get(i).getTipus() != null && nobels.get(i).getTipus().contains("kémiai")) {
             kemiai++;
            }else if (nobels.get(i).getTipus() != null && nobels.get(i).getTipus().contains("béke")) {
                beke++;
            }else if (nobels.get(i).getTipus() != null && nobels.get(i).getTipus().contains("orvosi")) {
                orvosi++;
            }else if (nobels.get(i).getTipus() != null && nobels.get(i).getTipus().contains("irodalmi")) {
                irodalmi++;
            }else if (nobels.get(i).getTipus() != null && nobels.get(i).getTipus().contains("közgazdaságtani")) {
                kozgazdasagtani++;
            }
        }

        System.out.printf("fizikai: %d\n", fizikai);
        System.out.printf("kemiai: %d\n", kemiai);
        System.out.printf("orvosi: %d\n", orvosi);
        System.out.printf("irodalmi: %d\n", irodalmi);
        System.out.printf("beke: %d\n", beke);
        System.out.printf("kozgazdasagtani: %d\n", kozgazdasagtani);


        System.out.println("8. feladat");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nobels.size(); i++) {
            sb.append(nobels.get(i).getEvszam()+":"+nobels.get(i).getKereszt()+" "+nobels.get(i).getVezetek()+"\n");
        }


        try {
            PrintWriter writer = new PrintWriter("orvosi.txt", Charset.forName("UTF-8"));

            writer.print(sb.toString());

            writer.close();
        }catch (IOException ex){
            System.out.println("Az állomány írása során hiba történt");
            System.exit(2);
        }




    }
}