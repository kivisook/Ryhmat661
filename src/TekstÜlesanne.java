import java.util.ArrayList;

/**
 * Created by kersti on 01.04.17.
 */
public class TekstÜlesanne extends Ülesanne {

    public TekstÜlesanne(String ID, String küsimus, String vastus) {super(ID, küsimus, vastus);}

    //tekstülesande failis on ühes reas: ülesande_id, tab, ülesande_küsimus
    //teises reas vastuse_id, tab, vastuse_tekst

    @Override
    public Ülesanne tükeldaÜlesanne(){
        Ülesanne yl = new TekstÜlesanne(this.getID(), this.getKüsimus(), this.getVastus());
        return yl;
    }


    public static Ülesanne tükeldaÜlesanne (String ülesanderida, String vastuserida)  {

        // maci jaoks:
        //   String[] tükid1 = ülesanderida.split("  ");   //osad on eraldatud tab-iga  MA
        // windowsi jaoks
        String[] tükid1 = ülesanderida.split("\t");   //osad on eraldatud tab-iga

        String indeks = tükid1[0];
        String ülesandetekst = tükid1[1];            //ülesanded on esimesel real teisel kohal

        // maci jaoks:
        //String[] tükid2 = vastuserida.split("   ");
        //windowsi jaoks:
        String[] tükid2 = vastuserida.split("\t");

        String vastus = tükid2[1];                   //vastused on teisel real teisel kohal

        Ülesanne yl = new TekstÜlesanne(indeks, ülesandetekst, vastus);
        return yl;

    }

    public static void  trükiÜlesanne(String üksülesanne) { //trükib ülesande teksti
        System.out.println(üksülesanne);
    }

    public static void trükiVastus(String üksvastus) {  //trükib vastuse
        System.out.println(üksvastus);
    }

    @Override
    public String getKüsimus (){
        return super.getKüsimus();
    }
}