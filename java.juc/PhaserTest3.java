import java.util.concurrent.Phaser;

public class PhaserTest3 {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1);

        log(phaser);

        phaser.register();

        log(phaser);

        phaser.arrive();

        log(phaser);

        phaser.arrive();

        log(phaser);
    }

    private static void log(Phaser phaser) {
        System.out.println("Current Phase = " + phaser.getPhase());
        System.out.println("Current number of registered parties = " + phaser.getRegisteredParties());
        System.out.println("Current number of arrived parties = " + phaser.getArrivedParties());
        System.out.println("Current number of unarrived parties = " + phaser.getUnarrivedParties());
        System.out.println();
    }
}
