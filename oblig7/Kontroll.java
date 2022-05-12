import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kontroll implements ActionListener{
    
    Slange slange;
    String sisteKommando = "";
    String kommando = "";
    int tasteTrykk = 0;


    public Kontroll(Slange slange){
        this.slange = slange;
    }


    public void actionPerformed(ActionEvent e){
        
        // System.out.println(e.getActionCommand());
        if((kommando.equals("opp") || tasteTrykk == 38) && ! sisteKommando.equals("ned")){
            
            this.bevegOpp();
            sisteKommando = "opp"; 
        }
        else if((kommando.equals("venstre") || tasteTrykk == 37) && ! sisteKommando.equals("hoyre")){
            
            this.bevegVenstre();
            sisteKommando = "venstre";
        }
        else if((kommando.equals("hoyre") || tasteTrykk == 39) && ! sisteKommando.equals("venstre")){
            
            this.bevegHoyre();
            sisteKommando = "hoyre";
        }
        else if((kommando.equals("ned") || tasteTrykk == 40) && ! sisteKommando.equals("opp")){
            
            this.bevegNed();
            sisteKommando = "ned";
        }
        // else{
        //     kommando = sisteKommando;
        //     this.actionPerformed(e);
        // }
    }


    private void bevegOpp() {
        try{
            slange.flyttRute(slange.hodeRute.naboNord);
        }
        catch(Exception e){
            System.out.println("noe gikk galt");
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    
    private void bevegVenstre(){
        try{
            slange.flyttRute(slange.hodeRute.naboVest);
        }
        catch(Exception e){
            System.out.println("noe gikk galt");
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    
    private void bevegHoyre() {
        try{
            slange.flyttRute(slange.hodeRute.naboOst);
        }
        catch(Exception e){
            System.out.println("noe gikk galt");
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    
    private void bevegNed() {
        try{
            slange.flyttRute(slange.hodeRute.naboSor);
        }
        catch(Exception e){
            System.out.println("noe gikk galt");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
