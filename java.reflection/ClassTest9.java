import java.lang.reflect.Method;

public class ClassTest9 {
    public static void main(String[] args) {
        Person p = new Person("tom", 18);

        System.out.println(p);
        System.out.println();

        Class<?> clazz = p.getClass();

        Method[] methods = clazz.getMethods();

        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];

            System.out.println("method " + i + " = " + method.getName());
        }

        System.out.println();

        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];

            System.out.println("declared method " + i + " = " + method.getName());
        }
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        protected void greet() {
            speak("hi, i am " + this.name);
        }

        private void speak(String words) {
            System.out.println(words);
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
}
