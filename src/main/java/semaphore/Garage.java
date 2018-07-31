package semaphore;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Garage {

    Queue<Car> cars;
    Semaphore availableCar;

    public Garage(Queue<Car> cars) {
        this.cars = cars;
        this.availableCar = new Semaphore(cars.size());
    }

    public Car carAvailable() {
        try {
            availableCar.acquire();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return cars.poll();
    }

    public void carParked(Car car) {
        cars.add(car);
        availableCar.release();
        System.out.println(car.getNumber() + " Parked...");
    }
}
