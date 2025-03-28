import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;


public class ChatApiAccess {
    //濫用厳禁(5$しか課金してない)
    final static String apiKey = "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";
    final static String apiUrl = "https://api.openai.com/v1/chat/completions";
    final static String model = "gpt-3.5-turbo";


    public String getResponse(String prompt) {
        try {
            URL obj = new URI(apiUrl).toURL();
            HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return getContent(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
    private String getContent(String jsonResponse) {
        String startPosition = "\"content\": \"";
        String endPosition = "\"      },";
        int startIndex = jsonResponse.indexOf(startPosition) + startPosition.length();
        String cutFormerJson = jsonResponse.substring(startIndex);
        int endIndex = cutFormerJson.indexOf(endPosition);
        return cutFormerJson.substring(0, endIndex);
    }
}


