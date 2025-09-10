import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.chain.ConversationalChain;

public class LowLevelExample {
    public static void main(String[] args) {
        // 1. Create a model
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .build();

        // 2. Add memory (stores conversation history)
        MessageWindowChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);

        // 3. Build a conversational chain
        ConversationalChain chain = ConversationalChain.builder()
                .chatLanguageModel(model)
                .chatMemory(memory)
                .build();

        // 4. Ask a question
        String answer = chain.execute("Who won the FIFA World Cup in 2022?");
        System.out.println("AI: " + answer);
    }
}
/*
 * Output:
 *     AI: Argentina won the FIFA World Cup in 2022.
 */