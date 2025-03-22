package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PromptTokenDetail {
  @JsonProperty("cached_tokens")
  private int cachedTokens;
  @JsonProperty("audit_tokens")
  private int auditTokens;
  @JsonProperty("audio_tokens")
  private int audioTokens;

  public int getCachedTokens() {
    return cachedTokens;
  }
  public void setCachedTokens(int cachedTokens) {
    this.cachedTokens = cachedTokens;
  }
  public int getAuditTokens() {
    return auditTokens;
  }
  public void setAuditTokens(int auditTokens) {
    this.auditTokens = auditTokens;
  }
  public int getAudioTokens() {
    return audioTokens;
  }
  public void setAudioTokens(int audioTokens) {
    this.audioTokens = audioTokens;
  }
}