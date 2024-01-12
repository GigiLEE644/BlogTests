import java.util.ArrayList;
import java.util.List;

public class Java8NewFeaturesTest9 {
    public static void main(String[] args) {
        List<String> words1 = new ArrayList<String>();
        words1.add("hello");

        List<String> words2 = new ArrayList<String>();
        words2.add("world");

        Message message1 = new Message(words1);

        Message message2 = new Message(words2);

        Merger m = Message::merge;

        m.merge(message1, message2);

        message1.read();
    }

    @FunctionalInterface
    private interface Merger {
        void merge(Message m1, Message m2);
    }

    private static class Message {
        private List<String> words;

        public Message(List<String> words) {
            this.words = words;
        }

        void merge(Message m) {
            this.words.addAll(m.words);
        }

        void read() {
            for (String word : words) {
                System.out.print(word);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
