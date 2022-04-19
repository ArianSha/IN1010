import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Oblig5Del1 {
    public static void main(String[] args) {
        
        BufferedReader mappeLeser = null;
        File folder = new File(args[0]);
        SubsekvensRegister register = new SubsekvensRegister();

        try{
            if (Arrays.stream(folder.list()).anyMatch("metadata.csv"::equals)){
                mappeLeser = new BufferedReader(new FileReader(new File(folder, "metadata.csv")));

                for(String linje; (linje = mappeLeser.readLine()) != null;)
                    register.settSub(SubsekvensRegister.lesFil(new File(folder.getPath() + "/" + linje)));
                
            }
            else throw new Exception("metadata.csv ikke funnet");
    
        }
        catch(FileNotFoundException e){
            System.out.println("filen finnes ikke");
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

        HashMap<String, Subsekvens> smettetSubs = register.hentSub(0);

        for(int i = 1; i < register.antSub(); i++)
            smettetSubs = SubsekvensRegister.subsSmettng(smettetSubs, register.hentSub(i));
        
        for(Map.Entry<String, Subsekvens> entry : smettetSubs.entrySet()) 
               System.out.println(entry.toString());
    }
}
