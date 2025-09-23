import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

public class VectorExample {
    public static void main(String[] args) {
        float[] a = { 1f, 2f, 3f, 4f };
        float[] b = { 5f, 6f, 7f, 8f };

        FloatVector aa = FloatVector.fromArray(FloatVector.SPECIES_128, a, 0);
        FloatVector bb = FloatVector.fromArray(FloatVector.SPECIES_128, b, 0);
        FloatVector cc = aa.add(bb);

        float[] c = new float[FloatVector.SPECIES_128.length()];

        cc.intoArray(c, 0);

        System.out.println(java.util.Arrays.toString(c));
    }
}
/*
 * Output:
 *     [6.0, 8.0, 10.0, 12.0]
 */