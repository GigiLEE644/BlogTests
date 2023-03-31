import java.util.EnumMap;

public class EnumMapTest {
    public static void main(String[] args) {
        enum DayOfWeek {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        EnumMap<DayOfWeek, String> activities = new EnumMap<>(DayOfWeek.class);
        activities.put(DayOfWeek.MONDAY, "working");
        activities.put(DayOfWeek.TUESDAY, "working");
        activities.put(DayOfWeek.WEDNESDAY, "working");
        activities.put(DayOfWeek.THURSDAY, "working");
        activities.put(DayOfWeek.FRIDAY, "working");
        activities.put(DayOfWeek.SATURDAY, "sleeping");
        activities.put(DayOfWeek.SUNDAY, "sleeping");

        for (DayOfWeek day : activities.keySet()) {
            String activity = activities.get(day);

            System.out.println(day + " : " + activity);
        }
    }
}
