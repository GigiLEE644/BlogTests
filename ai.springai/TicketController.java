import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final OpenAiChatClient chatClient;

    public TicketController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping
    public SupportTicket extractTicket(@RequestBody String issueDescription) {
        PromptTemplate template = new PromptTemplate(
                "Analyze the support request: {text}. " +
                        "Extract fields: category, priority (low, medium, high), summary.");

        BeanOutputParser<SupportTicket> parser = new BeanOutputParser<>(SupportTicket.class);

        String format = parser.getFormat();

        ChatResponse response = chatClient.call(
                template.createMessage(Map.of("text", issueDescription), format));

        return parser.parse(response.getResult().getOutput().getContent());
    }

    private static class SupportTicket {
        private String category;
        private String priority;
        private String summary;
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public String getPriority() {
            return priority;
        }
        public void setPriority(String priority) {
            this.priority = priority;
        }
        public String getSummary() {
            return summary;
        }
        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}