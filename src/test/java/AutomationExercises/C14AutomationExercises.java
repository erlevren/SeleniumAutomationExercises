package AutomationExercises;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C14AutomationExercises {
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        //4. Add products to cart
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        //5. Click 'Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
        //6. Verify that cart page is displayed
        WebElement cardPage = driver.findElement(By.id("product-1"));
        Assert.assertTrue(cardPage.isDisplayed());
        //7. Click Proceed To Checkout
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")).click();
        //9. Fill all details in Signup and create account
        WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
        name.sendKeys("adminuser12345");
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("adminuser12345@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        WebElement userName = driver.findElement(By.xpath("//input[@id='name']"));
        userName.clear();
        userName.sendKeys("name");
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='password']"));
        userPassword.sendKeys("passwords");
        WebElement date = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        date.click();
        date.sendKeys("3");
        WebElement month = driver.findElement(By.xpath("//*[@id=\"months\"]"));
        month.click();
        month.sendKeys("may");
        WebElement year = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        year.click();
        year.sendKeys("1980");
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys("erol");
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastName.sendKeys("evren");
        WebElement company = driver.findElement(By.xpath("//*[@id=\"company\"]"));
        company.sendKeys("cosmos");
        WebElement adresses = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        adresses.sendKeys("antalya");
        WebElement adresses2 = driver.findElement(By.xpath("//*[@id=\"address2\"]"));
        adresses2.sendKeys("dosemealti");
        WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        country.click();
        country.sendKeys("canada".toLowerCase());
        WebElement state = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        state.sendKeys("usak");
        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("banaz");
        WebElement zipcode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        zipcode.sendKeys("07100");
        WebElement mobileNumber = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
        mobileNumber.sendKeys("123456789");
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreate = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(accountCreate.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //11. Verify ' Logged in as username' at top
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
        //12.Click 'Cart' button
        driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //14. Verify Address Details and Review Your Order
        WebElement ads = driver.findElement(By.xpath("(//*[@class='heading'])[1]"));
        Assert.assertTrue(ads.isDisplayed());
        WebElement review = driver.findElement(By.xpath("(//*[@class='heading'])[2]"));
        Assert.assertTrue(review.isDisplayed());
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("erol evren naber");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("987654321");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("12346798765");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2000");
        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        //18. Verify success message 'Your order has been placed successfully!'
        WebElement hiddens = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(hiddens.isDisplayed());
        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }
}
