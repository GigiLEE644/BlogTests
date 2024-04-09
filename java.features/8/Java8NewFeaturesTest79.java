public class Java8NewFeaturesTest79 {
    public static void main(String[] args) {
        Car car = new Car(new FuelSystem(new FuelTank(20)));

        System.out.println(car.getFuel().getTank().getCapacity());

        System.out.println();

        int capacity = 0;

        if (car != null) {
            FuelSystem fuel = car.getFuel();

            if (fuel != null) {
                FuelTank tank = fuel.getTank();

                if (tank != null) {
                    capacity = tank.getCapacity();
                }
            }
        }

        System.out.println(capacity);
    }

    private static class Car {
        private FuelSystem fuel;

        public Car(FuelSystem fuel) {
            this.fuel = fuel;
        }

        public FuelSystem getFuel() {
            return fuel;
        }
    }

    private static class FuelSystem {
        private FuelTank tank;

        public FuelSystem(FuelTank tank) {
            this.tank = tank;
        }

        public FuelTank getTank() {
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
