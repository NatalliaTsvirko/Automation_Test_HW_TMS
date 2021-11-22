package test.herokuappTests;

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
        Assert.assertEquals(framePage.takeFrame(),textInFrame);
    }
}
