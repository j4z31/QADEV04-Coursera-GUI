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
import runner.RunCukesTest;
import ui.PageTransporter;
import ui.pages.*;

import static org.testng.Assert.assertTrue;

public class SearchCourseSteps {
    private static PageTransporter page = PageTransporter.getInstance();
    private MainPage mainPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private CoursesPage coursesPage;
    private CourseInformationPage courseInformationPage;
    private CoursePage coursePage;

    @Given("^I navigate to Main Page$")
    public void navigateToMainPage() {
        if (RunCukesTest.isLogin)
            homePage = page.navigateToHomePage();
        else
            mainPage = page.navigateToMainPage();
    }

    @When("^I search a course as \"(.*?)\"$")
    public void searchACourseAs(String searchCourse) {
        coursesPage = mainPage
                    .setSearchCourseInput(searchCourse)
                    .clickSearchButton();
    }

    @When("^I search a course like \"(.*?)\"$")
    public void searchACourseLike(String searchCourse) {
        coursesPage = homePage
                .setSearchCourseInput(searchCourse)
                .clickSearchButton();
    }

    @When("^I login like \"(.*?)\" with password \"(.*?)\"$")
    public void loginLike(String userName, String userPassword){
        if (!RunCukesTest.isLogin) {
            loginPage = mainPage.clickLogInButton();
            homePage = loginPage.loginSuccessful(userName, userPassword);
        }
        else
            homePage = new HomePage();
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
    @When("^I wish to enroll in the course \"(.*?)\"$")
    public void iWishToEnrollInTheCourse(String course) {
        courseInformationPage = coursesPage
                                .selectTheCourse(course)
                                .clickEnrollButtonSuccessful();
    }

    @And("^Sign the Coursera Honor Code.$")
    public void signTheCourseraHonorCode() {
    }

    @Then("^go to the course enrolled.$")
    public void goToTheCourseEnrolled() {
        coursePage = courseInformationPage.clickGoToCourseSuccessfull();
    }

    @When("^I navigate to Home Page$")
    public void iNavigateToHomePage() {
        homePage = page.navigateToHomePage();
    }

    @And("^I selected the course to unenroll \"([^\"]*)\"$")
    public void iSelectedTheCourseToUnenroll(String nameCourse) {
        //homePage = homePage
                    homePage.searchCourse(nameCourse);
                    //.clickDropdownMenuCourse();
    }

    @Then("^the registered course \"([^\"]*)\" should not be present.$")
    public void theRegisteredCourseShouldNotBePresent(String nameCourse) {
    }
}