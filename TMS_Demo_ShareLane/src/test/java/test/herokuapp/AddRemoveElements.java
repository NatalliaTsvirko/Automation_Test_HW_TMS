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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveElements {


    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

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
    public void addRemoveElements() {

        WebElement buttonAdd = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i <= 2; i++) {
            buttonAdd.click();
        }
        List<WebElement> deleteElements = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        for (int i = 0; i <= 1; i++) {
            deleteElements.get(1).click();
        }
        deleteElements = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteElements.size(), 1);
    }
}


