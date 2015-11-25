/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/19/15
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */
package runner;
import common.CommonMethods;
import cucumber.api.Scenario;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;

import java.io.File;
import org.apache.commons.io.FileUtils;

import static framework.BrowserManager.getInstance;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features"},
        //features = {"src/test/resources/features/login.feature"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    private static Logger log = Logger.getLogger("RunCukesTest");
    public static boolean isLogin;

    @BeforeTest
    public void beforeExecution() {
        try {
            System.out.println("************************GLOBAL HOOK - BEFORE: "+isLogin);
            CommonMethods.logIn();
            isLogin = true;
        }catch (Exception e) {
            log.error("Unable to login before execution");
        }
    }

    @AfterTest
    public void afterExecution() {
        try {
            if (isLogin) {
                CommonMethods.logOut();
                isLogin = false;
            }
            System.out.println("************************GLOBAL HOOK - AFTER: "+isLogin);
        } catch (Exception e) {
            log.error("Unable to logout after execution", e);
        } finally {
            getInstance().quitBrowser();
        }
    }

    @BeforeMethod
    public static void beforeFeature() {
        System.out.println("Starting Feature: "+isLogin);
    }

    @AfterMethod
    public static void afterFeature(ITestResult result) {
        System.out.println("Ending Feature: "+isLogin);
        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus())
        {
            try
            {
                // Create refernce of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)getInstance().getDriver();

                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

                // Copy files to specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));

                System.out.println("Screenshot taken");
            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
    }

    @org.junit.After
    public void embedScreenShot(Scenario scenario) {
        try {
            System.out.println("#########################Take a snapshot#######################");
            byte[] screenshot = ((TakesScreenshot)getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            System.out.println("#######SCENARIO: "+scenario.getName());
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }
}