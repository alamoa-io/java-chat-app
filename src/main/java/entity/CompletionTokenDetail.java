package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompletionTokenDetail {
  @JsonProperty("reasoning_tokens")
  private int reasoningTokens;
  @JsonProperty("audio_tokens")
  private int audioTokens;
  @JsonProperty("accepted_prediction_tokens")
  private int acceptedPredictionTokens;
  @JsonProperty("rejected_prediction_tokens")
  private int rejectedPredictionTokens;

  public int getReasoningTokens() {
    return reasoningTokens;
  }

  public void setReasoningTokens(int reasoningTokens) {
    this.reasoningTokens = reasoningTokens;
  }

  public int getAudioTokens() {
    return audioTokens;
  }

  public void setAudioTokens(int audioTokens) {
    this.audioTokens = audioTokens;
  }

  public int getAcceptedPredictionTokens() {
    return acceptedPredictionTokens;
  }

  public void setAcceptedPredictionTokens(int acceptedPredictionTokens) {
    this.acceptedPredictionTokens = acceptedPredictionTokens;
  }

  public int getRejectedPredictionTokens() {
    return rejectedPredictionTokens;
  }

  public void setRejectedPredictionTokens(int rejectedPredictionTokens) {
    this.rejectedPredictionTokens = rejectedPredictionTokens;
  }
}