public class hovedprogram {
    
    public static void main(String[] args) {
        dataklynge saga = new dataklynge();
        for(i=0; i<450; i++){
            node nyNode = new node(512, 4);
            saga.leggInnNode(nyNode);
        
        
        }

        string noderMedMinne = saga.noderMedNokMinner(512);
        System.out.println("noder med minst 512 gb minne:" + noderMedMinne);
    }
}