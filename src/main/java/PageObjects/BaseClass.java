package PageObjects;

import ReusableObjects.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass extends Abstract_Class {
    public BaseClass(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    // Object for Travel Page
    public static TravelPage travelPage() {
        TravelPage travelPage = new TravelPage(driver);
        return travelPage;
    }

    // Object for Regional Page
    public static RegionalPage regionalPage() {
        RegionalPage regionalPage = new RegionalPage(driver);
        return regionalPage;
    }


}
