import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Monitor2 extends Monitor1{
    private Lock laas = new ReentrantLock(true);
    private Lock laas2 = new ReentrantLock(true);
    public SubsekvensRegister beholder = new SubsekvensRegister();
    private Condition flettBar = laas.newCondition();


    public void settSub(HashMap<String, Subsekvens> sub){
        laas.lock();
        try{
            beholder.settSub(sub);
            flettBar.signalAll();
        }
        finally{laas.unlock();}
    }


    public HashMap<String, Subsekvens> hentSub(int indeks){return beholder.hentSub(indeks);}


    public int antSub(){return beholder.registerListe.size();}


    public static HashMap<String, Subsekvens> lesFil(File fil) {return SubsekvensRegister.lesFil(fil);}


    public static HashMap<String, Subsekvens> subsSmettng(HashMap<String, Subsekvens> mapEn, HashMap<String, Subsekvens> mapTo){
         return SubsekvensRegister.subsSmettng(mapEn, mapTo);
    }


    @SuppressWarnings("unchecked")
    public HashMap<String, Subsekvens>[] hentToSubs(){

        laas2.lock();
        HashMap<String, Subsekvens>[] subsekvensPar = null;
        
        try{
            if(this.antSub()<=1)
                return null;
                
            while(this.antSub()<2) 
                flettBar.await();

            subsekvensPar =  new HashMap[] {beholder.registerListe.remove(0), beholder.registerListe.remove(0)};
        }
        catch(InterruptedException e){
            System.out.println("Thread ble avbrutt!");
            e.printStackTrace();
        }
        finally{
            laas2.unlock();
        }

        return subsekvensPar;
    }
}
