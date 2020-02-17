package producer_consumer;

import helper.ThreadHelper;

public class Producer implements Runnable {

    public static Integer POISION_PILL = Integer.MIN_VALUE;

    public Producer(BlockingRecordHolder<Integer> blockingRecordHolder) {
        this.blockingRecordHolder = blockingRecordHolder;
    }

    BlockingRecordHolder<Integer> blockingRecordHolder;

    @Override
    public void run() {
        int i = 1;
        while (i < 10) {
            blockingRecordHolder.put(i);
            System.out.println("Producing new Data..............");
            ThreadHelper.sleepUnInterrupted();
            System.out.println("New Data Produced.............. " + i);
            i++;
        }
        blockingRecordHolder.put(POISION_PILL);
    }

}
