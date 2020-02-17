package helper;

final public class ThreadHelper {

    private ThreadHelper() {
    }

    public static void sleepUnInterrupted() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {

        }
    }
}
