public class bil1 {
    public void printMeg(){
        System.out.print("jeg er en bil");
    }
}

class BilBruk1{
    public static void main(String[] args) {
        bil1 bilObj = new bil1();
        bilObj.printMeg();
    }
}
