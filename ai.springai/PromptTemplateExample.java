import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.openai.OpenAiChatClient;
import java.util.Map;

public class PromptTemplateExample {

    private final OpenAiChatClient chatClient;

    public PromptTemplateExample(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String translate(String text, String language) {
        PromptTemplate template = new PromptTemplate("Translate the following sentence into {language}: {text}");

        UserMessage message = template.createMessage(Map.of(
                "language", language,
                "text", text));

        return chatClient.call(message);
    }

    public static void main(String[] args) {
        OpenAiChatClient chatClient = OpenAiChatClient.builder().build();
        PromptTemplateExample example = new PromptTemplateExample(chatClient);

        String result = example.translate("Hello, how are you?", "French");
        System.out.println(result);
    }
}
/*
 * Output:
 * Bonjour, comment ça va?
 */
