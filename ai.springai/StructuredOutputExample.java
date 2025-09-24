import java.util.Map;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.parser.BeanOutputParser;

public class StructuredOutputExample {
    private static class Person {
        private String name;
        private int age;
        private String city;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }
    }

    public static void main(String[] args) {
        BeanOutputParser<Person> parser = new BeanOutputParser<>(Person.class);

        String formattedPrompt = parser.getFormat(); // ensures model outputs correct JSON format

        PromptTemplate template = new PromptTemplate("Extract person info from the text: {input}");

        Map<String, Object> params = Map.of(
                "input", "My name is Alice, I am 30 years old, and I live in Paris.");

        OpenAiChatClient chatClient = OpenAiChatClient.builder().build();

        ChatResponse response = chatClient.call(template.createMessage(params, formattedPrompt));

        Person person = parser.parse(response.getResult().getOutput().getContent());

        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getCity());
    }
}
/*
 * Output:
 *      Alice
 *      30
 *      Paris
 */