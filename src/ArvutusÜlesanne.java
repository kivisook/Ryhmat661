import java.util.ArrayList;

/**
 * Created by kersti on 01.04.17.
 */
public class ArvutusÜlesanne extends Ülesanne {

    //arvutusülesande failis on igas reas: jrk.nr, tühik, ülesanne, tühik, vastus

    public ArvutusÜlesanne(String ID, String küsimus, String vastus) {
        super(ID, küsimus, vastus);
    }

    @Override
    public Ülesanne tükeldaÜlesanne(){
        Ülesanne yl = new ArvutusÜlesanne(this.getID(), this.getKüsimus(), this.getVastus());
        return yl;
    }


    public static Ülesanne tükeldaÜlesanne (String rida) {

        String[] tükid = rida.split(" ");   //osad on eraldatud tühikutega
        String indeks = tükid[0];                   //jrk.nr on indeksiks
        String ülesandetekst = tükid[1];            //ülesanded on teisel kohal
        String vastus = tükid[2];                   //vastused on kolmandal kohal

        Ülesanne yl = new ArvutusÜlesanne(indeks, ülesandetekst, vastus);
        return yl;
    }

    public static void  trükiÜlesanne(String üksülesanne) { //trükib ülesande teksti
        System.out.println(üksülesanne);
    }

    public static void trükiVastus(String üksvastus) {  //kirjutab vastustefaili ühe vastuse juurde
        System.out.println(üksvastus);
    }

}
