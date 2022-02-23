public class Test {
    public static void main(String[] args) {
        Lenkeliste<String> liste1 = new Lenkeliste<>();
        Stabel<String> liste2 = new Stabel<>();

        liste1.leggTil("hei");
        liste1.leggTil("hei du");
        liste1.leggTil("hei verden");
        
        liste2.leggTil("hei");
        liste2.leggTil("hei du");
        liste2.leggTil("hei verden");

        System.out.println(liste1.toString());
        // System.err.println(liste1.stoerrelse());
        // System.out.println(liste1.fjern());
        // System.err.println(liste1.stoerrelse());
        // System.out.println(liste1.toString());

        System.out.println(liste2.toString());
        // System.err.println(liste2.stoerrelse());
        // System.out.println(liste2.fjern());
        // System.err.println(liste2.stoerrelse());
        // System.out.println(liste2.toString());
    }
}
