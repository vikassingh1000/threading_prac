package join;

public class Test {

    public static void main(String[] args) {
        /** This not good appaoch
         1- AS All classes creates Thread as instance variable
         this can not be used in ThreadPool
         This example show join*

         https://stackoverflow.com/questions/12254704/what-is-the-difference-between-join-and-countdownlatch
         Countdonw is better than join as it does not bind number of thread to wait and thier reference
         it abstract them and usage only Countdown object
         Join will force to wait till required Thread is completed while Countdown  a thread can decrease
         the count anytime either on completion of thread or in between based on any condition.
         */

        DatabaseReader tb1Reader = new DatabaseReader("table1.txt");
        DatabaseReader tb2Reader = new DatabaseReader("table2.txt");
        FileReader fileReader = new FileReader(tb1Reader, tb2Reader);
        tb1Reader.startReadDB();
        tb2Reader.startReadDB();
        fileReader.startReadingFile();
    }
}
