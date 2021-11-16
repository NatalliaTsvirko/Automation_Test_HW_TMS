package test.herokuappTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pages.DynamicControlsPage;

import static org.testng.Assert.assertEquals;


public class DynamicControlsTest extends HerokuBaseTest {

    private DynamicControlsPage dynamicControlsPage;

    @BeforeClass(alwaysRun = true)
    public void setDynamicControlsTest() {
        dynamicControlsPage = new DynamicControlsPage(driver);

    }

    @Test
    public void checkboxNoOnPage() {
        dynamicControlsPage.checkboxNot();
        dynamicControlsPage.waitUntilElementVisible(DynamicControlsPage.WAIT_TEXT_CHECKBOX);
        int numberOfElements = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        assertEquals(numberOfElements, 0, "Element on page");
    }

    @Test
    public void enableInput() {
        dynamicControlsPage.findInput();
        dynamicControlsPage.clickButtonEnable();
        dynamicControlsPage.waitUntilElementVisible(DynamicControlsPage.WAIT_TEXT_INPUT_ENABLE);
        dynamicControlsPage.verifyInputDisabled();
        Assert.assertTrue(dynamicControlsPage.verifyInputDisabled(),"is Enable");
    }
}
