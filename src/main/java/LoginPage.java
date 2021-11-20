import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public final class LoginPage extends Page {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"user_login\"]")
    private WebElement userField;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"user_pass\"]")
    private WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"wp-submit\"]")
    private WebElement logInButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(), 'Howdy')]")
    private WebElement userGreeting;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://gephin.ml/wp-admin");
    }

    public void signIn(String user, String password) {
        userField.sendKeys(user);
        passwordField.sendKeys(password);
        logInButton.click();
    }

    public boolean isSigned() {
        return userGreeting.isDisplayed();
    }
}

