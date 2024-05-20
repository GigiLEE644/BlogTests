import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Java8NewFeaturesTest103 {
    @Repeatable(Roles.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Role {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Roles {
        Role[] value();
    }

    @Role("admin")
    @Role("user")
    private static class Administrator {
    }

    public static void main(String[] args) {
        Roles roles = Administrator.class.getAnnotation(Roles.class);

        for (Role role : roles.value()) {
            System.out.println(role.value());
        }
    }
}