package uitest.tests.homepage;

import driver.DriverFactory;
import org.testng.annotations.Test;
import uitest.methods.BeforeAndAfter;
import uitest.pages.HomePage;
import uitest.pages.SignUpPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoadHomePage extends BeforeAndAfter {
    HomePage homepage;
    SignUpPage signUpPage;

    @Test
    public void homePageLoading (){
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), "https://github.com/");
    }

    @Test
    public void clickSignUpButton(){
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signUpPage = new SignUpPage();
        assertTrue(signUpPage.emailContainerVisible());
    }

}
