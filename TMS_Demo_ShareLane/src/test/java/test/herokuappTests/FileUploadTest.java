package test.herokuappTests;

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

    }

}
