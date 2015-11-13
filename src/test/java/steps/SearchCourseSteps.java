/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/12/15
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.PageTransporter;
import ui.pages.CoursesPage;
import ui.pages.MainPage;

public class SearchCourseSteps {
    private static PageTransporter page = PageTransporter.getInstance();
    private MainPage mainPage;
    private CoursesPage coursesPage;

    @Given("^I navigate to Main Page$")
    public void navigateToMainPage() {
        mainPage = page.navigateToMainPage();
    }

    @When("^I search a course as \"JavaScript\"$")
    public  void searchACourseAs() {
    }

    @Then("^obtain a JavaScript's list course.$")
    public void obtainAJavaScriptSListCourse() {
    }
}