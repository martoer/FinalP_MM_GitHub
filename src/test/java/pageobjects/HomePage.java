package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy (partialLinkText = "Sign Up")
    private WebElement signUpButton;

}
