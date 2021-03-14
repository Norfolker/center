import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Call {

    private volatile static AtomicInteger workingCount = new AtomicInteger(0);
    protected static int count = 0;
    protected static BlockingQueue<String> calls = new LinkedBlockingDeque<>();

    public void create() {
        count++;
        String call = "звонок №" + count;
        try {
            calls.put(call);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(call);
    }

    public int getCall() {
        String msg = null;
        try {
            msg = calls.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Специалист " + Thread.currentThread().getName() + " обрабатывает " + msg);
        return workingCount.incrementAndGet();
    }
}
