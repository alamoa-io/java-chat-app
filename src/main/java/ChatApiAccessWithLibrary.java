import HttpAccess.RequestBase;
import POJO.ChatCompletion;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChatApiAccessWithLibrary {

    HttpClient client = HttpClient.newHttpClient();
    RequestBase requestBase = new RequestBase();

    protected String getResponse(String userInput){
        StringBuilder sb = new StringBuilder();
        try {
            HttpRequest request = requestBase.makeChatRequest(userInput);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            ObjectMapper mapper = new ObjectMapper();
            ChatCompletion chatCompletion = mapper.readValue(response.body(), ChatCompletion.class);
            chatCompletion.getChoices().forEach(choice -> sb.append(choice.getMessage().getContent()));
            System.out.println(sb.toString());

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            return "エラーが発生しました";
        }
        return sb.toString();
    }
}
