public class PolymorphismExample2 {
    private static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public double add(double a, double b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Using the int version
        int intResult = calc.add(5, 10);
        System.out.println("Integer addition: " + intResult); // Output: Integer addition: 15

        // Using the double version
        double doubleResult = calc.add(5.5, 10.2);
        System.out.println("Double addition: " + doubleResult); // Output: Double addition: 15.7
    }
}

/*
 * Output :
 * 
 * Integer addition: 15
 * Double addition: 15.7
 */