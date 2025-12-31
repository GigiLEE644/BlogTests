import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.List;

/**
 * -Xms256m -Xmx256m
 */
public class ManagementFactoryTest {
    public static void main(String[] args) {
        // Runtime MXBean
        RuntimeMXBean rmb = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = rmb.getInputArguments();
        for (int i = 0; i < arguments.size(); i++) {
            String argument = arguments.get(i);
            System.out.println("jvm argument " + (i + 1) + " = " + argument);
        }

        // Memory MXBean
        MemoryMXBean mmb = ManagementFactory.getMemoryMXBean();
        MemoryUsage hmu = mmb.getHeapMemoryUsage();
        System.out.println("used heap memory = " + hmu.getUsed());
        System.out.println("init heap memory = " + hmu.getInit());
        System.out.println("max heap memory = " + hmu.getMax());

        // Thread MXBean
        ThreadMXBean tmb = ManagementFactory.getThreadMXBean();
        long[] ids = tmb.getAllThreadIds();
        ThreadInfo[] infos = tmb.getThreadInfo(ids, 1);
        for (ThreadInfo info : infos) {
            System.out.println("thread id = " + info.getThreadId() +
                    ", thread name = " + info.getThreadName());
        }
    }
}
/*
Output:
    jvm argument 1 = --enable-preview
    jvm argument 2 = -XX:+ShowCodeDetailsInExceptionMessages
    used heap memory = 0
    init heap memory = 262144000
    max heap memory = 4171235328
    thread id = 3, thread name = main
    thread id = 13, thread name = Reference Handler
    thread id = 14, thread name = Finalizer
    thread id = 15, thread name = Signal Dispatcher
    thread id = 21, thread name = Notification Thread
    thread id = 22, thread name = Common-Cleaner
 */