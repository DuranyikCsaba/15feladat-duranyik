package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Kutyanevek> nevek = new ArrayList<>();
    public static List<Kutyafajtak> fajtak = new ArrayList<>();
    public static List<Kutyak> kutyaadatok = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // KutyaNevek.csv beolvasása
            BufferedReader olvas = new BufferedReader(new InputStreamReader(new FileInputStream("KutyaNevek.csv"), StandardCharsets.UTF_8));
            String fejlec = olvas.readLine();
            String sor;
            while ((sor = olvas.readLine()) != null) {
                nevek.add(new Kutyanevek(sor));
            }
            olvas.close();

            // KutyaFajtak.csv beolvasása
            BufferedReader olvas2 = new BufferedReader(new InputStreamReader(new FileInputStream("KutyaFajtak.csv"), StandardCharsets.UTF_8));
            String fejlec2 = olvas2.readLine();
            while ((sor = olvas2.readLine()) != null) {
                fajtak.add(new Kutyafajtak(sor));
            }
            olvas2.close();

            // Kutyak.csv beolvasása
            BufferedReader olvas3 = new BufferedReader(new InputStreamReader(new FileInputStream("Kutyak.csv"), StandardCharsets.UTF_8));
            String fejlec3 = olvas3.readLine();
            while ((sor = olvas3.readLine()) != null) {
                kutyaadatok.add(new Kutyak(sor));
            }
            olvas3.close();

            // Kutya nevek és fajták hozzárendelése
            for (Kutyak kutya : kutyaadatok) {
                for (Kutyafajtak fajta : fajtak) {
                    if (kutya.fajtaId == fajta.fajtaid) {
                        kutya.fajtaNev = fajta.fajtanev;
                    }
                }
                for (Kutyanevek nev : nevek) {
                    if (kutya.nevId == nev.nevekid) {
                        kutya.kutyaNev = nev.kutyanevek;
                    }
                }
            }

            // 3. feladat: Kutyanevek száma
            System.out.println("3. feladat: Kutyanevek száma: " + nevek.size());

            // 6. feladat: Kutyák átlagéletkora
            double atlageletkor = 0;
            for (Kutyak kutya : kutyaadatok) {
                atlageletkor += kutya.eletkor;
            }
            System.out.println("6. feladat: A kutyák átlagéletkora: " + Math.round(atlageletkor / kutyaadatok.size() * 100.0) / 100.0);

            // 7. feladat: Legidősebb kutya
            Kutyak legidosebbKutya = kutyaadatok.stream().max(Comparator.comparingInt(k -> k.eletkor)).orElse(null);
            if (legidosebbKutya != null) {
                System.out.println("7. feladat: A legidősebb kutya neve és fajtája: " + legidosebbKutya.kutyaNev + ", " + legidosebbKutya.fajtaNev);
            }

            // 8. feladat: 2018. január 10-i vizsgált kutyák
            System.out.println("8. feladat: január 10-én vizsgált kutya fajták");
            kutyaadatok.stream()
                .filter(k -> new SimpleDateFormat("yyyy.MM.dd").format(k.ellenorzes).equals("2018.01.10"))
                .collect(Collectors.groupingBy(k -> k.fajtaNev, Collectors.counting()))
                .forEach((fajta, szam) -> System.out.println("\t" + fajta + ": " + szam + " kutya"));

            // 9. feladat: Legjobban leterhelt nap
            Map<String, Long> napok = kutyaadatok.stream()
                .collect(Collectors.groupingBy(k -> new SimpleDateFormat("yyyy-MM-dd").format(k.ellenorzes), Collectors.counting()));

            String maxNap = Collections.max(napok.entrySet(), Map.Entry.comparingByValue()).getKey();
            long maxKutya = Collections.max(napok.values());

            System.out.println("9. feladat: Legjobban leterhelt nap: " + maxNap + ": " + maxKutya + " kutya");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
