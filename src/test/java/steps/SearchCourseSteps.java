/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/12/15
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
package steps;

import common.CommonMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
        if (!CommonMethods.isLogin) {
            mainPage = page.navigateToMainPage();
        }
        else
            homePage = page.navigateToHomePage();
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
        if (!CommonMethods.isLogin) {
            loginPage = mainPage.clickLogInButton();
            homePage = loginPage.loginSuccessful(userName, userPassword);
            CommonMethods.isLogin = true;
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

    @Then("^go to the course enrolled \"(.*?)\".$")
    public void goToTheCourseEnrolled(String courseNameEnroll) {
        coursePage = courseInformationPage.clickGoToCourseSuccessfull();
        assertTrue(coursePage.isCourseNamePresent(courseNameEnroll), "Course enrolled");
    }

    @When("^I navigate to Home Page$")
    public void iNavigateToHomePage() {
        homePage = page.navigateToHomePage();
    }

    @And("^I selected the course to unenroll \"([^\"]*)\"$")
    public void iSelectedTheCourseToUnenroll(String nameCourse) {
        homePage = homePage
                    .titleCoursePresent(nameCourse)
                    .clickDropdownMenuCourse()
                    .clickButtonUnenroll()
                    ;
    }

    @Then("^the registered course \"([^\"]*)\" should not be present.$")
    public void theRegisteredCourseShouldNotBePresent(String nameCourse) {
        assertTrue(homePage.isCourseEnroll(nameCourse), "Unenroll Course");
    }

    @When("^I selected the course to enroll \"([^\"]*)\"$")
    public void iSelectedTheCourseToEnroll(String courseEnroll) {
        courseInformationPage = homePage
                .titleCoursePresent(courseEnroll)
                .clickDropdownMenuCourseinformation()
                ;
    }

    @Then("^I see the view information about the course \"([^\"]*)\".$")
    public void iSeeTheViewInformationAboutTheCourse(String titleCourse) {
        assertTrue(courseInformationPage.isTitleCoursePresent(titleCourse), "Title Course is Present");
    }
}