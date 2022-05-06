package steps;

public class FirefoxUtility implements  AutomationApi{
    public void LaunchFirefox(){
        System.out.println("Launching Firefox: ");
    }
    public String getDriver() {
        return "Firefox Driver";
    }
    public String getBrowserName() {
        return "Firefox Browser";
    }
}
