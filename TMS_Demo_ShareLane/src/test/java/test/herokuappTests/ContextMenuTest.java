package test.herokuappTests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pages.ContextMenuPage;

public class ContextMenuTest extends HerokuBaseTest {

    private static final String ALERT_TEXT = "You selected a context menu";

    private ContextMenuPage contextMenuPage;

    @BeforeClass(alwaysRun = true)
    public void setContextMenuTests() {
        contextMenuPage = new ContextMenuPage(driver);
    }

    @Test
    public void contextMenuAlertWindow(){
        contextMenuPage.validationTextAlert();
        contextMenuPage.waitAlertWindow();
        Alert alert = driver.switchTo().alert();
        String alertText = "You selected a context menu";
        Assert.assertEquals(alertText,ALERT_TEXT);
        alert.accept();
    }
}
