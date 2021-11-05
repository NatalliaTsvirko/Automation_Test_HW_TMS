package test.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.List;

public class OpenHtmlPage extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void inputsSetUp() {
        driver.get("C:\\Tasks\\AutoHW\\Automation_Test_HW_TMS\\TMS_Demo_ShareLane\\src\\main\\resources\\halloweenPage.html");

    }

    @Test
    public void input() {
        //All elements in input field have index "0" and i can't fit them in one list.
        //And "Assert" don't pass I do not know why
        WebElement inputFirsName = driver.findElement(By.cssSelector("input[id='fname']"));
        inputFirsName.sendKeys("Liza");
        WebElement inputLastName = driver.findElement(By.cssSelector("input[id='lname']"));
        inputLastName.sendKeys("Can");
        WebElement inputUserName = driver.findElement(By.cssSelector("input[id='username']"));
        inputUserName.sendKeys("LiCa");
        WebElement inputEmail = driver.findElement(By.cssSelector("input[type='email']"));
        inputEmail.sendKeys("witch@coco.mail");
        WebElement inputPassword = driver.findElement(By.cssSelector("input[type='password']"));
        inputPassword.sendKeys("7777777");
        Assert.assertEquals(inputFirsName.getText(), "Liza");
        Assert.assertEquals(inputLastName.getText(), "Can");
        Assert.assertEquals(inputUserName.getText(), "LiCa");
        Assert.assertEquals(inputEmail.getText(), "witch@coco.mail");

//        List<WebElement> inputData = driver.findElements(By.cssSelector("input[type='text']"));
//        WebElement inputFirsName = inputData.get(0);
//        inputFirsName.sendKeys("Liza");
//        WebElement inputLastName =inputData.get(1);
//        inputLastName.sendKeys("Can");
//        WebElement inputUserName = inputData.get(2);
//        inputUserName.sendKeys("LiCa");
//        for (WebElement element : inputData) {
//            Assert.assertEquals(inputData.get(0).getAttribute("Liza"), "Liza");
//            Assert.assertEquals(inputData.get(1).getAttribute("Can"), "Can");
//            Assert.assertEquals(inputData.get(2).getAttribute("LiCa"), "LiCa");
//        }
    }

    @Test
    public void tableTest() {

        WebElement tableData = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]"));
        WebElement firstPerson = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]"));
        WebElement secondPerson = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]"));
        WebElement thirdPerson = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]"));
        WebElement fourPerson = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]"));
        Assert.assertEquals(tableData.getText(), "Person Name Age");
        Assert.assertEquals(firstPerson.getText(), "Witch Teodora 500");
        Assert.assertEquals(secondPerson.getText(), "Pumpkin Jack 100");
        Assert.assertEquals(thirdPerson.getText(), "Scull Ludwig 200");
        Assert.assertEquals(fourPerson.getText(), "Black cat Lucifer 50");
    }

    @Test
    public void checkboxesTestHtml() {
        //All elements in checkboxes have index "0" and i can't fit them in one list.
        //I search elements from id
        WebElement checkboxOfBike = driver.findElement(By.cssSelector("input[id='vehicle1']"));
        checkboxOfBike.click();
        WebElement checkboxOfCar = driver.findElement(By.cssSelector("input[id='vehicle2']"));
        checkboxOfCar.click();
        WebElement checkboxOfBoat = driver.findElement(By.cssSelector("input[id='vehicle3']"));
        checkboxOfBoat.click();
        Assert.assertTrue(checkboxOfBike.isSelected());
        Assert.assertTrue(checkboxOfCar.isSelected());
        Assert.assertTrue(checkboxOfBoat.isSelected());
        checkboxOfBike.click();
        checkboxOfCar.click();
        checkboxOfBoat.click();
        Assert.assertTrue(checkboxOfBike.isEnabled());
        Assert.assertTrue(checkboxOfCar.isEnabled());
        Assert.assertTrue(checkboxOfBoat.isEnabled());
    }
}
