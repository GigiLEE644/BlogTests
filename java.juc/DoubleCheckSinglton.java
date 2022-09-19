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
        DoubleCheckSinglton.getInstance();
    }
}
