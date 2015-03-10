package utils;

/**
 * Created by SumitBhatia on 28/02/15.
 */
public class NavigationUtils {

    private enum NavigationItems{
        BISHOPS("Bishops"),
        HISTORY("History"),
        CONTACTUS("Contact us"),
        ABOUT("About");

        private String navItem;

        NavigationItems(String navItem) {
            this.navItem = navItem;
        }
    }
}
