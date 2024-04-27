import java.util.Optional;

public class Java8NewFeaturesTest90 {
    public static void main(String[] args) {
        traditionalWay();

        System.out.println();

        optionalWay();
    }

    private static void optionalWay() {
        Optional<Computer> computer = Optional.ofNullable(new Computer(new Memory(64)));

        computer.map(Computer::getMemory).ifPresent(memory -> System.out.println(memory.getCapacity()));
    }

    private static void traditionalWay() {
        Computer computer = new Computer(new Memory(64));

        if (computer != null) {
            Memory memory = computer.getMemory();

            if (memory != null) {
                System.out.println(memory.getCapacity());
            }
        }
    }

    private static class Computer {
        private Memory memory;

        public Computer(Java8NewFeaturesTest90.Memory memory) {
            this.memory = memory;
        }

        public Memory getMemory() {
            return memory;
        }
    }

    private static class Memory {
        private int capacity;

        public Memory(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }
}
