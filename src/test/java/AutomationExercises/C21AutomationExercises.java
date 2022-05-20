package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;

public class C21AutomationExercises extends TestBase {
    @Test
    public void test1() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement verifyAlPrd = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyAlPrd.isDisplayed());
        //5. Click on 'View Product' button
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //6. Verify 'Write Your Review' is visible
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement writeReview = driver.findElement(By.xpath("//a[normalize-space()='Write Your Review']"));
        Assert.assertTrue(writeReview.isDisplayed());
        //7. Enter name, email and review
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("evren");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("evren@gmail.com");
        driver.findElement(By.xpath("//textarea[@id='review']")).sendKeys("test");
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//button[@id='button-review']")).click();
        //9. Verify success message 'Thank you for your review.'
        WebElement reviewSuc = driver.findElement(By.xpath("//div[@id='review-section']"));
        Assert.assertTrue(reviewSuc.isDisplayed());
    }
}
