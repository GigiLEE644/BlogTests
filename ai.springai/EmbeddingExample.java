import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.openai.OpenAiEmbeddingClient;

import java.util.List;

public class EmbeddingExample {

    private final EmbeddingClient embeddingClient;

    public EmbeddingExample(OpenAiEmbeddingClient embeddingClient) {
        this.embeddingClient = embeddingClient;
    }

    public List<Double> createEmbedding(String text) {
        return embeddingClient.embed(text).getResult().getEmbedding();
    }
}