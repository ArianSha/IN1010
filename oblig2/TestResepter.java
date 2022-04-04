public class TestResepter {
    public static void main(String[] args) {
        Narkotisk hasj = new Narkotisk("hasj", 300, 2, 50);
        Leger kiana = new Leger("Kiana");
        
        HviteResepter resept1 = new HviteResepter(hasj, kiana, hasj.hentId(), 5);
        MilResepter resept2 = new MilResepter(hasj, kiana, hasj.hentId());
        PResepter resept3 = new PResepter(hasj, kiana, hasj.hentId(), 2);
        BlaaResepter resept4 = new BlaaResepter(hasj, kiana, hasj.hentId(), 5);

        TestVerdier.<String>testVerdi(resept1.hentLege(), "Kiana");
        TestVerdier.<Integer>testVerdi(resept2.prisAaBetale(), 0);
        TestVerdier.<String>testVerdi(resept3.farge(), "hvit");
        TestVerdier.<String>testVerdi(resept4.farge(), "blaa");

        System.out.println("Testen gikk fint, alle verdier gitt var riktig.");
        
    }
}

class TestVerdier{

    public static <T> void testVerdi(T verdi, T forventetVerdi){
        if(!verdi.equals(forventetVerdi)){
            System.out.println("Verdi er ikke riktig");
            System.out.println("Ekte verdi: " + verdi + "\n" + "Forventet verdi: " + forventetVerdi);
            System.exit(0);
        }
    }
}
