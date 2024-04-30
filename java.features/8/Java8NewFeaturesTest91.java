import java.util.Optional;

public class Java8NewFeaturesTest91 {
    public static void main(String[] args) {
        Optional<Computer> computer = Optional.ofNullable(new Computer(new MotherBoard(new Memory(64))));

        Integer capacity = computer.flatMap(Computer::getMotherBoard).flatMap(MotherBoard::getMemory)
                .map(Memory::getCapacity).orElse(0);

        System.out.println(capacity);
    }

    private static class Computer {
        private Optional<MotherBoard> motherBoard;

        public Computer(MotherBoard motherBoard) {
            this.motherBoard = Optional.ofNullable(motherBoard);
        }

        public Optional<MotherBoard> getMotherBoard() {
            return motherBoard;
        }
    }

    private static class MotherBoard {
        private Optional<Memory> memory;

        public MotherBoard(Memory memory) {
            this.memory = Optional.ofNullable(memory);
        }

        public Optional<Memory> getMemory() {
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
