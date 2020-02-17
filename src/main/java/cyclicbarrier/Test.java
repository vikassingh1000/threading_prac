package cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Test {

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        createWorkerAndStart(cyclicBarrier);
        createWorkerAndStart(cyclicBarrier);
        Thread t = createWorkerAndStart(cyclicBarrier);
        t.join();

        Thread.sleep(4000);

        //
        System.out.println("Try to reuse it");
        createWorkerAndStart(cyclicBarrier);
        createWorkerAndStart(cyclicBarrier);
        createWorkerAndStart(cyclicBarrier);
    }

    private static Thread createWorkerAndStart(CyclicBarrier cyclicBarrier) {
        Worker w = new Worker(cyclicBarrier);
        Thread t = new Thread(w);
        t.start();
        return t;
    }
}
