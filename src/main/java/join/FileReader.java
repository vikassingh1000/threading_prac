package join;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Runnable {

    DatabaseReader table1Reader;
    DatabaseReader table2Reader;

    File tble1File;
    Thread t;
    ;

    public FileReader(DatabaseReader table1Reader, DatabaseReader table2Reader) {
        this.table1Reader = table1Reader;
        this.table2Reader = table2Reader;
        this.t = new Thread(this);
    }

    public void startReadingFile() {
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Waiting for both table to end....");
        waitForBothTable();
        System.out.println("Both Table reading is done...");
        try {
            readFile(table1Reader);
            readFile(table1Reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void readFile(DatabaseReader databaseReader) throws FileNotFoundException {
        Scanner tble1Scaner = new Scanner(databaseReader.getOutputFile());
        tble1Scaner.forEachRemaining(System.out::println);
        tble1Scaner.close();
    }

    private void waitForBothTable() {
        try {
            table1Reader.getThread().join();
            table2Reader.getThread().join();
        } catch (InterruptedException ex) {

        }
    }
}
