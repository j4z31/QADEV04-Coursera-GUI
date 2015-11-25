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
import runner.RunCukesTest;
import ui.PageTransporter;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    private static PageTransporter page = PageTransporter.getInstance();
    private HomePage homePage;
    private LoginPage loginPage;
    private MainPage mainPage;

    @Given("^I navigate to Login page$")
    public void navigateLoginPage(){
        if (!RunCukesTest.isLogin) {
            mainPage = page.navigateToMainPage();
            loginPage = mainPage.clickLogInButton();
            RunCukesTest.isLogin = true;
        }
        else {
            homePage = new HomePage();
        }
    }

    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
    public void loginAs(String userName, String userPassword){
        if (!RunCukesTest.isLogin) {
            homePage = loginPage.loginSuccessful(userName, userPassword);
        }
        else {
            homePage = new HomePage();
        }

    }

    @Then("^I should login successfully.$")
    public void shouldLoginSuccessfully(){
        assertTrue(homePage.isPartnersDisplayed(), "User Name displayed");

    }

    @When("^I want to close session$")
    public void iWantToCloseSession() {
        loginPage = page
                    .navigateToHomePage()
                    .clickAuthenticatedDropdownButton()
                    .clickSignOutButton();
        RunCukesTest.isLogin = false;
    }

    @Then("^I should logout successfully.$")
    public void iShouldLogoutSuccessfully() {
        //assertTrue(loginPage.isLogoCourseraPresent(), "Logo Coursera Displayed.");
        assertTrue(loginPage.isMissionCourseraPresent(), "Mission Coursera Displayed.");
        assertTrue(loginPage.isAccountLoginPresent(), "Account Login Displayed");
    }
}