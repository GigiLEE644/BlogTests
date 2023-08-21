import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest14 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Employee p1 = new Employee("tom");

        System.out.println(p1);

        Employee p2 = new Employee("jerry");

        System.out.println(p2);

        Class<?> clazz = Employee.class;

        Method method = clazz.getMethod("increment", int.class);

        method.invoke(null, 2);

        System.out.println("Total number of employees = " + Employee.numberOfEmployees);
    }

    private static class Employee {
        private static int numberOfEmployees;

        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public static void increment(int value) {
            numberOfEmployees += value;
        }

        @Override
        public String toString() {
            return "Employee [name=" + name + "]";
        }
    }
}
