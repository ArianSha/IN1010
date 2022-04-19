import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class Oblig5Del2A {
    public static void main(String[] args) throws InterruptedException {
        
        BufferedReader mappeLeser = null;
        File folder = new File(args[0]);
        Monitor1 monitor = new Monitor1();
        CountDownLatch bar = null;

        try{
            if (Arrays.stream(folder.list()).anyMatch("metadata.csv"::equals)){
                
                mappeLeser = new BufferedReader(new FileReader(new File(folder, "metadata.csv")));
                int antallFiler = (int) Files.lines( new File(folder, "metadata.csv").toPath()).count();
                bar = new CountDownLatch(antallFiler);

                for(String linje; (linje = mappeLeser.readLine()) != null;)
                    new Thread(new LeseTrad(folder.getPath() + "/" + linje, monitor, bar)).start();
            }
            else throw new Exception("metadata.csv ikke funnet");

        }
        catch(FileNotFoundException e){
            System.out.println("filen finnes ikke");
        }
        catch(InterruptedException e){
            System.out.println("traad avbrutt!");
        }
        catch(Exception e){
            System.out.println("Ugyldig fil format");
            System.out.println(e.getMessage());
        }
        finally{
            try{
                if(mappeLeser!=null) mappeLeser.close();
            }
            catch(IOException e){System.out.println("Feil under lesing");}
        }
        
        bar.await();
        HashMap<String, Subsekvens> smettetSubs = monitor.hentSub(0);

        for(int i = 0; i < monitor.antSub()-1; i++){
            smettetSubs = SubsekvensRegister.subsSmettng(smettetSubs, monitor.hentSub(i+1));
        }
        
        for(Map.Entry<String, Subsekvens> entry : smettetSubs.entrySet()) {
            System.out.println(entry.toString());
        }
    }
}
