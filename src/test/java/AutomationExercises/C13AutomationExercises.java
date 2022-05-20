package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C13AutomationExercises {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }
    @Test
    public void test1() throws AWTException, InterruptedException {
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'View Product' for any product on home page
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_4);
        driver.findElement(By.xpath("//a[@href='/product_details/2']")).click();
        //5. Verify product detail is opened
        WebElement detail = driver.findElement(By.className("product-information"));
        Assert.assertTrue(detail.isDisplayed());
        //6. Increase quantity to 4
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).sendKeys("4");
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        WebElement cart = driver.findElement(By.xpath("//button[@class='disabled']"));
        Assert.assertTrue(cart.getText().contains("4"));

    }
}
