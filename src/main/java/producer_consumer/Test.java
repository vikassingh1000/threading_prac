package producer_consumer;

public class Test {

    public static void main(String[] args) {


        BlockingRecordHolder<Integer> blockingRecordHolder = new BlockingRecordHolder();

        Consumer consumer = new Consumer(blockingRecordHolder);
        Thread consThread = new Thread(consumer);
        consThread.start();

        Producer producer = new Producer(blockingRecordHolder);
        Thread prodThread = new Thread(producer);
        prodThread.start();
    }
}
