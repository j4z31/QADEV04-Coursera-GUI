/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class LoginPage extends BasePageObject {

    @FindBy(name = "email")
    @CacheLookup
    private WebElement emailInput;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@data-js,'submit')]")
    private  WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    private LoginPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    private LoginPage enterPassword(String pass) {
        passwordInput.clear();
        passwordInput.sendKeys(pass);
        return this;
    }

    private HomePage clickLoginButtonSuccessful() {
        loginButton.click();
        return new HomePage();
    }

    private LoginPage clickLoginButtonFailed() {
        loginButton.click();
        return this;
    }

    private void login(String email, String pass) {
        enterEmail(email);
        enterPassword(pass);
    }

    public HomePage loginSuccessful(String email, String password) {
        login(email, password);
        return clickLoginButtonSuccessful();
    }

    public LoginPage loginFailed(String email, String password) {
        login(email, password);
        return clickLoginButtonFailed();
    }

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}