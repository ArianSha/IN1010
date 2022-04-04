import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Subsekvens> m = SubsekvensRegister.lesFil("/home/ariansh/dev/IN1010/oblig5/data1.txt");
        HashMap<String, Subsekvens> smettet = SubsekvensRegister.subsSmettng(m,m);

        // for(Map.Entry<String, Subsekvens> entry : m.entrySet()) {
        //    System.out.println(entry.toString());
        // }

        for(Map.Entry<String, Subsekvens> entry : smettet.entrySet()) {
           System.out.println(entry.toString());
        }
        
    }
}
