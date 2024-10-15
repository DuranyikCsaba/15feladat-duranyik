import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MorzeSzoveg {
    private List<Idezet> idezetek;
    private MorzeAbc morzeAbc;

    public MorzeSzoveg(String fajlNev, MorzeAbc morzeAbc) throws FileNotFoundException {
        this.morzeAbc = morzeAbc;
        idezetek = new ArrayList<>();
        beolvasFajl(fajlNev);
    }

    private void beolvasFajl(String fajlNev) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fajlNev), "UTF-8");
        while (scanner.hasNextLine()) {
            String[] sor = scanner.nextLine().split(";");
            String szerzo = sor[0].trim();
            String morzeSzoveg = sor[1].trim();
            String dekodoltSzoveg = Morze2Szoveg(morzeSzoveg);
            idezetek.add(new Idezet(szerzo, dekodoltSzoveg));
        }
        scanner.close();
    }

    public String getElsoIdezetSzerzoje() {
        return idezetek.get(0).getSzerzo();
    }

    public String getLeghosszabbIdezet() {
        Idezet leghosszabb = idezetek.get(0);
        for (Idezet idezet : idezetek) {
            if (idezet.getSzoveg().length() > leghosszabb.getSzoveg().length()) {
                leghosszabb = idezet;
            }
        }
        return leghosszabb.getSzerzo() + ": " + leghosszabb.getSzoveg();
    }

    public List<String> getArisztoteleszIdezetek() {
        List<String> arisztoteleszIdezetek = new ArrayList<>();
        for (Idezet idezet : idezetek) {
            if (idezet.getSzerzo().equalsIgnoreCase("Arisztotelész")) {
                arisztoteleszIdezetek.add(idezet.getSzoveg());
            }
        }
        return arisztoteleszIdezetek;
    }

    public List<String> getOsszesIdezet() {
        List<String> osszesIdezet = new ArrayList<>();
        for (Idezet idezet : idezetek) {
            osszesIdezet.add(idezet.getSzerzo() + ": " + idezet.getSzoveg());
        }
        return osszesIdezet;
    }

    private String Morze2Szoveg(String morzeSzoveg) {
        StringBuilder szoveg = new StringBuilder();
        String[] szavak = morzeSzoveg.split("       ");
        for (String szo : szavak) {
            String[] betuk = szo.split("   ");
            for (String betu : betuk) {
                String karakter = morzeAbc.getMorzeKod(betu);
                szoveg.append(karakter);
            }
            szoveg.append(" ");
        }
        return szoveg.toString().trim();
    }
}
