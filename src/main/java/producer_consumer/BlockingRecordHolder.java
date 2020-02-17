package producer_consumer;

import java.util.concurrent.Executors;

public class BlockingRecordHolder<E> {

    E record;
    boolean isNewContent;

    synchronized E get() {
        while (!isNewContent) {
            try {
                super.wait();
            } catch (InterruptedException ie) {

            }
        }
        isNewContent = false;
        notifyAll();
        return record;
    }


    synchronized void put(E e) {
        while (isNewContent) {
            try {
                super.wait();
            } catch (InterruptedException ie) {

            }
        }
        record = e;
        isNewContent = true;
        notifyAll();
    }

    // https://stackoverflow.com/questions/1038007/why-should-wait-always-be-called-inside-a-loop#
    private void waitUnInterrupted(boolean condition) {
        while (condition && isNewContent) {
            try {
                super.wait();
            } catch (InterruptedException ie) {

            }
        }
    }
}
