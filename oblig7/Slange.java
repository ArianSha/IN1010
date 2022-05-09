import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Slange implements ActionListener {
    
    int slangeLengde;
    Rute hodeRute;
    Rute hale;
    ArrayList<Rute> slangeRuter = new ArrayList<>();


    public Slange(Rute rute){
        rute.setBackground(Color.GREEN);
        hodeRute = rute;
        hale = rute;
        slangeRuter.add(hodeRute);
        slangeLengde = 1;
    }


    public void leggTilRute(Rute rute){
        rute.setBackground(Color.GREEN);
        hodeRute = rute;
        slangeRuter.add(hodeRute);
    }


    public void flyttRute(Rute fra, Rute til){

    }


    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getActionCommand().equals("oppKnapp")){
            // while(true){
            //     try{
            //         Thread.sleep(2000);
            //         this.flyttRute(hodeRute, til);
            //         hodeRute
            //     }
            // }
        }
        else if(e.getActionCommand().equals("venstreKnapp")){

        }
        else if(e.getActionCommand().equals("hoyreKnapp")){

        }
        else if(e.getActionCommand().equals("nedKnapp")){

        }
        else
            return;
    }
}
