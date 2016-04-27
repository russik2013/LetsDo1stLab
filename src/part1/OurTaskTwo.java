package part1;

import java.util.concurrent.TimeUnit;

/**
 * Created by russik on 18.04.2016.
 */
public class OurTaskTwo implements Runnable{
    public OurTaskTwo(String task) {

    }

    @Override
    public void run() {
        int i = 0;
        while( !Thread.currentThread().isInterrupted() ) {
            try {
                System.out.println("Task prints " + i++);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                //ex.printStackTrace();
                 Thread.currentThread().interrupt();
                 }
                 }
    }
}
