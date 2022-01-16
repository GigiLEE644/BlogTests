import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

public class MethodHandlesTest {
    public static void main(String[] args) throws Throwable {
        Country country = new Country("China");

        Lookup lookup = MethodHandles.lookup();

        MethodHandle setPopulation = lookup.findSetter(Country.class, "population", int.class);

        setPopulation.invoke(country, 1447872405);

        MethodHandle getPopulation = lookup.findGetter(Country.class, "population", int.class);

        int population = (int) getPopulation.invoke(country);

        String name = (String) lookup.findVarHandle(Country.class, "name", String.class).get(country);

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
