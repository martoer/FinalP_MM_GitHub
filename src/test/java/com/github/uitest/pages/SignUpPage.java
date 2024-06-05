package com.github.uitest.pages;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "//*[@id='opt-in-container']//*[contains(@Class, 'signup-continue-button')]")
    private WebElement buttonContinueAtOptIn;

    @FindBy(xpath = "//*[@id='email-container']")
    private WebElement emailContainer;

    @FindBy(xpath = "//*[@id='password-container']")
    private WebElement passwordContainer;

    @FindBy(xpath = "//*[@id='username-container']")
    private WebElement usernameContainer;

    @FindBy(xpath = "//*[@id='opt-in-container']")
    private WebElement optInContainer;

    @FindBy(xpath = "//*[@id='opt-in-container']//*[@name='opt_in']")
    private WebElement checkBox;

    String greenColor = "rgb(32, 187, 61)";
    String redColor = "rgb(209, 36, 47)";

    @Step("Get the color of Continue Button")
    public String getContinueAtEmailColor() {
        buttonContinueAtEmail.getCssValue("color");
        return getContinueAtEmailColor();
    }

    @Step("Enter Email")
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Enter Password")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Enter Username")
    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void clickFillEmail() {
        waitForElementToBeVisible(emailInput);
        emailInput.click();
    }

    @Step("Verify Email Container is Visible")
    public boolean emailContainerVisible() {
        waitForElementToBeVisible(emailContainer);
        return emailContainer.isDisplayed();
    }

    @Step("Verify Password Container is Visible")
    public boolean passwordContainerVisible() {
        waitForElementToBeVisible(emailContainer);
        return passwordContainer.isDisplayed();
    }

    @Step("Verify Username Container is Visible")
    public boolean usernameContainerVisible() {
        waitForElementToBeVisible(usernameContainer);
        return usernameContainer.isDisplayed();
    }

    @Step("Verify OptIn Container is Visible")
    public boolean optInContainerVisible() {
        waitForElementToBeVisible(optInContainer);
        return optInContainer.isDisplayed();
    }

    @Step("Verify OptIn Email Preferences CheckBox is Selected")
    public boolean checkBoxIsSelected() {
        waitForElementToBeVisible(optInContainer);
        return checkBox.isSelected();
    }

    @Step("Click Continue after Entering Email")
    public void clickContinueAtEmail() {
        waitFOrElementsToBeClickable(buttonContinueAtEmail);
        buttonContinueAtEmail.click();
    }

    @Step("Click Continue after Entering Password")
    public void clickContinueAtPassword() {
        waitFOrElementsToBeClickable(buttonContinueAtPassword);
        buttonContinueAtPassword.click();
    }

    @Step("Click Continue after Entering Username")
    public void clickContinueAtUsername() {
        waitFOrElementsToBeClickable(buttonContinueAtUsername);
        buttonContinueAtUsername.click();
    }

    @Step("Click Continue after deciding the Email preferences")
    public void clickContinueAtOptIn() {
        waitFOrElementsToBeClickable(buttonContinueAtOptIn);
        buttonContinueAtOptIn.click();
    }

    @Step("Check Email Preferences")
    public void clickCheckBoxOptIn() {
        waitFOrElementsToBeClickable(checkBox);
        checkBox.click();
    }

    @Step("Verify Email Error Message is Displayed")
    public boolean emailErrorIsDisplayed() {
        return errorMessageEmail.isDisplayed();
    }

    @Step("Verify Password Error Message is Displayed")
    public boolean passwordErrorIsDisplayed() {
        return errorMessagePassword.isDisplayed();
    }

    @Step("Verify Username Error Message is Displayed")
    public boolean usernameErrorIsDisplayed() {
        return errorMessageUsername.isDisplayed();
    }

    @Step("Verify Username Confirm Message is Displayed")
    public boolean usernameConfirmIsDisplayed() {
        waitForElementToBeVisible(confirmMessageUsername);
        return confirmMessageUsername.isDisplayed();
    }

    @Step("Verify Continue Button at Email is Clickable")
    public boolean continueAtEmailIsClickable() {
        waitFOrElementsToBeClickable(buttonContinueAtEmail);
        return buttonContinueAtEmail.isEnabled();
    }

    @Step("Verify Continue Button at Password is Clickable")
    public boolean continueAtPasswordIsClickable() {
        waitFOrElementsToBeClickable(buttonContinueAtPassword);
        return buttonContinueAtPassword.isEnabled();
    }

    @Step("Verify Continue Button at Username is Clickable")
    public boolean continueAtUsernameIsClickable() {
        waitFOrElementsToBeClickable(buttonContinueAtUsername);
        return buttonContinueAtUsername.isEnabled();
    }

    @Step("Verify Continue Button at OptIn is Clickable")
    public boolean continueAtOptInIsClickable() {
        waitFOrElementsToBeClickable(buttonContinueAtOptIn);
        return buttonContinueAtOptIn.isEnabled();
    }

    @Step("Verify Continue Button at Email is NOT Clickable")
    public boolean continueAtEmailIsNotClickable() {
        //waitFOrElementsToBeClickable(buttonContinueAtEmail);
        return buttonContinueAtEmail.isEnabled();
    }

    @Step("Verify Continue Button at Password is NOT Clickable")
    public boolean continueAtPasswordIsNotClickable() {
        //waitFOrElementsToBeClickable(buttonContinueAtPassword);
        return buttonContinueAtPassword.isEnabled();
    }

    @Step("Verify Continue Button at Username is NOT Clickable")
    public boolean continueAtUsernameIsNotClickable() {
        //waitFOrElementsToBeClickable(buttonContinueAtUsername);
        return buttonContinueAtUsername.isEnabled();
    }

    @Step("Get Email Error Message Text")
    public String errorMessageEmailText() {
        return errorMessageEmail.getText();
    }

    @Step("Get Password Error Message Text")
    public String errorMessagePasswordText() {
        return errorMessagePassword.getText();
    }

    @Step("Get Username Error Message Text")
    public String errorMessageUsernameText() {
        return errorMessageUsername.getText();
    }

    @Step("Get Username Confirmation Message Text")
    public String confirmMessageUsernameText() {
        return confirmMessageUsername.getText();
    }
}