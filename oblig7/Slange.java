import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public class Slange {
    
    JLabel score;
    int poeng = 1;
    Rute hodeRute;
    Rute haleRute;
    Rute[][] ruter;
    ArrayList<Rute> slangeRuter = new ArrayList<>();


    public Slange(int startRad, int startKollone, Rute[][] ruter, JLabel score){

        this.score = score;
        this.ruter = ruter;
        haleRute = hodeRute = ruter[startRad][startKollone];

        hodeRute.omgjorSlangeRute();
        slangeRuter.add(hodeRute);
    }


    private void leggTilRute(Rute rute){

        rute.omgjorSlangeRute();
        hodeRute = rute;
        slangeRuter.add(hodeRute);
    }


    public void flyttRute(Rute til){
        
        if (til == null || slangeRuter.contains(til)){
            System.out.println("du gikk ut");
            System.exit(0);
        }

        else if(til.skattRute == true){

            til.omgjorHvitRute();
            this.leggTilRute(til);
            this.leggTilNySkatt();
            score.setText("score: " + poeng++);
        }

        else{
            this.leggTilRute(til);
            this.fjernHale();
        }
    }


    private void fjernHale(){

        haleRute.omgjorHvitRute();

        slangeRuter.remove(0);
        haleRute = slangeRuter.get(0);
    }


    private void leggTilNySkatt(){
        Random tilfeldigKordinat = new Random();

        int tilfeldigX = tilfeldigKordinat.nextInt((11)+1);
        int tilfeldigY= tilfeldigKordinat.nextInt((11)+1);

        if(ruter[tilfeldigX][tilfeldigY].skattRute == true)
            this.leggTilNySkatt();
            
        else if(slangeRuter.contains(ruter[tilfeldigX][tilfeldigY]))
            this.leggTilNySkatt();

        else{
            Rute rute = ruter[tilfeldigX][tilfeldigY];
            rute.omgjorSkattRute();
        }
    }

}
