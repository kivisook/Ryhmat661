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

    public static ArrayList<String> tükeldaÜlesanne (String rida) {
        ArrayList<String> listÜlesanne = new ArrayList<>();
        ArrayList<Integer> listVastus = new ArrayList<>();
        String[] tükid = rida.split(" ");
        String ülesandetekst = tükid[1];
        String vastus = tükid[2];
        listÜlesanne.add(ülesandetekst);
        //System.out.println(listÜlesanne); //see on praegu kontrollimiseks, et loeb failist ülesande
        listVastus.add(Integer.valueOf(vastus));
        //System.out.println(listVastus);
        return listÜlesanne;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

