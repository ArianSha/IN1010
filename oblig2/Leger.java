public class Leger{
    protected String legeNavn;

    public Leger(String legeNavn){
        this.legeNavn = legeNavn;
    }

    public String hentNavn(){
        return legeNavn;
    }
}

class spesialist extends Leger implements Godkjenningsfritak{
    private String kontrollID;

    public spesialist(String legeNavn, String kontrollID){
        super(legeNavn);
        this.kontrollID = kontrollID;
    }

    public String hentKontrollID() {
        return kontrollID;
    }
}
