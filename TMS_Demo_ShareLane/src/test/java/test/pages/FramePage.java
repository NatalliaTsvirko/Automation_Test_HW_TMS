package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramePage extends BasePage {
    public static final By TEXT_IFRAME = By.xpath("//p[text()='Your content goes here.']");
    private static final String IFRAME_URL = "http://the-internet.herokuapp.com/frames";
    private static final By LINK_FRAME = By.xpath("//a[@href='/iframe']");

    public FramePage(WebDriver driver) {
        super(driver);
    }
    public void takeFrame(By locator) {
        driver.get(IFRAME_URL);
        driver.findElement(LINK_FRAME).click();
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(TEXT_IFRAME).getText();
    }

    public void switchToDefaultPage(){
        driver.switchTo().defaultContent();
    }
}
