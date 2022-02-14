public abstract class Resept {
    static int instanser = 0; 
    int ID;

    protected Legemiddel legemiddelRef;
    protected Leger legeRef;
    protected int pasientId;
    protected int reseptReit;

    public Resept(Legemiddel legemiddelRef, Leger legeRef, int pasientId, int reseptReit){
        this.legemiddelRef = legemiddelRef;
        this.legeRef = legeRef;
        this.pasientId = pasientId;
        this.reseptReit = reseptReit;
        ID = instanser + 1;
        instanser += 1;
    }

    protected int hendId(){return ID;}
    protected String hentLegemiddel(){return legemiddelRef.hentNavn();}
    protected String hentLege(){return legeRef.hentNavn();}
    protected int hentPasientId(){return pasientId;}
    protected int hentReit(){return reseptReit;}

    public boolean bruk(){
        if (reseptReit == 0){return false;}
        reseptReit =- 1;
        return true;
    }
    abstract public String farge(); 
    abstract public int prisAaBetale();
    
}

class HviteResepter extends Resept{
    
    public HviteResepter(Legemiddel legemiddelRef, Leger legeRef, int pasientID, int reseptReit){
        super(legemiddelRef, legeRef, pasientID, reseptReit);
    }
    
    public String farge(){
        return "hvit";
    }
    public int prisAaBetale(){
        return Math.round(legemiddelRef.hentPris());
    }
}

class MilResepter extends Resept{
    
    MilResepter(Legemiddel legemiddelRef, Leger legeRef, int pasientID){
        super(legemiddelRef, legeRef, pasientID, 3);
    }
    
    public String farge(){
        return "hvit";
    }
    public int prisAaBetale(){
        return 0;
    }
}

class PResepter extends Resept{
    private static int rabatt = 108;
    
    public PResepter(Legemiddel legemiddelRef, Leger legeRef, int pasientID, int reseptReit){
        super(legemiddelRef, legeRef, pasientID, reseptReit);
        System.out.println(hendId());
    }
    
    public String farge(){
        return "hvit";
    }
    public int prisAaBetale(){
        if (rabatt >= legemiddelRef.hentPris()){return 0;}
        return Math.round(legemiddelRef.hentPris() - rabatt);
    }
}

class BlaaResepter extends Resept{
    
    public BlaaResepter(Legemiddel legemiddelRef, Leger legeRef, Integer pasientId, int reseptReit) {
        super(legemiddelRef, legeRef, pasientId, reseptReit);
    }
    
    public String farge(){
        return "blaa";
    }
    public int prisAaBetale(){
        return (int) Math.round (legemiddelRef.hentPris()*0.25);
    }
}



class Test{
    public static void main(String[] args) {
        Narkotisk narko = new Narkotisk("jo", 300, 20, 10);
        Leger omid = new Leger("Omid");
        MilResepter hasj = new MilResepter(narko, omid, narko.hentId());
        
    }
}