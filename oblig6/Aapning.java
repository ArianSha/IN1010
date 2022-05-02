public class Aapning extends HvitRute {


    public Aapning(int radNr, int kolonneNr, Labyrint labyrint){
        super(radNr, kolonneNr, labyrint);
    }
    

    @Override
    public final void finn(Rute fra){
        System.out.println("(" + radNr + ", " + kolonneNr + ")");
    }
}
