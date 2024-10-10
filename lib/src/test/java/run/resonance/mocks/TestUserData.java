package run.resonance.mocks;

public class TestUserData {
  public String id;
  public String userTier;
  public String userType;

  public TestUserData(String id) {
    this.id = id;
    this.userTier = "PRO";
    this.userType = "FREQUENT";
  }
}
