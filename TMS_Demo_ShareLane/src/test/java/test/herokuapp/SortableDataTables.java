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

public class SortableDataTables {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");

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
    public void sortableDataTablesTest() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".tablesorter thead tr th"));
        for (WebElement element : elements) {
            Assert.assertEquals(elements.get(0).getText(), "Last Name");
            Assert.assertEquals(elements.get(1).getText(), "First Name");
            Assert.assertEquals(elements.get(2).getText(), "Email");
            Assert.assertEquals(elements.get(3).getText(), "Due");
            Assert.assertEquals(elements.get(4).getText(), "Web Site");
            Assert.assertEquals(elements.get(5).getText(), "Action");
        }
        List<WebElement> johnSmith = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        for (WebElement element : johnSmith) {
            Assert.assertEquals(johnSmith.get(0).getText(), "Smith");
            Assert.assertEquals(johnSmith.get(1).getText(), "John");
            Assert.assertEquals(johnSmith.get(2).getText(), "jsmith@gmail.com");
            Assert.assertEquals(johnSmith.get(3).getText(), "$50.00");
            Assert.assertEquals(johnSmith.get(4).getText(), "http://www.jsmith.com");
            Assert.assertEquals(johnSmith.get(5).getText(), "edit delete");
        }
        List<WebElement> bachFrank = driver.findElements(By.xpath("//tbody/tr[2]/td"));
        for (WebElement element : bachFrank) {
            Assert.assertEquals(bachFrank.get(0).getText(), "Bach");
            Assert.assertEquals(bachFrank.get(1).getText(), "Frank");
            Assert.assertEquals(bachFrank.get(2).getText(), "fbach@yahoo.com");
            Assert.assertEquals(bachFrank.get(3).getText(), "$51.00");
            Assert.assertEquals(bachFrank.get(4).getText(), "http://www.frank.com");
            Assert.assertEquals(bachFrank.get(5).getText(), "edit delete");
        }
        List<WebElement> doeJason = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        for (WebElement element : doeJason) {
            Assert.assertEquals(doeJason.get(0).getText(), "Doe");
            Assert.assertEquals(doeJason.get(1).getText(), "Jason");
            Assert.assertEquals(doeJason.get(2).getText(), "jdoe@hotmail.com");
            Assert.assertEquals(doeJason.get(3).getText(), "$100.00");
            Assert.assertEquals(doeJason.get(4).getText(), "http://www.jdoe.com");
            Assert.assertEquals(doeJason.get(5).getText(), "edit delete");
        }
        List<WebElement> timConway = driver.findElements(By.xpath("//tbody/tr[4]/td"));
        for (WebElement element : timConway) {
            Assert.assertEquals(timConway.get(0).getText(), "Conway");
            Assert.assertEquals(timConway.get(1).getText(), "Tim");
            Assert.assertEquals(timConway.get(2).getText(), "tconway@earthlink.net");
            Assert.assertEquals(timConway.get(3).getText(), "$50.00");
            Assert.assertEquals(timConway.get(4).getText(), "http://www.timconway.com");
            Assert.assertEquals(timConway.get(5).getText(), "edit delete");
        }
    }

}
