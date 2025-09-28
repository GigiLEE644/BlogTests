import org.springframework.ai.vectorstore.ChromaVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.embedding.EmbeddingDocument;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.SearchResults;

import java.util.List;

public class VectorStoreExample {

    private final VectorStore vectorStore;

    public VectorStoreExample(ChromaVectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public void storeDocument(String id, String content) {
        EmbeddingDocument doc = new EmbeddingDocument(id, content);
        vectorStore.add(List.of(doc));
    }

    public List<String> search(String query) {
        SearchResults results = vectorStore.similaritySearch(
                SearchRequest.query(query).withTopK(3) // return top 3 matches
        );

        return results.getMatches().stream()
                .map(r -> r.getDocument().getContent())
                .toList();
    }
}