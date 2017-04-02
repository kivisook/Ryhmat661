import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lindsirj on 20.03.2017.
 */
public class TestStart {
    public static void main(String[] args) throws FileNotFoundException {

        // Teeme kontrolltöö ja tõmbame sinna sisse kõik ülesanded
        koostaKontrolltöö kt = new koostaKontrolltöö("KONTROLLTÖÖ 08.04.2017");
        kt.lisaFailistÜlesanded1("ylesanded.txt", "arvutusülesanne");

        // vaatme, mis kontrolltöösse sai.
        System.out.println(kt);

        // Tegeleme õpilastega. Loome varaiandid, tõmbame sinna õpilased
        Variandid klass6a = new Variandid();
        klass6a.loeNimekiri();

        // saab testida nimekirja importi
        //System.out.println(klass6a.kuvaVariandid());

        klass6a.genereeriKõigile(kt, "KÕIK", 3);
        //Testin ühte õpilast. lisan talle rohkem
        klass6a.genereeriÜhele("3",kt, "KÕIK", 6);

        klass6a.kuvaVariandid(); //ekraanile
        klass6a.failVariandid(); // faili

        klass6a.kuvaVastused(); //ekraanile
        klass6a.failVastused(); //faili

        klass6a.failidKõigile(); //  genereerib faildi kõigile
        klass6a.failÜhele("3"); // genereerib ühele faili

        //näide, küsimuse trükkimine ekraanile
        System.out.println(ArvutusÜlesanne.tükeldaÜlesanne("1000 10000+100= 1100"));

        //näide, (ülemklassis) abstraktse meetodi kasutamine
        Ülesanne a1 = new ArvutusÜlesanne("66", "666-66=", "600");
        System.out.println(a1.tükeldaÜlesanne());

        Ülesanne t1 = new TekstÜlesanne("77", "Kolmnurga nurkade summa on: ", "180 kraadi.");
        System.out.println(t1.tükeldaÜlesanne());



    }
}