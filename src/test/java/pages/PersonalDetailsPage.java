package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PersonalDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all web elements in Person Details Page
     */

    @FindBy(how = How.CSS, using = ".input-value.q-mt-sm")
    WebElement txtFullName;
    @FindBy(how = How.CSS, using = ".q-mt-md")
    WebElement txtPhoneNumber;
    @FindBy(how = How.CSS, using = "input[data-cy='person-edit-email']")
    WebElement txtEmail;
    @FindBy(how = How.CSS, using = "div[label='Date of Birth']>label>div>div>div>input")
    WebElement txtDOB;
    @FindBy(how = How.CSS, using = "div[label='Nationality']>label>div>div>div>div>input")
    WebElement txtNationality;
    @FindBy(how = How.CSS, using = "div[label='Gender']>label>div>div>div>div>input")
    WebElement txtGender;
    @FindBy(how = How.CSS, using = "#div[label='Which products are you interested in?']>label>div>div>div>div")
    WebElement txtInterestedProducts;
    @FindBy(how = How.CSS, using = ".aspire-cta >button")
    WebElement btnSubmit;

    /**
     * All actions in Person Details Page
     */

    public void editPersonalDetails(String fullname, String phoneNo, String email, String dob,
                                    String nationality, String gender, ArrayList<String> interestedProducts) {
        Actions actions = new Actions(driver);

        if (fullname != null && fullname != "") {
            this.wait.until(ExpectedConditions.elementToBeClickable(txtFullName));
            txtFullName.sendKeys(fullname);
        }

        if (phoneNo != null && phoneNo != "") {
            this.wait.until(ExpectedConditions.elementToBeClickable(txtPhoneNumber));
            txtPhoneNumber.sendKeys(phoneNo);
        }

        if (email != null && email != "") {
            this.wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
            txtEmail.sendKeys(email);
        }

//        if (dob != null && dob != "") {
//            this.wait.until(ExpectedConditions.elementToBeClickable(txtDOB));
//            txtDOB.sendKeys(dob);
//        }

        if (nationality != null && nationality != "") {
            this.wait.until(ExpectedConditions.elementToBeClickable(txtNationality));
            txtNationality.sendKeys(nationality);
        }

        if (gender != null && gender != "") {
            this.wait.until(ExpectedConditions.elementToBeClickable(txtGender));
            txtGender.sendKeys(gender);
        }

//        this.wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
//        btnSubmit.click();
    }
}
