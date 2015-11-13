/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
package ui;

import framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Initializes the web driver, wait and web elements
     */
    public BasePageObject() {
        this.driver = BrowserManager.getInstance().getDriver();
        this.wait = BrowserManager.getInstance().getWaitDriver();
        PageFactory.initElements(driver, this);
    }

    public abstract void waitUntilPageObjectIsLoaded();
}