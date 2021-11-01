package test.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hovers {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/hovers");

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
    public void hoversTest() {
        Actions action = new Actions(driver);
        //Check first user
        WebElement firstUser = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        action.moveToElement(firstUser).moveToElement(firstUser).build().perform();
        WebElement nameFirstUser = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(nameFirstUser.isDisplayed(), "name: user1");
        WebElement linkFirstUser = driver.findElement(By.cssSelector("a[href='/users/1']"));
        linkFirstUser.click();
        WebElement errorMessageFirst = driver.findElement(By.xpath("/html/body/h1"));
        errorMessageFirst.getText();
        Assert.assertTrue(errorMessageFirst.isDisplayed(), "Not Found");
        driver.navigate().back();
        ////Check second user
        WebElement secondUser = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        action.moveToElement(secondUser).moveToElement(secondUser).build().perform();
        WebElement nameSecondUser = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(nameSecondUser.isDisplayed(), "name: user2");
        WebElement linkSecondUser = driver.findElement(By.cssSelector("a[href='/users/2']"));
        linkSecondUser.click();
        WebElement errorMessageSecond = driver.findElement(By.xpath("/html/body/h1"));
        errorMessageSecond.getText();
        Assert.assertTrue(errorMessageSecond.isDisplayed(), "Not Found");
        driver.navigate().back();
        //Check third user
        WebElement thirdUser = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        action.moveToElement(thirdUser).moveToElement(thirdUser).build().perform();
        WebElement nameThirdUser = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(nameThirdUser.isDisplayed(), "name: user3");
        WebElement linkThirdUser = driver.findElement(By.cssSelector("a[href='/users/3']"));
        linkThirdUser.click();
        WebElement errorMessageThird = driver.findElement(By.xpath("/html/body/h1"));
        errorMessageThird.getText();
        Assert.assertTrue(errorMessageThird.isDisplayed(), "Not Found");
        driver.navigate().back();
    }
}



