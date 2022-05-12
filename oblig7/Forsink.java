import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Forsink implements ActionListener, KeyListener{

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
    public void actionPerformed(ActionEvent e) {

        kontroll.kommando = e.getActionCommand();
        timer.start();
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
