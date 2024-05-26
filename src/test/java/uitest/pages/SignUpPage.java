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

    @FindBy(xpath = "//*[@id='password-err']//*[contains(@class, 'password-validity-summary')]")
    private WebElement errorMessagePassword;

    @FindBy(xpath = "//*[@id='login-err']//*[contains(@class, 'mb-1')]")
    private WebElement errorMessageUsername;

    @FindBy(xpath = "//*[@id='login-err']")
    private WebElement confirmMessageUsername;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@class='d-flex flex-items-center flex-column flex-sm-row']" +
            "//*[@data-continue-to='password-container']")
    private WebElement buttonContinueAtEmail;

    @FindBy(xpath = "//*[@id='password-container']//*[contains(@class, 'signup-continue-button')]")
    private WebElement buttonContinueAtPassword;

    @FindBy(xpath = "//*[@class='d-flex flex-items-center flex-column flex-sm-row']" +
            "//*[@data-continue-to='opt-in-container']")
    private WebElement buttonContinueAtUsername;


    @FindBy(xpath = "//*[@id='email-container']")
    private WebElement emailContainer;

    @FindBy(xpath = "//*[@id='password-container']")
    private WebElement passwordContainer;

    @FindBy(xpath = "//*[@id='username-container']")
    private WebElement usernameContainer;

    @FindBy(xpath = "//*[@id='opt-in-container']")
    private WebElement optInContainer;

    String greenColor = "rgb(32, 187, 61)";
    String redColor = "rgb(209, 36, 47)";

    public String getContinueAtEmailColor() {
        buttonContinueAtEmail.getCssValue("color");
        return getContinueAtEmailColor();
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void clickFillEmail() {
        waitForElementToBeVisible(emailInput);
        emailInput.click();
    }

    public boolean emailContainerVisible() {
        waitForElementToBeVisible(emailContainer);
        return emailContainer.isDisplayed();
    }

    public boolean passwordContainerVisible() {
        waitForElementToBeVisible(emailContainer);
        return passwordContainer.isDisplayed();
    }

    public boolean usernameContainerVisible() {
        waitForElementToBeVisible(usernameContainer);
        return usernameContainer.isDisplayed();
    }

    public boolean optInContainerVisible() {
        waitForElementToBeVisible(optInContainer);
        return optInContainer.isDisplayed();
    }

    public void clickContinueAtEmail() {
        waitFOrElementsToBeClickable(buttonContinueAtEmail);
        buttonContinueAtEmail.click();
    }
    public void clickContinueAtPassword() {
        waitFOrElementsToBeClickable(buttonContinueAtPassword);
        buttonContinueAtPassword.click();
    }

    public void clickContinueAtUsername() {
        waitFOrElementsToBeClickable(buttonContinueAtUsername);
        buttonContinueAtUsername.click();
    }

    public boolean emailErrorIsDisplayed() {
        return errorMessageEmail.isDisplayed();
    }
    public boolean passwordErrorIsDisplayed() {
        return errorMessagePassword.isDisplayed();
    }

    public boolean usernameErrorIsDisplayed() {
        return errorMessageUsername.isDisplayed();
    }
    public boolean usernameConfirmIsDisplayed() {
        waitForElementToBeVisible(confirmMessageUsername);
        return confirmMessageUsername.isDisplayed();
    }

    public boolean continueAtEmailIsClickable() {
        waitFOrElementsToBeClickable(buttonContinueAtEmail);
        return buttonContinueAtEmail.isEnabled();
    }
    public boolean continueAtPasswordIsClickable() {
        waitFOrElementsToBeClickable(buttonContinueAtPassword);
        return buttonContinueAtPassword.isEnabled();
    }

    public boolean continueAtUsernameIsClickable() {
        waitFOrElementsToBeClickable(buttonContinueAtUsername);
        return buttonContinueAtUsername.isEnabled();
    }
    public boolean continueAtEmailIsNotClickable() {
        //waitFOrElementsToBeClickable(buttonContinueAtEmail);
        return buttonContinueAtEmail.isEnabled();
    }
    public boolean continueAtPasswordIsNotClickable() {
        //waitFOrElementsToBeClickable(buttonContinueAtPassword);
        return buttonContinueAtPassword.isEnabled();
    }

    public boolean continueAtUsernameIsNotClickable() {
        //waitFOrElementsToBeClickable(buttonContinueAtUsername);
        return buttonContinueAtUsername.isEnabled();
    }

    public String errorMessageEmailText() {
        return errorMessageEmail.getText();
    }

    public String errorMessagePasswordText() {
        return errorMessagePassword.getText();
    }
    public String errorMessageUsernameText() {
        return errorMessageUsername.getText();
    }
    public String confirmMessageUsernameText() {
        return confirmMessageUsername.getText();
    }
}