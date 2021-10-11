import org.openqa.selenium.WebDriver;

public class AboutPage {
    private WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return "https://www.gephin.ml/about/";
    }
}
