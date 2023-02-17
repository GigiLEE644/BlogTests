import java.util.concurrent.Phaser;

public class PhaserTest8 {
    public static void main(String args[]) throws Exception {
        Phaser phaserParent = new Phaser(2);
        Phaser childPhaser1 = new Phaser(phaserParent, 1);
        Phaser childPhaser2 = new Phaser(phaserParent, 2);

        System.out.println("Registered party count for parentPhaser " + phaserParent.getRegisteredParties());
        System.out.println();

        phaserParent.arrive();
        log(phaserParent);

        phaserParent.arrive();
        log(phaserParent);

        childPhaser1.arrive();
        log(phaserParent);

        childPhaser2.arrive();
        log(phaserParent);

        childPhaser2.arrive();
        log(phaserParent);
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