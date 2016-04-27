package part1;

import java.util.concurrent.TimeUnit;

/**
 * Created by russik on 18.04.2016.
 */
public class OurTask implements Runnable{

    @Override
    public void run() {
        try { for (int i = 0; i < 5; i++) { System.out.println("Task prints " + i);
            TimeUnit.SECONDS.sleep(1);
        }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    }

