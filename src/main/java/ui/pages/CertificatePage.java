/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/28/15
 * Time: 13:00 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

public class CertificatePage extends BasePageObject {
    @FindBy(className = "coursera-sigtrack-courses-no-courses")
    private WebElement txtNoCertificate;

    public boolean notCertificatePresent() {
        return txtNoCertificate
                .getText()
                .equalsIgnoreCase
                ("You have no Certificate Courses. Browse courses offering Certificates now »");
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
