/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/12/15
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.PageTransporter;
import ui.pages.CoursesPage;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

import static org.testng.Assert.assertTrue;

public class SearchCourseSteps {
    private static PageTransporter page = PageTransporter.getInstance();
    private MainPage mainPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private CoursesPage coursesPage;

    @Given("^I navigate to Main Page$")
    public void navigateToMainPage() {
        mainPage = page.navigateToMainPage();
    }

    @When("^I search a course as \"(.*?)\"$")
    public void searchACourseAs(String searchCourse) {
        coursesPage = mainPage
                    .setSearchCourseInput(searchCourse)
                    .clickSearchButton();
    }

    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
    public void loginAs(String userName, String userPassword){
        homePage = loginPage.loginSuccessful(userName, userPassword);
    }

    @Then("^obtain a \"(.*?)\" list course.$")
    public void obtainAJavaScriptListCourse(String course) {
        assertTrue(coursesPage.coursesFinds(course), "Courses are displayed");
    }

    @Then("^do not obtain \"(.*?)\" none course.$")
    public void doNotObtainNoneCourse(String course) {
        assertTrue(coursesPage.notCourseFind(course), "Courses aren't displayed");
    }

    //Enroll the course
    @When("^I wish to enroll in the course$")
    public void iWishToEnrollInTheCourse() {
    }

    @And("^Sign the Coursera Honor Code.$")
    public void signTheCourseraHonorCode() {
    }

    @Then("^I am enrolled in the course$")
    public void iAmEnrolledInTheCourse() {
    }
}