import java.util.ArrayList;
import java.util.List;

public abstract class Rute {
    
    int radNr;
    int kolonneNr;
    Labyrint labyrint;
    boolean besoekt = false;
    List<Rute> naboer = new ArrayList<Rute>();


    public Rute(int radNr, int kolonneNr, Labyrint labyrint) {
        this.radNr = radNr;
        this.kolonneNr = kolonneNr;
        this.labyrint = labyrint;
    }
    
    
    public void leggTilNabo(Rute nabo){
        naboer.add(nabo);
    }


    public void finn(Rute fra) {
        return;
    }
}
