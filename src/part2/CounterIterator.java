package part2;

/**
 * Created by russik on 18.04.2016.
 */
public class CounterIterator implements Runnable{
    Counter counter;
    public CounterIterator(Counter count){
        this.counter = count;
    }
    @Override
    public void run() {
        for(int i = 0; i < 100000; i++)
        counter.inc();

    }
}
