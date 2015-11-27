/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/19/15
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */
package runner;
import common.CommonMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;

import static framework.BrowserManager.getInstance;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features"},
        //features = {"src/test/resources/features/login.feature"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    private static Logger log = Logger.getLogger("RunCukesTest");

    @BeforeTest
    public void beforeExecution() {
        try {
            CommonMethods.logIn();
        }catch (Exception e) {
            log.error("Unable to login before execution");
        }
    }

    @AfterTest
    public void afterExecution() {
        try {
            if (CommonMethods.isLogin) {
                CommonMethods.logOut();
            }
        } catch (Exception e) {
            log.error("Unable to logout after execution", e);
        } finally {
            getInstance().quitBrowser();
        }
    }

    @BeforeMethod
    public static void beforeFeature() {
        System.out.println("Starting Feature: "+CommonMethods.isLogin);
    }

    @AfterMethod
    public static void afterFeature(ITestResult result) {
        System.out.println("Ending Feature: "+CommonMethods.isLogin);
    }
}