package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // Find the username field element
        WebElement emailField = driver.findElement(By.name("username"));
        // Sending username to username field element
        emailField.sendKeys("prime123");

        // Find the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // Sending Password to password field element
        passwordField.sendKeys("Prime123!");

        //Find the login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginButton.click();

    }



    @Test
    public void verifyTheErrorMessage() {

        // Find the username field element
        WebElement emailField = driver.findElement(By.name("username"));
        // Sending username to username field element
        emailField.sendKeys("prime");

        // Find the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // Sending Password to password field element
        passwordField.sendKeys("xyz!");

        //Find the login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginButton.click();

        String expectedErrorMessage = "The username and password could not be verified.";
        String actualErrorMessage = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]")).getText();

        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {

        // Find the username field element
        WebElement emailField = driver.findElement(By.name("username"));
        // Sending username to username field element
        emailField.sendKeys("prime123");

        // Find the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // Sending Password to password field element
        passwordField.sendKeys("Prime123!");

        //Find the login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginButton.click();

        //Find the logout button and click on it
        WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logoutButton.click();

        String expectedErrorMessage = "Customer Login";
        String actualErrorMessage = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]")).getText();

        // Validate actual and expected message
        Assert.assertEquals("Customer Login not displayed", expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}



