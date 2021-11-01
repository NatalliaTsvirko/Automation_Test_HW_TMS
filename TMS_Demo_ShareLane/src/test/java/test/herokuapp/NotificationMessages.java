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

public class NotificationMessages {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

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
    public void notificationMessageTest() {
        WebElement clickLink = driver.findElement(By.cssSelector("a[href='/notification_message']"));
        clickLink.click();
        WebElement notificationMessage = driver.findElement(By.xpath("//*[@id='flash']"));
        while (true) {
            if (notificationMessage.getText() == "Action unsuccesful, please try again\n" + "×") {
                Assert.assertEquals(notificationMessage.getText(),"Action unsuccesful, please try again\n" + "×");
            }
            break;
        }
    }
}
