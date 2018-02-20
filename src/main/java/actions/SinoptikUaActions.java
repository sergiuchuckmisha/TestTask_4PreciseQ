package actions;

import pageObjects.GooglePage;
import pageObjects.SinoptikUaPage;
import selenium.utils.DriverHelper;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on Calender page
 */
public class SinoptikUaActions extends ActionsBase<SinoptikUaPage> {

    private static String url = "https://sinoptik.ua";

    /**
     * purpose of the constructor is to initialize page field
     */
    public SinoptikUaActions() {
        super();
        page = new SinoptikUaPage();//in this case we
    }

    @Override
    public void navigateTo() {
        if (!page.isOnPage())
            DriverHelper.navigateToCertainUrl(url);
    }


    public SinoptikUaActions searchString(String searchString) {
        page.fillSearchField(searchString);
        page.pressEnter();
        DriverHelper.waitUntilPageIsLoaded();
        return this;
    }

    public SinoptikUaActions verifyPressures(int min, int max) {
        Collection<String> pressureStringValues = page.getPressures();

        //check of state
        if (4 != pressureStringValues.size()) {
            System.out.println("pressures: " + String.valueOf(pressureStringValues));
            throw new IllegalStateException(String.format("exactly 4 pressures are expected: for night, morning, day and evening. But %d is observed", pressureStringValues.size()));
        }

        for (String pressureString : pressureStringValues) {
            int pressureInt = Integer.parseInt(pressureString);
            if (min > pressureInt || max < pressureInt) {
                throw new IllegalStateException(String.format("wrong pressure is observed.\n observed: %d\n min: %d\n max %d", pressureInt, min, max));
            }
        }

        return this;
    }

    public SinoptikUaActions clickSunday() {
        page.clickSunday();
        return this;
    }
}
