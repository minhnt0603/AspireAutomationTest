package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all web elements in Login Page
     */

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Login to Aspire')]")
    WebElement lblLoginToAspire;
    @FindBy(how = How.XPATH, using = "//a[@href='/sg/register']")
    WebElement linkRegister;

    /**
     * All actions in Login Page
     */

    public void navigateToRegisterPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(linkRegister));
        linkRegister.click();
    }
}
