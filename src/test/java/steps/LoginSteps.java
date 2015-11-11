package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by jhasmanyquiroz on 11/10/2015.
 */
public class LoginSteps {
    public BrowserManager browser = BrowserManager.getInstance();

    @Given("^I navigate to Login page$")
    public void navigateLoginPage(){
        browser.getDriver().navigate().to("https://www.coursera.org/");
    }

    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
    public void login(String userName, String userPassword){
        WebElement text = browser.getDriver().findElement(By.tagName("data-click-key"));

    }
}
