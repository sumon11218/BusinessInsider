package PageObjects;

import ReusableObjects.Abstract_Class;
import ReusableObjects.Reusable_Methods;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class RegionalPage extends Abstract_Class {

    ExtentTest extentTest;
    public RegionalPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.extentTest = super.logger;
    }
    @FindBy(xpath = "//figure[@data-e2e-name='image-figure-image']")
    @CacheLookup public static List<WebElement> slideImage;

    //page object method displaying slideshow images count
    public RegionalPage displaySlideImageCount() throws IOException {
        Reusable_Methods.getArticleImagesCount(extentTest,driver,slideImage);
        return new RegionalPage(driver);
    }



}//end of RegionalPage class
