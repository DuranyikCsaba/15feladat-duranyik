package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String verdteli(int operandus1, String operator, int operandus2){
        if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*") ||operator.equals("div") ||operator.equals("mod")){
            if ((operator.equals("/") || operator.equals("div") || operator.equals("mod")) && operandus2 == 0){
                return operandus1 + " " + operator + " " + operandus2 + " " + "= Egyéb hiba!";
            }
            try{
                switch (operator){
                    case "+":
                        int osszeg = Math.addExact(operandus1, operandus2);
                        return operandus1 + " " + operator + " " + operandus2 + " " + "=" + " " + osszeg;
                    case "-":
                        int kulonbseg = Math.subtractExact(operandus1, operandus2);
                        return operandus1 + " " + operator + " " + operandus2 + " " + "=" + " " + kulonbseg;
                    case "*":
                        int szorzat = Math.multiplyExact(operandus1, operandus2);
                        return operandus1 + " " + operator + " " + operandus2 + " " + "=" + " " + szorzat;
                    case "/":
                    case "div":
                        int hanyados = operandus1 / operandus2;
                        return operandus1 + " " + operator + " " + operandus2 + " " + "=" + " " + hanyados;
                    case "mod":
                        return operandus1 + " " + operator + " " + operandus2 + " " + "=" + " " + operandus1 % operandus2;
                }
            }catch (ArithmeticException exception){
                return operandus1 + " " + operator + " " + operandus2 + " " + "= Egyéb hiba!";
            }
        }else {
            return operandus1 + " " + operator + " " + operandus2 + " " + "= Hibás operátor!";
        }
        return "A pacski az az ha cigarettat szisz, kiótod, asztan kicsinaod belule a doant. Úgyho azé mondom gyerekek, nem kell adni éte pézt. Az ingyen van a pacski, ez a cigaretta amirül én beszélek. Elmész a kocsmába, kiszeded a kocsmábó, vagy ha példájul nincsennek essőidő, akkó főszedem a fődrő, kicsikkezem és ugyanúgy van belülle doan.";
    }



    public static void main(String[] args) {

        ArrayList<Kifejezesek> kifejezesek = new ArrayList<>();



        try{
            Scanner sc = new Scanner(new File("kifejezesek.txt"));
            while (sc.hasNextLine()){
                String sor = sc.nextLine();
                String[] adatok = sor.split(" ");

                kifejezesek.add(new Kifejezesek(adatok));

            }
            sc.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
            System.exit(1);
        }

        System.out.printf("2. feladat: Kifejezések száma: %d\n", kifejezesek.size());

        int mods = 0;

        for (Kifejezesek elem : kifejezesek){
            if (elem.getOperator().equals("mod")){
                mods++;
            }
        }

        System.out.printf("3. feladat: kifejezések maradékos osztással: %d\n", mods);

        boolean vanE4 = false;

        for (Kifejezesek elem : kifejezesek){
            if (elem.getOperandus1() % 10 ==  0 && elem.getOperandus2() % 10 ==  0){
                vanE4 = true;
            }
        }

        if (vanE4){
            System.out.println("4. Feladat: Van ilyen kifejezés!");
        }else {
            System.out.println("4. Feladat: Nincs  ilyen kifejezés!");
        }

        int[] stat = new int[6];

        for (Kifejezesek elem : kifejezesek){
            switch (elem.getOperator()){
                case "+": stat[0]++;
                break;
                case "-": stat[1]++;
                break;
                case "*": stat[2]++;
                break;
                case "/": stat[3]++;
                break;
                case "div": stat[4]++;
                break;
                case "mod": stat[5]++;
                break;
            }
        }

        System.out.println("5. feladat: statisztika");
        System.out.printf("\t\tmod -> %d db\n\t\t/ -> %d db\n\t\tdiv -> %d db\n\t\t- -> %d db\n\t\t* -> %d db\n\t\t+ -> %d db\n", stat[5], stat[3], stat[4], stat[1], stat[2], stat[0]);

        Scanner beker = new Scanner(System.in);

        String vegszo = "vége";
        String pacski;

        do{
            System.out.println("7. feladat: Kérek egy kifejezést: (pl. 1 + 1)");
            pacski = beker.nextLine();
            if (!pacski.equals(vegszo)){
                String[] pacskiTomb = pacski.split(" ");
                String eredmeny = verdteli(Integer.parseInt(pacskiTomb[0]), pacskiTomb[1], Integer.parseInt(pacskiTomb[2]));;
                System.out.printf("\t\t%s\n", eredmeny);
            }
        }while (!pacski.equals(vegszo));

        try {
            PrintWriter iro = new PrintWriter(new File("eredmenyek.txt"));
            try {
                Scanner olvaso = new Scanner(new File("kifejezesek.txt"));
                while (olvaso.hasNextLine()){
                    String sor = olvaso.nextLine();
                    String [] adatok = sor.split(" ");
                    iro.println(verdteli(Integer.parseInt(adatok[0]), adatok[1], Integer.parseInt(adatok[2])));
                }
            }catch (FileNotFoundException exception){
                System.out.println("A fájl beolvasása sikertelen!");
                System.exit(1);
            }
            iro.close();
        }catch (IOException exception){
            System.out.println("A fájl írása sikertelen!");
        }
        System.out.print("8. feladat: eredmenyek.txt");

    }
}