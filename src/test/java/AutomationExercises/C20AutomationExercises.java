package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;
import java.util.List;

public class C20AutomationExercises extends TestBase {
    @Test
    public void test1() throws AWTException, InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement verifyAlPrd = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyAlPrd.isDisplayed());
        //5. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Winter Top");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement verifySerPrd = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifySerPrd.isDisplayed());
        //7. Verify all the products related to search are visible
        driver.navigate().back();
        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        for (WebElement w:allProducts) {
            String urunler = w.getText();
            System.out.println(urunler);
        }
        //8. Add those products to cart
        for (WebElement each : allProducts) {
            driver.findElement(By.xpath("//input[@id='search_product']")).clear();
            driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(each.getText());
            driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();
            Thread.sleep(2000);
            actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='modal-footer']")).click();
            Thread.sleep(1000);
            driver.navigate().back();
        }
        //9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        List<WebElement> allProductsSepet = driver.findElements(By.xpath("//td[@class='cart_description']"));
        Assert.assertEquals(allProductsSepet.size(), allProducts.size());
        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("evren@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("passwords");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //11. Again, go to Cart page
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        //12. Verify that those products are visible in cart after login as well
        allProductsSepet.forEach(WebElement::isDisplayed);


    }
}

