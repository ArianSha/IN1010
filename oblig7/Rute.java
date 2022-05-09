import java.awt.*;
import javax.swing.*;


public class Rute extends JLabel{
    
    Rute naboNord;
    Rute naboVest;
    Rute naboOst;
    Rute naboSor;

    public Rute(){
        super.setOpaque(true);
        super.setBackground(Color.WHITE);
        super.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }
}
