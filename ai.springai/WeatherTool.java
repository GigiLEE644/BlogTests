import org.springframework.ai.tool.annotation.AiFunction;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool {

    @AiFunction
    public String getWeather(String city) {
        // In real life, call an API like OpenWeather here.
        if ("Paris".equalsIgnoreCase(city)) {
            return "It's sunny and 22°C in Paris.";
        }
        return "Weather data not available for " + city;
    }
}
