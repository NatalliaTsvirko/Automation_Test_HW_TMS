package test.herokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pages.FileUploadPage;

public class FileUploadTest extends HerokuBaseTest{

    private FileUploadPage fileUploadPage;

    @BeforeClass(alwaysRun = true)
    public void setFileUploadPageTests() {
        fileUploadPage = new FileUploadPage(driver);
    }

    @Test
    public void uploadFile() {
        fileUploadPage.chooseFile();
        fileUploadPage.waitUploadFile();
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(),"boy and fox.jpg");
    }
}
