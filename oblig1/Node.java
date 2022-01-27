public class Node{
    private int minne;
    private int cpu;

    public Node(int minne, int cpu){
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
