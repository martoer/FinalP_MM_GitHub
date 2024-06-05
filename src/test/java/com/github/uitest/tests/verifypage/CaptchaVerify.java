package com.github.uitest.tests.verifypage;

import com.opencsv.exceptions.CsvException;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.github.uitest.methods.BeforeAndAfter;
import com.github.uitest.pages.HomePage;
import com.github.uitest.pages.SignUpPage;
import com.github.uitest.pages.VerifyPage;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class CaptchaVerify extends BeforeAndAfter {

    HomePage homepage;
    SignUpPage signuppage;
    VerifyPage verifypage;

    @DataProvider(name = "happy-path")
    public static Object[][] dataProviderCsvHappyPath() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/happy-path.csv");
    }

    @Epic("New User Sign Up")
    @Story("Successfully Load Captcha Test")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "happy-path")               //ИМАМ ЗА ПОПРАВКА
    public void validSignUp(String email, String password, String username) throws InterruptedException {
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

        Thread.sleep(500);

        verifypage = new VerifyPage();
        assertTrue(verifypage.parentFrameVisible());
        verifypage.goInsideParentFrame();
        assertTrue((verifypage.verificationChallengeFrameVisible()));
        verifypage.goInsideVerificationChallengeFrame();
        assertTrue(verifypage.gameCoreFrameVisible());
        verifypage.goInsideGameCoreFrame();
        verifypage.buttonVerifyAccountVisible();
        assertTrue(verifypage.buttonVerifyAccountVisible());
        verifypage.clickButtonVerify();

        assertTrue(verifypage.arrowsTextVisible());


    }
}
