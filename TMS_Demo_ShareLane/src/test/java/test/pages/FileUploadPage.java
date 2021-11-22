package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FileUploadPage extends BasePage{

    private static final String FILE_UPLOADER_URL = "http://the-internet.herokuapp.com/upload";
    private static final By CHOOSE_FILE_BUTTON =By.cssSelector("input[type='file']");
    private static final By UPLOAD_BUTTON =By.cssSelector(".button");
    private static final By TEXT_UPLOAD_FILE = By.xpath("//div[contains(text(),'boy and fox.jpg')]");


    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void chooseFile(){
        driver.get(FILE_UPLOADER_URL);
        WebElement input = driver.findElement(CHOOSE_FILE_BUTTON);
        File file = new File("src/main/resources/boy and fox.jpg");
        input.sendKeys(file.getAbsolutePath());
        WebElement uploadButton = driver.findElement(UPLOAD_BUTTON);
        uploadButton.click();
    }

    public void waitUploadFile(){
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'File Uploaded')]")));
    }

}
