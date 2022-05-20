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

public class C11AutomationExercises {
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
        driver.close();
    }
    @Test
    public void test1() throws AWTException, InterruptedException {
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'Cart' button
        driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
        //5. Scroll down to footer
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        //6. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        //7. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("evren@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        //8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='success-subscribe']"));
        Assert.assertTrue(successMessage.isDisplayed());
    }
}
