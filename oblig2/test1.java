public class test1 {
    public static void main(String[] args) {
        Narkotisk hasj = new Narkotisk("hasj", 300, 2, 50);
        Vanedannende morfin = new Vanedannende("morfin", 1000, 0.1, 90);
        Vanlig cardizem = new Vanlig("cardizem", 500, 1);
        Vanlig cerazette = new Vanlig("Cerazette", 200, 40);

        Spesialist omid = new Spesialist("Omid", "123");
        Leger kiana = new Leger("Kiana");

        HviteResepter resept1 = new HviteResepter(cardizem, kiana, cardizem.hentId(), 5);
        MilResepter resept2 = new MilResepter(hasj, omid, hasj.hentId());
        PResepter resept3 = new PResepter(cerazette, kiana, cerazette.hentId(), 2);
        BlaaResepter resept4 = new BlaaResepter(morfin, kiana, morfin.hentId(), 5);
        
        System.out.println(hasj.toString());
        System.out.println(morfin.toString());
        System.out.println(cardizem.toString());
        System.out.println(cerazette.toString());

        System.out.println(omid.toString());
        System.out.println(kiana.toString());

        System.out.println(resept1.toString());
        System.out.println(resept2.toString());
        System.out.println(resept3.toString());
        System.out.println(resept4.toString());
        
    }
}
