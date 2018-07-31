package latches;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    Processor processor;
    CountDownLatch countDownLatch;

    public Worker(Processor processor, CountDownLatch countDownLatch) {
        this.processor = processor;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        processor.process();
        countDownLatch.countDown();
    }
}
