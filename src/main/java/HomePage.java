import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        WebElement logo = driver.findElement(By.xpath("/html/body/header/div/div/div[1]/div/div/div/div[1]/a/img"));

        return logo.isDisplayed();
    }

    public void open() {
        driver.get("https://gephin.ml");
    }

    public void goToAboutPage() {
        WebElement aboutButton = driver.findElement(By.xpath("//*[@id=\"menu-item-36\"]/a"));
        aboutButton.click();
    }
}
