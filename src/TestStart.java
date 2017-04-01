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
        while (scanner.hasNextLine()) {
            String rida = scanner.nextLine();
            System.out.println(ArvutusÜlesanne.tükeldaÜlesanne(rida)); //katsetus, et meetod töötab
        }
        scanner.close();


    }
}
