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

public class Oblig5Hele {
    public static void main(String[] args) throws InterruptedException{
        
        BufferedReader mappeLeser = null;
        File folder = new File(args[0]);
        Monitor2 sykeMonitor = new Monitor2();
        Monitor2 ikkeSykeMonitor = new Monitor2();
        CountDownLatch leseTradBar = null;
        CountDownLatch fletteTradBar = null;

        try{
            if (Arrays.stream(folder.list()).anyMatch("metadata.csv"::equals)){

                mappeLeser = new BufferedReader(new FileReader(new File(folder, "metadata.csv")));
                int antallFiler = (int) Files.lines( new File(folder, "metadata.csv").toPath()).count();
                
                if(antallFiler > 0)
                    leseTradBar = new CountDownLatch(antallFiler); 
                else
                    throw new Exception("Det er ingen filer til lesing");
                
                for(String linje; (linje = mappeLeser.readLine()) != null;){
                    String[] linjePar = linje.split(",");

                    if( linjePar[1].equals("True"))
                        new Thread(new LeseTrad(folder.getPath() + "/" + linjePar[0], sykeMonitor, leseTradBar)).start();
                    else
                        new Thread(new LeseTrad(folder.getPath() + "/" + linjePar[0], ikkeSykeMonitor, leseTradBar)).start();
                }
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
        fletteTradBar = new CountDownLatch(16);

        for(int i = 0; i<8; i++){
            new Thread(new FletteTrad(sykeMonitor, fletteTradBar)).start();
            new Thread(new FletteTrad(ikkeSykeMonitor, fletteTradBar)).start();
        }
        
        fletteTradBar.await();

        HashMap<String, Subsekvens> flettetSykSubsekvens = sykeMonitor.hentSub(0); 
        HashMap<String, Subsekvens> flettetSubsekvens = ikkeSykeMonitor.hentSub(0);

        for(Map.Entry<String, Subsekvens> entry : flettetSykSubsekvens.entrySet()) {
            int sykeSubsekvensAnt = entry.getValue().hentAnt();
            
            if(flettetSubsekvens.containsKey(entry.getKey())){
                if(sykeSubsekvensAnt - flettetSubsekvens.get(entry.getKey()).hentAnt() >= 7){
                    System.out.println(entry.toString());
                    System.out.print("Antall flere forekomster:");
                    System.out.println(sykeSubsekvensAnt - flettetSubsekvens.get(entry.getKey()).hentAnt() + "\n");
                }
            }
            else{
                if(sykeSubsekvensAnt >=7){
                    System.out.println(entry.toString());
                    System.out.print("Antall flere forekomster:");
                    System.out.println(sykeSubsekvensAnt + "\n");
                }
            }
        }   
    }
}
