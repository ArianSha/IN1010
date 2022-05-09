import java.awt.*;
import javax.swing.*;


public class SnakeGame {

    
    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
                );
        }
        catch (Exception e){
            System.out.println("Noe galt skjedde");
            System.exit(0);
        }
            
        JFrame vindu = new JFrame("Snake Game");
        vindu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vindu.setSize(700,700);
        vindu.setLocationRelativeTo(null);
        
        Rute[][] ruter = new Rutenett().lagRuteNett();
        JPanel ruteNett = SnakeGame.skrivRuteNett(ruter);
        Rute startRute = ruter[5][6];
        Slange slange = new Slange(startRute);
        JPanel header = SnakeGame.lagHeader(vindu, slange); 

        vindu.add(header, BorderLayout.NORTH);
        vindu.add(ruteNett);
        
        vindu.setVisible(true);
    }


    private static JPanel lagHeader(JFrame vindu, Slange slange){
        JPanel header = new JPanel();
        JLabel score = new JLabel();
        JPanel kontroller = new JPanel();

        header.setLayout(new BorderLayout());
        header.add(score, BorderLayout.WEST);
        header.add(kontroller);

        score.setText("Poeng: 0");

        JButton oppKnapp = new JButton("opp");
        JButton venstreKnapp = new JButton("venstre");
        JButton hoyreKnapp = new JButton("høyre");
        JButton nedKnapp = new JButton("ned");

        oppKnapp.addActionListener(slange);
        venstreKnapp.addActionListener(slange);
        hoyreKnapp.addActionListener(slange);
        nedKnapp.addActionListener(slange);
        
        kontroller.add(oppKnapp, BorderLayout.NORTH);
        kontroller.add(venstreKnapp, BorderLayout.WEST);
        kontroller.add(hoyreKnapp, BorderLayout.EAST);    
        kontroller.add(nedKnapp, BorderLayout.SOUTH);
        return header;
    }


    private static JPanel skrivRuteNett(Rute[][] ruter){
        
        JPanel ruteNett = new JPanel();
        ruteNett.setLayout(new GridLayout(12,12));
        
        for(Rute[] ruteKolonne: ruter){
            for(Rute rute: ruteKolonne)
                ruteNett.add(rute);
        }

        return ruteNett;
    }
}
