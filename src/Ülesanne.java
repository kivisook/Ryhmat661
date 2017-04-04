/**
 * Created by kersti on 01.04.17.
 */
abstract class Ülesanne {
    private String ID; //ülesande identifikaator (kood)
    private String küsimus; // Ülesande sõnastus
    private String vastus; // Ülesande vastus

    public Ülesanne(String ID, String küsimus, String vastus) {
        this.ID = ID;
        this.küsimus = küsimus;
        this.vastus = vastus;
    }

    public String getID() {return ID;}

    public String getKüsimus() {
        return küsimus;
    }

    public String getVastus() {
        return vastus;
    }

    abstract Ülesanne tükeldaÜlesanne();

    @Override
    public String toString() {
        return "[" +
                "ID: '" + ID + '\'' +
                ", Küsimus: '" + küsimus + '\'' +
                ", Vastus: '" + vastus + '\'' +
                ']';
    }
}