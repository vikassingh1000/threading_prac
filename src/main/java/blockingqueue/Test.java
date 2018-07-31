package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

    public static void main(String[] args) {

        ConcurrentLinkedQueue<String> fileLocationsForDownloading = new ConcurrentLinkedQueue<>();
        fileLocationsForDownloading.add("trn_in");
        fileLocationsForDownloading.add("trn_ld");
        fileLocationsForDownloading.add("cpy");
        fileLocationsForDownloading.add("prv");
        fileLocationsForDownloading.add("cld");
        fileLocationsForDownloading.add("psd");
        fileLocationsForDownloading.add("ins");
        fileLocationsForDownloading.add("fds");
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);

        createConsumerAndStart(blockingQueue);

        createConsumerAndStart(blockingQueue);

        createConsumerAndStart(blockingQueue);

        createDownloaderAndStart(fileLocationsForDownloading, blockingQueue);
        createDownloaderAndStart(fileLocationsForDownloading, blockingQueue);

    }

    private static void createDownloaderAndStart(ConcurrentLinkedQueue<String> fileLocationsForDownloading, BlockingQueue<String> blockingQueue) {
        Downloader downloader1 = new Downloader(blockingQueue, fileLocationsForDownloading);
        Thread t = new Thread(downloader1);
        t.start();
    }

    private static void createConsumerAndStart(BlockingQueue<String> blockingQueue) {
        Conversion conversion3 = new Conversion(blockingQueue);
        Thread t3 = new Thread(conversion3);
        t3.start();
    }


}
