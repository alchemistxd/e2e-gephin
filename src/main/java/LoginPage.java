import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://gephin.ml/wp-admin");
    }

    public void signIn() {
        WebElement userField = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        userField.sendKeys("Admin");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
        passwordField.sendKeys("T0Cxt!EbAb8YOthdL!*X#0ci");

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"wp-submit\"]"));
        logInButton.click();
    }

    public boolean isSigned() {
        WebElement userGreeting = driver.findElement(By.xpath("//a[contains(text(), 'Howdy')]"));
        return userGreeting.isDisplayed();
    }
}



