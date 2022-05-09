public class HvitRute extends Rute{

    
    public HvitRute(int radNr, int kolonneNr, Labyrint labyrint){
        super(radNr, kolonneNr, labyrint);
    }

    @Override
    public void finn(Rute fra) {
        if (this.besoekt)
            return;

        this.besoekt = true;

        for(Rute nabo: naboer) {
            if (nabo != fra)
                nabo.finn(this);
        }
    }
}