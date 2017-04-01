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
        Nimi = nimi;
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

    //trükib Kontrolltöö sellisel kujul nagu see õpilasele antakse.
    // ma pane praegu stringiks, sest ei tea
     public String trükiÕpilasele() {
         String trükk ="";
         trükk +="--------------------\n";
         trükk +=Nimi+ '\n';
         trükk += "KONTROLLTÖÖ"+ '\n' ;

         for (Ülesanne ülesanne : õpilaseÜlesanded) {
             trükk +=ülesanne.getID()+" "+ülesanne.trükiKüsimus()+"\n\n";
         }
         trükk +="--------------------\n";
         return trükk;


    }

    public String trükiÕpilaseVastused() {
        String trükk = id + " " + Nimi + ":" ;
        for (Ülesanne ülesanne : õpilaseÜlesanded) {
            trükk += " ["+ülesanne.getID()+": " + ülesanne.trükiVastus()+"]";
        }
        return trükk;
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
