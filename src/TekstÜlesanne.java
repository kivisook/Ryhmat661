import java.util.ArrayList;

/**
 * Created by kersti on 01.04.17.
 */
public class TekstÜlesanne extends Ülesanne {
    private String ID;
    private String küsimus;
    private String vastus;

    public TekstÜlesanne(String ID, String küsimus, String vastus) {super(ID, küsimus, vastus);}

    //tekstülesande failis on ühes reas: ülesande_id, tab, ülesande_küsimus
    //teises reas vastuse_id, tab, vastuse_tekst

    @Override
    public Ülesanne tükeldaÜlesanne(){
        Ülesanne yl = new TekstÜlesanne(this.getID(), this.getKüsimus(), this.getVastus());
        return yl;
    }


    public static Ülesanne tükeldaÜlesanne (String ülesanderida, String vastuserida) {

        String[] tükid1 = ülesanderida.split("  ");   //osad on eraldatud tab-iga
        String indeks = tükid1[0];
        String ülesandetekst = tükid1[1];            //ülesanded on esimesel real teisel kohal

        String[] tükid2 = vastuserida.split("   ");
        String vastus = tükid2[1];                   //vastused on teisel real teisel kohal

        Ülesanne yl = new TekstÜlesanne(indeks, ülesandetekst, vastus);
        return yl;

    }

    public static void  trükiÜlesanne(String üksülesanne) {
        System.out.println(üksülesanne);
    }

    public static void trükiVastus(String üksvastus) {
        System.out.println(üksvastus);
    }
}