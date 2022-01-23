public class InitializationTest2 {
    static {
        A = 1;
        // accesse of A is not allowed here
        // bcz it is defined after this static block
        // comment below will solve it
        // System.out.println(A);
    }

    // in case of keeping line 9
    // put below in front of static block
    // will solve it as well
    private static int A;
}
