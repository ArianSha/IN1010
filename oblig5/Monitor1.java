import java.io.File;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor1 {
    private Lock laas = new ReentrantLock(true);
    public SubsekvensRegister beholder = new SubsekvensRegister();
    private Condition ledig = laas.newCondition();


    public void settSub(HashMap<String, Subsekvens> subsekvens){
        laas.lock();
        try{
            beholder.settSub(subsekvens);
            ledig.signalAll();
        }
        finally{laas.unlock();}
    }


    public HashMap<String, Subsekvens> hentSub(int indeks) {
        return beholder.hentSub(indeks);
    }


    public int antSub() {
        return beholder.registerListe.size();
    }


    public static HashMap<String, Subsekvens> lesFil(File fil) {
        return SubsekvensRegister.lesFil(fil);
    }


    public static HashMap<String, Subsekvens> subsSmettng(HashMap<String, Subsekvens> mapEn, HashMap<String, Subsekvens> mapTo){
         return SubsekvensRegister.subsSmettng(mapEn, mapTo);
    }
}
