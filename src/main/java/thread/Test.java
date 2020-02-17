package thread;

public class Test {


    public static void main(String[] args) {

        Worker w2 = new Worker("2");
        Thread thread1 = new Thread(w2, "first");
        thread1.start();

        Thread thread = new Thread(w2, "second");
        thread.start();


  /*    WorkerT workerT1 = new WorkerT("1");
        WorkerT workerT2 = new WorkerT("2");
       workerT1.start();
        workerT2.start();
*/
        String a = "vikas singh";
        String ne = "";
        int count = 0;
        StringBuilder b = new StringBuilder();
        while (count < a.length()) {
            b.append(a.charAt(count)).append(",");
            ne = ne + a.charAt(count) + ",";
            count++;
        }
        System.out.println(ne);
        System.out.println(b);


    }

    static class WorkerT extends Thread {

        String s;

        public WorkerT(String s) {
            this.s = s;
        }

        @Override
        public void run() {
            while (true) {

                method();
            }
        }

        synchronized private void method() {
            System.out.println("This is first Thread :" + s);
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException ei) {

            }
        }
    }

    static class Worker implements Runnable {

        String s;

        public Worker(String s) {
            this.s = s;
        }

        @Override
        synchronized public void run() {
            int count = 0;
            while (count < 2) {

                count++;

                System.out.println("This is first Thread :" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException ei) {

                }
            }
        }
    }
}
