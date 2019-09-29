package sync;

import creator.BasicCreator;
import creator.Creator;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/*
* 同步的对象生成器，每隔一段时间生成对象
 */
public class SyncGenerator<T> {
    T element;

    AtomicBoolean ready = new AtomicBoolean(false);

    Creator<T> creator;

    Object[] args;

    int timeInterval;

    TimeUnit timeUnit;

    Thread generateThread = new Thread(()->{
        try {
            while (true) {
                Thread.sleep(timeUnit.toMillis(timeInterval));
                synchronized (ready) {
                    while (ready.get() == true) ready.wait();
                    element = creator.create(args);
                    ready.set(true);
                    ready.notifyAll();
                }
            }
        } catch(InterruptedException e){}
    });

    public SyncGenerator(Creator<T> creator, int timeInterval, TimeUnit timeUnit, Object... args) {
        this.creator = creator;
        this.timeInterval = timeInterval;
        this.timeUnit = timeUnit;
        this.element = null;
        this.args = args;
    }

    public void startGenerating(){
        generateThread.start();
    }

    public void stopGenerating(){
        generateThread.interrupt();
    }

    public boolean isReady(){
        return ready.get();
    }

    public T fetch(){
        T fetched = null;
        synchronized(ready) {
            try {
                while (ready.get() == false) ready.wait();
                fetched = element;
                element = null;
                ready.set(false);
                ready.notifyAll();
            } catch(InterruptedException e){}
        }
        return fetched;
    }

    public static void main(String[] args) {
        SyncGenerator<Integer> generator = new SyncGenerator<>(new BasicCreator<>(Integer.class, int.class), 1000, TimeUnit.MILLISECONDS, 2);
        generator.startGenerating();
        while(true){
            System.out.println(generator.fetch());
        }
    }
}
