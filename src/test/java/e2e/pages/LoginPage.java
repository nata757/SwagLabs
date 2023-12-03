package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage {
    public LoginPage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userNameInput;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;
    public void login(String email,String password){
        userNameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
