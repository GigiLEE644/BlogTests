import java.util.Optional;

public class Java8NewFeaturesTest91 {
    public static void main(String[] args) {
        Optional<Computer> computer = Optional.ofNullable(new Computer(new MotherBoard(new Memory(64))));

        Integer capacity = computer.flatMap(Computer::getMotherBoard).flatMap(MotherBoard::getMemory)
                .map(Memory::getCapacity).orElse(0);

        System.out.println(capacity);
    }

    private static class Computer {
        private MotherBoard motherBoard;

        public Computer(MotherBoard motherBoard) {
            this.motherBoard = motherBoard;
        }

        public Optional<MotherBoard> getMotherBoard() {
            return Optional.ofNullable(this.motherBoard);
        }
    }

    private static class MotherBoard {
        private Memory memory;

        public MotherBoard(Memory memory) {
            this.memory = memory;
        }

        public Optional<Memory> getMemory() {
            return Optional.ofNullable(this.memory);
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
/**
 * Output:
 * 64
 */