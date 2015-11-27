/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/25/15
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
package steps.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import static framework.BrowserManager.getInstance;

public class GlobalHooks {
    @After
    public void embedScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                System.out.println("#########################Take a snapshot#######################");
                byte[] screenshot = ((TakesScreenshot)getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                System.out.println("#######SCENARIO: "+scenario.getName());
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }

        //if (scenario.getName().equalsIgnoreCase(""))
    }
}
