package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OTPVerifyPage {
    WebDriver driver;
    WebDriverWait wait;

    public OTPVerifyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all web elements in Enter OTP Page
     */

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Change email')]")
    WebElement btnChangeEmail;
    @FindBy(how = How.CSS, using = ".verify-otp__recipient.text-weight-medium.text-h6.text-info")
    WebElement lblEmailAddress;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Resend OTP')]")
    WebElement linkRegister;
    @FindBy(how = How.XPATH, using = "//div[@class='digit-input__box flex justify-between no-wrap']/div[1]")
    WebElement txt1stOTPdigit;
    @FindBy(how = How.XPATH, using = "//div[@class='digit-input__box flex justify-between no-wrap']/div[2]")
    WebElement txt2ndOTPdigit;
    @FindBy(how = How.XPATH, using = "//div[@class='digit-input__box flex justify-between no-wrap']/div[3]")
    WebElement txt3rdOTPdigit;
    @FindBy(how = How.XPATH, using = "//div[@class='digit-input__box flex justify-between no-wrap']/div[4]")
    WebElement txt4thOTPdigit;

    /**
     * All actions in Enter OTP Page
     */

    public void enterOTP(String first, String second, String third, String fourth) {

        this.wait.until(ExpectedConditions.elementToBeClickable(txt1stOTPdigit));
        try{
            Thread.sleep(5000);
        } catch(InterruptedException ie){
        }

        Actions actions = new Actions(driver);

        // Enter the 1st digit of OTP
        this.wait.until(ExpectedConditions.elementToBeClickable(txt1stOTPdigit));
        actions.sendKeys(txt1stOTPdigit,first).perform();

        // Enter the 2nd digit of OTP
        this.wait.until(ExpectedConditions.elementToBeClickable(txt2ndOTPdigit));
        actions.sendKeys(txt2ndOTPdigit,second).perform();

        // Enter the 3rd digit of OTP
        this.wait.until(ExpectedConditions.elementToBeClickable(txt3rdOTPdigit));
        actions.sendKeys(txt3rdOTPdigit,third).perform();

        // Enter the 4th digit of OTP
        this.wait.until(ExpectedConditions.elementToBeClickable(txt4thOTPdigit));
        actions.sendKeys(txt4thOTPdigit,fourth).perform();
    }
}
