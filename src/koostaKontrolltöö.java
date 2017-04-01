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

    public koostaKontrolltöö(String pealkiri, ArrayList<Ülesanne> ülesanded) {
        this.ülesanded = ülesanded;
        this.pealkiri = pealkiri;
    }

    public static ArrayList<String> lisaFailistÜlesanded(File sisendfail, String tüüp) throws FileNotFoundException {
        Scanner scanner = new Scanner(sisendfail, "UTF-8");
        ArrayList<String> KTül1 = new ArrayList<>();
        ArrayList<String> KTva1 = new ArrayList<>();
                //kui etteantud tüüp on arvutusülesanne
        if (tüüp.equals("arvutusülesanne")) {
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                ArvutusÜlesanne.tükeldaÜlesanne(KTül1, KTva1, rida); //rakendab arvutusülesannete klassi meetodid

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
                TekstÜlesanne.tükeldaÜlesanne(KTül1, KTva1, ülesanderida, vastuserida); //rakendab tekstülesannete klassi meetodit
            }
        }
        scanner.close();
        //return KTül1; //tagastab ülesannete listi
        return KTva1;   //tagastab vastuste listi



    }
}
