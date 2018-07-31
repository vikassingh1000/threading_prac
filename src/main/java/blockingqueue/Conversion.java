package blockingqueue;

import java.util.concurrent.*;

class Conversion implements Runnable {
    BlockingQueue<String> downloadedFileLocations;

    public Conversion(BlockingQueue<String> downloadedFileLocations) {
        this.downloadedFileLocations = downloadedFileLocations;
    }

    @Override
    public void run() {
        String location = null;
        int randomNum = ThreadLocalRandom.current().nextInt(2000, 6000);
        try {
            while (true) {
                location = downloadedFileLocations.poll(5, TimeUnit.HOURS);
                if (Downloader.POISION_PILL.equals(location)) {
                    downloadedFileLocations.offer(Downloader.POISION_PILL);
                    System.out.println("All Conversion is done shutting down");
                    break;
                }
                System.out.println("Starting Conversion For location :" + location + " with estimated time: " + randomNum / 1000);
                Thread.sleep(randomNum);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}