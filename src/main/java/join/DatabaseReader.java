package join;

import java.io.File;
import java.io.PrintWriter;

public class DatabaseReader implements Runnable {

    File outputFile;

    Thread t;

    public DatabaseReader(String outputFileLoc) {
        this.outputFile = new File(outputFileLoc);
        t = new Thread(this);
    }

    public void startReadDB() {
        t.start();
    }

    public File getOutputFile() {
        return outputFile;
    }

    Thread getThread() {
        return t;
    }

    @Override
    public void run() {
        System.out.println("Starting reading DB" + outputFile.getName());
        readDBAndWriteIntoFile();
        System.out.printf("Done with Reading.....");
    }

    private void readDBAndWriteIntoFile() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(outputFile);
            int row = 1;
            while (row <= 10) {
                System.out.printf("Reading Row %s \n", row);
                printWriter.printf("This is %s row from table", row, outputFile.getName());
                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }


}
