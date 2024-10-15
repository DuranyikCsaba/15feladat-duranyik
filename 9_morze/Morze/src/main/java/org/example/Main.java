import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            MorzeAbc morzeAbc = new MorzeAbc("morzeabc.txt");
            System.out.println("2. feladat: Karakterek száma a morze kódtárban: " + morzeAbc.getKarakterekSzama());

            Scanner sc = new Scanner(System.in);
            System.out.print("4. feladat: Kérek egy karaktert: ");
            String bekertKarakter = sc.nextLine().toUpperCase();
            String morzeKod = morzeAbc.getMorzeKod(bekertKarakter);
            if (morzeKod != null) {
                System.out.println(bekertKarakter + " morze kódja: " + morzeKod);
            } else {
                System.out.println("Nem található a kódtárban ilyen karakter!");
            }

            MorzeSzoveg morzeSzoveg = new MorzeSzoveg("morze.txt", morzeAbc);
            System.out.println("7. feladat: Az első idézet szerzője: " + morzeSzoveg.getElsoIdezetSzerzoje());
            System.out.println("8. feladat: A leghosszabb idézet szerzője és szövege: " + morzeSzoveg.getLeghosszabbIdezet());
            System.out.println("9. feladat: Arisztotelész idézetei:");
            for (String idezet : morzeSzoveg.getArisztoteleszIdezetek()) {
                System.out.println(idezet);
            }

            PrintWriter writer = new PrintWriter("forditas.txt");
            for (String sor : morzeSzoveg.getOsszesIdezet()) {
                writer.println(sor);
            }
            writer.close();
            System.out.println("10. feladat: A forditas.txt fájl elkészült!");

        } catch (FileNotFoundException e) {
            System.out.println("Hiba: " + e.getMessage());
        }
    }
}
