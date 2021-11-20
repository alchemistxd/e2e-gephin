import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @CacheLookup
    @FindBy(xpath = "/html/body/header/div/div/div[1]/div/div/div/div[1]/a/img")
    private WebElement logo;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"menu-item-36\"]/a")
    private WebElement aboutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return logo.isDisplayed();
    }

    public void open() {
        driver.get("https://gephin.ml");
    }

    public void goToAboutPage() {
        aboutButton.click();
    }
}
