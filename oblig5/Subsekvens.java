public class Subsekvens {
    public final String subsekvens;
    private int subAnt;

    public Subsekvens(String subsekvens){
        this.subsekvens = subsekvens;
    }

    
    public endreAnt(int nyAnt){
        subAnt = nyAnt;
    }


    public int hentAnt(){
        return subAnt;
    }

    
    public toString(){
        System.out.println(subsekvens + ", " + subAnt);
    }

}
