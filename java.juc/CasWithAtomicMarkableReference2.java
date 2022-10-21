import java.util.concurrent.TimeUnit;

public class CasWithAtomicMarkableReference2 {
    public static void main(String[] args) throws InterruptedException {
        Document doc = new Document("hello");

        new Thread(doc::delete).start();

        sleep(1);

        if (!doc.deleted && doc.content == null) {
            System.err.println("This situation should never happened!");
        }

        if (doc.deleted && doc.content == null) {
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
        private boolean deleted = false;
        private String content;

        Document(String content) {
            this.content = content;
        }

        void delete() {
            this.content = null;
            sleep(2);
            this.deleted = true;
        }
    }
}
