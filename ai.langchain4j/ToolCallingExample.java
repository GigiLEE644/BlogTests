import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiService;
import dev.langchain4j.service.tool.Tool;

public class ToolCallingExample {

    interface Assistant {

        @Tool("Calculates the sum of two numbers")
        int addNumbers(int a, int b);

        String chat(String message);
    }

    public static void main(String[] args) {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .build();

        Assistant assistant = AiService.create(Assistant.class, model);

        System.out.println(assistant.chat("What is 42 + 58?"));
    }
}
/*
 * Output:
 *      The sum of 42 and 58 is 100.
 */