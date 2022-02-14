public abstract class Resept {
    static int instanser = 0; 
    Integer ID;

    protected Legemiddel legemiddelRef;
    protected Leger legeRef;
    protected Integer pasientId;
    protected Integer reseptReit;

    public Resept(Legemiddel legemiddelRef, Leger legeRef, Integer pasientId, int reseptReit){
        this.legemiddelRef = legemiddelRef;
        this.legeRef = legeRef;
        this.pasientId = pasientId;
        this.reseptReit = reseptReit;
        ID = instanser + 1;
        instanser += 1;
    }

    protected String hendId(){return ID.toString();}
    protected String hentLegemiddel(){return legemiddelRef.navn;}
    // protected String hentLege(){return legeRef;}
    protected String hentPasientId(){return pasientId.toString();}
    protected String hentReit(){return reseptReit.toString();}

    // public boolean bruk(){
        
    // }

}

class hviteResepter extends Resept{
 
    public hviteResepter(Legemiddel legemiddelRef, Leger legeRef, Integer pasientID, Integer reseptReit){
        super(legemiddelRef, legeRef, pasientID, reseptReit);
    }
    
}

class MilResept extends Resept{
    
    MilResept(Legemiddel legemiddelRef, Leger legeRef, Integer pasientID){
        super(legemiddelRef, legeRef, pasientID, 3);
    }

}
class PResepter extends Resept{
    private static int rabatt = 108;

    public PResepter(Legemiddel legemiddelRef, Leger legeRef, Integer pasientID, Integer reseptReit){
        super(legemiddelRef, legeRef, pasientID, reseptReit);
        System.out.println(hendId());

    }
}



class Test{
    public static void main(String[] args) {
        Narkotisk narko = new Narkotisk("jo", 300, 20, 10);
        MilResept hasj = new MilResept(narko, narko.hentId());
    }
}