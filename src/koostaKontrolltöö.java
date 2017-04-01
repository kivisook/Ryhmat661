import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kersti on 20.03.17.
 */
public class koostaKontrolltöö {
    private String pealkiri;
    private ArrayList<Ülesanne> ülesanded;

    public koostaKontrolltöö(String nimi, ArrayList<Ülesanne> ülesanded) {
        this.ülesanded = ülesanded;
        this.pealkiri = pealkiri;
    }

    public static ArrayList lisaFailistÜlesanded(File sisendfail, String tüüp) throws FileNotFoundException {
        Scanner scanner = new Scanner(sisendfail, "UTF-8");
        ArrayList<String> KTül1 = new ArrayList<>();
        ArrayList<String> KTva1 = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String rida = scanner.nextLine();
            if (tüüp.equals("arvutusülesanne")) {
                ArvutusÜlesanne.tükeldaÜlesanne(KTül1, KTva1, rida); //paneb failist ülesanded ühte listi ja vastused teise
            }
            //siia on vaja veel tekstülesannetefaili varianti
        }
        scanner.close();
        return KTül1;
    }
}
