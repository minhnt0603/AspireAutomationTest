package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import util.GlobalVariables;


public class TestBase {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void Initialize() {

        System.setProperty("webdriver.gecko.driver", "./src/test/java/drivers/geckodriver");

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.navigate().to(GlobalVariables.URL_ASPIRE);
    }

    @AfterClass
    public void CleanUp() {
        if (driver != null) {
            driver.close();
        }
    }
}

