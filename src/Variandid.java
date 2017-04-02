import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by lindsirj on 1.04.2017.
 */
public class Variandid {
    ArrayList<ÕpilaseTöö> variant = new ArrayList<>();

    public ArrayList<ÕpilaseTöö> getVariant() {
        return variant;
    }

    // Õpilaste nimikirja lugemine failist
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
        if (algoritm == "JUHUSLIK") {
            int max = kt.getÜlesanded().size();
            ArrayList<Integer> juhuslikud = new ArrayList<>();
            for (int i = 0; i < max; i++) {
                juhuslikud.add(i);
            }
            Collections.shuffle(juhuslikud);    //ajab arvud sassi
            for (int i = 0; i < ülesanneteArv; i++) {
                int j = juhuslikud.get(i);
                õpilane.lisaÜlesanne(kt.getÜlesanded().get(j));
            }

        }

    }
    // sellega saab genererida ühele õpilasele käsurealt teades õpilase koodi.
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

    //-------------- Variantide kuvamine ja trükk faili  -----------------

    //väljastab nimekirja, kus on õpilaste nimekiri ja tema variandid.
    public String variandid(){
        String trükk = "VARIANTIDE LEHT \n";
        for (ÕpilaseTöö õpilaseTöö : variant) {
            trükk += õpilaseTöö.trükiLeotelu() +'\n';
        }
        return trükk;
    }

    public void kuvaVariandid(){
        System.out.println(variandid());
    }

    public void failVariandid() throws FileNotFoundException {
        String failinimi = "variandid.txt";
        File file = new File(failinimi);
        // Kirjutamine
        PrintWriter pw = new PrintWriter(file);
        pw.append(variandid());
        pw.close();
    }


    //-------------- Õpilastele failide genereerimine -----------------

    public void failidKõigile() throws FileNotFoundException {
        for (ÕpilaseTöö õpilaseTöö : variant) {
            õpilaseTöö.failÕpilasele();
        }
    }

    public void failÜhele(String õpilaseID) throws FileNotFoundException {
        for (ÕpilaseTöö seeÕpilane : variant) {
            // otsime õpilast, kelle id on õpilaseID
            if (seeÕpilane.getId().compareTo(õpilaseID) == 0) {
                seeÕpilane.failÕpilasele();
            }
        }
    }

    //-------------- Vastuste kuvamine ja trükk faili  -----------------

    public String vastused(){
        String trükk = "VASTUSTE LEHT \n";
        for (ÕpilaseTöö õpilaseTöö : variant) {
            trükk += õpilaseTöö.trükiÕpilaseVastused() +'\n';
        }
        return trükk;
    }

    public void kuvaVastused(){
        System.out.println(vastused());
    }

    public void failVastused() throws FileNotFoundException {
        String failinimi = "vastused.txt";
        File file = new File(failinimi);
        // Kirjutamine
        PrintWriter pw = new PrintWriter(file);
        pw.append(vastused());
        pw.close();
    }



    @Override
    public String toString() {
        return "Variandid{" +
                "variant=" + variant +
                '}';
    }
}
