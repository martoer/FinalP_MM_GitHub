package uitest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//*[@for='email']")
    private WebElement textEnterYourEmail;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@class='mb-0']")
    private WebElement errorMessageEmail;
    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@class='d-flex flex-items-center flex-column flex-sm-row']" +
            "//*[@data-continue-to='password-container']")
    private WebElement buttonContinueAtEmail;

    @FindBy(xpath = "//*[@class='d-flex flex-items-center flex-column flex-sm-row']" +
            "//*[@data-continue-to='username-container']")
    private WebElement buttonContinueAtPassword;

    @FindBy(xpath = "//*[@class='d-flex flex-items-center flex-column flex-sm-row']" +
            "//*[@data-continue-to='opt-in-container']")
    private WebElement buttonContinueAtUsername;


    @FindBy(xpath = "//*[@id='email-container']")
    private WebElement emailContainer;

    String greenColor = "rgb(32, 187, 61)";
    String redColor = "rgb(209, 36, 47)";

    public String getUsernameColor(){
        buttonContinueAtEmail.getCssValue("color");
        return getUsernameColor();
    }

    public void setEmail (String email){emailInput.sendKeys(email);}
    public void setPassword (String password) {passwordInput.sendKeys(password);}
    public void setUsername (String username) {usernameInput.sendKeys(username);}

    public void clickFillEmail (){ waitForElementToBeVisible(emailInput);
    emailInput.click();}

    public boolean emailContainerVisible(){
        waitForElementToBeVisible(emailContainer);
        return emailContainer.isDisplayed();
    }

    public void clickContinueAtEmail(){
        waitFOrElementsToBeClickable(buttonContinueAtEmail);
        buttonContinueAtEmail.click();
    }

    public boolean emailErrorIsDisplayed(){
        return errorMessageEmail.isDisplayed();
    }

    public boolean continueAtEmailsClicable() { return buttonContinueAtEmail.isEnabled();}
}
