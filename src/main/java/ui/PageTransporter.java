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
import ui.pages.HomePage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

public class PageTransporter {
    private WebDriver driver = BrowserManager.getInstance().getDriver();
    private String baseLoginURL = "https://www.coursera.org/";
    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if(instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
//        log.info("Initialize the page transporter");
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public MainPage navigateToMainPage() {
        goToURL(baseLoginURL);
        return new MainPage();
    }

    public LoginPage navigateToLoginPage() {
        return new LoginPage();
    }
}