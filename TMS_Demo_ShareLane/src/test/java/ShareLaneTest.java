import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShareLaneTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
       WebDriverManager.chromedriver().setup();
        //Open browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void zipCodePositiveTest() {

        //Navigate to ShareLane()
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();

        //Click "Sign up" link
        WebElement signupLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signupLink.click();

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        //Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        //Verify that user is redirected to "Sign up" page
        WebElement registerButton = driver.findElement(By.cssSelector("input[value = 'Register']"));
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertFalse(zipCodeInput.isDisplayed(), "Zip code input should not be hidden");
        Assert.assertTrue(registerButton.isDisplayed(), "Register button should be displayed");

    }

    @Test
    public void emptyZipCodeTest() {
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();

        //Click "Sign up" link
        WebElement signupLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signupLink.click();

        //Input valid zip code
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));

        //Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        //Verify that user stayed on the "zip code" page and got an error message page
        zipCodeInput = driver.findElement(By.name("zip_code"));
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(zipCodeInput.isDisplayed(), "Zip code input should be displaed");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message ");
        Assert.assertEquals(errorMessage.getText(), "Oops, error on page. ZIP code should have 5 digits");

    }

    @Test
    public void zipCodeFourDigitTest() {
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();

        //Click "Sign up" link
        WebElement signupLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signupLink.click();

        //Input four digit in zip code field
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");

        //Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        //Verify that user stayed on the "zip code" page and got an error message page
        zipCodeInput = driver.findElement(By.name("zip_code"));
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(zipCodeInput.isDisplayed(), "Zip code input should be displayed");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message ");
        Assert.assertEquals(errorMessage.getText(), "Oops, error on page. ZIP code should have 5 digits");

    }

    @Test
    public void zipCodeSixDigitTest() {
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();

        //Click "Sign up" link
        WebElement signupLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signupLink.click();

        //Input six digit in zip code field
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");

        //Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        //Verify that user stayed on the "zip code" page and got an error message page
        zipCodeInput = driver.findElement(By.name("zip_code"));
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(zipCodeInput.isDisplayed(), "Zip code input should be displayed");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message ");
        Assert.assertEquals(errorMessage.getText(), "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void signUpPositiveTest() {
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();

        //Click "Sign up" link
        WebElement signupLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signupLink.click();

        //Input valid zip code
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        //Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        //Find fields registration form
        WebElement fieldFirstName = driver.findElement(By.cssSelector("input[name='first_name']"));
        fieldFirstName.sendKeys("Natallia");
        WebElement fieldEmail = driver.findElement(By.cssSelector("input[name='email']"));
        fieldEmail.sendKeys("Valdemor149@gmail.com");
        WebElement fieldPassword = driver.findElement(By.cssSelector("input[name='password1']"));
        fieldPassword.sendKeys("11111");
        WebElement fieldConfirmPassword = driver.findElement(By.cssSelector("input[name='password2']"));
        fieldConfirmPassword.sendKeys("11111");

        //Click "Register" button
        WebElement buttonRegister = driver.findElement(By.cssSelector("input[value='Register']"));
        buttonRegister.click();

        //Verify what account is created
        WebElement confirmationMessage = driver.findElement(By.cssSelector("span[class='confirmation_message']"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Confirmation message");
        Assert.assertEquals(confirmationMessage.getText(), "Account is created!");
    }

    @Test
    public void signUpThreeDigitPassword() {
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();

        //Click "Sign up" link
        WebElement signupLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signupLink.click();

        //Input valid zip code
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        //Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        //Fill in the form
        WebElement fieldFirstName = driver.findElement(By.cssSelector("input[name='first_name']"));
        fieldFirstName.sendKeys("Natallia");
        WebElement fieldEmail = driver.findElement(By.cssSelector("input[name='email']"));
        fieldEmail.sendKeys("Valdemor149@gmail.com");
        WebElement fieldPassword = driver.findElement(By.cssSelector("input[name='password1']"));
        fieldPassword.sendKeys("111");
        WebElement fieldConfirmPassword = driver.findElement(By.cssSelector("input[name='password2']"));
        fieldConfirmPassword.sendKeys("111");

        //Click "Register" button
        WebElement buttonRegister = driver.findElement(By.cssSelector("input[value='Register']"));
        buttonRegister.click();

        //Verify that user stayed on the register page and got an error message page
        WebElement errorMessage = driver.findElement(By.cssSelector("span[class='error_message']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message ");
        Assert.assertEquals(errorMessage.getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }
}
