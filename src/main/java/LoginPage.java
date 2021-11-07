import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;

public final class LoginPage {
    private final WebDriver driver;

    public LoginPage(final WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://gephin.ml/wp-admin");
    }

    public void signIn() throws IOException {
        final Properties credentials = PropertyReader.from("res/conf/creds.properties");

        final WebElement userField = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        userField.sendKeys(credentials.getProperty("admin_user"));

        final WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
        passwordField.sendKeys(credentials.getProperty("admin_pass"));

        final WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"wp-submit\"]"));
        logInButton.click();
    }

    public boolean isSigned() {
        final WebElement userGreeting = driver.findElement(By.xpath("//a[contains(text(), 'Howdy')]"));
        return userGreeting.isDisplayed();
    }
}

