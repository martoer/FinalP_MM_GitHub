package com.github.uitest.tests.signuppage.negative;

import com.github.uitest.pages.HomePage;
import com.github.uitest.pages.SignUpPage;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.github.uitest.methods.BeforeAndAfter;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class UsernameSignUp extends BeforeAndAfter {
    HomePage homepage;
    SignUpPage signuppage;
    public SoftAssert soft;

    @DataProvider(name = "wrong-username")
    public static Object[][] dataProviderCsWrongUsername() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/wrong-username.csv");
    }

    @DataProvider(name = "valid-username")
    public static Object[][] dataProviderCsValidUsername() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/valid-username.csv");
    }

    @Epic("New User Sign Up")
    @Feature("Enter Username For Sign Up")
    @Story("Enter Wrong Username")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "wrong-username")               //ИМАМ ЗА ПОПРАВКА
    public void wrongUsername(String email, String password, String errorMessagePassword, String username,
                              String errorMessageUsernamePart1) {
        soft = new SoftAssert();
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signuppage = new SignUpPage();
        signuppage.emailContainerVisible();
        signuppage.setEmail(email);
        assertTrue(signuppage.continueAtEmailIsClickable());
        signuppage.clickContinueAtEmail();

        signuppage.passwordContainerVisible();
        signuppage.setPassword(password);

        assertTrue(signuppage.passwordErrorIsDisplayed());
        soft.assertEquals(signuppage.errorMessagePasswordText(), errorMessagePassword);
        assertTrue(signuppage.continueAtPasswordIsClickable());
        signuppage.clickContinueAtPassword();

        signuppage.usernameContainerVisible();
        signuppage.setUsername(username);
        assertTrue(signuppage.usernameErrorIsDisplayed());
        soft.assertEquals(signuppage.errorMessageUsernameText(), errorMessageUsernamePart1);
        assertFalse(signuppage.continueAtUsernameIsNotClickable());

        soft.assertAll();

    }

    @Epic("New User Sign Up")
    @Feature("Enter Username For Sign Up")
    @Story("Enter Valid Username")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "valid-username")               //ИМАМ ЗА ПОПРАВКА
    public void validUsername(String email, String password, String errorMessagePassword, String username,
                              String errorMessageUsername) {
        soft = new SoftAssert();
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signuppage = new SignUpPage();
        signuppage.emailContainerVisible();
        signuppage.setEmail(email);
        assertTrue(signuppage.continueAtEmailIsClickable());
        signuppage.clickContinueAtEmail();

        signuppage.passwordContainerVisible();
        signuppage.setPassword(password);

        assertTrue(signuppage.passwordErrorIsDisplayed());
        soft.assertEquals(signuppage.errorMessagePasswordText(), errorMessagePassword);
        assertTrue(signuppage.continueAtPasswordIsClickable());
        signuppage.clickContinueAtPassword();

        signuppage.usernameContainerVisible();
        signuppage.setUsername(username);
        assertTrue(signuppage.usernameConfirmIsDisplayed());
        soft.assertEquals(signuppage.confirmMessageUsernameText(), errorMessageUsername);
        assertTrue(signuppage.continueAtUsernameIsClickable());
        signuppage.clickContinueAtUsername();
        assertTrue(signuppage.optInContainerVisible());

        soft.assertAll();

    }
}
