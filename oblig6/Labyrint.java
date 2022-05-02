import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labyrint {
    
    Rute[][] labyrint;
    Scanner leser = null; 
    int antallRader;
    int antallKolonner;


    public Labyrint(String filnavn) {
        try {
            File fil = new File(filnavn);
            if (!fil.exists()) throw new FileNotFoundException();

            try {
                leser = new Scanner(new File(filnavn));

                antallRader = leser.nextInt();
                antallKolonner = leser.nextInt();
                labyrint = new Rute[antallRader][antallKolonner];

                for(int rad = 0; rad < antallRader; rad ++) {
                    char[] ruter = leser.next().toCharArray();

                    for(int kolonne = 0; kolonne < antallKolonner; kolonne++) {
                        char rute = ruter[kolonne];
                       
                        if(rute == '#')
                            labyrint[rad][kolonne] = new SortRute(rad, kolonne, this);
                        
                        else if(rute == '.') {
                            if (erKantRute(rad, kolonne)) {
                                labyrint[rad][kolonne] = new Aapning(rad, kolonne, this);
                            }

                            else
                                labyrint[rad][kolonne] = new HvitRute(rad, kolonne, this);
                        }
                        else
                            throw new Exception("oppgitt rute format er ikke stoettet" + rad + kolonne );
                    }
                }
                this.linkNaboer();

            }   
            finally{
                leser.close();
            }

        }
        catch(FileNotFoundException | NullPointerException e) {
            System.out.println("filen finnes ikke");
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("Ugyldig fil format");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }


    private boolean erKantRute(int rad, int kolonne) {
        return (rad == 0 || rad == antallRader - 1 || kolonne == 0 || kolonne == antallKolonner - 1);
    }


    public void finnUtveiFra(int rad, int kol) {
        Rute startRute = labyrint[rad][kol];
        startRute.finn(null);
    }


    private void linkNaboer(){
        for(int rad = 0; rad < antallRader; rad++){
            for(int kolonne = 0; kolonne < antallKolonner; kolonne++) {
                leggTilNaboer(rad, kolonne);
            }
        }   
    }

    
    private void leggTilNaboer(int rad, int kolonne) {
        Rute rute = labyrint[rad][kolonne];

        if (rad - 1 >= 0)
            rute.leggTilNabo(labyrint[rad-1][kolonne]);

        if (rad+1 < antallRader)
            rute.leggTilNabo(labyrint[rad+1][kolonne]);

        if (kolonne - 1 >= 0)
            rute.leggTilNabo(labyrint[rad][kolonne-1]);

        if (kolonne + 1 < antallKolonner)
            rute.leggTilNabo(labyrint[rad][kolonne+1]);
    }


    public String toString(){

        StringBuilder visuellLabyrint = new StringBuilder();

        for (Rute[] rad: labyrint){
            visuellLabyrint.append("\n");

            for(Rute rute: rad){
                if(rute instanceof HvitRute)
                    visuellLabyrint.append(".");
                else
                    visuellLabyrint.append("#");
            }
        }
        return visuellLabyrint.toString();
    }
}
