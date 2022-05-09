import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.*;

public class SkattRute extends Rute {
    

    public SkattRute(){
        super();
        super.setForeground(Color.RED);
        super.setText("$");
        super.setFont(new Font("Serif", Font.PLAIN, 20));
        super.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
