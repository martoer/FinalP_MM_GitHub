package uitest.tests.signuppage.negative;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import uitest.methods.BeforeAndAfter;
import uitest.pages.HomePage;
import uitest.pages.SignUpPage;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class PasswordSignUp extends BeforeAndAfter {

    HomePage homepage;
    SignUpPage signuppage;
    public SoftAssert soft;

    @DataProvider(name = "wrong-password")
    public static Object[][] dataProviderCsvShortPassword() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/wrong-password.csv");
    }

    @DataProvider(name = "valid-password")
    public static Object[][] dataProviderCsvValidPassword() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/valid-password.csv");
    }

    @Test(dataProvider = "wrong-password")               //ИМАМ ЗА ПОПРАВКА
    public void wrongPassword(String email, String password, String errorMessagePassword) {
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
        assertFalse(signuppage.continueAtPasswordIsNotClickable());

        soft.assertAll();

    }

    @Test(dataProvider = "valid-password")               //ИМАМ ЗА ПОПРАВКА
    public void validPassword(String email, String password, String errorMessagePassword) {
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
        assertTrue(signuppage.usernameContainerVisible());

        soft.assertAll();

    }
}
