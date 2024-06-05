package com.github.uitest.tests.signuppage.negative;

import com.github.uitest.pages.HomePage;
import com.github.uitest.pages.SignUpPage;
import com.github.uitest.pages.VerifyPage;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.github.uitest.methods.BeforeAndAfter;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class OptInSignUp extends BeforeAndAfter {
    HomePage homepage;
    SignUpPage signuppage;
    VerifyPage verifypage;
    public SoftAssert soft;

    @DataProvider(name = "happy-path")
    public static Object[][] dataProviderCsvHappyPath() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/happy-path.csv");
    }

    @Epic("New User Sign Up")
    @Feature("Check Opt In For Email Preferences Sign Up")
    @Story("Checked Opt In Box")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "happy-path")               //ИМАМ ЗА ПОПРАВКА
    public void optInBoxChecked(String email, String password, String username) {
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signuppage = new SignUpPage();
        signuppage.emailContainerVisible();
        signuppage.setEmail(email);
        assertTrue(signuppage.continueAtEmailIsClickable());
        signuppage.clickContinueAtEmail();

        signuppage.passwordContainerVisible();
        signuppage.setPassword(password);
        assertTrue(signuppage.continueAtPasswordIsClickable());
        signuppage.clickContinueAtPassword();

        signuppage.usernameContainerVisible();
        signuppage.setUsername(username);
        assertTrue(signuppage.continueAtUsernameIsClickable());
        signuppage.clickContinueAtUsername();

        assertTrue(signuppage.optInContainerVisible());
        signuppage.clickCheckBoxOptIn();
        assertTrue(signuppage.checkBoxIsSelected());

        assertTrue(signuppage.continueAtOptInIsClickable());
        signuppage.clickContinueAtOptIn();

        verifypage = new VerifyPage();
        assertTrue(verifypage.captchaContainerVisible());


    }

    @Epic("New User Sign Up")
    @Feature("Check Opt In For Email Preferences Sign Up")
    @Story("Not Checked Opt In Box")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "happy-path")               //ИМАМ ЗА ПОПРАВКА
    public void optInBoxNotChecked(String email, String password, String username) {
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signuppage = new SignUpPage();
        signuppage.emailContainerVisible();
        signuppage.setEmail(email);
        assertTrue(signuppage.continueAtEmailIsClickable());
        signuppage.clickContinueAtEmail();

        signuppage.passwordContainerVisible();
        signuppage.setPassword(password);
        assertTrue(signuppage.continueAtPasswordIsClickable());
        signuppage.clickContinueAtPassword();

        signuppage.usernameContainerVisible();
        signuppage.setUsername(username);
        assertTrue(signuppage.continueAtUsernameIsClickable());
        signuppage.clickContinueAtUsername();

        assertTrue(signuppage.optInContainerVisible());
        assertFalse(signuppage.checkBoxIsSelected());

        assertTrue(signuppage.continueAtOptInIsClickable());
        signuppage.clickContinueAtOptIn();

        verifypage = new VerifyPage();
        assertTrue(verifypage.captchaContainerVisible());


    }
}
