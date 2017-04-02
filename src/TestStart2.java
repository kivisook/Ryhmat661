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
        scanner.close();

        //System.out.println(koostaKontrolltöö.lisaFailistÜlesanded(file1, "arvutusülesanne"));

        File file2 = new File("tekstülesanded.txt");
        Scanner sc = new Scanner(file2, "UTF-8");
        sc.close();
        //System.out.println(koostaKontrolltöö.lisaFailistÜlesanded(file2, "tekstülesanne"));


        //ülesandeid saab ka ühekaupa sisestada
        //Ülesanne Y1 = new ArvutusÜlesanne("esimene", "3+2=", "5");

        //ArvutusÜlesanne.trükiÜlesanne("4+6");
        //ArvutusÜlesanne.trükiVastus("10");


        ÕpilaseTöö mary = new ÕpilaseTöö("1.õ", "Mary Aas");
        for (int i = 0; i < 10; i++) {
            mary.lisaÜlesanne(koostaKontrolltöö.lisaFailistÜlesanded(file1, "arvutusülesanne").get(i));
           // mary.lisaÜlesanne(koostaKontrolltöö.lisaFailistÜlesanded(file2, "tekstülesanne").get(i));
        }

        System.out.println(mary.trükiÕpilasele());
        System.out.println(mary.trükiÕpilaseVastused());

    }
}
