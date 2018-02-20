package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import selenium.browsers.WebDriverFactory;
import selenium.utils.DriverHelper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:03 PM
 * purpose of the class is to describe html elements on page
 * https://sinoptik.ua/
 * pageObject pattern is implemented
 */
public class SinoptikUaPage implements iPage {

    private static By searchCityFieldLocator = By.id("search_city");
    private static By searchCityButtonLocator = By.xpath("//input[@class='search_city-submit']");
    private static By sundayDayLocator = By.xpath("//a[@class='day-link' and text()='Воскресенье']");//todo would be more nice to parametrize this string
    private static By pressuresLocator = By.xpath("//tr[@class='temperatureSens']/following-sibling::tr[1]/td");


    @Override
    public boolean isOnPage() {
        return DriverHelper.isElementPresent(searchCityFieldLocator) && !DriverHelper.getTitle().isEmpty() && DriverHelper.getTitle().startsWith("SINOPTIK:");
    }

    public void pressEnter() {
        DriverHelper.findElement(searchCityButtonLocator).sendKeys(Keys.RETURN);
    }

    public void fillSearchField(String str) {
        DriverHelper.type(searchCityFieldLocator, str);
    }

    public void clickSunday(){
        DriverHelper.click(sundayDayLocator);
    }

    //*prints pressures of selected day*/
    public Collection<String> getPressures(){
        Collection<WebElement> pressuresElements = WebDriverFactory.getDriver().findElements(pressuresLocator);

        ArrayList<String> pressuresValues = new ArrayList<>();
        //todo move this logic to actions
        for(WebElement searchResult: pressuresElements)
            if(searchResult.isDisplayed()){
            pressuresValues.add(searchResult.getText());
        }

        return pressuresValues;
    }
}
