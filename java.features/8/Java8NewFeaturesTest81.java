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
        return car.getFuel().map(
                            fuel -> fuel.getTank().map(
                                tank -> tank.getCapacity()
                            )
                            .orElseGet(() -> 0)
                        )
                        .orElseGet(() -> 0);
    }

    private static class Car {
        private Optional<FuelSystem> fuel;

        public Car(FuelSystem fuel) {
            this.fuel = Optional.ofNullable(fuel);
        }

        public Optional<FuelSystem> getFuel() {
            return fuel;
        }
    }

    private static class FuelSystem {
        private Optional<FuelTank> tank;

        public FuelSystem(FuelTank tank) {
            this.tank = Optional.ofNullable(tank);
        }

        public Optional<FuelTank> getTank() {
            return tank;
        }
    }

    private static class FuelTank {
        private int capacity;

        public FuelTank(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }
}
