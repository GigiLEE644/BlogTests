import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Country country = new Country("China");

        Class<? extends ReflectionTest.Country> clazz = country.getClass();

        Method setPopulation = clazz.getMethod("setPopulation", int.class);

        setPopulation.invoke(country, 1447872405);

        Method getPopulation = clazz.getMethod("getPopulation");

        int population = (int) getPopulation.invoke(country);

        String name = (String) clazz.getField("name").get(country);

        System.out.println(name + "'s population is " + population);
    }

    private static class Country {
        public String name;
        private int population;

        public Country(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Country [name=" + name + ", population=" + population + "]";
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }
    }
}
