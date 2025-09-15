import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final OpenAiChatClient chatClient;

    public HelloWorldController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ask-ai")
    public String askAi(@RequestParam String prompt) {
        // Send the user's prompt directly to the AI model
        return chatClient.call(prompt);
    }
}