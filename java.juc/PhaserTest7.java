import java.util.concurrent.Phaser;

public class PhaserTest7 {
    static class MyPhaser extends Phaser {
        public MyPhaser(int registeredParties) {
            super(registeredParties);
        }

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            System.out.println("Advancing from phase "
                    + phase + " to next phase with registeredParties = " + registeredParties);
            System.out.println();
            return super.onAdvance(phase, registeredParties);
        }
    }

    public static void main(String[] args) {
        Phaser phaser = new MyPhaser(2);

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
