package ro.utcn;

public class Laptop extends Device {

  int displaySizeInInches;

  public void installSteam() {
    System.out.println("Installing Steam...");
  }

  @Override
  public String getExtraData() {
    return displaySizeInInches + " inches";
  }
}
