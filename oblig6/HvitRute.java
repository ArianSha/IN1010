public class HvitRute extends Rute{

    
    public HvitRute(int radNr, int kolonneNr, Labyrint labyrint){
        super(radNr, kolonneNr, labyrint);
    }

    @Override
    public void finn(Rute fra) {

        for(Rute nabo: naboer) {
            if (nabo != fra)
                nabo.finn(this);
        }
    }
}