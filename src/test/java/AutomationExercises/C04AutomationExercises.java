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

import java.time.Duration;

public class C04AutomationExercises {
    /*
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Verify that home page is visible successfully
       4. Click on 'Signup / Login' button
       5. Verify 'Login to your account' is visible
       6. Enter correct email address and password
       7. Click 'login' button
       8. Verify that 'Logged in as username' is visible
       9. Click 'Logout' button
       10. Verify that user is navigated to login page
     */
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
    public void test1(){
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        WebElement loginTitle = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(loginTitle.isDisplayed());
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("evren@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("passwords");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebElement logged = driver.findElement(By.xpath("//li[9]//a[1]"));
        Assert.assertTrue(logged.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        WebElement loginScreen = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(loginScreen.isDisplayed());
    }
}
