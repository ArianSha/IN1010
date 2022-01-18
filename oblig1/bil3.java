public class bil3 {
    private String bilnummer;

    public bil3(String id){
        bilnummer = id; 
    }
    public void printMeg(){
        System.out.println("jeg er en bil. Mitt billnummer er " + this.bilnummer);
    }
    public String hentBilnummer() {
        return this.bilnummer;
    }
}

class person{
    private bil3 bil;

    public person(bil3 ob){
        bil = ob;
    }
    public void utskriftPersonBilnummer(){
        System.out.println(bil.hentBilnummer());
    }
}

class BilBruk3{
    public static void main(String[] args) {
        bil3 bilObj = new bil3("123");
        person personObj = new person(bilObj);
        personObj.utskriftPersonBilnummer();

    }
}




