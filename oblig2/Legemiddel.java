public abstract class Legemiddel{
    private String navn;
    private Integer ID;
    private Integer prisKr;
    private Double virkestoff;

    public Legemiddel(String navn, int ID, int prisKr, double virkestoff){
        this.navn = navn;
        this.ID = ID;
        this.prisKr = prisKr;
        this.virkestoff = virkestoff;
    }
    public String hentNavn(){return navn;}
    public String hentId() {return ID.toString();}
    public String hentPris(){return prisKr.toString();}
    public String hentVirkestoff(){return virkestoff.toString();}

    public void settNyPris(int nyPris){prisKr = nyPris;}
    
}

class Narkotisk extends Legemiddel{
    private int narkoStyrke;

    public Narkotisk(String navn, int ID, int prisKr, double virkestoff, int narkoStyrke) {
        super(navn, ID, prisKr, virkestoff);
        this.narkoStyrke = narkoStyrke;
    }
    public int hentNarkoStyrke(){ return narkoStyrke;}
}

class Vanedannende extends Legemiddel{
    private int vaneStyrke;

    public Vanedannende(String navn, int ID, int prisKr, double virkestoff, int vaneStyrke) {
        super(navn, ID, prisKr, virkestoff);
        this.vaneStyrke = vaneStyrke;
    }
    public int hentVaneStyrke(){return vaneStyrke;}
}

class Vanlig extends Legemiddel{

    public Vanlig(String navn, int ID, int prisKr, double virkestoff, int narkoStyrke) {
        super(navn, ID, prisKr, virkestoff);
    }
}