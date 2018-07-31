package latches;

public class MainFrameFetcher implements Processor {

    @Override
    public void process() {
        System.out.println("Started MainFrame Data Fetcher");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done MainFrame Data Fetcher");

    }

    @Override
    public Object getProcessedData() {
        return "MainFrame";
    }
}
