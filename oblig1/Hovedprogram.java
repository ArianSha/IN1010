import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Hovedprogram {
    private File fil;
    private Dataklynge dataklynge = new Dataklynge();
    
    public Hovedprogram(String filPath){
        URL path = Hovedprogram.class.getResource(filPath);
        fil = new File(path.getFile());
    }

    public void lesFil(){
        Scanner leser = null;
        try{
            leser = new Scanner(fil);

            while(leser.hasNextInt()){
                int antNoder = leser.nextInt();
                int prosessorer = leser.nextInt();
                int minne = leser.nextInt();

                if (minne < 4096 && prosessorer < 16){
                    for(int i = 0; i < antNoder; i++){
                        dataklynge.leggInnNode(new Node(minne, prosessorer));
                    }
                }else throw new IOException();
            }
        }
        catch(IOException e){
            System.out.println("feil node format");
        }
        finally{
            if(leser != null){
                leser.close();
            }
        }
    }

    public static void main(String[] args) {
        Hovedprogram dataklynge1 = new Hovedprogram("dataklynge.txt");
        dataklynge1.lesFil();
        // Hovedprogram dataklynge2 = new Hovedprogram("dataklynge2.txt");
        // dataklynge2.lesFil();
        // Hovedprogram dataklynge3 = new Hovedprogram("dataklynge3.txt");
        // dataklynge3.lesFil();
        // Hovedprogram dataklynge4 = new Hovedprogram("dataklynge4.txt");
        // dataklynge4.lesFil();
        System.out.println(dataklynge1.dataklynge.noderMedNokMinne(128));
        System.out.println(dataklynge1.dataklynge.noderMedNokMinne(512));
        System.out.println(dataklynge1.dataklynge.noderMedNokMinne(1024));
        System.out.println(dataklynge1.dataklynge.antProsessorer());
        System.out.println(dataklynge1.dataklynge.antallRacks());
    }
}




// Integer antNoder = Integer.parseInt(leser.nextLine().split(" ")[0]);
// Integer prosessorer = Integer.parseInt(leser.nextLine().split(" ")[1]);