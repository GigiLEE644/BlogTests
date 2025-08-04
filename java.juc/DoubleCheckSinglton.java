public class DoubleCheckSinglton {
    private static volatile DoubleCheckSinglton instance;

    public static DoubleCheckSinglton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSinglton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSinglton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckSinglton i1 = DoubleCheckSinglton.getInstance();
        DoubleCheckSinglton i2 = DoubleCheckSinglton.getInstance();

        System.out.println("i1 == i2 : " + (i1 == i2));

    }
}
