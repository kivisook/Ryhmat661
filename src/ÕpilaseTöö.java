import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by lindsirj on 1.04.2017.
 */
public class ÕpilaseTöö {

    private String id; //võib olla kood, Järjekorra nr....
    private String Nimi;
    private ArrayList<Ülesanne> õpilaseÜlesanded = new ArrayList<>();  // õpilasele määratud ülesanded

    // konstruktor uue õpilase lisamine ilema ülesanneteta
    public ÕpilaseTöö(String id, String nimi) {
        this.id = id;
        Nimi = nimi;
    }

    //olemasolevale õpilase ülesannete lisamine. Seda on vaja variantide genereerimisel
    public void lisaÜlesanne(Ülesanne ülesanne) {
        this.õpilaseÜlesanded.add(ülesanne);
    }

    //konstruktor uue õpilase lisamine koos ülesannetega. Seda on vaja variantidest taastamisel
    public ÕpilaseTöö(String id, String nimi, ArrayList<Ülesanne> õpilaseÜlesanded) {
        this.id = id;
        this.Nimi = nimi;
        this.õpilaseÜlesanded = õpilaseÜlesanded;
    }

    //väljastab selle õpilase ülesannete id-d
    public String trükiLeotelu() {
        String trükk = id +" "+Nimi;
        for (Ülesanne ülesanne : õpilaseÜlesanded) {
            trükk += "  "+ülesanne.getID();
        }
        return trükk;
    }

    public void failÕpilasele() throws FileNotFoundException {
        File file = new File("koostatud", this.Nimi+".txt");
        //File file = new File(failinimi);
        // Kirjutamine
        PrintWriter pw = new PrintWriter(file);

        String trükk ="";
        trükk +=Nimi+ "\n\n";
        trükk += "KONTROLLTÖÖ"+ "\n\n";

        for (Ülesanne ülesanne : õpilaseÜlesanded) {
            trükk +=ülesanne.getID()+": "+ülesanne.getKüsimus()+"\n\n";
        }
        pw.append(trükk);
        pw.close();
    }


    public String trükiÕpilaseVastused() {
        String trükk = id + " " + Nimi + ":" ;
        for (Ülesanne ülesanne : õpilaseÜlesanded) {
            trükk += " ["+ülesanne.getID()+": " + ülesanne.getVastus()+"]";
        }
        return trükk;
    }

    public String getId() {
        return id;
    }

    public void kustutaÕpilaseÜlesanded() {
        this.õpilaseÜlesanded = new ArrayList<>();
    }

    @Override
    // siin on praegu sama kood, mis trükiLeotelu()
    public String toString() {
        String trükk = id +" "+Nimi;
        for (Ülesanne ülesanne : õpilaseÜlesanded) {
            trükk += "  "+ülesanne.getID();
        }
        return trükk;
    }
}