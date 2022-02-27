public class TestLegemiddel{
    public static void main(String[] args) {
        Narkotisk hasj = new Narkotisk("hasj", 400, 10, 20);
        Vanedannende ibux = new Vanedannende("ibuprofen", 200, 250, 20);
        Vanlig ivermectin = new Vanlig("ibuprofen", 800, 30);

        testVerdier.<String>testVerdi(hasj.hentNavn(), "hasj");
        testVerdier.<Integer>testVerdi(hasj.hentPris(), 400);
        testVerdier.<Double>testVerdi(hasj.hentVirkestoff(), (double) 10);
        testVerdier.<Integer>testVerdi(hasj.hentNarkoStyrke(), 20);
        hasj.settNyPris(700);
        testVerdier.<Integer>testVerdi(hasj.hentPris(), 700);

        testVerdier.<String>testVerdi(ibux.hentNavn(), "ibuprofen");
        testVerdier.<Integer>testVerdi(ibux.hentPris(), 200);
        testVerdier.<Double>testVerdi(ibux.hentVirkestoff(), (double) 250);
        testVerdier.<Integer>testVerdi(ibux.hentVaneStyrke(), 20);
        ibux.settNyPris(300);
        testVerdier.<Integer>testVerdi(ibux.hentPris(), 300);

        testVerdier.<String>testVerdi(ivermectin.hentNavn(), "ibuprofen");
        testVerdier.<Integer>testVerdi(ivermectin.hentPris(), 800);
        testVerdier.<Double>testVerdi(ivermectin.hentVirkestoff(), (double) 30);
        ivermectin.settNyPris(500);
        testVerdier.<Integer>testVerdi(ivermectin.hentPris(), 500);

        System.out.println("Testen gikk fint, alle verdier gitt var riktig.");

    }
}

class testVerdier{

    public static <T> void testVerdi(T verdi, T forventetVerdi){
        if(!verdi.equals(forventetVerdi)){
            System.out.println("Verdi er ikke riktig");
            System.out.println("Ekte verdi: " + verdi + "\n" + "Forventet verdi: " + forventetVerdi);
            System.exit(0);
        }
    }
}
