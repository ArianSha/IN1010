import java.util.ArrayList;
import java.util.HashMap;

public class subsekvensRegister {
    ArrayList<HashMap<String, Subsekvens>> registerListe = new ArrayList<>();
    
    public subsekvensRegister(){
        HashMap<String, Subsekvens> register = new HashMap<>();
    }

    public void settInnRegister(){

    }
    
    public HashMap<String, Subsekvens> hentRegister(int indeks){
        return registerListe.get(indeks);
    }


    public int antRegister(){
        return registerListe.size();
    }
    
}
