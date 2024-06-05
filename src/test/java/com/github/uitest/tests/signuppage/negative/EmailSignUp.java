package com.github.uitest.tests.signuppage.negative;

import com.opencsv.exceptions.CsvException;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.github.uitest.methods.BeforeAndAfter;
import com.github.uitest.pages.HomePage;
import com.github.uitest.pages.SignUpPage;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.*;

public class EmailSignUp extends BeforeAndAfter {

    HomePage homepage;
    SignUpPage signuppage;
    public SoftAssert soft;

    @DataProvider(name = "invalid-email")
    public static Object[][] dataProviderCsvEnterNotValidEmail() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/invalid-email.csv");
    }

    @DataProvider(name = "real-email")
    public static Object[][] dataProviderCsvEnterValidEmail() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/real-email.csv");
    }


    @Epic("New User Sign Up")
    @Feature("Enter Email For Sign Up")
    @Story("Enter Invalid Email")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "invalid-email")
    public void invalidEmail(String email) {
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signuppage = new SignUpPage();
        signuppage.emailContainerVisible();
        signuppage.setEmail(email);
        assertTrue(signuppage.emailErrorIsDisplayed());
        assertFalse(signuppage.continueAtEmailIsNotClickable());
        assertEquals("Email is invalid or already taken", signuppage.errorMessageEmailText());
    }

    @Epic("New User Sign Up")
    @Feature("Enter Email For Sign Up")
    @Story("Enter Valid Email")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "real-email")               //ИМАМ ЗА ПОПРАВКА
    public void validEmail(String email) {
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signuppage = new SignUpPage();
        signuppage.emailContainerVisible();
        signuppage.setEmail(email);

        assertTrue(signuppage.continueAtEmailIsClickable());
        signuppage.clickContinueAtEmail();

        assertTrue(signuppage.passwordContainerVisible());

    }


}
