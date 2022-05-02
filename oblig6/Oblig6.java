import java.util.Scanner;

public class Oblig6 {

    public static void main(String[] args) {
        
        Labyrint lab1 = new Labyrint(args[0]);
        Oblig6.kommandoLokke(lab1);
    }
    

    private static void kommandoLokke(Labyrint labyrint){

        Scanner leser = null;

        try{
            while (true) {
                leser  = new Scanner(System.in);

                System.out.println(labyrint);
                System.out.println("Skriv inn kordinat for startRute. <Rad nummer>, <Kolonne nummer> Eks (3,2)");
    
                String kommando = leser.nextLine();
                
                if(kommando.equals("-1"))
                    System.exit(0);

                String[] startKordinater = kommando.split(" ");
                int startRad = Integer.parseInt(startKordinater[0]);
                int startKolonne = Integer.parseInt(startKordinater[1]);
                
                if(labyrint.labyrint[startRad][startKolonne] instanceof SortRute){
                    System.out.println("Du kan ikke starte paa en sort rute, prov igjen");
                    Oblig6.kommandoLokke(labyrint);
                }

                System.out.println("Aaapninger: \n");
                labyrint.finnUtveiFra(startRad, startKolonne); 
            }
        }
        catch(Exception e){
            System.out.println("oppgit start rute er ikke riktig");
        } 

        finally{
            if(leser != null)
                leser.close();
        }
    } 
}  
