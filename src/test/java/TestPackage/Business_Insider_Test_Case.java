package TestPackage;

import PageObjects.BaseClass;
import PageObjects.TravelPage;
import ReusableObjects.Abstract_Class;
import ReusableObjects.Reusable_Methods;
import org.jsoup.Connection;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.PrimitiveIterator;

import static PageObjects.BaseClass.regionalPage;
import static PageObjects.BaseClass.travelPage;

public class Business_Insider_Test_Case extends Abstract_Class {

    @Test(priority = 1)
    public void testTravelPage() throws IOException, InterruptedException {

        //1. Navigate to https://www.thisisinsider.com/
        Reusable_Methods.navigate(logger,driver,"https://www.thisisinsider.com/");

        //2. Verify loaded page title matches “INSIDER”
        Reusable_Methods.compareTitle(logger,driver,"INSIDER");

        //3. On the navigation bar, click on “TRAVEL”
        travelPage().clickOnTravel();

        //4. Verify loaded page title contains "Travel - INSIDER" and URL is https://www.thisisinsider.com/travel
        Reusable_Methods.compareTitle(logger,driver,"Travel - INSIDER");
        Reusable_Methods.compareUrl(logger,driver,"https://www.thisisinsider.com/travel");

        /*5. Print the URL, title and author byline of the first left-side article result
             e.g.
             https://www.thisisinsider.com/regional-thanksgiving-dishes-us-2017-11
             What Thanksgiving dinner looks like in 16 regions across the country
             Author: Joanna Fantozzi - Post Date: 27m - Page Views: 48,202
         */
        travelPage().articleTitleAndAuthor(0);

    }//end of testTravelPage method

    @Test(priority = 2)
    public void testRegionalPage() throws IOException, InterruptedException {

        //Navigate to https://www.thisisinsider.com/regional-thanksgiving-dishes-us-2017-11. And create two methods.
        Reusable_Methods.navigate(logger,driver,"https://www.thisisinsider.com/regional-thanksgiving-dishes-us-2017-11");

        //6.1 getArticleImagesCount(webelement). webelement for this particular example would be a section html tag with css selector
        // 'section[data-post-type="slideshow"]' which is the article body content.
        // This method should get the count of the total number of images
        // contained in the webelement excluding images found in ads
        // (their class name is ‘slideshow-vaop-ad ad’). Print the restult afterwards.
        regionalPage().displaySlideImageCount();

        //scroll to the bottom fo the page where the category links are
        Thread.sleep(1500);
        jse.executeScript("scroll(0,10000);");

        //6.2 getCategories(boolean). Categories css selector is [data-e2e-name='category-wrapper']
        // and is found at the bottom of the article.



    }//end of testRegionalPage method

}//end of class
