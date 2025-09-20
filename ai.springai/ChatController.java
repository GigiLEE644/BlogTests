import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final OpenAiChatClient chatClient;
    private final ChatMemory chatMemory = new InMemoryChatMemory();

    public ChatController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping
    public String chat(@RequestBody String userMessage) {
        // Store the user’s message in memory
        chatMemory.addUserMessage(userMessage);

        // Generate the AI’s response using memory
        ChatResponse response = chatClient.call(chatMemory.getMessages());

        String responseText = response.getResult().getOutput().getContent();

        // Store the AI’s response in memory
        chatMemory.addAssistantMessage(responseText);

        return responseText;
    }
}