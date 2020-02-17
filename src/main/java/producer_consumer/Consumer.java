package producer_consumer;

public class Consumer implements Runnable {

    BlockingRecordHolder<Integer> blockingRecordHolder;

    public Consumer(BlockingRecordHolder<Integer> blockingRecordHolder) {
        this.blockingRecordHolder = blockingRecordHolder;
    }

    @Override
    public void run() {
        int newData = 0;
        while (true) {
            System.out.println("Waiting for new Data..............");
            newData = blockingRecordHolder.get();
            if (isPoisonPill(newData)) {
                System.out.println("Data Production ends... ");
                break;
            }
            System.out.println("New Data found: " + newData);
        }
    }

    private boolean isPoisonPill(int newData) {
        return Producer.POISION_PILL == newData;
    }
}
