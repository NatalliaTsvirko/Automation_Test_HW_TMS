package test.herokuappTests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pages.ContextMenuPage;

import static test.pages.ContextMenuPage.ALERT_TEXT;

public class ContextMenuTest extends HerokuBaseTest {

    private ContextMenuPage contextMenuPage;

    @BeforeClass(alwaysRun = true)
    public void setContextMenuTests() {
        contextMenuPage = new ContextMenuPage(driver);

    }

    @Test
    public void contextMenuAlertWindow(){
        contextMenuPage.validationAlert();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        Assert.assertEquals(alert.getText(),ALERT_TEXT);
        alert.accept();
    }
}
