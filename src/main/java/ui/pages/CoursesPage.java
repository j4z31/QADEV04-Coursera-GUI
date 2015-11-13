/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/12/15
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;

public class CoursesPage extends BasePageObject {
    public CoursesPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public void waitUntilPageObjectIsLoaded() {
    }
}

