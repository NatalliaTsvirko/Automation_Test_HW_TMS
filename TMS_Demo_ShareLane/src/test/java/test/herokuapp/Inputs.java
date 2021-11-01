package test.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Inputs {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");

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
    public void actionInputsWithButton() {
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(Keys.ARROW_UP);
        String upKeyResult = driver.findElement(By.cssSelector("input[type='number']")).getAttribute("value");
        Assert.assertEquals(upKeyResult, "1");
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        String downKeyResult = driver.findElement(By.cssSelector("input[type='number']")).getAttribute("value");
        Assert.assertEquals(downKeyResult, "-3");
    }

    @Test
    public void actionInputWithHandLetter() {
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys("Hey");
        String letterResult = driver.findElement(By.cssSelector("input[type='number']")).getAttribute("value");
        Assert.assertEquals(letterResult, "");
    }

    @Test
    public void actionInputWithHandDigit(){
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys("37");
        String digitResult = driver.findElement(By.cssSelector("input[type='number']")).getAttribute("value");
        assertEquals(digitResult, "37");
    }
}
