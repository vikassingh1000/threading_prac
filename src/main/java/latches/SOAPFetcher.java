package latches;

public class SOAPFetcher implements Processor {

    @Override
    public void process() {
        System.out.println("Started SOAP Data Fetcher");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done SOAP Data Fetcher");
    }

    @Override
    public Object getProcessedData() {
        return "SOAP";
    }
}
