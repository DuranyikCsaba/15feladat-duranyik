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

        ArrayList<Verseny> versenies = new ArrayList<>();


        try {
            Scanner sc = new Scanner(new File("jackie.txt"));

            sc.nextLine();

            while (sc.hasNextLine()){
                String sor = sc.nextLine();
                String[] adatok = sor.split("\t");

                versenies.add(new Verseny(adatok));
            }


            sc.close();
        }catch (FileNotFoundException ex){
            System.out.println("A file nem tanáható");
            System.exit(1);
        }

        System.out.println("3. feladat: " + versenies.size());

        int max = versenies.get(0).getRaces();
        int maxEv = versenies.get(0).getYear();

        for (int i = 1; i < versenies.size(); i++){
            if (versenies.get(i).getRaces() > max){
                max = versenies.get(i).getRaces();
                maxEv = versenies.get(i).getYear();
            }
        }

        System.out.println("4. feladat: " + maxEv);

        ArrayList<Integer> evtizedek = new ArrayList<>();

        for (Verseny elem : versenies){
            int evtized = ((elem.getYear() % 100) / 10) * 10;
            if (!evtizedek.contains(evtized)) {
                evtizedek.add(evtized);
            }
        }

        for (int evtized : evtizedek){
            int osszeg = 0;
            for (Verseny elem : versenies){
                int ét = ((elem.getYear()%100)/10)*10;
                if (ét == evtized){
                    osszeg += elem.getWins();
                }
            }

            System.out.printf("\t\t%d-es évek: %d megnyert verseny \n", evtized, osszeg);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head></head>");
        sb.append("<style> td{ border: 1px solid black; }</style>");
        sb.append("<body>");
        sb.append("<h1>Jackie Stewart</h1>");
        sb.append("<table>");
        for (Verseny elem : versenies){
             sb.append("<tr>");
             sb.append("<td>");
             sb.append(elem.getYear());
             sb.append("</td>");
             sb.append("<td>");
             sb.append(elem.getRaces());
             sb.append("</td>");
             sb.append("<td>");
             sb.append(elem.getWins());
             sb.append("</td>");
             sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</body>");
        sb.append("</html>");


        try {
            PrintWriter writer = new PrintWriter("jackie.html", Charset.forName("UTF-8"));

            writer.print(sb.toString());

            writer.close();
        }catch (IOException ex){
            System.out.println("Az állomány írása során hiba történt");
        }



    }
}