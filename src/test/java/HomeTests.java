import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeTests {
    private WebDriver driver;
    private HomePage home;
    private AboutPage about;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        home = new HomePage(driver);
        about = new AboutPage(driver);

        home.open();
    }

    @Test
    public void homePage_IsLogoDisplayed_ShouldWebsiteLoad() {
        assertThat(home.isLoaded()).isTrue();
    }

    @Test
    public void homePage_UserClicksAboutLink_ShouldBeRedirectedToAboutPage() {
        home.goToAboutPage();

        assertThat(about.getUrl()).isEqualTo(driver.getCurrentUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
