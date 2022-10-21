import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class CasWithAtomicMarkableReference3 {
    public static void main(String[] args) throws InterruptedException {
        Document doc = new Document("hello");

        new Thread(doc::delete).start();

        sleep(1);

        if (!doc.isDeleted() && doc.read() == null) {
            System.err.println("This situation should never happened!");
        }

        if (doc.isDeleted() && doc.read() == null) {
            System.out.println("Document has been deleted");
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Document {
        private AtomicMarkableReference<String> content = new AtomicMarkableReference<>(null, false);

        Document(String content) {
            this.content.set(content, false);
        }

        void delete() {
            while (true) {
                String expectedReference = this.content.getReference();
                String newReference = null;
                boolean expectedMark = this.content.isMarked();
                boolean newMark = true;

                if (this.content.compareAndSet(expectedReference, newReference, expectedMark, newMark)) {
                    return;
                }
            }
        }

        boolean isDeleted() {
            return this.content.isMarked();
        }

        String read() {
            return this.content.getReference();
        }
    }
}
