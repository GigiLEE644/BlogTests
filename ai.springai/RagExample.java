import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.openai.OpenAiChatClient;

public class RagExample {

    private final OpenAiChatClient chatClient;
    private final VectorStore vectorStore;

    public RagExample(OpenAiChatClient chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient;
        this.vectorStore = vectorStore;
    }

    public String ask(String question) {
        List<String> contextDocs = vectorStore.similaritySearch(
                SearchRequest.query(question).withTopK(3)).getMatches().stream()
                .map(r -> r.getDocument().getContent())
                .toList();

        String augmentedPrompt = """
                Use the following context to answer the question:

                %s

                Question: %s
                """.formatted(String.join("\n", contextDocs), question);

        return chatClient.call(new Prompt(new UserMessage(augmentedPrompt)));
    }
}