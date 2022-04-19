import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class Oblig5Del2B {
    public static void main(String[] args) throws InterruptedException {
        
        BufferedReader mappeLeser = null;
        File folder = new File(args[0]);
        Monitor2 monitor = new Monitor2();
        CountDownLatch leseTradBar = null;
        CountDownLatch fleeteTradBar = null;
        
        try{
            if (Arrays.stream(folder.list()).anyMatch("metadata.csv"::equals)){

                mappeLeser = new BufferedReader(new FileReader(new File(folder, "metadata.csv")));
                int antallFiler = (int) Files.lines( new File(folder, "metadata.csv").toPath()).count();
                
                if(antallFiler >= 0)
                    leseTradBar = new CountDownLatch(antallFiler);
                else
                    throw new Exception("Det er ingen filer til lesing");

                for(String linje; (linje = mappeLeser.readLine()) != null;)
                    new Thread(new LeseTrad(folder.getPath() + "/" + linje, monitor, leseTradBar)).start();
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
        
        leseTradBar.await();
        fleeteTradBar = new CountDownLatch(8);
        
        for(int i = 0; i<8; i++)
            new Thread(new FletteTrad(monitor, fleeteTradBar)).start();

        fleeteTradBar.await();

        for(Map.Entry<String, Subsekvens> entry : monitor.hentSub(0).entrySet()) {
            System.out.println(entry.toString());
        }
    }
}
