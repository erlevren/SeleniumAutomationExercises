package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C22AutomationExercises extends TestBase {
    @Test
    public void test1() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Scroll to bottom of page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement recommended = driver.findElement(By.xpath("//h2[normalize-space()='recommended items']"));
        Assert.assertTrue(recommended.isDisplayed());
        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[69]")).click();
        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("(//p[@class='text-center'])[2]")).click();
        //7. Verify that product is displayed in cart page
        WebElement prdDetails = driver.findElement(By.xpath("//button[@class='disabled']"));
        Assert.assertTrue(prdDetails.isDisplayed());
    }
}
