package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    @FindBy(xpath = "//*[@for='email']")
    private WebElement textEnterYourEmail;

    @FindBy(xpath = "//*[@class=\"d-flex flex-items-center flex-column flex-sm-row\"]//*[@data-continue-to=\"password-container\"]")
}
