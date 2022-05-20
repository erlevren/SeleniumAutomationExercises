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

public class C15AutomationExercises {
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
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("adminuser1123456789");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("adminuser1123456789@gmail.com");
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("name");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        WebElement daySlct = driver.findElement(By.xpath("//select[@id='days']"));
        daySlct.click();
        daySlct.sendKeys("23");
        daySlct.click();
        WebElement monthSlct = driver.findElement(By.xpath("//select[@id='months']"));
        monthSlct.click();
        monthSlct.sendKeys("may");
        monthSlct.click();
        WebElement yearSlct = driver.findElement(By.xpath("//select[@id='years']"));
        yearSlct.click();
        yearSlct.sendKeys("1980");
        yearSlct.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("evren");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("evren");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("cosmos");
        WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys("Antalya , 1234 ");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys(" 10/2");
        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        country.click();
        country.sendKeys("canada");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("afyon");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("manisa");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("123546");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("6546879");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        WebElement accCreate = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        Assert.assertTrue(accCreate.isDisplayed());
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreate = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(accountCreate.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
        //7. Verify ' Logged in as username' at top
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
        //8. Add products to cart
        Robot rbt = new Robot();
        rbt.mouseWheel(4);
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        //9. Click 'Cart' button
        driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
        //10. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());
        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //12. Verify Address Details and Review Your Order
        WebElement adress = driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
        Assert.assertTrue(adress.isDisplayed());
        WebElement review = driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
        Assert.assertTrue(review.isDisplayed());
        //13. Enter description in comment text area and click 'Place Order'
        rbt.mouseWheel(7);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Testtest test");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("erolevren");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("12341234");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("51");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("65");
        //15. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        //16. Verify success message 'Your order has been placed successfully!'
        WebElement success = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(success.isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        //Bu sayfa yok
    }
}
