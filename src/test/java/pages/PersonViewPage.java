package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonViewPage {
    WebDriver driver;
    WebDriverWait wait;

    public PersonViewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all web elements in Person View Page
     */

    @FindBy(how = How.CSS, using = ".aspire-button--cta")
    WebElement btnGetStarted;

    /**
     * All actions in Person View Page
     */

    public void clickButtonGetStarted() {
        this.wait.until(ExpectedConditions.elementToBeClickable(btnGetStarted));
        btnGetStarted.click();
    }
}
