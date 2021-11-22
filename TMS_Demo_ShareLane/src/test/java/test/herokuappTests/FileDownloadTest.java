package test.herokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;
import test.BaseTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileDownloadTest() {
        driver.get("http://the-internet.herokuapp.com/download");
        String fileName = "MyFile.txt";
        WebElement downloadLink = driver.findElement(By.cssSelector("a[href='download/"+fileName+"']"));
        downloadLink.click();
        wait.until(
                (ExpectedCondition<Boolean>) driver ->
                        Files.exists(Paths.get(testDownloadsDir + File.separator + fileName))
        );
    }
}

