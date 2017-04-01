/**
 * Created by kersti on 01.04.17.
 */
public class Ülesanne {
    private String ID; //ülesande identifikaator (kood)
    private String küsimus; // Ülesande sõnastus
    private String vastus; // Ülesande vastus


    public Ülesanne(String ID, String küsimus, String vastus) {
        this.ID = ID;
        this.küsimus = küsimus;
        this.vastus = vastus;
    }
    // Kui ülesandeklassis ei ole väljatrükki üle defineeritud, siis kasutab seda
    public String trükiKüsimus(){
        return küsimus;
    }

    // Kui ülesandeklassis ei ole väljatrükki üle defineeritud, siis kasutab seda
    public String trükiVastus (){
        return vastus;
    }

    public String getID() {
        return ID;
    }

}
