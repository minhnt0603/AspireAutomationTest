package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectMethodPage {
    WebDriver driver;
    WebDriverWait wait;

    public SelectMethodPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all web elements in Select Method Page
     */

    @FindBy(how = How.XPATH, using = "(//div[@class='onboarding-step-register-select-method__column-content'])[1]/button")
    WebElement btnMyInfoReg;
    @FindBy(how = How.XPATH, using = "(//div[@class='onboarding-step-register-select-method__column-content'])[2]/button")
    WebElement btnStandardReg;

    /**
     * All actions in Select Method Page
     */

    public void selectRegistrationMethod(String registrationMethod) {
        if (registrationMethod.equalsIgnoreCase("myinfo registration")) {
            this.wait.until(ExpectedConditions.elementToBeClickable(btnMyInfoReg));
            btnMyInfoReg.click();
        } else if (registrationMethod.equalsIgnoreCase("standard registration")) {
            this.wait.until(ExpectedConditions.elementToBeClickable(btnStandardReg));
            btnStandardReg.click();
        }
    }
}
