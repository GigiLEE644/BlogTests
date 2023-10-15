public class ExceptionTest13 {
    public static void main(String[] args) {
        try {
            System.out.println(Integer.parseInt("123 "));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
