import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oblig5Del1 {
    public static void main(String[] args) {
        
        Scanner mappeLeser = null;
        File folder = new File(args[0]);
        
        try{
            if (new File(folder, "metadata.csv").exists()){
                mappeLeser = new Scanner( new File(folder, "metadata.csv"));
                while (mappeLeser.hasNextLine()) SubsekvensRegister.lesFil(mappeLeser.nextLine());
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
        
    }
}
