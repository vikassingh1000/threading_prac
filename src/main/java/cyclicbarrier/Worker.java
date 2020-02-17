package cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Worker implements Runnable {

    CyclicBarrier cyclicBarrier;

    public Worker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {

            int randomNum = ThreadLocalRandom.current().nextInt(2000, 6000);
            System.out.println("At First setup...., it will take " + randomNum / 1000);
            Thread.sleep(randomNum);
            int arrival = cyclicBarrier.await();

            randomNum = ThreadLocalRandom.current().nextInt(2000, 6000);
            System.out.println("At Second setup...., it will take " + randomNum / 1000);
            Thread.sleep(randomNum);
            cyclicBarrier.await();
        } catch (Exception ie) {

        }
    }
}
