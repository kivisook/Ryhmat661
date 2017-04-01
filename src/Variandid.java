import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lindsirj on 1.04.2017.
 */
public class Variandid {
    ArrayList<ÕpilaseTöö> variant = new ArrayList<>();

    public ArrayList<ÕpilaseTöö> getVariant() {
        return variant;
    }

    //Õpilaste nimikirja lugemine failist
    public void loeNimekiri() throws FileNotFoundException {
        File fileNK = new File("nimekiri.txt");
        Scanner scanner = new Scanner(fileNK, "UTF-8");
        while (scanner.hasNextLine()) {
            String rida = scanner.nextLine();
            String[] osad = rida.split("\t");
            //ÕpilaseTöö sirje = new ÕpilaseTöö(osad[0], osad[1]);
            variant.add(new ÕpilaseTöö(osad[0], osad[1]));
        }
        scanner.close();
    }

//    public void genereeri(String ÕpilaseID){
//        ÕpilaseTöö koht;
//        koht=variant.indexOf("1");

   // }


    //väljastab nimekirja, kus on õpilaste nimekiri ja tema variandid.
    public String trükiVariandid(){
        String trükk="";
        for (ÕpilaseTöö õpilaseTöö : variant) {
            trükk += õpilaseTöö.trükiLeotelu() +'\n';
        }
        return trükk;
    }

    @Override
    public String toString() {
        return "Variandid{" +
                "variant=" + variant +
                '}';
    }
}
