public class Leger{
    protected String legeNavn;

    public Leger(String legeNavn){
        this.legeNavn = legeNavn;
    }

    public String hentNavn(){
        return legeNavn;
    }
    public String toString(){
        return "Navn: " + legeNavn;
    }
}

class Spesialist extends Leger implements Godkjenningsfritak{
    private String kontrollID;

    public Spesialist(String legeNavn, String kontrollID){
        super(legeNavn);
        this.kontrollID = kontrollID;
    }

    public String hentKontrollID() {
        return kontrollID;
    }

    public String toString(){
        return super.toString() + "\n" + "Kontroll-ID: " + kontrollID;
    }
}
