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
import org.openqa.selenium.devtools.v97.indexeddb.model.Key;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C26AutomayionExercises {
    /*
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Verify that home page is visible successfully
       4. Scroll down page to bottom
       5. Verify 'SUBSCRIPTION' is visible
       6. Scroll up page to top
       7. Verify that page is scrolled up and
       'Full-Fledged practice website for Automation Engineers' text is visible on screen
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test() throws AWTException, InterruptedException {
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        WebElement subscription = driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_HOME);
        //driver.findElement(By.xpath("//*[@class='fa fa-angle-up']")).click();
        WebElement scrolledUp = driver.findElement(By.xpath("//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]"));
        Assert.assertTrue(scrolledUp.isDisplayed());


    }

}
