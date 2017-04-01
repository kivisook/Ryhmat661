import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * Created by lindsirj on 1.04.2017.
 */
public class TestSirje_r1 {
    public static void main(String[] args) throws FileNotFoundException {
        ÕpilaseTöö sirje = new ÕpilaseTöö("S1", "Sirje Lind");

        Ülesanne yl1 = new Ülesanne("y1", "4+5", "9");
        Ülesanne yl2 = new Ülesanne("2.", "Millal algab kevad?", "Pärast eksameid");
        Ülesanne yl3 = new Ülesanne("3", "Mitu kraadi on viisnurga nurkade  summa?", "360°");


        sirje.lisaÜlesanne(yl1);
        sirje.lisaÜlesanne(yl2);
        sirje.lisaÜlesanne(yl3);


        System.out.println(sirje.trükiLeotelu());
        System.out.println(sirje.trükiÕpilasele());
        System.out.println(sirje.trükiÕpilaseVastused());

        Variandid var1 = new Variandid();
        var1.loeNimekiri();
        System.out.println(var1.trükiVariandid());

        System.out.println(var1);
        System.out.println(var1.getVariant());
        //     System.out.println(var1.variant[0]);

    }
}
