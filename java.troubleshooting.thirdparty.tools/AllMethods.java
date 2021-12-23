import static org.openjdk.btrace.core.BTraceUtils.print;

import org.openjdk.btrace.core.BTraceUtils.Strings;
import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.OnMethod;
import org.openjdk.btrace.core.annotations.ProbeClassName;
import org.openjdk.btrace.core.annotations.ProbeMethodName;

@BTrace
public class AllMethods {
    @OnMethod(clazz = "/RandomTest*/", method = "/.*/")
    public static void m(@ProbeClassName String probeClass,
            @ProbeMethodName String probeMethod) {
        print(Strings.strcat(probeClass, Strings.strcat(".", probeMethod)));
    }
}