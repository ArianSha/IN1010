import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Oblig5Del1 {
    public static void main(String[] args) {
        
        Scanner mappeLeser = null;
        File folder = new File(args[0]);
        SubsekvensRegister register = new SubsekvensRegister();
        
        try{
            Arrays.stream(folder.list()).anyMatch("metadata.csv"::equals);
            if (new File(folder, "metadata.csv").exists()){
                mappeLeser = new Scanner( new File(folder, "metadata.csv"));
                while (mappeLeser.hasNextLine()) register.settSub(SubsekvensRegister.lesFil(new File(folder.getPath() + "/" + mappeLeser.nextLine())));
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
            if(mappeLeser!=null){
                mappeLeser.close();

            }
        }

        HashMap<String, Subsekvens> smettetSubs = register.hentSub(0);

        for(int i = 0; i < register.antSub()-1; i++){
            smettetSubs = SubsekvensRegister.subsSmettng(smettetSubs, register.hentSub(i+1));
        }
        
        for(Map.Entry<String, Subsekvens> entry : smettetSubs.entrySet()) {
               System.out.println(entry.toString());
            }

    }
}
