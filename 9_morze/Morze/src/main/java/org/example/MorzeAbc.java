import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MorzeAbc {
    private HashMap<String, String> morzeKatalogus;

    public MorzeAbc(String fajlNev) throws FileNotFoundException {
        morzeKatalogus = new HashMap<>();
        beolvasFajl(fajlNev);
    }

    private void beolvasFajl(String fajlNev) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fajlNev), "UTF-8");
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] sor = scanner.nextLine().split("\t");
            morzeKatalogus.put(sor[0], sor[1]);
        }
        scanner.close();
    }

    public int getKarakterekSzama() {
        return morzeKatalogus.size();
    }

    public String getMorzeKod(String karakter) {
        return morzeKatalogus.get(karakter);
    }
}
