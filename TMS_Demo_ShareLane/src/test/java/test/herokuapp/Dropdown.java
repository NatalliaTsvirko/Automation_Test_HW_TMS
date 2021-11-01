package test.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dropdown");

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
    public void actionDropdownTest() {
        Select selectAllElementsOfDropdown = new Select(driver.findElement(By.cssSelector("select[id='dropdown']")));
        List<WebElement> allElements = selectAllElementsOfDropdown.getOptions();
        Assert.assertEquals(allElements.size(), 3);
    }

    @Test
    public void actionDropdownFirstOption() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        driver.findElement(By.id("dropdown")).click();
        dropdown.selectByVisibleText("Option 1");
        Assert.assertTrue(driver.findElement(By.cssSelector("option[value='1']")).isSelected());
    }

    @Test
    public void actionDropdownSecondOption() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        driver.findElement(By.id("dropdown")).click();
        dropdown.selectByVisibleText("Option 2");
        Assert.assertTrue(driver.findElement(By.cssSelector("option[value='2']")).isSelected());
    }
}



