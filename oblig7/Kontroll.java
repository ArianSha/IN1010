import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kontroll implements ActionListener{
    
    Slange slange;
    int tasteTrykk = 0;

    
    public Kontroll(Slange slange){
        this.slange = slange;
    }


    public void actionPerformed(ActionEvent e){
        
        if( tasteTrykk == 38)
            slange.flyttRute(slange.hodeRute.naboNord);
        
        else if( tasteTrykk == 37) 
            slange.flyttRute(slange.hodeRute.naboVest);
        
        else if( tasteTrykk == 39)
            slange.flyttRute(slange.hodeRute.naboOst);
        
        else if( tasteTrykk == 40)
            slange.flyttRute(slange.hodeRute.naboSor);
    }
}
