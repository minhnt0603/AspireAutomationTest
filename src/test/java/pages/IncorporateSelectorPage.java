package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncorporateSelectorPage {
    WebDriver driver;
    WebDriverWait wait;

    public IncorporateSelectorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all web elements in Incorporate Selector Page
     */

    @FindBy(how = How.XPATH, using = "(//div[@class='incorporated_selector__column-content'])[1]/button")
    WebElement btnRegisteredBusiness;
    @FindBy(how = How.XPATH, using = "(//div[@class='incorporated_selector__column-content'])[2]/button")
    WebElement btnDonotHaveBusiness;

    /**
     * All actions in Incorporate Selector Page
     */

    public void selectIncorporated(boolean isBusinessRegistered) {
        if (isBusinessRegistered = true) {
            this.wait.until(ExpectedConditions.elementToBeClickable(btnRegisteredBusiness));
            btnRegisteredBusiness.click();
        } else {
            this.wait.until(ExpectedConditions.elementToBeClickable(btnDonotHaveBusiness));
            btnDonotHaveBusiness.click();
        }
    }
}
