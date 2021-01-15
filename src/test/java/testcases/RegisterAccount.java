package testcases;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.*;
import util.CommonFunctions;
import util.GlobalVariables;

public class RegisterAccount extends TestBase {

    static private String FULL_NAME = "Aspire Test";
    static private String HEARD_ABOUT = "Google";
    static private String REFFERAL_CODE = "TestingAspire";
    static private String FIRST_DIGIT = "1";
    static private String SECOND_DIGIT = "2";
    static private String THIRD_DIGIT = "3";
    static private String FOURTH_DIGIT = "4";
    static private boolean IS_BUSSINESS_REGISTERED = true;
    static private String REGISTRATION_METHOD = "Standard Registration";
    static private String DOB = "Mar 6, 1991";
    static private String NATIONALITY = "Viet Nam";
    static private String GENDER = "Male";


    @Test
    public void RegisterAccount() {
        /** Initialize web elements */
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        OTPVerifyPage otpVerifyPage = PageFactory.initElements(driver, OTPVerifyPage.class);
        RegisterCompletedPage registerCompletedPage = PageFactory.initElements(driver,RegisterCompletedPage.class);
        IncorporateSelectorPage incorporateSelectorPage = PageFactory.initElements(driver, IncorporateSelectorPage.class);
        SelectMethodPage selectMethodPage = PageFactory.initElements(driver, SelectMethodPage.class);
        PersonViewPage personViewPage = PageFactory.initElements(driver, PersonViewPage.class);
        PersonalDetailsPage personalDetailsPage = PageFactory.initElements(driver, PersonalDetailsPage.class);

        /** Step 1: Navigate to Register Page */
        loginPage.navigateToRegisterPage();

        /** Fill value into the register form then Submit */
        // Generate random email and phone number to avoid existing value
        CommonFunctions commonFunctions = new CommonFunctions();
        String reg_email = commonFunctions.generateRandomEmail();
        String phone_no = commonFunctions.generateRandomPhoneNumber();

        registerPage.registerNewAccount(FULL_NAME, reg_email, GlobalVariables.VIET_NAM, phone_no,
                GlobalVariables.ROLE_APPOINTED_DIRECTOR, HEARD_ABOUT, REFFERAL_CODE);

        /** Enter OTP */
        otpVerifyPage.enterOTP(FIRST_DIGIT, SECOND_DIGIT, THIRD_DIGIT, FOURTH_DIGIT);

        /** Verify the new account is registered successfully */
        registerCompletedPage.verifyRegisterSuccessfully();

        /** Navigate to Incorporated Selector Page */
        registerCompletedPage.clickButtonContinue();

        /** Select the Business */
        incorporateSelectorPage.selectIncorporated(IS_BUSSINESS_REGISTERED);

        /** Select Registration Method */
        selectMethodPage.selectRegistrationMethod(REGISTRATION_METHOD);

        /** Click button Get Started to edit personal information */
        personViewPage.clickButtonGetStarted();

        /** Edit personal information */
        personalDetailsPage.editPersonalDetails(null,null,null, DOB, NATIONALITY, GENDER, null);
    }
}