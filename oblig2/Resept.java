public abstract class Resept {
    protected static int instanser = 0; 
    protected int ID;

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

    public int hendId(){return ID;}
    public String hentLegemiddel(){return legemiddelRef.hentNavn();}
    public String hentLege(){return legeRef.hentNavn();}
    public int hentPasientId(){return pasientId;}
    public int hentReit(){return reseptReit;}

    public boolean bruk(){
        if (reseptReit == 0){return false;}
        reseptReit =- 1;
        return true;
    }
    abstract public String farge(); 
    abstract public int prisAaBetale();

    public String toString(){
        return "Legemiddel: " + legemiddelRef.hentNavn() + "\n" + "Lege: " + legeRef.hentNavn() + "\n" + "Pasient-ID: " + pasientId + "\n" + "reit: " + reseptReit; 
    }
    
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

class MilResepter extends HviteResepter{
    
    public MilResepter(Legemiddel legemiddelRef, Leger legeRef, int pasientID){
        super(legemiddelRef, legeRef, pasientID, 3);
    }
    
    public int prisAaBetale(){
        return 0;
    }
}

class PResepter extends HviteResepter{
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