import java.util.concurrent.Phaser;

public class PhaserTest5 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);

        log(phaser);

        phaser.arrive();

        log(phaser);

        phaser.arriveAndDeregister();

        log(phaser);

        phaser.arrive();

        log(phaser);

        phaser.arriveAndDeregister();

        log(phaser);
    }

    private static void log(Phaser phaser) {
        System.out.println("Current Phase = " + phaser.getPhase());
        System.out.println("Current number of registered parties = " + phaser.getRegisteredParties());
        System.out.println("Current number of arrived parties = " + phaser.getArrivedParties());
        System.out.println("Current number of unarrived parties = " + phaser.getUnarrivedParties());
        System.out.println("Phaser is terminated = " + phaser.isTerminated());
        System.out.println();
    }
}
