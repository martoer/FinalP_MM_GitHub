package com.github.uitest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'js-octocaptcha-parent')]")
    private WebElement captchaContainer;

    @FindBy(xpath = "//*[contains(@class, 'captcha-container')]//*[contains(.,'Verify your account')]")
    private WebElement verifyAccountSign;

    @FindBy(xpath = "//*[contains(@class, 'home box screen')]//*[contains(text(), 'Verify')]")
    private WebElement buttonVerifyAccount;

    @FindBy(xpath = "//*[contains(text(), 'arrows')]")
    private WebElement arrowsTextBox;

    @FindBy(xpath = "//*[contains(@class, 'game-core-frame')]")
    private WebElement gameCoreFrame;

    @FindBy(xpath = "//*[contains(@title, 'Verification challenge')]")
    private WebElement verificationChallengeFrame;

    @FindBy(xpath = "//*[contains(@class, 'js-octocaptcha-frame width-full d-block border-0 rounded-2')]")
    private WebElement parentFrame;


    @Step("Verify Captcha Contains is Visible")
    public boolean captchaContainerVisible() {
        waitForElementToBeVisible(captchaContainer);
        return captchaContainer.isDisplayed();
    }

    @Step("Verify Game Core Frame is Visible")
    public boolean gameCoreFrameVisible() {
        waitForElementToBeVisible(gameCoreFrame);
        return gameCoreFrame.isDisplayed();
    }

    @Step("Verify Verification Challenge Frame is Visible")
    public boolean verificationChallengeFrameVisible() {
        waitForElementToBeVisible(verificationChallengeFrame);
        return verificationChallengeFrame.isDisplayed();
    }

    @Step("Verify Parent Frame is Visible")
    public boolean parentFrameVisible() {
        waitForElementToBeVisible(parentFrame);
        return parentFrame.isDisplayed();
    }

    @Step("Click on Verify Button")
    public void clickButtonVerify() {
        waitForElementToBeVisible(buttonVerifyAccount);
        buttonVerifyAccount.click();
    }

    @Step("Verify Verify Button is Visible")
    public boolean buttonVerifyAccountVisible() {
        waitForElementToBeVisible(buttonVerifyAccount);
        return buttonVerifyAccount.isDisplayed();
    }

    @Step("Verify Instructions Text is Visible")
    public boolean arrowsTextVisible() {
        waitForElementToBeVisible(arrowsTextBox);
        return arrowsTextBox.isDisplayed();
    }

    @Step("Switch To Game Core Frame")
    public void goInsideGameCoreFrame() {
        driver.switchTo().frame(gameCoreFrame);
    }

    @Step("Switch To Verification Challenge Frame")
    public void goInsideVerificationChallengeFrame() {
        driver.switchTo().frame(verificationChallengeFrame);
    }

    @Step("Switch To Parent Frame")
    public void goInsideParentFrame() {
        driver.switchTo().frame(parentFrame);
    }
}