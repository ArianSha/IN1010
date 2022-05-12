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
        
        Rute[][] ruter = new Rutenett(5, 6, 12).lagRuteNett();
        Gui GUI = new Gui(vindu, ruter);
        Slange slange = new Slange(5, 6, ruter, GUI.score);

        GUI.lagHeader(); 
        GUI.skrivRuteNett();
        GUI.leggTilKontroller(slange);
        

        vindu.setVisible(true);
    }
}
