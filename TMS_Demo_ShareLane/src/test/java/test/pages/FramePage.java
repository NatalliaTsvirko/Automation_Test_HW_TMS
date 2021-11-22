package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BasePage {
    private static final By TEXT_IFRAME = By.xpath("//p[text()='Your content goes here.']");
    private static final String IFRAME_URL = "http://the-internet.herokuapp.com/frames";
    private static final By LINK_FRAME = By.xpath("//a[@href='/iframe']");

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public String takeFrame() {
        driver.get(IFRAME_URL);
        driver.findElement(LINK_FRAME).click();
        driver.switchTo().frame(0);
        String text = driver.findElement(TEXT_IFRAME).getText();
        driver.switchTo().defaultContent();
        return text;
    }
}
