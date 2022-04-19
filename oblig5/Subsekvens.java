public class Subsekvens {
    public final String subsekvens;
    private int subAnt;

    public Subsekvens(String subsekvens){
        this.subsekvens = subsekvens;
        subAnt = 1;
    }
    
    
    public void leggTilAnt(int ant){
        subAnt += ant;
    }


    public int hentAnt(){
        return subAnt;
    }

    
    public String toString(){
        return "(" + subsekvens + ", " + subAnt + ")";
    }

}
