package semaphore;

public class HatchBack implements Car {

    String number;


    @Override
    public String getNumber() {
        return number;
    }

    public HatchBack(String number) {
        this.number = number;
    }

    @Override
    public CarType getCarType() {
        return CarType.HATCH_BACK;
    }

    @Override
    public void start() {
        System.out.println(" Started HatchBack .....");
    }

    @Override
    public void run() {
        System.out.println("Running HatchBack....." + number);
    }

    @Override
    public void stop() {
        System.out.println("Stopped HatchBack.....");
    }
}
