import dev.langchain4j.service.*;

public class HighLevelExample {

    interface Assistant {
        @SystemMessage("You are a helpful assistant.")
        String chat(@UserMessage String message);
    }

    public static void main(String[] args) {
        // Build the service (LangChain4j generates the implementation)
        Assistant assistant = AiServices.create(Assistant.class,
                OpenAiChatModel.withApiKey(System.getenv("OPENAI_API_KEY")));

        // Ask a question
        String response = assistant.chat("Who won the FIFA World Cup in 2022?");
        System.out.println("AI: " + response);
    }
}
/*
 * Output:
 *     AI: Argentina won the FIFA World Cup in 2022.
 */