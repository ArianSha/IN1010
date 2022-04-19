import java.io.File;
import java.util.concurrent.CountDownLatch;

public class LeseTrad implements Runnable {
    Monitor1 monitor;
    String filPath;
    CountDownLatch bar;

    public LeseTrad(String filPath, Monitor1 monitor, CountDownLatch bar){
        this.monitor = monitor;
        this.filPath = filPath;
        this.bar = bar;
    }

    @Override
    public void run(){
        monitor.settSub(Monitor1.lesFil(new File(filPath)));
        bar.countDown();
    }
}
