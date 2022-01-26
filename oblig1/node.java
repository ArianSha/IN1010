public class node{
    private int minne;
    private int cpu;

    public node(int minne, int cpu){
        this.minne = minne;
        this.cpu = cpu;
    }
    public int antProsessorer(){
        return cpu;
    }
    public int antMinne(){
        return minne;
    }
    
}
