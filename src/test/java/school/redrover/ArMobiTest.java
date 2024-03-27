package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArMobiTest {



    private final By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");

    @Test
    public void removePaswordTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://23.105.246.172:5000/login");

        Thread.sleep(1000);

        WebElement inputMail = driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']"));
        inputMail.sendKeys("yyyyyyyyyy@mail.xx");

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']")).click();
        Thread.sleep(1000);

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");

        driver.quit();
    }
}