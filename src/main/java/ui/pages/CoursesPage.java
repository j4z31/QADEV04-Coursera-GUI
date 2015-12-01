/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/12/15
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class CoursesPage extends BasePageObject {
    @FindBy(css = "div.rc-NoSearchResults > p")
    private WebElement messageCourseNotFound;

    @FindBy(css = "div.c-you-searched-for > span")
    private WebElement messageCourseFound;

    @FindBy(xpath = "//h2[contains(@class, 'headline-1-text')]")
    private WebElement courseSelected;

    public CoursesPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public boolean coursesFinds(String nameCourse) {
        System.out.println("COURSE FIND: "+messageCourseFound.getText());
        return (messageCourseFound.getText().equalsIgnoreCase("You searched for "+nameCourse+"."));
    }

    public boolean notCourseFind(String course) {
        return (messageCourseNotFound.getText().equalsIgnoreCase("No Results found"));
    }

    public CourseInformationPage selectTheCourse(String course) {
        if (courseSelected.getText().equalsIgnoreCase(course)) {
            courseSelected.click();
        }

        return new CourseInformationPage();
    }

    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOf(courseSelected));
    }
}

