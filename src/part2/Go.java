package part2;

/**
 * Created by russik on 18.04.2016.
 */
public class Go {
    public static void main (String args[]){
        Counter count = new Counter();
        Thread thread1 = new Thread(new CounterIterator(count));
        Thread thread2 = new Thread(new CounterIterator(count));
        Thread thread3 = new Thread(new CounterIterator(count));
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.counter);
    }
}
