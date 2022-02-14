public abstract class Legemiddel{
    static int instanser = 0;
    protected Integer ID;

    protected String navn;
    protected Integer prisKr;
    protected Double virkestoff;

    public Legemiddel(String navn, int prisKr, double virkestoff){
        this.navn = navn;
        this.prisKr = prisKr;
        this.virkestoff = virkestoff;
        ID = instanser + 1;
        instanser += 1;
    }
    public String hentNavn(){return navn;}
    public Integer hentId() {return ID;}
    public String hentPris(){return prisKr.toString();}
    public String hentVirkestoff(){return virkestoff.toString();}

    public void settNyPris(int nyPris){prisKr = nyPris;}
}

class Narkotisk extends Legemiddel{
    private Integer narkoStyrke;

    public Narkotisk(String navn, int prisKr, double virkestoff, int narkoStyrke) {
        super(navn, prisKr, virkestoff);
        this.narkoStyrke = narkoStyrke;
    }
    public String hentNarkoStyrke(){ return narkoStyrke.toString();}
}

class Vanedannende extends Legemiddel{
    private Integer vaneStyrke;

    public Vanedannende(String navn, int prisKr, double virkestoff, int vaneStyrke) {
        super(navn, prisKr, virkestoff);
        this.vaneStyrke = vaneStyrke;
    }
    public String hentVaneStyrke(){return vaneStyrke.toString();}
}

class Vanlig extends Legemiddel{
    public Vanlig(String navn, int prisKr, double virkestoff) {
        super(navn, prisKr, virkestoff);
    }
}