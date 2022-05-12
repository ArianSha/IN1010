import java.awt.*;
import javax.swing.*;


public class Rute extends JLabel{
    
    boolean skattRute = false;

    Rute naboNord;
    Rute naboVest;
    Rute naboOst;
    Rute naboSor;

    ImageIcon fotballBilde; 


    public Rute(){

        super.setOpaque(true);
        super.setBackground(new Color(155,228,165));
        
        super.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        super.setFont(new Font("Serif", Font.PLAIN, 20));
        super.setHorizontalAlignment(SwingConstants.CENTER);
        
        Image fotballIkom = new ImageIcon("fotball.png").getImage();
        fotballBilde = new ImageIcon(fotballIkom.getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    }
    
    
    public void omgjorHvitRute(){

        super.setBackground(new Color(155,228,165));
        skattRute = false;
        super.setIcon(null);
        
        super.setIcon(null);
        super.setText(null);
    }
    

    public void omgjorSkattRute(){

        skattRute = true;
        super.setIcon(fotballBilde);
    }

    public void omgjorSlangeRute(){
        super.setBackground(Color.red);
    }
}
