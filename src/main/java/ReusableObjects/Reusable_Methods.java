package ReusableObjects;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Reusable_Methods {

    //method ro navigating to a page
    public static void navigate(ExtentTest logger,WebDriver driver, String url) throws IOException {
        try{
            //System.out.print("Navigating to " + url);
            logger.log(LogStatus.INFO,"Navigating to " + url);
            driver.navigate().to(url);
        }catch (Exception err) {
            //System.out.println("Unable to navigate to the url... " + err);
            logger.log(LogStatus.FAIL,"Unable to navigate to the url... " + err);
            getScreenshot(driver,logger,"URL Error");
        }
    }//end of navigate method

    //method for clicking on an element
    public static void clickMethod(ExtentTest logger,WebDriver driver, WebElement element, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        try{
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            //store the locator into WebElement variable
            WebElement clickbtn = wait.until(ExpectedConditions.visibilityOf(element));
            clickbtn.click();
            //logger.log(LogStatus.PASS,"Succesfully clicked on the element " + elementName);
        }catch (Exception err){
            //System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName);
            getScreenshot(driver,logger,elementName);
        }//end of try catch
    }//end of click method

    //method for clicking on an element
    public static void clickMethodByIndex(ExtentTest logger,WebDriver driver, List<WebElement> element, int indexNumber,String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        try{
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            //store the locator into WebElement variable
            List<WebElement> clickbtn = wait.until(ExpectedConditions.visibilityOfAllElements(element));
            clickbtn.get(indexNumber).click();
            //logger.log(LogStatus.PASS,"Succesfully clicked on the element " + elementName);
        }catch (Exception err){
            //System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName);
            getScreenshot(driver,logger,elementName);
        }//end of try catch
    }//end of click method

    //method for clearing on an element
    public static void clearMethod(ExtentTest logger,WebDriver driver, WebElement element, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        try{
            System.out.println("Clearing on element " + elementName);
            logger.log(LogStatus.INFO,"Clearing on element " + elementName);
            //store the locator into WebElement variable
            WebElement clrBtn = wait.until(ExpectedConditions.visibilityOf(element));;
            clrBtn.clear();
        }catch (Exception err){
            logger.log(LogStatus.FAIL,"Unable to clear on element " + elementName + " " + err);
            System.out.println("Unable to clear on element " + elementName + " " + err);
            getScreenshot(driver,logger,elementName);
        }//end of try catch
    }//end of clear method

    //method for entering on an element
    public static void sendKeysMethod(ExtentTest logger,WebDriver driver, WebElement element, String userInput, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        try{
            //System.out.println("Entering " + userInput + " in element " + elementName);
            logger.log(LogStatus.INFO,"Entering " + userInput + " in element " + elementName);
            //store the locator into WebElement variable
            WebElement input = wait.until(ExpectedConditions.visibilityOf(element));
            input.sendKeys(userInput);
        }catch (Exception err){
            //System.out.println("Unable to send info on element " + elementName);
            logger.log(LogStatus.FAIL,"Unable to send info on element " + elementName);
            getScreenshot(driver,logger,elementName);
        }//end of try catch
    }//end of Send Keys method

    //method for compareTitle
    public static void compareTitle(ExtentTest logger,WebDriver driver,String expectedTitle){
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            logger.log(LogStatus.PASS,"Expected title matches -- " + expectedTitle);
            System.out.println("Expected title matches -- " + expectedTitle);
        } else {
            logger.log(LogStatus.FAIL,"Title doesn't match.. Actual is -- " + actualTitle);
            System.out.println("Title doesn't match. Actual is -- " + actualTitle);
        }
    }//end of compareTitle method

    //method for compareTitle
    public static void compareUrl(ExtentTest logger,WebDriver driver,String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            logger.log(LogStatus.PASS,"Expected URL matches -- " + expectedUrl);
            System.out.println("Expected URL matches -- " + expectedUrl);
        } else {
            logger.log(LogStatus.FAIL,"URL doesn't match.. Actual is -- " + actualUrl);
            System.out.println("URL doesn't match. Actual is -- " + actualUrl);
        }
    }//end of compareTitle method

    //method for getText
    public static String captureText(ExtentTest logger, WebDriver driver, List<WebElement> element, int indexNumber, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        String textValue = null;
        try{
            //System.out.println("Capturing text " + elementName);
            //logger.log(LogStatus.INFO,"Capturing text " + elementName);
            textValue = wait.until(ExpectedConditions.visibilityOfAllElements(element)).get(indexNumber).getText();
            logger.log(LogStatus.PASS,"Text " + elementName + " is " + textValue);
            System.out.println("Text " + elementName + " is " + textValue);
        }catch (Exception err){
            System.out.println("Unable to capture text " + elementName + " " + err);
            logger.log(LogStatus.FAIL,"Unable to capture text " + elementName);
            getScreenshot(driver,logger,elementName);
        }//end of try catch
        return textValue;
    }//end of capture text method

    //count for all article images
    public static int getArticleImagesCount(ExtentTest logger, WebDriver driver,List<WebElement> element) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        List<WebElement> imgCount = null;
        int imgCountSize = 0;
        try{
            imgCount = wait.until(ExpectedConditions.visibilityOfAllElements(element));
            logger.log(LogStatus.INFO,"Image count is " + imgCount.size());
            System.out.println("Images count is " + imgCount.size());
            imgCountSize = imgCount.size();
        }catch (Exception err) {
            logger.log(LogStatus.INFO,"Unable to get images count");
            getScreenshot(driver,logger,"Image Count");
        }
        return imgCountSize;
    }


    public static void getCategories(ExtentTest logger, WebDriver driver,List<WebElement> linkElement,WebElement dropDownElement,boolean trueFalse){
        WebDriverWait wait = new WebDriverWait(driver,20);
        List<WebElement> elements,categoryElements;
        try {
            elements = wait.until(ExpectedConditions.visibilityOfAllElements(linkElement));
            for(int i =0; i<elements.size();i++) {
                if (trueFalse == true) {
                    //System.out.println("");
                } else {

                }
            }
        } catch (Exception err) {


        }
    }

    //method for capturing screenshot when element fails
    public static void getScreenshot(WebDriver driver, ExtentTest logger, String screenshotName) throws IOException {
        // String path = "C:\\Users\\sumon.kashem\\Desktop\\Screenshots\\";
        String path = "src\\main\\java\\Report_Folder\\ScreenShots\\";
        String fileName = screenshotName + ".png";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Now you can do whatever you need to do with, for example copy somewhere
        FileUtils.copyFile(sourceFile, new File(path + fileName));
        //String imgPath = directory + fileName;
        String image = logger.addScreenCapture("ScreenShots\\" + fileName);
        logger.log(LogStatus.FAIL, "", image);
    }



}//end of parent class
