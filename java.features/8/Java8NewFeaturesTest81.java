import java.util.Optional;

public class Java8NewFeaturesTest81 {
    public static void main(String[] args) {
        Car car = new Car(new FuelSystem(new FuelTank(20)));

        int capacity = getCapacity(car);

        System.out.println(capacity);
        System.out.println();

        Car car2 = new Car(new FuelSystem(null));

        capacity = getCapacity(car2);

        System.out.println(capacity);
        System.out.println();

        Car car3 = new Car(null);

        capacity = getCapacity(car3);

        System.out.println(capacity);

    }

    private static int getCapacity(Car car) {
        return Optional.ofNullable(car)
                .map(Car::getFuel)
                .map(FuelSystem::getTank)
                .map(FuelTank::getCapacity)
                .orElseGet(() -> 0);
    }

    private static class Car {
        private FuelSystem fuel;

        public Car(FuelSystem fuel) {
            this.fuel = fuel;
        }

        public FuelSystem getFuel() {
            return this.fuel;
        }
    }

    private static class FuelSystem {
        private FuelTank tank;

        public FuelSystem(FuelTank tank) {
            this.tank = tank;
        }

        public FuelTank getTank() {
            return this.tank;
        }
    }

    private static class FuelTank {
        private int capacity;

        public FuelTank(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return this.capacity;
        }
    }
}
/**
 * Output:
    20

    0

    0
 */