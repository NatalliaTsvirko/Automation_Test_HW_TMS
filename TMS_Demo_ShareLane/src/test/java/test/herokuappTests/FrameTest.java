package test.herokuappTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pages.FramePage;

public class FrameTest extends HerokuBaseTest{

    private FramePage framePage;
    private String textInFrame;

    @BeforeClass(alwaysRun = true)
    public void setDynamicControlsTest() {
        framePage = new FramePage(driver);
    }

    @Test
    public void switchToFrame(){
        textInFrame = "Your content goes here.";
        framePage.takeFrame(FramePage.TEXT_IFRAME);
        WebElement text = driver.findElement(FramePage.TEXT_IFRAME);
        Assert.assertEquals(text.getText(),textInFrame);
        framePage.switchToDefaultPage();

    }
}
