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

    @FindBy(xpath = "//div[contains(@class, 'c-logo')]")
    private WebElement logoCoursera;

    @FindBy(xpath = "//div[contains(@class, 'c-user-modal-mission')]")
    private WebElement missionCoursera;

    @FindBy(xpath = "//a[contains(@data-click-key, 'account.wall.click.login')]")
    private WebElement accountLogin;

    private String nameLogoCoursera = "Coursera";
    private String nameMissionCoursera = "Universal access to the world’s best education.";
    private String nameAccountLogin = "Log In";

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

    public boolean isLogoCourseraPresent() {
        return (logoCoursera.getText().equalsIgnoreCase(nameLogoCoursera));
    }

    public boolean isMissionCourseraPresent() {
        return (missionCoursera.getText().equalsIgnoreCase(nameMissionCoursera));
    }

    public boolean isAccountLoginPresent() {
        return (accountLogin.getText().equalsIgnoreCase(nameAccountLogin));
    }

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(logoCoursera));
    }
}