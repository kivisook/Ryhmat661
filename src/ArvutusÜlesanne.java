import java.util.ArrayList;

/**
 * Created by kersti on 01.04.17.
 */
public class ArvutusÜlesanne extends Ülesanne {
    private String ID;
    private String küsimus;
    private String vastus;

    //arvutusülesande failis on igas reas: jrk.nr, tühik, ülesanne, tühik, vastus

    public ArvutusÜlesanne(String ID, String küsimus, String vastus) {
        super(ID, küsimus, vastus);
    }

    public static void tükeldaÜlesanne (ArrayList YlList, ArrayList VaList, String rida) {
        String[] tükid = rida.split(" ");   //osad on eraldatud tõhikutega
        String ülesandetekst = tükid[1];            //ülesanded on teisel kohal
        String vastus = tükid[2];                   //vastused on kolmandal kohal

        trükiÜlesanne(YlList, ülesandetekst);   //lisab ülesande teksti etteantud faili
        trükiVastus(VaList, vastus);            //lisab vastuse etteantud faili
    }

    public static ArrayList  trükiÜlesanne(ArrayList Ylesanded1, String üksülesanne) { //kirjutab etteantud ülesannetefaili ühe ülesande juurde
        //System.out.println(üksülesanne);
        Ylesanded1.add(üksülesanne);
        return Ylesanded1;
    }

    public static ArrayList trükiVastus(ArrayList Vastused1, String üksvastus) {  //kirjutab vastustefaili ühe vastuse juurde
        Vastused1.add(üksvastus);
        return Vastused1;
    }

    @Override
    public String toString() {
        return getKüsimus() + " " + getVastus();
    }
}

