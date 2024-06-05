package com.github.uitest.tests.homepage;

import com.github.uitest.pages.HomePage;
import com.github.uitest.pages.SignUpPage;
import driver.DriverFactory;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import com.github.uitest.methods.BeforeAndAfter;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoadHomePage extends BeforeAndAfter {
    HomePage homepage;
    SignUpPage signUpPage;

    @Epic("Loading Home Page")
    @Story("Open Home Page successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void homePageLoading() {

        assertEquals(DriverFactory.getDriver().getCurrentUrl(), "https://github.com/");
    }

    @Epic("New User Sign Up")
    @Feature("Start Sign Up")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void clickSignUpButton() {
        homepage = new HomePage();
        homepage.clickSignUpButton();

        signUpPage = new SignUpPage();
        assertTrue(signUpPage.emailContainerVisible());
    }

}
