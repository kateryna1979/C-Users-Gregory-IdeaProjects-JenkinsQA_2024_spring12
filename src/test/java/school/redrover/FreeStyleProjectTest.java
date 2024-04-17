package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.util.List;

//Create freestyle project
//
//See it on a dashboard
//
//Open it to configure project information

//Создать проект фристайла
//
//Посмотрите это на приборной панели
//
//Откройте его, чтобы настроить информацию о проекте.

public class FreeStyleProjectTest extends BaseTest {



    @Test
    public void testFreeStyleProject() throws InterruptedException {

        final int EXPECTED_AMOUNT_OF_JOBS_CREATED = 1;

        final String EXPECTED_TITLE = "Test Config [Jenkins]";


        getDriver().findElement(By.xpath("//a[@href='newJob']/span[@class='trailing-icon']")).click();



        getDriver().findElement(By.name("name")).sendKeys("Test");

        getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']")).click();


        getDriver().findElement(By.id("ok-button")).click();



        getDriver().findElement(By.xpath("//button[@formnovalidate='formNoValidate']")).click();




        getDriver().findElement(By.id("jenkins-name-icon")).click();


        //getDriver().findElement(By.xpath("//a[@href='job/Test/']"));

        List<WebElement> jobs = getDriver().findElements(By.xpath("//table[@id='projectstatus']/tbody/tr"));


        Assert.assertEquals(jobs.size(),EXPECTED_AMOUNT_OF_JOBS_CREATED);


        getDriver().findElement(By.xpath("//a[@href='job/Test/']")).click();

        getDriver().findElement(By.xpath("//a[@href='/job/Test/configure']")).click();

        Thread.sleep(5000);

        Assert.assertEquals(getDriver().getTitle(),EXPECTED_TITLE);

        Thread.sleep(5000);


    }
}
