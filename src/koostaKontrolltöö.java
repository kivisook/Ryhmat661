import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kersti on 20.03.17.
 */
public class koostaKontrolltöö {
    private String pealkiri;
    private ArrayList<Ülesanne> ülesanded = new ArrayList<>();;

    // konstruktor
    public koostaKontrolltöö(String pealkiri) {
        this.pealkiri = pealkiri;
    }
    // konstruktor
    public koostaKontrolltöö(String pealkiri, ArrayList<Ülesanne> ülesanded) {
        this.ülesanded = ülesanded;
        this.pealkiri = pealkiri;
    }

    public void lisaFailistÜlesanded(String failinimi, String tüüp) throws FileNotFoundException {
        File file = new File(failinimi);
        Scanner scanner = new Scanner(file, "UTF-8");

        //kui etteantud tüüp on arvutusülesanne
        if (tüüp.equals("arvutusülesanne")) {
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                this.ülesanded.add(ArvutusÜlesanne.tükeldaÜlesanne(rida)); //rakendab arvutusülesannete klassi meetodid
            }
        }
        //kui etteantud tüüp on tekstülesanne
        else if (tüüp.equals("tekstülesanne")) {
            ArrayList<String> YlVa = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String ridadekaupa = scanner.nextLine();
                YlVa.add(ridadekaupa);
            }
            for (int i = 0; i < YlVa.size() - 1; i=i+2) {
                String ülesanderida = YlVa.get(i);
                String vastuserida = YlVa.get(i+1);
                this.ülesanded.add(TekstÜlesanne.tükeldaÜlesanne(ülesanderida, vastuserida)); //rakendab tekstülesannete klassi meetodit
            }
        }
        scanner.close();
    }

    @Override
    public String toString() {
        return "Kontrolltöö{" +
                '\''+ pealkiri + '\'' +
                ", ülesanded=" + ülesanded +
                '}';
    }

    public ArrayList<Ülesanne> getÜlesanded() {
        return ülesanded;
    }
}
