package test.shareLane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShoppingCartTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }

    @AfterMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void openShoppingCartUnregister(){

        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement linkShoppingCart = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']"));
        linkShoppingCart.click();
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td/span"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message ");
        Assert.assertEquals(errorMessage.getText(), "Oops, error. You must log in");
    }
    @Test
    public void addBookInShoppingCartUnregister(){

        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement searchField = driver.findElement(By.cssSelector("input[type='text']"));
        searchField.click();
        searchField.sendKeys("War and Peace");
        WebElement searchButton = driver.findElement(By.cssSelector("input[type='submit']"));
        searchButton.click();
        WebElement addButton = driver.findElement(By.cssSelector("a[href='./add_to_cart.py?book_id=4']"));
        addButton.click();
        WebElement errorMessage = driver.findElement(By.cssSelector("span[class='error_message']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message ");
        Assert.assertEquals(errorMessage.getText(), "Oops, error. You must log in");

    }
    @Test
    public void addBookWithRegisterUserButNotLogin(){
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement signupLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        signupLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();
        WebElement fieldFirstName = driver.findElement(By.cssSelector("input[name='first_name']"));
        fieldFirstName.sendKeys("Natallia");
        WebElement fieldEmail = driver.findElement(By.cssSelector("input[name='email']"));
        fieldEmail.sendKeys("Valdemor149@gmail.com");
        WebElement fieldPassword = driver.findElement(By.cssSelector("input[name='password1']"));
        fieldPassword.sendKeys("11111");
        WebElement fieldConfirmPassword = driver.findElement(By.cssSelector("input[name='password2']"));
        fieldConfirmPassword.sendKeys("11111");
        WebElement buttonRegister = driver.findElement(By.cssSelector("input[value='Register']"));
        buttonRegister.click();
        WebElement searchField = driver.findElement(By.cssSelector("input[type='text']"));
        searchField.click();
        searchField.sendKeys("War and Peace");
        WebElement searchButton = driver.findElement(By.cssSelector("input[type='submit']"));
        searchButton.click();
        WebElement addButton = driver.findElement(By.cssSelector("a[href='./add_to_cart.py?book_id=4']"));
        addButton.click();
        WebElement linkShoppingCart = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']"));
        linkShoppingCart.click();
        WebElement errorMessage = driver.findElement(By.cssSelector("span[class='error_message']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message ");
        Assert.assertEquals(errorMessage.getText(), "Oops, error. You must log in");

    }
    @Test
    public void addBookWithLoginUser(){
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement linkTestPortal = driver.findElement(By.cssSelector("a[href='../test_portal.html']"));
        linkTestPortal.click();
        WebElement linkAccountCreator = driver.findElement(By.cssSelector("a[href='../cgi-bin/create_account.py']"));
        linkAccountCreator.click();
        WebElement buttonCreateUser = driver.findElement(By.cssSelector("input[value='Create new user account']"));
        buttonCreateUser.click();
        WebElement buttonAutoLogin = driver.findElement(By.cssSelector("input[value='Auto Login']"));
        buttonAutoLogin.click();
        WebElement searchField = driver.findElement(By.cssSelector("input[type='text']"));
        searchField.click();
        searchField.sendKeys("War and Peace");
        WebElement searchButton = driver.findElement(By.cssSelector("input[type='submit']"));
        searchButton.click();
        WebElement addButton = driver.findElement(By.cssSelector("a[href='./add_to_cart.py?book_id=4']"));
        addButton.click();
        WebElement linkShoppingCart = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']"));
        linkShoppingCart.click();
        WebElement buttonCheckout = driver.findElement(By.cssSelector("input[value='Proceed to Checkout']"));
        Assert.assertTrue(buttonCheckout.isDisplayed());

    }
    @Test
    public void changeQuantityInShoppingCart(){
        driver.get("https://www.sharelane.com");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement linkTestPortal = driver.findElement(By.cssSelector("a[href='../test_portal.html']"));
        linkTestPortal.click();
        WebElement linkAccountCreator = driver.findElement(By.cssSelector("a[href='../cgi-bin/create_account.py']"));
        linkAccountCreator.click();
        WebElement buttonCreateUser = driver.findElement(By.cssSelector("input[value='Create new user account']"));
        buttonCreateUser.click();
        WebElement buttonAutoLogin = driver.findElement(By.cssSelector("input[value='Auto Login']"));
        buttonAutoLogin.click();
        WebElement searchField = driver.findElement(By.cssSelector("input[type='text']"));
        searchField.click();
        searchField.sendKeys("War and Peace");
        WebElement searchButton = driver.findElement(By.cssSelector("input[type='submit']"));
        searchButton.click();
        WebElement addButton = driver.findElement(By.cssSelector("a[href='./add_to_cart.py?book_id=4']"));
        addButton.click();
        WebElement linkShoppingCart = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']"));
        linkShoppingCart.click();
        WebElement fieldQuantity = driver.findElement(By.cssSelector("input[name='q']"));
        fieldQuantity.click();
        fieldQuantity.clear();
        fieldQuantity.sendKeys("2");
        WebElement buttonUpdate = driver.findElement(By.cssSelector("input[value='Update']"));
        buttonUpdate.click();
        WebElement total = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]"));
        WebElement updateText = driver.findElement(By.cssSelector("span[class='confirmation_message']"));
        Assert.assertEquals(total.getText(),"21.40");
        Assert.assertTrue(updateText.isDisplayed(), "Confirmation message ");
        Assert.assertEquals(updateText.getText(), "Cart Updated");

    }

}
