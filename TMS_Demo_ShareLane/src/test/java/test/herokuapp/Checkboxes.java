package test.herokuapp;

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

public class Checkboxes {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
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
    public void checkboxesTest() {
        WebElement elementChecked = driver.findElement(By.cssSelector("input[type='checkbox']"));
        elementChecked.isEnabled();
        elementChecked.click();
        Assert.assertTrue(elementChecked.isSelected());
        WebElement elementUnchecked = driver.findElement(By.cssSelector("input[type='checkbox']"));
        elementUnchecked.isSelected();
        elementUnchecked.click();
        Assert.assertTrue(elementUnchecked.isEnabled());
    }
}
