package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
    public WebDriver driver;


    //id

    WebElement elementUserName = driver.findElement(By.cssSelector("#user-name"));
    WebElement elementPassword = driver.findElement(By.cssSelector("#password"));
    WebElement elementLoginButton = driver.findElement(By.xpath("//input[@id='login-button']"));


}
