package latches;

import sun.plugin.viewer.context.IExplorerAppletContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Processor restProcessor = new RestFetcher();
        startWorker(countDownLatch, restProcessor);

        Processor soapProcessor = new SOAPFetcher();
        startWorker(countDownLatch, soapProcessor);

        Processor mainProcessor = new MainFrameFetcher();
        startWorker(countDownLatch, mainProcessor);

        List<Object> fetchedData = new ArrayList<>();

        try {
            System.out.println("Waiting for all processes...");
            countDownLatch.await(Long.MAX_VALUE, TimeUnit.DAYS);

            fetchedData.add(restProcessor.getProcessedData());
            fetchedData.add(soapProcessor.getProcessedData());
            fetchedData.add(mainProcessor.getProcessedData());
            fetchedData.forEach(System.out::println);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }


    }

    private static void startWorker(CountDownLatch countDownLatch, Processor restProcessor) {
        Worker w1 = new Worker(restProcessor, countDownLatch);
        Thread thread = new Thread(w1);
        thread.start();
    }
}
