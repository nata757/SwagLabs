import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {
    public WebDriver driver;

    @Test
    public void firstSeleniumTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        emailInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(10000);


        List<WebElement> elements = driver.findElements(By.xpath("//span[@class = 'title']"));
        int actualContainer = elements.size();
        int expectedContainer = 6;
        Assert.assertEquals(actualContainer, expectedContainer, actualContainer + " can not " + expectedContainer);
        driver.quit();
    }
}
