package uitest.tests.signuppage.negative;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uitest.methods.BeforeAndAfter;
import uitest.pages.HomePage;
import uitest.pages.SignUpPage;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.*;

public class SignUp extends BeforeAndAfter {

    HomePage homepage;
    SignUpPage signuppage;

    @DataProvider(name = "invalid-email")
    public static Object[][] dataProviderCsvEnterNotValidEmail() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/invalid-email.csv");
    }
    @Test(dataProvider = "invalid-email")
    public void invalidEmail(String email) {
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signuppage = new SignUpPage();
        signuppage.emailContainerVisible();
        signuppage.setEmail(email);
       // signuppage.clickContinueAtEmail();
        assertTrue(signuppage.emailErrorIsDisplayed());
        assertFalse(signuppage.continueAtEmailsClicable());
    }

}
