package blockingqueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

class Downloader implements Runnable {

    public static final String POISION_PILL="POISION_PILL";

    BlockingQueue<String> downloadedFileLocations;
    ConcurrentLinkedQueue<String> fileLocationsForDownloading;

    public Downloader(BlockingQueue<String> downloadedFileLocations, ConcurrentLinkedQueue<String> fileLocationsForDownloading) {
        this.downloadedFileLocations = downloadedFileLocations;
        this.fileLocationsForDownloading = fileLocationsForDownloading;
    }

    public void run() {
        try {
            int randomNum = ThreadLocalRandom.current().nextInt(2000, 6000);
            String location = null;
            while ((location = fileLocationsForDownloading.poll()) != null) {
                System.out.println("Starting Downloading with :" + location + " with estimated time: " + randomNum / 1000);
                Thread.sleep(randomNum);
                downloadedFileLocations.put( location);
            }
            System.out.println("All Downloader is done shutting down");
            fileLocationsForDownloading.offer(POISION_PILL);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}