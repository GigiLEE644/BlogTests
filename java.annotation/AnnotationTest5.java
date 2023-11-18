public class AnnotationTest5 {

    @interface MyAnnotation {
        String value();
    }

    @MyAnnotation("i am a custom annotation")
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
