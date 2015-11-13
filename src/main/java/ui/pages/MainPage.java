/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import framework.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.BasePageObject;

public class MainPage extends BasePageObject {
    private BrowserManager browser;
    private WebElement element;

    public MainPage() {
        super();
        browser = BrowserManager.getInstance();
    }

    public void clickLogInButton() {
        element = browser.getDriver().findElement(By.linkText("Log In"));
        element.click();
    }

    public void waitUntilPageObjectIsLoaded() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
