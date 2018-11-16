package PageObjects;

import ReusableObjects.Abstract_Class;
import ReusableObjects.Reusable_Methods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.io.IOException;
import java.util.List;

public class TravelPage extends Abstract_Class {

    ExtentTest extentTest;
    public TravelPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.extentTest = super.logger;
    }
    @FindBy(xpath = "//*[@data-dropdown-id='dropdown-Travel']")
    @CacheLookup public static WebElement travelTab;
    @FindBy(css = "a.title")
    @CacheLookup public static List<WebElement> articleTitle;
    @FindBy(xpath = "//div[@class='list-pipes no-pipe']")
    @CacheLookup public static List<WebElement> articleAuthor;
    @FindBy(xpath = "//img[@class='river-thumb']")
    @CacheLookup public static List<WebElement> articleThumbUrl;

    //page object method for clicking on Travel Tab
    public TravelPage clickOnTravel() throws IOException {
        Reusable_Methods.clickMethod(extentTest,driver,travelTab,"Travel Tab");
        return new TravelPage(driver);
    }

    //page object method for getting article content with author
    public TravelPage articleTitleAndAuthor(int indexNumber) throws IOException, InterruptedException {
        String prviousUrl = driver.getCurrentUrl();
        Reusable_Methods.clickMethodByIndex(extentTest,driver,articleThumbUrl,indexNumber,"Thumbnail Image");
        Thread.sleep(2500);
        //thumbnail page url
        extentTest.log(LogStatus.INFO,"Image url is " + driver.getCurrentUrl());
        System.out.println("Image url is " + driver.getCurrentUrl());
        //navigate back to previous url to capture title and author
        Reusable_Methods.navigate(extentTest,driver,prviousUrl);
        Reusable_Methods.captureText(extentTest,driver,articleTitle,indexNumber,"Title");
        Reusable_Methods.captureText(extentTest,driver,articleAuthor,indexNumber,"Author");
        return new TravelPage(driver);
    }




}//end of TravelPage class
