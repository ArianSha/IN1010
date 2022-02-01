import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.InvalidPathException;
import java.util.Scanner;

public class Hovedprogram {
    private String objektId;
    private File fil;
    private Dataklynge dataklynge = new Dataklynge();
    
    public Hovedprogram(String objektId, String filPath){
        this.objektId = objektId;
        try{
            URL path = Hovedprogram.class.getResource(filPath);
            fil = new File(path.getFile());
        }
        catch(InvalidPathException | NullPointerException ex){
            System.out.println(objektId + ": Filen du har oppgitt finnes ikke eller er ikke lesbar");
            System.exit(0);
        }
    }
    
    public void lesFil(){
        Scanner leser = null;
        try{
            leser = new Scanner(fil);
            while(leser.hasNextInt()){
                int antNoder = leser.nextInt();
                int prosessorer = leser.nextInt();
                int minne = leser.nextInt();

                if (minne > 4096) throw new IOException("minne");
                if (prosessorer > 16) throw new IOException("prosessorer");
                
                else{
                    for(int i = 0; i < antNoder; i++){
                        dataklynge.leggInnNode(new Node(minne, prosessorer));
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println(objektId + ": " + "Ugyldig node format i text fil.");
            System.out.println("Ugyldig antall " + e.getMessage());
            System.exit(0);
        }
        finally{
            if(leser != null){
                leser.close();
            }
        }
    }

    public static void main(String[] args) {
        // Hovedprogram dataklynge4 = new Hovedprogram("dataklynge4", "dataklynge4.txt");
        // dataklynge4.lesFil();
        Hovedprogram saga = new Hovedprogram("saga", "dataklynge.txt");
        saga.lesFil();
        System.out.println(saga.dataklynge.noderMedNokMinne(128));
        System.out.println(saga.dataklynge.noderMedNokMinne(512));
        System.out.println(saga.dataklynge.noderMedNokMinne(1024));
        System.out.println(saga.dataklynge.antProsessorer());
        System.out.println(saga.dataklynge.antallRacks());

    }
}
