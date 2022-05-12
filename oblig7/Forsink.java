import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Forsink implements KeyListener{

    int forsinkelse;
    Kontroll kontroll;
    Slange slange;
    Timer timer;

    public Forsink(int forsinkelse, Slange slange){
        this.forsinkelse = forsinkelse;
        this.slange = slange;

        this.kontroll = new Kontroll(slange);
        timer = new Timer(forsinkelse, kontroll);
    }


    @Override
    public void keyPressed(KeyEvent e) {

        kontroll.tasteTrykk = e.getKeyCode();
        timer.start();
    }


    @Override
    public void keyReleased(KeyEvent e) {
        
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
