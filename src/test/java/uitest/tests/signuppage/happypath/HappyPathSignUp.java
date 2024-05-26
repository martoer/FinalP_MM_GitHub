package uitest.tests.signuppage.happypath;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import uitest.methods.BeforeAndAfter;
import uitest.pages.HomePage;
import uitest.pages.SignUpPage;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class HappyPathSignUp extends BeforeAndAfter {
    HomePage homepage;
    SignUpPage signuppage;
    public SoftAssert soft;

    @DataProvider(name = "happy-path")
    public static Object[][] dataProviderCsvHappyPath() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/happy-path.csv");
    }

    @Test(dataProvider = "happy-path")               //ИМАМ ЗА ПОПРАВКА
    public void validSignUp(String email, String password, String username) {
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


    }
}
