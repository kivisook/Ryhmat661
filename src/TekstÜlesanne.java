import java.util.ArrayList;

/**
 * Created by kersti on 01.04.17.
 */
public class TekstÜlesanne extends Ülesanne {

    public TekstÜlesanne(String ID, String küsimus, String vastus) {
        super(ID, küsimus, vastus);
    }
    //tekstülesande failis on ühes reas: ülesande_nimi, tab, ülesande_tekst
    //teises reas vastuse_nimi, tab, vastuse_tekst

    public static void tükeldaÜlesanne (ArrayList YlList, ArrayList VaList, String ülesanderida, String vastuserida) {
        String[] tükid1 = ülesanderida.split("\t");   //osad on eraldatud tab-iga
        String ülesandetekst = tükid1[0];            //ülesanded on esimesel real teisel kohal, aga ei võta???

        String[] tükid2 = vastuserida.split("\t");
        String vastus = tükid2[0];                   //vastused on teisel real teisel kohal, aga ei võta???

        trükiÜlesanne(YlList, ülesandetekst);   //lisab ülesande teksti etteantud faili
        trükiVastus(VaList, vastus);            //lisab vastuse etteantud faili
    }

    public static ArrayList  trükiÜlesanne(ArrayList Ylesanded1, String üksülesanne) { //kirjutab etteantud ülesannetefaili ühe ülesande juurde
        Ylesanded1.add(üksülesanne);
        return Ylesanded1;
    }

    public static ArrayList trükiVastus(ArrayList Vastused1, String üksvastus) {  //kirjutab vastustefaili ühe vastuse juurde
        Vastused1.add(üksvastus);
        return Vastused1;
    }
}
