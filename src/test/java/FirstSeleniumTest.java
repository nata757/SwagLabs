import e2e.TestBase;
import e2e.pages.InventoryPage;
import e2e.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {
    public WebDriver driver;
    private final String titleNameX5 = "Купить BMW X5";
    private final String nameOfBack = "Sauce Labs Backpack";
    private final String titleCheckoutText = "Checkout: Your Information";


    @Test
    public void firstSeleniumTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*driver.get("https://www.avito.ru/");
        WebElement searchForm = driver.findElement(By.xpath("//input[@class='input-input-Zpzc1']"));
        searchForm.sendKeys("Audi", Keys.ENTER);
        searchForm.sendKeys("BMW", Keys.ENTER);
        WebElement modelBmwX5 = driver.findElement(By.xpath("//a[@title='X5' and @data-category-id = '9'][1]"));
        modelBmwX5.click();
        WebElement titleOfBmwX5 = driver.findElement(By.xpath("//h1[@data-marker='page-title/text']"));
        var text = titleOfBmwX5.getText();
        Assert.assertEquals(text, titleNameX5);*/
        //LoginPage loginPage = new LoginPage(driver);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        emailInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement backPack = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        backPack.click();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        WebElement inventoryItemPrice = driver.findElement(By.xpath("//*[@class='inventory_item_price']"));
        Assert.assertTrue(inventoryItemPrice.isDisplayed());

        WebElement shoppingCartButton = driver.findElement(By.xpath("//*[@class = 'shopping_cart_link']"));
        shoppingCartButton.click();
        Assert.assertTrue(backPack.isDisplayed());

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        WebElement titleCheckout = driver.findElement(By.xpath("//*[text() = 'Checkout: Your Information']"));
        Assert.assertEquals(titleCheckout.getText(),titleCheckoutText);


        //loginPage.loginButton.click();
        /*List<WebElement> elements = driver.findElements(By.xpath("//*[@class='inventory_list']"));
        int actualContainer = elements.size();
        int expectedContainer = 1;
        Assert.assertEquals(actualContainer, expectedContainer, actualContainer + " can not " + expectedContainer);
        */
        driver.close();
        driver.quit();

    }
}
