public class Spec extends Thread {

    private Call call;
    private final int CALLS_SUM;
    private final int WAITTIME = 100;
    private final int PROCESS_TIME = 1500;

    public Spec(String name, Call call) {
        super(name);
        this.call = call;
        CALLS_SUM = Atc.TIME * Atc.CALLS_IN_SECOND;
    }

    @Override
    public void run() {
        if (Call.calls.isEmpty()) {
            try {
                Thread.sleep(WAITTIME);
            } catch (InterruptedException e) {
                System.out.println("Нет звонков для обработки");
            }
        }
        while (true) {
            if (!(call.getCall() < CALLS_SUM)) break;
            try {
                Thread.sleep(PROCESS_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}