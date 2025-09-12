import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.transport.stdio.StdioMcpTransport;
import dev.langchain4j.service.tool.ToolProvider;

import java.util.List;

public class McpExample {

    interface FileAssistant {
        String chat(String message);
    }

    public static void main(String[] args) {
        // 1. Connect to MCP server (filesystem in this case)
        var mcpClient = new DefaultMcpClient.Builder()
                .clientName("fs-assistant")
                .transport(new StdioMcpTransport.Builder()
                        .command(List.of("npm", "exec", "@modelcontextprotocol/server-filesystem@0.6.2", "playground"))
                        .logEvents(true)
                        .build())
                .build();

        ToolProvider toolProvider = dev.langchain4j.mcp.McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // 2. Set up LLM
        var model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .build();

        // 3. Create AI service with MCP tools
        FileAssistant assistant = AiServices.builder(FileAssistant.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // 4. Chat with filesystem-enabled assistant
        System.out.println(assistant.chat("Read the file playground/hello.txt"));
        System.out.println(assistant.chat("Write 'Hello LangChain4j!' to playground/greeting.txt"));
    }
}
/*
 * Output:
 *     AI: The file playground/hello.txt contains: "Hi there!"
 *     AI: Successfully created greeting.txt with content: "Hello LangChain4j!"
 */