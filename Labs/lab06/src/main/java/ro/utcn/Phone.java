package ro.utcn;

public class Phone extends Device {

  String imeiNumber;

  public void installCandyCrush() {
    System.out.println("Installing CandyCrush...");
  }

  public String getExtraData() {
    return imeiNumber;
  }
}
