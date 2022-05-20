package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02AutomationExercises {
    /*
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup / Login' button
      5. Verify 'Login to your account' is visible
      6. Enter correct email address and password
      7. Click 'login' button
      8. Verify that 'Logged in as username' is visible
      9. Click 'Delete Account' button
      10. Verify that 'ACCOUNT DELETED!' is visible
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void finish() {
        driver.close();
    }
    @Test
    public void test1() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        if (homePage.isDisplayed()){
            System.out.println("HomePage testing PASSED");
        }else System.out.println("HomePage testing FAILED");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAcc = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        if (loginToYourAcc.isDisplayed()){
            System.out.println("Testing PASSED");
        }else System.out.println("Testing FAILED");
        //6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("evren@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("passwords");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement LoggedInAsUserName = driver.findElement(By.xpath("//li[9]//a[1]"));
        if (LoggedInAsUserName.isDisplayed()){
            System.out.println("Testing PASSED");
        }else System.out.println("Testing FAILED");
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDelete = driver.findElement(By.xpath("//h1[normalize-space()='Delete Account']"));
        if (accountDelete.isDisplayed()){
            System.out.println("Testing is PASSED");
        }else System.out.println("Testing is FAILED");
    }
}
