/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import framework.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.BasePageObject;

public class LoginPage extends BasePageObject {
    private BrowserManager browser;
    private WebElement element;

    public LoginPage() {
        super();
        browser = BrowserManager.getInstance();
        //PageFactory.initElements(driver, this);
        //waitUntilPageObjectIsLoaded();
    }

    private void enterEmail(String email) {
        element = browser.getDriver().findElement(By.name("email"));
        element.clear();
        element.sendKeys(email);
    }

    private void enterPassword(String pass) {
        element = browser.getDriver().findElement(By.name("password"));
        element.clear();
        element.sendKeys(pass);
    }

    private void clickLogInButton() {
        element = browser.getDriver().findElement(By.xpath("//button[contains(@data-js,'submit')]"));
        //element = browser.getDriver().findElement(By);
        element.click();
    }

    public HomePage loginAs(String email, String pass) {
        enterEmail(email);
        enterPassword(pass);
        clickLogInButton();
        HomePage page = new HomePage();

        return page;
    }

    public void waitUntilPageObjectIsLoaded() {
        //To change body of implemented methods use File | Settings | File Templates.
        //wait.until();
    }
}