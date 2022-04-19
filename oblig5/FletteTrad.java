import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class FletteTrad implements Runnable {
    Monitor2 monitor;
    CountDownLatch bar;

    public FletteTrad(Monitor2 monitor, CountDownLatch bar) {
        this.monitor = monitor;
        this.bar = bar;
    }

    @Override
    public void run() {
        try {
            while(monitor.antSub() >=2 ) {
                HashMap<String, Subsekvens>[] par = monitor.hentToSubs();
    
                if(par == null)
                    return;
                else{
                    HashMap<String, Subsekvens> flettetPar = Monitor2.subsSmettng(par[0], par[1]);
                    monitor.settSub(flettetPar);
                }
            }
        }
        finally {
            bar.countDown();
        }
    }
}
