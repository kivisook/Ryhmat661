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

    public void genereeriÜhele(ÕpilaseTöö õpilane, koostaKontrolltöö kt, String algoritm, int ülesanneteArv ) {
        // tühjendab. kustutab varem genereritud variandid ära
        õpilane.kustutaÕpilaseÜlesanded();
        if (algoritm == "KÕIK"){
            for (int i = 0; i < ülesanneteArv; i++) {
               õpilane.lisaÜlesanne(kt.getÜlesanded().get(i));
            }
        }
    }
    // sellega saab genererida ühele käsurealt teades õpilase koodi.
    public void genereeriÜhele(String õpilaseID, koostaKontrolltöö kt, String algoritm, int ülesanneteArv ) {
        for (ÕpilaseTöö seeÕpilane : variant) {
            // otsime õpilast, kelle id on õpilaseID
            if (seeÕpilane.getId().compareTo(õpilaseID) == 0) {
                genereeriÜhele(seeÕpilane, kt, algoritm, ülesanneteArv);
            }
        }
    }


    public void genereeriKõigile(koostaKontrolltöö kt, String algoritm, int ülesanneteArv ) {
        // üle kogu variandi tabeli õpilaste
        for (ÕpilaseTöö õpilane : variant) {
            genereeriÜhele(õpilane, kt, algoritm,ülesanneteArv );
        }
    }

    //väljastab nimekirja, kus on õpilaste nimekiri ja tema variandid.
    public String kuvaVariandid(){
        String trükk = "VARIANTIDE LEHT \n";
        for (ÕpilaseTöö õpilaseTöö : variant) {
            trükk += õpilaseTöö.trükiLeotelu() +'\n';
        }
        return trükk;
    }

    public String kuvaVastused(){
        String trükk = "VASTUSTE LEHT \n";
        for (ÕpilaseTöö õpilaseTöö : variant) {
            trükk += õpilaseTöö.trükiÕpilaseVastused() +'\n';
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
