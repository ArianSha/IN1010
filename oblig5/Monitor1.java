import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor1 {
    private Lock laas = new ReentrantLock();
    private Condition ledig = laas.newCondition();
    private boolean ikkeKjort = true;

    public ArrayList<HashMap<String, Subsekvens>> registerListe = new ArrayList<>();


    public void settSub(String subsekvens){
        registerListe.add(new HashMap<String, Subsekvens>() {{
            put(subsekvens, new Subsekvens(subsekvens));
        }});
    }


    public void settSub(HashMap<String, Subsekvens> subsekvens){
        ikkeKjort = false;
        laas.lock();
        try{
            while(ikkeKjort == true)ledig.await();
            registerListe.add(subsekvens);
            ledig.signalAll();
        }
        catch(InterruptedException e) {
            System.out.println("Traaden ble ikke gjennomfoert");
        }
        finally{laas.unlock(); ikkeKjort = true;}
    }
    

    public HashMap<String, Subsekvens> hentSub(int indeks){
        return registerListe.get(indeks);
    }


    public int antSub(){
        return registerListe.size();
    }

    
    public static HashMap<String, Subsekvens> lesFil(File fil){
        HashMap<String, Subsekvens> persSubsekvens = new HashMap<>();
        Scanner leser = null;

        try{
            leser = new Scanner(fil);
            ArrayList<String> subsekvenser = new ArrayList<>();
            
            while(leser.hasNextLine()){
                String linje = leser.nextLine();
                int startSub = 0;

                if (linje.isEmpty()) break;
                if (linje.isEmpty() && persSubsekvens.isEmpty()) throw new Exception("Filen er tom");
                if(linje.length() < 3) throw new Exception("substreng må være 3 karakterer");
                
                while (! (startSub+2 == linje.length())){
                    StringBuilder sekvensBuilder = new StringBuilder();
                    for(int i = 0; i<3; i++) sekvensBuilder.append(linje.charAt(startSub+i));
                    
                    String sekvens = sekvensBuilder.toString();
                    startSub++;
                    
                    if(! subsekvenser.contains(sekvens.toString())){
                        persSubsekvens.put(sekvens, new Subsekvens(sekvens));
                        subsekvenser.add(sekvens);
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Filen finnes ikke");
            e.printStackTrace();
            // System.out.println();
        }
        catch(Exception e){
            System.out.println("Filen kunne ikke tolkes");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        finally{
            if(leser != null){
                leser.close(); 
            }
        }
        return persSubsekvens;
    }


    public static HashMap<String, Subsekvens> subsSmettng(HashMap<String, Subsekvens> mapEn, HashMap<String, Subsekvens> mapTo){
        for (Map.Entry<String, Subsekvens> entry: mapEn.entrySet()){

            if(mapTo.containsKey(entry.getKey())) {
                mapTo.get(entry.getKey()).endreAnt(entry.getValue().hentAnt() + mapTo.get(entry.getKey()).hentAnt());
            }
            else mapTo.put(entry.getKey(), entry.getValue());

        }
        return mapTo;
    }
}
