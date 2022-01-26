public class hovedprogram {
    
    public static void main(String[] args) {
        dataklynge saga = new dataklynge();
        
        for(int i = 0; i<450; i++){
            saga.leggInnNode(new node(512, 4));
        }
        for(int i = 0; i<16; i++){
            saga.leggInnNode(new node(1024, 8));
        }
        for(int i = 0; i<300; i++){
            saga.leggInnNode(new node(128, 8));
        }

        int noderMedMinne = saga.noderMedNokMinner(512);
        System.out.println("noder med minst 512 gb minne: " + noderMedMinne);
        
        noderMedMinne = saga.noderMedNokMinner(128);
        System.out.println("noder med minst 128 gb minne: " + noderMedMinne);
        
        noderMedMinne = saga.noderMedNokMinner(512);
        System.out.println("noder med minst 1024 gb minne: " + noderMedMinne);

        System.out.println("prosessorer: " + saga.antProsessorer());
        System.out.println("racks: " + saga.antallRacks());

    }
}