public abstract class Legemiddel{
    static int instanser = 0;
    protected int ID;

    protected String navn;
    protected int prisKr;
    protected double virkestoff;

    public Legemiddel(String navn, int prisKr, double virkestoff){
        this.navn = navn;
        this.prisKr = prisKr;
        this.virkestoff = virkestoff;
        ID = instanser + 1;
        instanser += 1;
    }
    public int hentId() {return ID;}
    public String hentNavn(){return navn;}
    public int hentPris(){return prisKr;}
    public double hentVirkestoff(){return virkestoff;}

    public void settNyPris(int nyPris){prisKr = nyPris;}

    public String toString(){
        return "ID: " + ID + "\n" + "Navn: " + navn + "\n" + "Pris: " + prisKr + "\n" + "Virkestoff: " + virkestoff;
    }
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