import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.rag.content.Document;
import dev.langchain4j.rag.content.ContentRetriever;
import dev.langchain4j.rag.vectorstore.InMemoryEmbeddingStore;
import dev.langchain4j.rag.vectorstore.VectorStoreRetriever;
import dev.langchain4j.service.*;

import java.util.List;

public class HighLevelRagExample {

    // Define your assistant interface
    interface ResearchAssistant {
        @SystemMessage("You are a research assistant. Use retrieved documents to answer.")
        String ask(@UserMessage String question);
    }

    public static void main(String[] args) {
        // 1. Create the embedding store (vector DB)
        InMemoryEmbeddingStore<Document> embeddingStore = new InMemoryEmbeddingStore<>();

        // (Normally you'd load docs from PDFs, DBs, etc.)
        embeddingStore.add("The capital of France is Paris.");
        embeddingStore.add("The Eiffel Tower is one of the most famous landmarks in Paris.");
        embeddingStore.add("France won the FIFA World Cup in 2018.");

        // 2. Wrap it in a retriever
        ContentRetriever retriever = new VectorStoreRetriever<>(embeddingStore);

        // 3. Build the assistant service with RAG enabled
        ResearchAssistant assistant = AiServices.builder(ResearchAssistant.class)
                .chatLanguageModel(OpenAiChatModel.withApiKey(System.getenv("OPENAI_API_KEY")))
                .contentRetriever(retriever)   // enables RAG automatically
                .build();

        // 4. Ask a question (the model will pull context from docs)
        String answer = assistant.ask("What is the capital of France and a famous landmark there?");
        System.out.println("AI: " + answer);
    }
}
/*
 * Output:
 *     AI: The capital of France is Paris, and a famous landmark there is the Eiffel Tower.
 */