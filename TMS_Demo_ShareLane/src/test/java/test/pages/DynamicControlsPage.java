package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage extends BasePage {

    public static final By WAIT_TEXT_CHECKBOX = By.cssSelector("p[id='message']");
    public static final By WAIT_TEXT_INPUT_ENABLE = By.xpath("//button[@onclick='swapInput()']/following-sibling::p");
    public static final By CHECKBOX = By.cssSelector("input[type='checkbox']");
    private static final String DYNAMIC_CONTROL_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    private static final By REMOVE_BUTTON = By.cssSelector("button[onclick='swapCheckbox()']");
    private static final By INPUT_FIELD = By.cssSelector("input[type='text']");
    private static final By ENABLE_BUTTON = By.xpath("//button[@onclick='swapInput()']");


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void checkboxNot() {
        driver.get(DYNAMIC_CONTROL_URL);
        WebElement checkbox = driver.findElement(CHECKBOX);
        checkbox.click();
        driver.findElement(REMOVE_BUTTON).click();

    }

    public void waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void findInput() {
        driver.get(DYNAMIC_CONTROL_URL);
        driver.findElement(INPUT_FIELD);

    }
    public void clickButtonEnable(){
        driver.findElement(ENABLE_BUTTON).click();
    }

    public boolean verifyInputDisabled() {
        driver.findElement(INPUT_FIELD).isEnabled();
        return true;
    }
}
