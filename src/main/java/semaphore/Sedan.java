package semaphore;

public class Sedan implements Car {


    String number;


    public Sedan(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public CarType getCarType() {
        return CarType.SEDAN;
    }

    @Override
    public void start() {
        System.out.println(" Started Sedan.....");
    }

    @Override
    public void run() {
        System.out.println("Running Sedan.....");
    }

    @Override
    public void stop() {
        System.out.println("Stopped Sedan.....");
    }
}
