package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPage extends BasePage{

    private static final String FILE_UPLOADER_URL = "http://the-internet.herokuapp.com/upload";
    private static final By CHOOSE_FILE_BUTTON =By.cssSelector("input[id='file-upload']");
    private static final By UPLOAD_BUTTON =By.cssSelector("input[type='file']");
    private WebElement loader;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void chooseFile(){
        driver.get(FILE_UPLOADER_URL);
        Actions action = new Actions(driver);
        action.perform();
        driver.findElement(CHOOSE_FILE_BUTTON).sendKeys("C:\\Wget\\лиса и мальчик.jpg");
        driver.findElement(UPLOAD_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.invisibilityOf(loader));

    }

}
