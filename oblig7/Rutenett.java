import java.nio.file.AccessMode;
import java.util.Random;

public class Rutenett {

    int startRad;
    int startKollone;
    Rute[][] ruter;

    public Rutenett(int startRad, int startKollone){

        this.startRad = startRad;
        this.startKollone = startKollone;
        ruter = new Rute[12][12]; 
    }
    

    public Rute[][] lagRuteNett(){
        
        for(int rader = 0; rader < 12; rader++){
            for (int kolonner = 0; kolonner < 12; kolonner++ ){

                Rute rute = new Rute();
                ruter[rader][kolonner] = rute; 
            }
        }
        this.lagTilFeldigSkatter(10);
        this.linkNaboer();

        return ruter;
    }


    private void lagTilFeldigSkatter(int antallSkatter){

        for(int i = 0; i < antallSkatter; i++)
            leggTilfeldigSkatt();
    }


    private void leggTilfeldigSkatt(){
        Random tilfeldigKordinat = new Random();

        int tilfeldigX = tilfeldigKordinat.nextInt((12 - 1)+1);
        int tilfeldigY= tilfeldigKordinat.nextInt((12 - 1)+1);

        if(ruter[tilfeldigX][tilfeldigY].skattRute == true)
            this.leggTilfeldigSkatt();
            
        else if(tilfeldigX == startRad && tilfeldigY == startKollone)
            this.leggTilfeldigSkatt();

        else{
            Rute rute = new Rute();
            rute.omgjorSkattRute();
            ruter[tilfeldigX][tilfeldigY] = rute;
        }
    }


    private void linkNaboer(){

        for(int rad = 0; rad < 12; rad++)
            for(int kolonne = 0; kolonne < 12; kolonne++) 

                leggTilNaboer(rad, kolonne);
    }

    
    private void leggTilNaboer(int rad, int kolonne) {
        Rute rute = ruter[rad][kolonne];

        if (rad - 1 >= 0)
            rute.naboNord = ruter[rad-1][kolonne];

        if (rad + 1 < 12)
            rute.naboSor = ruter[rad+1][kolonne];

        if (kolonne - 1 >= 0)
            rute.naboVest = ruter[rad][kolonne-1];

        if (kolonne + 1 < 12)
            rute.naboOst = ruter[rad][kolonne+1];
    }
}

