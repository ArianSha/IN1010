import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui{

    private JFrame vindu;
    private Rute[][] ruter;
    public JLabel score = new JLabel(); 

    
    public Gui(JFrame vindu, Rute[][] ruter){
        this.vindu = vindu;
        this.ruter = ruter;
    }
    
    
    public void lagHeader(){
        
        JPanel header = new JPanel();
        
        score.setText("score: 0" );
        score.setHorizontalAlignment(JLabel.CENTER);

        header.add(score);
        vindu.add(header, BorderLayout.NORTH);
    }


    public void skrivRuteNett(){
        
        JPanel ruteNett = new JPanel();
        ruteNett.setLayout(new GridLayout(12,12));
        
        for(Rute[] ruteKolonne: ruter){
            for(Rute rute: ruteKolonne)

                ruteNett.add(rute);
        }
        vindu.add(ruteNett);
    }


    public void leggTilKontroller(Slange slange){

        Forsink forsink = new Forsink(250, slange);
        vindu.addKeyListener(forsink);
        
        vindu.setFocusable(true);
        vindu.requestFocusInWindow();
    }
}