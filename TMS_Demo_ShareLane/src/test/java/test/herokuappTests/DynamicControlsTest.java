package test.herokuappTests;

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
        dynamicControlsPage.waitUntilWaitTextboxTextVisible();
        assertEquals(dynamicControlsPage.getCheckboxCount(), 0, "Element on page");
    }

    @Test
    public void enableInput() {
        dynamicControlsPage.clickButtonEnable();
        dynamicControlsPage.waitUntilElementVisible();
        Assert.assertTrue(dynamicControlsPage.isInputEnabled());
    }
}
