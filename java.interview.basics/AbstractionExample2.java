public class AbstractionExample2 {
    private static interface Vehicle {
        void start();

        void stop();
    }

    private static class Car implements Vehicle {
        @Override
        public void start() {
            System.out.println("Car started");
        }

        @Override
        public void stop() {
            System.out.println("Car stopped");
        }
    }

    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start(); // Car started
        myCar.stop(); // Car stopped
    }
}
/*
 * Output :
 * 
 * Car started
 * Car stopped
 */
