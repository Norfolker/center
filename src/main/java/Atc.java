public class Atc extends Thread {

    private Call call;
    protected static final int TIME = 2;
    protected static final int CALLS_IN_SECOND = 60;
    private static final int CREATE_CALLS_TIME = 1000;

    public Atc(String name, Call call) {
        super(name);
        this.call = call;
    }

    @Override
    public void run() {
        for (int i = 0; i < TIME; i++) {
            try {
                Thread.sleep(CREATE_CALLS_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < CALLS_IN_SECOND; j++) {
                call.create();
            }
        }
    }
}