import java.util.concurrent.Phaser;

public class PhaserTest6 {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
            }
            phaser.arrive();
        }).start();

        System.out.println("main thread about to block on phase " + phaser.getPhase());
        int phase = phaser.awaitAdvance(0);
        System.out.println("main thread past the barrier and next phase is " + phase);
    }
}
