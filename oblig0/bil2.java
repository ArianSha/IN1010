public class bil2 {
    String bilnummer;

    public bil2(String id){
        bilnummer = id; 
    }
    public void printMeg(){
        System.out.print("jeg er en bil. Mitt billnummer er " + this.bilnummer);
    }
}

class BilBruk2{
    public static void main(String[] args) {
        bil2 bilObj = new bil2("123");
        bilObj.printMeg();
    }
}




