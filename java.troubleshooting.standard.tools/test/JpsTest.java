// package test;

import java.util.Scanner;

public class JpsTest {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter something: ");
            String input = scanner.nextLine();
            System.out.println("You entered: " + input);
        }
    }
}
/*
jps // list all java processes and their main classes
    20461 JpsTest

jps -l // list all java processes with package names + class names
    20461 test.JpsTest

jps -v // list jvm parameters
    20461 JpsTest -Xms128m -Xmx128m

jps -q // list only the process IDs
    20461

jps -m // list parameters of main method
    20461 JpsTest ovo
*/