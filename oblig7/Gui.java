// import java.awt.*;
// import java.util.Random;
// import javax.swing.*;

// public class Gui {


//     public Rute[][] lagRuteNett(Rute[][] ruter){
        
//         JPanel ruteNett = new JPanel();
//         ruteNett.setLayout(new GridLayout(12,12));
        
//         for(int x = 0; x < 12; x++){
//             for (int y = 0; y < 12; y++ ){
//                 Rute rute = new Rute();
//                 ruter[x][y] = rute; 
//             }
//         }

//         this.lagTilFeldigSkatter(ruter, 10);
//         return ruter;
//     }


//     private void lagTilFeldigSkatter(Rute[][] ruter, int antallSkatter){

//         for(int i = 0; i < antallSkatter; i++)
//             Gui.leggTilfeldigSkatt(ruter);
//     }


//     private static void leggTilfeldigSkatt(Rute[][] ruter){
//         Random tilfeldigKordinat = new Random();

//         int tilfeldigX = tilfeldigKordinat.nextInt((11)+1);
//         int tilfeldigY= tilfeldigKordinat.nextInt((11)+1);

//         if(ruter[tilfeldigX][tilfeldigX] instanceof SkattRute)
//             Gui.leggTilfeldigSkatt(ruter);
            
//         else if(tilfeldigX == 5 && tilfeldigY == 6)
//             Gui.leggTilfeldigSkatt(ruter);

//         else
//             ruter[tilfeldigX][tilfeldigY] = new SkattRute();

//     }


//     private void linkNaboer(Rute[][] ruter){
//         for(int rad = 0; rad < 12; rad++){
//             for(int kolonne = 0; kolonne < 12; kolonne++) {
//                 leggTilNaboer(rad, kolonne);
//             }
//         }   
//     }

    
//     private void leggTilNaboer(int rad, int kolonne) {
//         Rute rute = ruter[rad][kolonne];

//         if (rad - 1 >= 0)
//             rute.leggTilNabo(labyrint[rad-1][kolonne]);

//         if (rad+1 < antallRader)
//             rute.leggTilNabo(labyrint[rad+1][kolonne]);

//         if (kolonne - 1 >= 0)
//             rute.leggTilNabo(labyrint[rad][kolonne-1]);

//         if (kolonne + 1 < antallKolonner)
//             rute.leggTilNabo(labyrint[rad][kolonne+1]);
//     }
// }
