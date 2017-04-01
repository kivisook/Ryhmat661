import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lindsirj on 20.03.2017.
 */
public class TestStart {
    public static void main (String [] args) throws FileNotFoundException {
        File file = new File("ylesanded.txt");
        Scanner scanner = new Scanner(file, "UTF-8");
        ArrayList<String> Ylist1 = new ArrayList<>();
        ArrayList<String> Vlist1 = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String rida = scanner.nextLine();
            ArvutusÜlesanne.tükeldaÜlesanne(Ylist1, Vlist1, rida); //paneb failist ülesanded ühte listi ja vastused teise
        }
        scanner.close();

        System.out.println(Ylist1); //ülesannete list
        System.out.println(Vlist1); //vastuste list

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
