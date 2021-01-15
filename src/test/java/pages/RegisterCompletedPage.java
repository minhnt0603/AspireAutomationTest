package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.GlobalVariables;

public class RegisterCompletedPage {
    WebDriver driver;
    WebDriverWait wait;

    private String PAGE_TITLE = "Let's get started | Aspire";

    public RegisterCompletedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all web elements in Completed Register Page
     */

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement btnContinue;
    @FindBy(how = How.CSS, using = ".aspire-cta-screen__content p.q-mb-xl")
    WebElement lblSuccessfulMessage;

    /**
     * All actions in Completed Register Page
     */

    public void verifyRegisterSuccessfully() {
        this.wait.until(ExpectedConditions.titleIs(PAGE_TITLE));
        this.wait.until(ExpectedConditions.visibilityOf(lblSuccessfulMessage));
        Assert.assertTrue(lblSuccessfulMessage.getText().matches(GlobalVariables.REGISTER_SUCCESSFULLY_MESSAGE));
    }

    public void clickButtonContinue() {
        this.wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
        btnContinue.click();
    }
}
