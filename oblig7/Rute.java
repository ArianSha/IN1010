import java.awt.*;
import javax.swing.*;


public class Rute extends JLabel{
    
    boolean skattRute = false;
    Rute naboNord;
    Rute naboVest;
    Rute naboOst;
    Rute naboSor;


    public Rute(){
        super.setOpaque(true);
        super.setBackground(Color.WHITE);
        super.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        super.setFont(new Font("Serif", Font.PLAIN, 20));
        super.setHorizontalAlignment(SwingConstants.CENTER);
    }


    public void omgjorHvitRute(Rute naboNord, Rute naboVest, Rute naboOst, Rute naboSor){
        skattRute = false;

        super.setText("");
        super.setBackground(Color.WHITE);
        this.omgjorNaboer(naboNord, naboVest, naboOst, naboSor);
    }
    

    public void omgjorSkattRute(){
        skattRute = true;

        super.removeAll();
        super.setForeground(Color.RED);
        super.setText("$");
    }
    

    public void omgjorSkattRute(Rute naboNord, Rute naboVest, Rute naboOst, Rute naboSor){
        skattRute = true;
        super.removeAll();
        
        super.setForeground(Color.RED);
        super.setText("$");
        
        this.omgjorNaboer(naboNord, naboVest, naboOst, naboSor);
        
    }
    
    
    private void omgjorNaboer(Rute naboNord, Rute naboVest, Rute naboOst, Rute naboSor){

        this.naboNord = naboNord;
        this.naboVest = naboVest;
        this.naboSor = naboSor;
        this.naboOst = naboOst;

        if(naboNord != null)
            naboNord.naboSor = this;
        
        if(naboOst != null)
            naboVest.naboOst = this;
        
        if(naboOst != null)
            naboOst.naboVest = this;

        if(naboSor != null)
            naboSor.naboNord = this;
    }
}
