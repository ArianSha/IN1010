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


    public void omgjorHvitRute(){
        skattRute = false;

        super.setText("");
        super.setBackground(Color.WHITE);
    }
    

    public void omgjorSkattRute(){
        skattRute = true;
        super.removeAll();
        
        super.setForeground(Color.RED);
        super.setText("$");
    }


    public void omgjorSlangeRute(){
        this.setBackground(Color.green);
    }
}
