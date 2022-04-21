package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        // Click on Register link
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        driver.findElement(By.linkText("Signing up is easy!"));
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        // Click on Register link
        driver.findElement(By.linkText("Register")).click();
        // Enter First name
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Umi");
        // Enter Last name
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Patel");
        //Enter Address
        driver.findElement((By.xpath("//input[@id='customer.address.street']"))).sendKeys("Queen Road");
        driver.findElement((By.xpath("//input[@id='customer.address.city']"))).sendKeys("London");
        driver.findElement((By.xpath("//input[@id='customer.address.state']"))).sendKeys("England");
        driver.findElement((By.xpath("//input[@id='customer.address.zipCode']"))).sendKeys("WA26RJ");
        //Enter Phone, SSN, Username, Password and Confirm Password
        driver.findElement((By.xpath("//input[@id='customer.phoneNumber']"))).sendKeys("umipatel@gmail.com");
        driver.findElement((By.xpath("//input[@id='customer.ssn']"))).sendKeys("123abc");
        driver.findElement((By.xpath("//input[@id='customer.username']"))).click();
        driver.findElement((By.xpath("//input[@id='customer.password']"))).sendKeys("umi123");
        driver.findElement((By.xpath("//input[@id='repeatedPassword']"))).sendKeys("umi123");
        // Click Register button
        driver.findElement((By.xpath("//tbody/tr[13]/td[2]/input[1]"))).click();
    }

    @After
    public void stop() {
        closeBrowser();

    }

}

