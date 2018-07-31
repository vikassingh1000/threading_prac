package semaphore;

import java.util.EnumSet;
import java.util.concurrent.ThreadLocalRandom;

public class Customer implements Runnable {

    EnumSet<CarType> carTypes;
    ShowRoom showRoom;
    private Car car;

    public Customer(EnumSet<CarType> carTypes) {
        this.carTypes = carTypes;
    }

    public EnumSet<CarType> carTypePreference() {
        return carTypes;
    }


    @Override
    public void run() {
        car.start();
        int randomNum = ThreadLocalRandom.current().nextInt(2000, 6000);
        car.run();
        try {
            Thread.sleep(randomNum);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        car.stop();
        showRoom.getGarage().carParked(car);
    }

    public void visitShowRoom(ShowRoom showRoom) {
        showRoom.newCustomerArrived(this);
        this.showRoom = showRoom;
    }

    public void driverAndPark(Car car) {
        this.car = car;
        Thread th = new Thread(this);
        th.start();
    }

}
