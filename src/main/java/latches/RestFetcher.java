package latches;

public class RestFetcher implements Processor {

    @Override
    public void process() {
        System.out.println("Started Rest Data Fetcher");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done Rest Data Fetcher");
    }
    @Override
    public Object getProcessedData() {
        return "Rest";
    }
}
