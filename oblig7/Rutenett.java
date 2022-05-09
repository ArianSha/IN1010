import java.awt.*;
import java.util.Random;
import javax.swing.*;


public class Rutenett {

    Rute[][] ruter = new Rute[12][12];


    public Rute[][] lagRuteNett(){
        
        for(int x = 0; x < 12; x++){
            for (int y = 0; y < 12; y++ ){
                Rute rute = new Rute();
                ruter[x][y] = rute; 
            }
        }

        this.lagTilFeldigSkatter(ruter, 10);
        this.linkNaboer();
        return ruter;
    }


    private void lagTilFeldigSkatter(Rute[][] ruter, int antallSkatter){

        for(int i = 0; i < antallSkatter; i++)
            Rutenett.leggTilfeldigSkatt(ruter);
    }


    private static void leggTilfeldigSkatt(Rute[][] ruter){
        Random tilfeldigKordinat = new Random();

        int tilfeldigX = tilfeldigKordinat.nextInt((11)+1);
        int tilfeldigY= tilfeldigKordinat.nextInt((11)+1);

        if(ruter[tilfeldigX][tilfeldigX] instanceof SkattRute)
            Rutenett.leggTilfeldigSkatt(ruter);
            
        else if(tilfeldigX == 5 && tilfeldigY == 6)
            Rutenett.leggTilfeldigSkatt(ruter);

        else
            ruter[tilfeldigX][tilfeldigY] = new SkattRute();

    }


    private void linkNaboer(){
        for(int rad = 0; rad < 12; rad++){
            for(int kolonne = 0; kolonne < 12; kolonne++) {
                leggTilNaboer(rad, kolonne);
            }
        }   
    }

    
    private void leggTilNaboer(int rad, int kolonne) {
        Rute rute = ruter[rad][kolonne];

        if (rad - 1 >= 0)
            rute.naboNord = ruter[rad-1][kolonne];

        if (rad + 1 < 11)
            rute.naboSor = ruter[rad+1][kolonne];

        if (kolonne - 1 >= 0)
            rute.naboVest = ruter[rad][kolonne-1];

        if (kolonne + 1 < 11)
            rute.naboOst = ruter[rad][kolonne+1];
    }
}

