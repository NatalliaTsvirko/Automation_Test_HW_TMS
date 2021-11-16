package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenuPage extends BasePage{

    public static final String ALERT_TEXT = "You selected a context menu";
    private static final String CONTEXT_MENU_URL = "http://the-internet.herokuapp.com/context_menu";
    private static final By WINDOW_ELEMENT_ON_PAGE = By.cssSelector("div[id='hot-spot']");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }
    public void validationAlert(){
        driver.get(CONTEXT_MENU_URL);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(WINDOW_ELEMENT_ON_PAGE)).contextClick().perform();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());

    }
}