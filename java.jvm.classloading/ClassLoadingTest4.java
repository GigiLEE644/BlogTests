public class ClassLoadingTest4 {
    public static void main(String[] args) throws ClassNotFoundException {
        // boot strap class loader
        System.out.println(String.class.getClassLoader());

        // application class loader (system class loader)
        System.out.println(ClassLoadingTest4.class.getClassLoader());

        // array's class loader depends on its type
        String[] stringArr = new String[2];

        // String is loaded by boot strap class loader
        // so string array has boot strap class loader
        System.out.println(stringArr.getClass().getClassLoader());

        ClassLoadingTest4[] myArr = new ClassLoadingTest4[2];

        // Class created by developer is loaded by application class loader
        // so here it is application class loader (system class loader)
        System.out.println(myArr.getClass().getClassLoader());

        // primitive array does not have any class loader
        int[] intArr = new int[2];

        // here null does not stand for boot strap class loader
        // it means no class loader
        System.out.println(intArr.getClass().getClassLoader());
    }
}
