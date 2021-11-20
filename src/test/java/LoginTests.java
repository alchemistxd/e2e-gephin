import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests {
    private WebDriver driver;
    private LoginPage login;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        login = new LoginPage(driver);
        login.open();
    }

    @Test
    public void signIn_AsAdmin_ShouldBeLoggedIn() throws IOException {
        final Properties credentials = PropertyReader.from("res/conf/creds.properties");

        login.signIn(credentials.getProperty("admin_user"), credentials.getProperty("admin_pass"));

        assertThat(login.isSigned()).isTrue();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
