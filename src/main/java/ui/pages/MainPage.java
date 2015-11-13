/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class MainPage extends BasePageObject {
    @FindBy(linkText = "Log In")
    private WebElement loginButton;

    @FindBy(xpath = "(//input[@value=''])[2]")
    private  WebElement searchInput;

    @FindBy(css = "i.cif-search.search-icon")
    private WebElement searchButton;

    public MainPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public LoginPage clickLogInButton() {
        loginButton.click();
        return new LoginPage();
    }

    public MainPage setSearchCourseInput(String searchCourse) {
        searchInput.clear();
        searchInput.sendKeys(searchCourse);
        return this;
    }

    public CoursesPage clickSearchButton() {
        return new CoursesPage();
    }

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}