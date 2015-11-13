/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/10/15
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */
package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.PageTransporter;

public class LoginSteps {
    public PageTransporter page = PageTransporter.getInstance();

    @Given("^I navigate to Login page$")
    public void navigateLoginPage(){
        page.navigateToMainPage();
    }

    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
    public void loginAs(String userName, String userPassword){
        page.navigateToLoginPage();
    }

    @Then("^I should login successfully$")
    public void should_login_successfully(){
    }
}