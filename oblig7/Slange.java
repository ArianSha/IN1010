import java.awt.*;
import java.util.ArrayList;

public class Slange {
    
    int startRad;
    int startKollone;
    Rute hodeRute;
    Rute hale;
    Rute[][] ruter;
    ArrayList<Rute> slangeRuter = new ArrayList<>();


    public Slange(int startRad, int startKollone, Rute[][] ruter){
    
        hale = hodeRute = ruter[startRad][startKollone];
        hodeRute.setBackground(Color.GREEN);
        slangeRuter.add(hodeRute);
    }


    private void leggTilRute(Rute rute){
        rute.setBackground(Color.GREEN);
        hodeRute = rute;
        slangeRuter.add(hodeRute);
    }


    public void flyttRute(Rute til){
        
        if (til == null){
            System.out.println("du gikk ut");
            System.exit(0);
        }

        else if(til.skattRute == true){

            til.omgjorHvitRute(til.naboNord, til.naboVest, til.naboOst, til.naboSor);
            this.leggTilRute(til);
            return;
        }

        else{
            this.leggTilRute(til);
            this.fjernRute(hale);
        }
    }


    private Rute fjernRute(Rute rute){

        hale.setBackground(Color.WHITE);

        Rute gammelHale = slangeRuter.remove(0);
        hale = slangeRuter.get(0);

        return gammelHale;
    }

}
