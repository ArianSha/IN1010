import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Gui{

    private JFrame vindu;
    private Rute[][] ruter;

    JLabel score = new JLabel();

    private JButton oppKnapp;
    private JButton venstreKnapp;
    private JButton hoyreKnapp;
    private JButton nedKnapp;


    public Gui(JFrame vindu, Rute[][] ruter){
        this.vindu = vindu;
        this.ruter = ruter;
    }


    public void lagHeader(){

        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        score.setText("score: 0" );
        JPanel kontroller = new JPanel();
        
        this.oppKnapp = new JButton("opp");
        this.venstreKnapp = new JButton("venstre");
        this.hoyreKnapp = new JButton("høyre");
        this.nedKnapp = new JButton("ned");
        
        kontroller.add(oppKnapp, BorderLayout.NORTH);
        kontroller.add(venstreKnapp, BorderLayout.WEST);
        kontroller.add(hoyreKnapp, BorderLayout.EAST);    
        kontroller.add(nedKnapp, BorderLayout.SOUTH);

        header.add(score, BorderLayout.WEST);
        header.add(kontroller);
        
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

        // Kontroll kontroll = new Kontroll(slange);
        Forsink forsink = new Forsink(250, slange);

        oppKnapp.setActionCommand("opp");
        venstreKnapp.setActionCommand("venstre");
        hoyreKnapp.setActionCommand("hoyre");
        nedKnapp.setActionCommand("ned");
        
        oppKnapp.addActionListener(forsink);
        venstreKnapp.addActionListener(forsink);
        hoyreKnapp.addActionListener(forsink);
        nedKnapp.addActionListener(forsink);
        
        vindu.setFocusable(true);
        vindu.requestFocusInWindow();
        vindu.addKeyListener(forsink);
    }
}