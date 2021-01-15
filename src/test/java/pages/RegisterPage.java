package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all web elements in Register Page
     */

    @FindBy(how = How.CSS, using = "input[name='full_name']")
    WebElement txtFullName;
    @FindBy(how = How.CSS, using = "input[name='email']")
    WebElement txtEmail;
    @FindBy(how = How.CSS, using = "div.q-img__content.absolute-full")
    WebElement iconCountry;
    @FindBy(how = How.XPATH, using = "//input[@name='phone']")
    WebElement txtPhoneNumber;
    @FindBy(how = How.CSS, using = "div[aria-label='Appointed director']")
    WebElement rdbAppointedDirector;
    @FindBy(how = How.CSS, using = "div[aria-label='Non-director']")
    WebElement rdbNonDirector;
    @FindBy(how = How.CSS, using = "input[data-cy='register-person-heard-about']")
    WebElement txtHeardAbout;
    @FindBy(how = How.CSS, using = "input[data-cy='register-person-referral-code")
    WebElement txtReferralCode;
    @FindBy(how = How.CSS, using = "div[data-cy='register-person-privacy")
    WebElement chbTermsAndConditions;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement btnSubmit;

    /**
     * All actions in Register Page
     */
    public void registerNewAccount(String fullName, String email, String country, String phoneNo,
                                   String role, String heardAbout, String referralCode) {
        // Enter Full Name
        this.wait.until(ExpectedConditions.elementToBeClickable(txtFullName));
        txtFullName.sendKeys(fullName);

        // Enter Email
        this.wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
        txtEmail.sendKeys((email));

        // Select National Code
        this.wait.until(ExpectedConditions.elementToBeClickable(iconCountry));
        iconCountry.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + country + "')]")));
        WebElement selectedCountry = driver.findElement(By.xpath("//div[contains(text(),'" + country + "')]"));
        selectedCountry.click();

        // Enter Phone Number
        this.wait.until(ExpectedConditions.elementToBeClickable(txtPhoneNumber));
        txtPhoneNumber.sendKeys(phoneNo);

        // Select user role
        this.wait.until(ExpectedConditions.elementToBeClickable(rdbAppointedDirector));
        if (role.equalsIgnoreCase("appointed director")) {
            rdbAppointedDirector.click();

        } else rdbNonDirector.click();

        // Select Where did you hear about us
        this.wait.until(ExpectedConditions.elementToBeClickable(txtHeardAbout));
        txtHeardAbout.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + heardAbout + "')]")));
        WebElement heardAboutSelection = driver.findElement(By.xpath("//div[contains(text(),'" + heardAbout + "')]"));
        heardAboutSelection.click();

        // Enter Referral Code
        if (referralCode != null && referralCode != "") {
            this.wait.until(ExpectedConditions.elementToBeClickable(txtReferralCode));
            txtReferralCode.sendKeys(referralCode);
        }

        // Check the checkbox Terms and Conditions
        this.wait.until(ExpectedConditions.visibilityOf(chbTermsAndConditions));
        chbTermsAndConditions.click();

        // Click button Continue
        this.wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();
    }

}
