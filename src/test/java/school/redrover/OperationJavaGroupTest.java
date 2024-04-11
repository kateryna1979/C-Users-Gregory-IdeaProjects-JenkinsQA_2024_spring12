package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class OperationJavaGroupTest extends BaseTest {

    @Test

    public void testWelcome() {
        WebElement welcomeText = getDriver().findElement(By.cssSelector(".empty-state-block > h1"));

        Assert.assertEquals(welcomeText.getText(), "Welcome to Jenkins!");
    }
    @Test
    public void testFreestyleProject() {
        getDriver().findElement(By.cssSelector("[it='hudson.model.Hudson@57458ec6'] [fill='none']")).click();

        WebElement nameInput = getDriver().findElement(By.id("name"));
        nameInput.click();
        nameInput.sendKeys("FreestyleProject");

        WebElement project = getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']"));
        project.click();

        WebElement buttonOk = getDriver().findElement(By.id("ok-button"));
        buttonOk.click();

        WebElement buttonSave = getDriver().findElement(By.name("Submit"));
        buttonSave.click();

        WebElement dashboard = getDriver().findElement(By.xpath("//a[.='Dashboard']"));
        dashboard.click();

        WebElement nameDashboard = getDriver().findElement(By.xpath("//span[.='FreestyleProject']"));

        Assert.assertEquals(nameDashboard.getText(), "FreestyleProject");
    }
}

