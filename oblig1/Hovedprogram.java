import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hovedprogram {
                
    public static Dataklynge lesFil(String objektId, String filNavn){

        Dataklynge dataklynge = new Dataklynge();
        Scanner leser = null;
        try{
            leser = new Scanner(new File(filNavn));

            while (leser.hasNextInt()) {
                int antNoder = leser.nextInt();
                int prosessorer = leser.nextInt();
                int minne = leser.nextInt();

                if (minne > 4096) throw new IOException("Minne kan ikke vaere hoeyere enn 4096. Minne er " + minne);
                if (prosessorer > 16) throw new IOException("For mange prossesorer");

                for(int i = 0; i < antNoder; i++) {
                    dataklynge.leggInnNode(new Node(minne, prosessorer));
                }
            }
        }
        
        catch(IOException e) {
            System.out.println(objektId + ": " + "Ugyldig node format i text fil.");
            System.out.println("Ugyldig antall " + e.getMessage());
            System.exit(0);
        }

        finally{
            if(leser != null) {
                leser.close();
            }
        }

        return dataklynge;
    }

    public static void main(String[] args) {
        Dataklynge dataklynge4 = lesFil("dataklynge4", "dataklynge4.txt");

        Dataklynge saga = lesFil("saga", "dataklynge.txt");
        System.out.println(saga.noderMedNokMinne(128));
        System.out.println(saga.noderMedNokMinne(512));
        System.out.println(saga.noderMedNokMinne(1024));
        System.out.println(saga.antProsessorer());
        System.out.println(saga.antallRacks());
    }
}
