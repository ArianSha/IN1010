import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Subsekvens> m = SubsekvensRegister.lesFil("data1.txt");

        for(Map.Entry<String, Subsekvens> entry : m.entrySet()) {
           System.out.println(entry.toString());
        }
        
    }
}
