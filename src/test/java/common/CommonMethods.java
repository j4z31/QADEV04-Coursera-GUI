/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/19/15
 * Time: 6:38 PM
 * To change this template use File | Settings | File Templates.
 */
package common;

import ui.PageTransporter;

public class CommonMethods {
    private static PageTransporter pageTransporter = PageTransporter.getInstance();
    public static boolean isLogin;

    public static void logOut() {
        pageTransporter
                .navigateToHomePage()
                .clickAuthenticatedDropdownButton()
                .clickSignOutButton()
        ;
        isLogin = false;
    }

    public static void logIn() {
        pageTransporter
                .navigateToMainPage()
                .clickLogInButton()
                .loginSuccessful("Jhasmany.Quiroz@fundacion-jala.org", "1c7hu57&7")
        ;
        isLogin = true;
    }
}
