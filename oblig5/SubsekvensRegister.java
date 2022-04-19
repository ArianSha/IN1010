import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SubsekvensRegister {
    
    public ArrayList<HashMap<String, Subsekvens>> registerListe = new ArrayList<>();

    
    public void settSub(HashMap<String, Subsekvens> subsekvens){
            registerListe.add(subsekvens);
    }
    

    public HashMap<String, Subsekvens> hentSub(int indeks){
        return registerListe.get(indeks);
    }


    public int antSub(){
        return registerListe.size();
    }


    public static HashMap<String, Subsekvens> lesFil(File fil){
        HashMap<String, Subsekvens> personSubsekvens = new HashMap<>();
        Scanner leser = null;

        try{
            leser = new Scanner(fil);
            
            while(leser.hasNextLine()){
                String linje = leser.nextLine();

                if (linje.isEmpty()) break;
                if (linje.isEmpty() && personSubsekvens.isEmpty()) throw new Exception("Filen er tom");
                if(linje.length() < 3) throw new Exception("substreng må være 3 karakterer");
                
                for(int sekvensStartIndex = 0; sekvensStartIndex+2 < linje.length(); sekvensStartIndex++){
                    String sekvens = linje.substring(sekvensStartIndex, sekvensStartIndex + 3);
                    personSubsekvens.put(sekvens, new Subsekvens(sekvens));
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Filen finnes ikke");
            e.printStackTrace();
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
        return personSubsekvens;
    }


    public static HashMap<String, Subsekvens> subsSmettng(HashMap<String, Subsekvens> mapEn, HashMap<String, Subsekvens> mapTo) {
        for (String subsekvens : mapEn.keySet()) {

            if(mapTo.containsKey(subsekvens)) {
                int antallFraMapEn = mapEn.get(subsekvens).hentAnt();
                mapTo.get(subsekvens).leggTilAnt(antallFraMapEn);
            }
            else
                mapTo.put(subsekvens, mapEn.get(subsekvens));
        }
        return mapTo;
    }
}
