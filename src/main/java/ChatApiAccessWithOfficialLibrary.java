import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.audio.AudioModel;
import com.openai.models.audio.transcriptions.TranscriptionCreateParams;

import java.nio.file.Path;

public class ChatApiAccessWithOfficialLibrary {
    OpenAIClient client = OpenAIOkHttpClient.builder()
        .apiKey("")
        .build();

    protected String getResponse(Path path){

        TranscriptionCreateParams createParams = TranscriptionCreateParams.builder()
                .file(path)
                .model(AudioModel.WHISPER_1)
                .build();

        return client.audio().transcriptions().create(createParams).asTranscription().text();
    }
}

