import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lindsirj on 20.03.2017.
 */
public class TestStart2 {
    public static void main (String [] args) throws FileNotFoundException {



        //arvutusülesannete failist
        File file1 = new File("ylesanded.txt");
        Scanner scanner = new Scanner(file1, "UTF-8");
        ArrayList<String> Ylist1 = new ArrayList<>();
        ArrayList<String> Vlist1 = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String rida = scanner.nextLine();
            ArvutusÜlesanne.tükeldaÜlesanne(Ylist1, Vlist1, rida); //paneb failist ülesanded ühte listi ja vastused teise
        }
        scanner.close();

        //System.out.println(Ylist1); //arvutusülesannete list
        //System.out.println(Vlist1); //arvutusülesannete vastuste list

        //tekstülesannete failist
        File file2 = new File("tekstülesanded.txt");
        Scanner sc = new Scanner(file2, "UTF-8");
        ArrayList<String> YlVa = new ArrayList<>();     //ajutine, siia kogutakse scanneriga ülesanded ja vastused koos
        ArrayList<String> Ylist2 = new ArrayList<>();   //tühi list, kuhu lähevad ülesanded
        ArrayList<String> Vlist2 = new ArrayList<>();   //tühi list, kuhu lähevad vastused
        while (sc.hasNextLine()) {
            String ridadekaupa = sc.nextLine();
            YlVa.add(ridadekaupa);
        }
        sc.close();

        for (int i = 0; i < YlVa.size() - 1; i=i+2) {   //paneb failist ülesanded ühte listi ja vastused teisel
            String ülesanderida = YlVa.get(i);
            String vastuserida = YlVa.get(i+1);
            TekstÜlesanne.tükeldaÜlesanne(Ylist2, Vlist2, ülesanderida, vastuserida);
        }

        //System.out.println(Ylist2); //prindib tekstülesannete listi
        //System.out.println(Vlist2); //prindib tekstülesannete vastuste listi

        //võtab ettentud failist kõik ülesanded ja teeb neist kontrolltöö ülesanded
        koostaKontrolltöö.lisaFailistÜlesanded(file1, "arvutusülesanne");
        System.out.println(koostaKontrolltöö.lisaFailistÜlesanded(file1, "arvutusülesanne"));
        System.out.println(koostaKontrolltöö.lisaFailistÜlesanded(file2, "tekstülesanne"));

        //ülesandeid saab ka ühekaupa sisestada
        //Ülesanne Y1 = new ArvutusÜlesanne("esimene", "3+2=", "5");

        ArrayList<String> Ylist = new ArrayList<>();
        ArrayList<String> Vlist = new ArrayList<>();
        ArvutusÜlesanne.trükiÜlesanne(Ylist, "4+6");
        ArvutusÜlesanne.trükiVastus(Vlist, "10");
        ArvutusÜlesanne.trükiÜlesanne(Ylist, "5+7");
        ArvutusÜlesanne.trükiVastus(Vlist, "12");
        //System.out.println(Ylist);
        //System.out.println(Vlist);

    }
}
