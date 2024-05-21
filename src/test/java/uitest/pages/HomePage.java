package uitest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    /*@FindBy (xpath = "//*[@class='d-lg-flex flex-items-center mb-3 mb-lg-0 text-center text-lg-left ml-3']" +
            "//*[contains(text(),'Sign up')]")
    private WebElement signUpButton;*/

    /*@FindBy(partialLinkText = " Sign up ")
    private WebElement signUpButton;*/

   // @FindBy(xpath = "//div[contains(@class, 'd-lg-flex')]//a[contains(@class, 'HeaderMenu-link--sign-up')]")
    //private WebElement signUpButton;

    @FindBy(xpath = "//div[contains(@class, 'd-lg-flex')]//a[contains(@class, 'HeaderMenu-link--sign-up')]")
    private WebElement signUpButton;
    public void clickSignUpButton() {
        signUpButton.click();
    }

}
