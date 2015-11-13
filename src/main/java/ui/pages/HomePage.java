/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class HomePage extends BasePageObject {
    @FindBy(linkText = "Institutions")
    @CacheLookup
    private WebElement linkText;

    public HomePage(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public boolean isPartnersDisplayed() {
        return (linkText.getText().equalsIgnoreCase("Institutions"))? true : false;
    }
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(linkText));
    }
}