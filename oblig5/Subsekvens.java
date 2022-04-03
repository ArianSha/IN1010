public class Subsekvens {
    public final String subsekvens;
    private int subAnt;

    public Subsekvens(String subsekvens){
        this.subsekvens = subsekvens;
    }

    
    public void endreAnt(int nyAnt){
        subAnt = nyAnt;
    }

    public void leggTil(int ant){
        subAnt =+ ant;
    }


    public int hentAnt(){
        return subAnt;
    }

    
    public String toString(){
        return "(" + subsekvens + ", " + subAnt + ")";
    }

}
