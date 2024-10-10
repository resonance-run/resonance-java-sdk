package run.resonance.customization.network;

public class PostBody<K> {
  private K userData;
  private String apiKey;
  private String clientId;
  private String customizationType;
  private String surfaceId;

  public PostBody(K userData, String apiKey, String clientId, String customizationType, String surfaceId) {
    this.userData = userData;
    this.apiKey = apiKey;
    this.clientId = clientId;
    this.customizationType = customizationType;
    this.surfaceId = surfaceId;
  }
}
