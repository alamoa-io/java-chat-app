import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.audio.AudioModel;
import com.openai.models.audio.transcriptions.TranscriptionCreateParams;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMain {

  public static void main(String[] args) throws Exception {
    String apiKey = "";
    OpenAIClientAsync client = OpenAIOkHttpClientAsync.builder()
        .apiKey(apiKey)
        .build();

    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    Path path = Paths.get(classloader.getResource("sample.wav").toURI());

    TranscriptionCreateParams createParams = TranscriptionCreateParams.builder()
        .file(path)
        .model(AudioModel.WHISPER_1)
        .build();

    client.audio()
        .transcriptions()
        .create(createParams)
        .thenAccept(response ->
            System.out.println(response.asTranscription().text()))
        .join();
  }

}