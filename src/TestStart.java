import java.io.FileNotFoundException;

/**
 * Created by lindsirj on 20.03.2017.
 */
public class TestStart {
    public static void main(String[] args) throws FileNotFoundException {

        // Teeme kontrolltöö ja tõmbame sinna sisse kõik ülesanded
        Kontrolltöö kt = new Kontrolltöö();
        kt.lisaFailistÜlesanded("ylesanded.txt", "arvutusülesanne");
        kt.lisaFailistÜlesanded("tekstülesanded.txt", "tekstülesanne");

        // kontrolliks võib vaadata, mis kontrolltöösse sai.
        System.out.println("----- IMPORDITUD KONTROLLTÖÖ ON SELLINE --------------");
        System.out.println(kt);

        // Tegeleme õpilastega. Loome variandi 6a klassi jaoks ja impordime sinna õpilased
        Variandid klass6a = new Variandid("Suur arvestustöö");
        klass6a.loeNimekiri();

        // kontrolliks võib kuvada variandi ( ehk ülesanneteta nimekirja  ekraanile)
        System.out.println("----- IMPORTISIN SELLISE NIMEKIRJA ---------------");
        klass6a.kuvaVariandid();

        System.out.println("----- VÄLJUNDID kõigiga töötamisel---------------");

        klass6a.genereeriKõigile(kt, "JUHUSLIK", 3);
        //Testin ühte õpilast. Ühele targale poisile annan rohkem ülesandeid
        klass6a.genereeriÜhele("3",kt, "KÕIK", 6);

        klass6a.kuvaVariandid(); //ekraanile
        klass6a.failVariandid(); // faili

        klass6a.kuvaVastused(); //ekraanile
        klass6a.failVastused(); //faili

        klass6a.failidKõigile(); //  genereerib faildi kõigile


        // -- TÖÖ ÜHE ÜKSIKU LAPSE LISAMISEGA
        System.out.println("----- VÄLJUNDID ühe õpilase Mary lisamisel---------------");

        // Lisame ühe õpilase käsitsi  -- selle asemele tuleb meetod kirjuatda
        klass6a.variant.add (new ÕpilaseTöö("9", "Mary Aas"));

        //Genreerimse selle õpilasele õpilasele 6 ülesannnet algoritmi 'juhuslik' abil
        klass6a.genereeriÜhele("9",kt,"JUHUSLIK",6);

        // Genereerib ainult ühe õpilase faili
        klass6a.failÜhele("9");

        // uuendab vastuste ja variantide failid, ning kuvab ka tulemused ekraanle
        klass6a.kuvaVariandid(); //ekraanile
        klass6a.failVariandid(); // faili

        klass6a.kuvaVastused(); //ekraanile
        klass6a.failVastused(); //faili

        // MUUD NÄITED
        System.out.println("----- MUUD NÄITED---------------");

        //näide, küsimuse trükkimine ekraanile
        System.out.println(ArvutusÜlesanne.tükeldaÜlesanne("1000 10000+100= 1100"));

        //näide, (ülemklassis) abstraktse meetodi kasutamine
        Ülesanne a1 = new ArvutusÜlesanne("66", "666-66=", "600");
        System.out.println(a1.tükeldaÜlesanne());

        Ülesanne t1 = new TekstÜlesanne("77", "Kui suur on kolmnurga nurkade summa? ", "360 kraadi.");
        System.out.println(t1.tükeldaÜlesanne());



    }
}