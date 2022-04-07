public class LeseTrad implements Runnable {
    Monitor1 monitor;
    String filNavn;

    public LeseTrad(String filNavn, Monitor1 monitor){
        this.monitor = monitor;
        this.filNavn = filNavn;
    }

    @Override
    public void run(){
        m.settSub(lesFil(filNavn));
    }
}
