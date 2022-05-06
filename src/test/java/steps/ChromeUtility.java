package steps;

public class ChromeUtility implements  AutomationApi{
    public void LaunchChrome(){
        System.out.println("Launching Chrome: ");
    }
    public String getDriver() {
        return "Chrome Driver";
    }
    public String getBrowserName() {
        return "Chrome Browser";
    }
}
