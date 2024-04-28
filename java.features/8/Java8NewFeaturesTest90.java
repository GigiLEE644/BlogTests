import java.util.Optional;

public class Java8NewFeaturesTest90 {
    public static void main(String[] args) {
        traditionalWay();

        System.out.println();

        optionalWay();
    }

    private static void optionalWay() {
        Optional<Computer> computer = Optional.ofNullable(new Computer(new MotherBoard(new Memory(64))));

        Integer capacity = computer.map(Computer::getMotherBoard).map(MotherBoard::getMemory).map(Memory::getCapacity)
                .orElse(0);

        System.out.println(capacity);
    }

    private static void traditionalWay() {
        int capacity = 0;

        Computer computer = new Computer(new MotherBoard(new Memory(64)));

        if (computer != null) {
            MotherBoard motherBoard = computer.getMotherBoard();

            if (motherBoard != null) {
                Memory memory = motherBoard.getMemory();

                if (memory != null) {
                    capacity = memory.getCapacity();
                }
            }
        }

        System.out.println(capacity);
    }

    private static class Computer {
        private MotherBoard motherBoard;

        public Computer(MotherBoard motherBoard) {
            this.motherBoard = motherBoard;
        }

        public MotherBoard getMotherBoard() {
            return motherBoard;
        }
    }

    private static class MotherBoard {
        private Memory memory;

        public MotherBoard(Memory memory) {
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
