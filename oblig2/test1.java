public class test1 {
    public static void main(String[] args) {
        Narkotisk hasj = new Narkotisk("hasj", 300, 2, 50);
        Vanedannende morfin = new Vanedannende("morfin", 1000, 0.1, 90);
        Vanlig cardizem = new Vanlig("cardizem", 500, 1);

        Spesialist omid = new Spesialist("Omid", "123");
        Leger kiana = new Leger("Kiana");

        MilResepter resept1 = new MilResepter(hasj, omid, hasj.hentId());
        
        System.out.println(resept1.toString());
        


        // System.out.println(hasj.hentNarkoStyrke());
        // System.out.println(resept1.farge());


    }
}
