import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class Kontroll implements ActionListener{
    
    Slange slange;
    String sisteKommando = "n";

    public Kontroll(Slange slange){
        this.slange = slange;
    }
    
    
    public void actionPerformed(ActionEvent e){

        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("opp") && ! (sisteKommando.equals("ned"))){
            this.bevegOpp();
            sisteKommando = e.getActionCommand();
        }
        else if(e.getActionCommand().equals("venstre") && !sisteKommando.equals("hoyre")){
            this.bevegVenstre();
            sisteKommando = e.getActionCommand();
        }
        else if(e.getActionCommand().equals("hoyre") && !sisteKommando.equals("venstre")){
            this.bevegHoyre();
            sisteKommando = e.getActionCommand();
        }
        else if(e.getActionCommand().equals("ned") && !sisteKommando.equals("opp")){
            this.bevegNed();
            sisteKommando = e.getActionCommand();
        }
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
