/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/10/15
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserManager {
    private WebDriver driver;
    private WebDriverWait wait;

    private static BrowserManager instance = null;

    protected BrowserManager() {
        initialize();
    }

    public static BrowserManager getInstance() {
        if(instance == null || instance.driver == null) {
            instance = new BrowserManager();
        }

        return instance;
    }

    private void initialize(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5, 1000);
    }

    public void quitBrowser(){
        driver.quit();
    }

    public WebDriverWait getWaitDriver(){
        return wait;
    }

    public WebDriver getDriver(){
        return driver;
    }
}